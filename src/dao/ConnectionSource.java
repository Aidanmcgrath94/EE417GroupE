package dao;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionSource {
    private static BasicDataSource dataSource = null;

    public ConnectionSource() {
    }

    public static void init() {
        Properties properties = new Properties();
        try {
            properties.load(ConnectionSource.class.getClassLoader()
                    .getResourceAsStream("dbcpConfiguration.properties"));
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            System.out.println(password);

            String initialSize = properties.getProperty("initialSize");
            String minIdle = properties.getProperty("minIdle");
            String maxIdle = properties.getProperty("maxIdle");
            String maxWait = properties.getProperty("maxWait");
            String maxTotal = properties.getProperty("maxTotal");

            dataSource = new BasicDataSource();
            dataSource.setDriverClassName(driver);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);

           
            if (initialSize != null)
                dataSource.setInitialSize(Integer.parseInt(initialSize));

           
            if (minIdle != null)
                dataSource.setMinIdle(Integer.parseInt(minIdle));

            
            if (maxIdle != null)
                dataSource.setMaxIdle(Integer.parseInt(maxIdle));

           
            if(maxWait!=null)
                dataSource.setMaxWaitMillis(Integer.parseInt(maxWait));

          
            if(maxTotal!=null){
                if(!maxTotal.trim().equals("0"))
                    dataSource.setMaxTotal(Integer.parseInt(maxTotal));
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error creating connection! Please check configuration");
        }
    }

    public static synchronized Connection getConnection() throws SQLException {
        if (dataSource == null) {
            init();
        }
        Connection conn = null;
        if (dataSource != null) {
            conn = dataSource.getConnection();
        }
        return conn;
    }

}
