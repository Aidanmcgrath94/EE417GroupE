package dao;

import entity.User;

import java.sql.*;

/**
 * User data access object implementation
 */
public class UserDaoImpl implements UserDao{
    /**
     *
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param email
     * @return
     */
    @Override
    public User addUser(String username, String password, String firstName, String lastName, String email, boolean admin) {
        User user=null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try{
            connection=ConnectionSource.getConnection();
            String sql="INSERT INTO user values (0,?,?,?,?,?,true,?,now());";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,firstName);
            preparedStatement.setString(4,lastName);
            preparedStatement.setString(5,email);
            preparedStatement.setBoolean(6,admin);
            preparedStatement.execute();
            sql="SELECT LAST_INSERT_ID();";
            statement = connection.createStatement();
            resultSet=statement.executeQuery(sql);
            user=new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setValid(true);
            user.setAdmin(admin);
            while (resultSet.next()){
                user.set_id(resultSet.getInt("LAST_INSERT_ID()"));
            }
            sql="SELECT createdDate FROM user WHERE _id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,user.get_id());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setCreatedDate(resultSet.getDate("createdDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try{
                if(connection!=null) connection.close();
                if(preparedStatement!=null) preparedStatement.close();
                if(statement!=null) statement.close();
                if(resultSet!=null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    /**
     * check whether the username Exist
     * @param username
     * @return
     */
    @Override
    public boolean usernameExist(String username) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Statement statement=null;
        ResultSet resultSet=null;
        boolean ret=false;
        try{
            connection=ConnectionSource.getConnection();
            String sql="select * from user where username=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) ret=true;
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(connection!=null) connection.close();
                if(preparedStatement!=null) preparedStatement.close();
                if(statement!=null) statement.close();
                if(resultSet!=null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    /**
     * see if username exist and the password and username match
     * @param username
     * @param password
     * @return return user for success login and return null otherwise
     */
    public User verifyUsername(String username,String password){
        User user=null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Statement statement=null;
        ResultSet resultSet=null;
        boolean ret=false;
        try{
            connection=ConnectionSource.getConnection();
            String sql="SELECT * FROM user where username=? AND password=?;";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                user=new User();
                user.set_id(resultSet.getInt("_id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setEmail(resultSet.getString("mailAddress"));
                user.setValid(resultSet.getBoolean("isValid"));
                user.setAdmin(resultSet.getBoolean("isAdmin"));
                user.setCreatedDate(resultSet.getDate("createdDate"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(connection!=null) connection.close();
                if(preparedStatement!=null) preparedStatement.close();
                if(statement!=null) statement.close();
                if(resultSet!=null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public static void main(String[] args) {
        UserDao userDao=new UserDaoImpl();
        userDao.verifyUsername("root","root");
        userDao.addUser("baz","123","a","b","123@123.com", true);
        userDao.usernameExist("root");
    }

	@Override
	public String getUsername(int user_id) {
		// TODO Auto-generated method stub
		Connection connection=null;
        PreparedStatement preparedStatement=null;
        Statement statement=null;
        ResultSet resultSet=null;
        String author = "";
		try{
            connection=ConnectionSource.getConnection();
            String sql="SELECT * FROM user where _ID=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,user_id);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
            	author = resultSet.getString("username");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(connection!=null) connection.close();
                if(preparedStatement!=null) preparedStatement.close();
                if(statement!=null) statement.close();
                if(resultSet!=null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return author;
	}
}
