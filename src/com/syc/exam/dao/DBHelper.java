package com.syc.exam.dao;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@SuppressWarnings("unchecked")
public class DBHelper {
	/*static {
		try {
			Class.forName(ReadPro.getInstance().getProperty("driverClassName"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	 */
	/**
	 * 获取数据库连接的方法
	 * @return
	 */
	private Connection getConnection() {
		Connection con = null;
		try {
			//con = DriverManager.getConnection(ReadPro.getInstance().getProperty("url"), ReadPro.getInstance());
			//JNDI: Java Naming and Directory Interface: java命名和目录接口
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/mysql");
			con = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 给预编译执行语句中的占位符赋值
	 * @param pstmt 要赋值的预编译对象
	 * @param params 对应占位符的值
	 */
	private void setParams(PreparedStatement pstmt, Object ... params) {
		// 说明预编译执行语句块中没有占位符?
		if (params == null || params.length <= 0) {
			return;
		}

		for (int i = 0, len = params.length; i < len; ++ i) {
			try {
				pstmt.setObject(i + 1, params[i]);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void setParams(PreparedStatement pstmt, List<Object> params) {
		// 说明预编译执行语句块中没有占位符?
		if (params == null || params.size() <= 0) {
			return;
		}
		
		for (int i = 0, len = params.size(); i < len; ++ i) {
			try {
				pstmt.setObject(i + 1, params.get(i));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭资源的方法
	 * @param rs 结果集
	 * @param pstmt 预编译执行语句块
	 * @param con 连接
	 */
	private void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * 执行数据更新的方法（update、delete、insert）
	 * @param sql 要执行的更新语句
	 * @param params 执行的更新语句中，对应占位符的值
	 * @return
	 */
	public int update(String sql, Object ... params) {
		int result = -1;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = this.getConnection();
			pstmt = con.prepareStatement(sql);
			this.setParams(pstmt, params);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(null, pstmt, con);
		}
		return result;
	}

	/**
	 * 获取结果集中列的列名
	 * @param rs
	 * @return
	 */
	private String[] getColumnNames(ResultSet rs) {
		String[] colNames = null;
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获取结果集中列的数量
			int colCount = rsmd.getColumnCount();

			// 数组的长度等于查询语句中所查列的数量
			colNames = new String[colCount];

			// 获取每一个列的名字，存到这个数组中
			for(int i = 1; i <= colCount; ++i) {
				colNames[i - 1] = rsmd.getColumnName(i).toLowerCase(); // oracle中默认返回的所有列的列名是大写的，那么我们就其全部转成小写
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return colNames;
	}

	/**
	 * 查询一条数据的方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public Map<String, String> find(String sql, Object ... params) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, String> map = new HashMap<String, String>();

		try {
			con = this.getConnection();
			pstmt = con.prepareStatement(sql);
			this.setParams(pstmt, params);

			rs = pstmt.executeQuery();

			// 获取结果集中所有列的列名
			String[] colNames = this.getColumnNames(rs);
			if (rs.next()) {
				// 循环所有的列名，根据列名取出每一个列的值
				for (String colName : colNames) {
					// 将查询出来的结果，存到map中。以对应列的列名为键，对应列的值为值
					map.put(colName, rs.getString(colName));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(rs, pstmt, con);
		}
		return map;
	}
	
	public Map<String, String> find(String sql, List<Object> params) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, String> map = new HashMap<String, String>();
		
		try {
			con = this.getConnection();
			pstmt = con.prepareStatement(sql);
			this.setParams(pstmt, params);
			
			rs = pstmt.executeQuery();
			
			// 获取结果集中所有列的列名
			String[] colNames = this.getColumnNames(rs);
			if (rs.next()) {
				// 循环所有的列名，根据列名取出每一个列的值
				for (String colName : colNames) {
					// 将查询出来的结果，存到map中。以对应列的列名为键，对应列的值为值
					map.put(colName, rs.getString(colName));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(rs, pstmt, con);
		}
		return map;
	}

	/**
	 * 查询多条数据的方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Map<String, String>> finds(String sql, Object ... params) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		try {
			con = this.getConnection();
			pstmt = con.prepareStatement(sql);
			this.setParams(pstmt, params);

			rs = pstmt.executeQuery();

			// 获取结果集中所有列的列名
			String[] colNames = this.getColumnNames(rs);
			Map<String, String> map = null;
			while (rs.next()) {
				// 每循环一次就是一条记录，一条记录的信息就存到一个map中
				map = new HashMap<String, String>();
				// 循环所有的列名，根据列名取出每一个列的值
				for (String colName : colNames) {
					// 将查询出来的结果，存到map中。以对应列的列名为键，对应列的值为值
					map.put(colName, rs.getString(colName));
				}
				// 当循环结束，说明这一样的数据已经读取完成，那么就存到了这一行数据的map存到list中
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(rs, pstmt, con);
		}
		return list;
	}
	
	/**
	 * 查询多条数据的方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Map<String, String>> finds(String sql, List<Object> params) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		
		try {
			con = this.getConnection();
			pstmt = con.prepareStatement(sql);
			this.setParams(pstmt, params);
			
			rs = pstmt.executeQuery();
			
			// 获取结果集中所有列的列名
			String[] colNames = this.getColumnNames(rs);
			Map<String, String> map = null;
			while (rs.next()) {
				// 每循环一次就是一条记录，一条记录的信息就存到一个map中
				map = new HashMap<String, String>();
				// 循环所有的列名，根据列名取出每一个列的值
				for (String colName : colNames) {
					// 将查询出来的结果，存到map中。以对应列的列名为键，对应列的值为值
					map.put(colName, rs.getString(colName));
				}
				// 当循环结束，说明这一样的数据已经读取完成，那么就存到了这一行数据的map存到list中
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(rs, pstmt, con);
		}
		return list;
	}

	/**
	 * 获取总记录数的方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public int getTotal(String sql, Object ... params) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = this.getConnection();
			pstmt = con.prepareStatement(sql);
			this.setParams(pstmt, params);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(rs, pstmt, con);
		}
		return result;
	}
	
	public int getTotal(String sql, List<Object> params) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			con = this.getConnection();
			pstmt = con.prepareStatement(sql);
			this.setParams(pstmt, params);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(rs, pstmt, con);
		}
		return result;
	}

	/**
	 *  泛型查询 对象的集合
	 * @param sql  要执行的查询语句
	 * @param c    对象
	 * @param params  占位符
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IOException 
	 */
	public <T> List<T> finds(String sql, Class<?> c, Object... params) {
		List<T> list = new ArrayList<T>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = this.getConnection();
			pstmt = con.prepareStatement(sql);
			setParams(pstmt, params);
			rs = pstmt.executeQuery();

			//获取所有列名
			String[] columnNames = getColumnNames(rs);
			//声明一个对象
			T t = null;
			Object obj = null;
			String typeName = null;
			//通过反射获取所有的Method方法
			Method[] methods = c.getDeclaredMethods();

			while(rs.next()) {
				//创建一个对象
				t = (T)c.newInstance();//相当于调用无参数的构造方法 可等于UserInfoBean users = new UserInfoBean()
				//循环列
				for(String columnName : columnNames) {
					obj = rs.getObject(columnName);//获取对应的值
					//循环所有的方法
					for(Method m: methods) {
						String name = "set" + columnName;
						if(name.equalsIgnoreCase(m.getName())) {
							if(obj == null) {
								continue;
							}

							//获取值的类型
							typeName = obj.getClass().getName();
							if("java.math.BigDecimal".equals(typeName)) {
								try {
									m.invoke(t, rs.getInt(columnName));
								} catch (Exception e) {
									m.invoke(t, rs.getDouble(columnName));
								}
							}else if("java.lang.Integer".equals(typeName)) {
								m.invoke(t, rs.getInt(columnName));
							}else if("java.lang.Double".equals(typeName)) {
								m.invoke(t, rs.getDouble(columnName));
							}else {
								m.invoke(t, rs.getString(columnName));
							}			
						}
					}
				}
				list.add(t); //设置对象到List集合中
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}finally{
			close(rs, pstmt, con);
		}
		return list;
	}
	
	public <T> List<T> finds(String sql, Class<?> c, List<Object> params) {
		List<T> list = new ArrayList<T>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = this.getConnection();
			pstmt = con.prepareStatement(sql);
			setParams(pstmt, params);
			rs = pstmt.executeQuery();
			
			//获取所有列名
			String[] columnNames = getColumnNames(rs);
			//声明一个对象
			T t = null;
			Object obj = null;
			String typeName = null;
			//通过反射获取所有的Method方法
			Method[] methods = c.getDeclaredMethods();
			
			while(rs.next()) {
				//创建一个对象
				t = (T)c.newInstance();//相当于调用无参数的构造方法 可等于UserInfoBean users = new UserInfoBean()
				//循环列
				for(String columnName : columnNames) {
					obj = rs.getObject(columnName);//获取对应的值
					//循环所有的方法
					for(Method m: methods) {
						String name = "set" + columnName;
						if(name.equalsIgnoreCase(m.getName())) {
							if(obj == null) {
								continue;
							}
							
							//获取值的类型
							typeName = obj.getClass().getName();
							if("java.math.BigDecimal".equals(typeName)) {
								try {
									m.invoke(t, rs.getInt(columnName));
								} catch (Exception e) {
									m.invoke(t, rs.getDouble(columnName));
								}
							}else if("java.lang.Integer".equals(typeName)) {
								m.invoke(t, rs.getInt(columnName));
							}else if("java.lang.Double".equals(typeName)) {
								m.invoke(t, rs.getDouble(columnName));
							}else {
								m.invoke(t, rs.getString(columnName));
							}			
						}
					}
				}
				list.add(t); //设置对象到List集合中
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}finally{
			close(rs, pstmt, con);
		}
		return list;
	}
	
	public <T> T find(String sql, Class<?> c, Object... params) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		T t = null;
		
		try {
			con = this.getConnection();
			pstmt = con.prepareStatement(sql);
			setParams(pstmt, params);
			rs = pstmt.executeQuery();
			
			//获取所有列名
			String[] columnNames = getColumnNames(rs);
			//声明一个对象
			
			Object obj = null;
			String typeName = null;
			//通过反射获取所有的Method方法
			Method[] methods = c.getDeclaredMethods();
			
			if(rs.next()) {
				//创建一个对象
				t = (T)c.newInstance();//相当于调用无参数的构造方法 可等于UserInfoBean users = new UserInfoBean()
				//循环列
				for(String columnName : columnNames) {
					obj = rs.getObject(columnName);//获取对应的值
					//循环所有的方法
					for(Method m: methods) {
						String name = "set" + columnName;
						if(name.equalsIgnoreCase(m.getName())) {
							if(obj == null) {
								continue;
							}
							
							//获取值的类型
							typeName = obj.getClass().getName();
							if("java.math.BigDecimal".equals(typeName)) {
								try {
									m.invoke(t, rs.getInt(columnName));
								} catch (Exception e) {
									m.invoke(t, rs.getDouble(columnName));
								}
							}else if("java.lang.Integer".equals(typeName)) {
								m.invoke(t, rs.getInt(columnName));
							}else if("java.lang.Double".equals(typeName)) {
								m.invoke(t, rs.getDouble(columnName));
							}else {
								m.invoke(t, rs.getString(columnName));
							}			
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}finally{
			close(rs, pstmt, con);
		}
		return t;
	}
	
	public <T> T find(String sql, Class<?> c, List<Object> params) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		T t = null;
		
		try {
			con = this.getConnection();
			pstmt = con.prepareStatement(sql);
			setParams(pstmt, params);
			rs = pstmt.executeQuery();
			
			//获取所有列名
			String[] columnNames = getColumnNames(rs);
			//声明一个对象
			
			Object obj = null;
			String typeName = null;
			//通过反射获取所有的Method方法
			Method[] methods = c.getDeclaredMethods();
			
			if(rs.next()) {
				//创建一个对象
				t = (T)c.newInstance();//相当于调用无参数的构造方法 可等于UserInfoBean users = new UserInfoBean()
				//循环列
				for(String columnName : columnNames) {
					obj = rs.getObject(columnName);//获取对应的值
					//循环所有的方法
					for(Method m: methods) {
						String name = "set" + columnName;
						if(name.equalsIgnoreCase(m.getName())) {
							if(obj == null) {
								continue;
							}
							
							//获取值的类型
							typeName = obj.getClass().getName();
							if("java.math.BigDecimal".equals(typeName)) {
								try {
									m.invoke(t, rs.getInt(columnName));
								} catch (Exception e) {
									m.invoke(t, rs.getDouble(columnName));
								}
							}else if("java.lang.Integer".equals(typeName)) {
								m.invoke(t, rs.getInt(columnName));
							}else if("java.lang.Double".equals(typeName)) {
								m.invoke(t, rs.getDouble(columnName));
							}else {
								m.invoke(t, rs.getString(columnName));
							}			
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}finally{
			close(rs, pstmt, con);
		}
		return t;
	}
}

