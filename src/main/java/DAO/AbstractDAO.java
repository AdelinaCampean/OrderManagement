package DAO;

import java.beans.FeatureDescriptor;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.Statement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.ConnectionFactory;
import Model.Client;

public class AbstractDAO<T> {
	protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

	
	private final Class<T> type;

	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	}

	
	/**
	 * metoda are rolul de a crea interogarea de select
	 * @param field poate fi de exemplu un id
	 * @return String care contine interogarea completa
	 */
	
	private String createSelectQuery(String field) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" * ");
		sb.append(" FROM ");
		sb.append(type.getSimpleName());
		sb.append(" WHERE " + field + "=?");
		return sb.toString();
	}

	/**
	 * metoda creaza interogarea pentru inserarea intr-o baza de date 
	 * @param object este folosit pentru a avea acces la field-urile clasei 
	 * @param pop contine valorile pe care dorim sa le inseram 
	 * @return String care contine interogarea completa
	 */
	private String createInsert(Object object, String pop) {
		int w=0;
		int u=1;
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(type.getSimpleName());
		sb.append("(");
		
		while(u<object.getClass().getDeclaredFields().length)
		{
			sb.append(object.getClass().getDeclaredFields()[u].getName());
			if(w!=object.getClass().getDeclaredFields().length-2)
			{
				sb.append(",");
			}
			w++;
			u++;
		}
		
		sb.append(")");
		sb.append(" VALUES ");
		sb.append(pop);
		
		return sb.toString();
	}
	
	/**
	 * metoda are rolul de a actualiza un anumit produs sau client din respectiva tabela
	 * @param obj este folosit pentru a avea acces la field-urile clasei 
	 * @param pop contine valorile pe care dorim sa le adaugam in tabela (modificam) 
	 * @param field contine valoarea id-ului corespunzator
	 * @param num reprezinta id-ul, care poate fi "idclients" sau "idproduct"
	 * @return String care contine interogarea completa
	 */
	private String updateQuery(Object obj, String[] pop, int field,String num) {
		int i=0;
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE ");
		sb.append(type.getSimpleName());
		sb.append(" SET ");
		for(Field f: obj.getClass().getDeclaredFields()) {
			sb.append(f.getName()+"="+pop[i]);
			if (i!=obj.getClass().getDeclaredFields().length-1)
			{
				sb.append(",");
			}
			i++;
		
		}
		sb.append(" WHERE " + num + " = "+field);
		return sb.toString();
	}
	
	/**
	 * metoda are rolul de a sterge un anumit client sau produs
	 * @param obj este folosit pentru a avea acces la field-urile clasei 
	 * @param field reprezinta id-ul, care poate fi "idclients" sau "idproduct"
	 * @param id contine valoarea id-ului corespunzator
	 * @return String care contine interogarea completa
	 */
	private String deleteQuery(Object obj, String field, int id)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE ");
		sb.append(" FROM ");
		sb.append(type.getSimpleName());
		sb.append(" WHERE "+field+" = "+id);
		
		return sb.toString();
	}
	
	/**
	 * metoda afiseaza tot ceea ce contine tabela
	 * @return o lista de obiecte
	 */
	public List<T> findAll() {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sb = "SELECT * FROM "+ type.getSimpleName()+";";
		try {
			
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sb);
			resultSet = statement.executeQuery();
			
			return  (List<T>) createObjects(resultSet);
			
		} catch (SQLException e) {
		
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findALL " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	/**
	 * Metoda este folosita pentru a identifica un anumit produs, client sau comanda, in functie de id
	 * @param id
	 * @return un obiect de tip T, care poate fi atat un produs, un client sau o comanda
	 */
	public T findById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query="";
		String f = type.getSimpleName();
		String q = "";
		if(f.equals("Client"))
			q="idclients";
		
		else if(f.equals("Product"))
			 q="idProducts";
		
			query = createSelectQuery(q);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			statement.setInt(1, id);
			
			resultSet = statement.executeQuery();
			List<T> ob = createObjects(resultSet);
			
			return ob.get(0);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	private List<T> createObjects(ResultSet resultSet) {
		List<T> list = new ArrayList<T>();

		try {
			while (resultSet.next()) {
				T instance = type.newInstance();
				for (Field field : type.getDeclaredFields()) {
					Object value = resultSet.getObject(field.getName());
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
					Method method = propertyDescriptor.getWriteMethod();
					method.invoke(instance, value);
				}
				list.add(instance);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Este apelata metoda createInsert pentru a adauga un nou obiect intr-o tabela
	 * @param t reprezinta tipul de obiect pe care dorim sa il adaugam 
	 * @param val
	 */
	public void insert(T t, String val) {

		Connection connection = null;
		PreparedStatement statement = null;
		
			String ins = createInsert(t,val);
				try {
					connection = ConnectionFactory.getConnection();
					statement = connection.prepareStatement(ins);
					 int r = statement.executeUpdate();

				} catch (SQLException e) {
					LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
				} finally {
					ConnectionFactory.close(statement);
					ConnectionFactory.close(connection);
				}
			}

	
	public T update(T t, int id, String[] val,String num) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		String up = updateQuery(t,val,id,num);
			
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(up);
			int r = statement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		
		return t;
	}
	

	public void delete(T obj,String field,int id)
	{
		Connection connection = null;
		PreparedStatement statement = null;
		
		String del = deleteQuery(obj,field,id);
			
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(del);
			 int r = statement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:delete " + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		
	}
	
	public JTable createTable(Object object) {
	
		int i=0;
		int j=0;
		List<T> obj = findAll();
		Object[][] populate = new Object[obj.size()][object.getClass().getDeclaredFields().length];
		String[] header=new String[object.getClass().getDeclaredFields().length];
		for (Field field : object.getClass().getDeclaredFields()) {
			field.setAccessible(true); 
			header[j]=field.getName();
			j++;
		}
		j=0;
			for(Object o:obj)
			{
						for (Field field : object.getClass().getDeclaredFields()) {
							field.setAccessible(true); 
							try {
								populate[i][j]=field.get(o);
									j++;
							}
							catch (IllegalArgumentException e) {
									e.printStackTrace();
							} catch (IllegalAccessException e) {
									e.printStackTrace();
							}
								
						}
							i++;
							j=0;
							
			}
					
	 return new JTable(populate,header);	
	     
	}
	
	
}
