package AkýllýCihaz;

import java.sql.*;

public class PostgreSQLSunucu implements IVeriTabaniSunucu {

	
    Connection connection;
    ResultSet resultSet;
    Statement statement;
    boolean status;

    @Override
    public void Baglan(){
        try{
        	connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/SqlServer","postgres", "postgres");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean SistemeGiris(String username, String password) {
        try{
        	 String query = "select *  FROM \"User\" where \"user_name\"='" + username + "' and \"user_password\"='" + password + "'";
	            statement = connection.createStatement();
	            resultSet = statement.executeQuery(query);
	            if(!resultSet.next())
	            	status = false;
	            else{
	            	status = true;
	            }
	            return status; 	                  
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public void BaglantiSonlandir() throws SQLException {
    	connection.close();
        statement.close();
        resultSet.close();
    }
    
    public boolean KullaniciKontrol(String username) {
        try{
        	 String query = "select *  FROM \"User\" where \"user_name\"='" + username+"'";
	            statement = connection.createStatement();
	            resultSet = statement.executeQuery(query);
	            if(!resultSet.next())
	            	status = false;
	            else{
	            	status = true;
	            }
	            return status; 	                  
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }  


    public boolean YetkiKontrol(String username, String password) {
        try{
        	 String query = "select *  FROM \"UserAndRole\" where\"fk_role_id\"=1 and \"fk_user_id\"=(select  \"user_id\"  FROM \"User\" where \"user_name\"='" + username+ "' and \"user_password\"='" + password+ "' )";
	            statement = connection.createStatement();
	            resultSet = statement.executeQuery(query);
	            if(!resultSet.next())
	            	status = false;
	            else{
	            	status = true;
	            }
	            return status; 	                  
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
