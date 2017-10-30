package dao;

import java.sql.*;

public class BaseDao {
		public Connection getConnection(){
			Connection conn=null;
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=Book-2014-06-20","sa","");
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return conn;
		}
		public int executeUpdate(String sql,Object[] param){
			int result=-1;
			Connection conn=null;
			PreparedStatement ps=null;
			try{
				conn=getConnection();
			    ps=conn.prepareStatement(sql);
				if(param!=null){
					for(int i=0;i<param.length;i++){
						ps.setObject(i+1,param[i]);
					}
				}
				result=ps.executeUpdate();
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				closeAll(conn,ps,null);
			}
			return result;
		}
		public void closeAll(Connection conn,Statement statm,ResultSet rs){
			try {
				if(rs!=null){
					rs.close();
				}
				rs=null;
				if(statm!=null){
					statm.close();
				}
				statm=null;
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					if(conn!=null && !conn.isClosed()){
						conn.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}finally{
					conn=null;
				}
			}
		}
}
