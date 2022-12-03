package com.facebook.Facebook.daoimpl;

import com.facebook.Facebook.dao.GenericDAO;
import com.facebook.Facebook.mapper.IRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> implements GenericDAO<T> {

    @Override
    public Integer save(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer id=null;
        try{
            connection = getConnection();
            if(connection!= null){
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                setParameters(statement,parameters);
                statement.executeUpdate();
                resultSet = statement.getGeneratedKeys();
                while(resultSet.next()){
                    id =  resultSet.getInt(1);
                }
                connection.commit();
                return id;
            }
        }catch(SQLException e){
           try{
               if(connection != null){
                   connection.rollback();
               }
           }catch(SQLException e1){
               return null;
           }
        }finally {
            try{
                if(connection!=null){
                    connection.close();
                }
                if(statement!= null){
                    statement.close();
                }
                if(resultSet!=null){
                    resultSet.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public <T> List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = getConnection();
            if(connection!= null){
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(sql);
                setParameters(statement,parameters);
                resultSet = statement.executeQuery();
                List<T> results = new ArrayList<>();
                while(resultSet.next()){
                    results.add(rowMapper.rowMapper(resultSet));
                }
                connection.commit();
                return results;
            }
        }catch(SQLException e){
            try{
                if(connection != null){
                    connection.rollback();
                }
            }catch(SQLException e1){
                return null;
            }
        }finally {
            try{
                if(connection!=null){
                    connection.close();
                }
                if(statement!= null){
                    statement.close();
                }
                if(resultSet!=null){
                    resultSet.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void delete(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            if(connection != null){
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(sql);
                setParameters(statement,parameters);
                int result = statement.executeUpdate();
                if(result > 0){
                    connection.commit();
                }
            }
        }catch(SQLException e){
            try{
                if(connection != null){
                    connection.rollback();
                }
            }catch(SQLException e1){
                e.printStackTrace();
            }
        }finally {
            try{
                if(connection!=null){
                    connection.close();
                }
                if(statement!= null){
                    statement.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            if(connection != null){
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(sql);
                setParameters(statement,parameters);
                int result = statement.executeUpdate();
                if(result > 0){
                    connection.commit();
                }
            }
        }catch(SQLException e){
            try{
                if(connection != null){
                    connection.rollback();
                }
            }catch(SQLException e1){
                e.printStackTrace();
            }
        }finally {
            try{
                if(connection!=null){
                    connection.close();
                }
                if(statement!= null){
                    statement.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    private void setParameters(PreparedStatement statement, Object[] parameters) {
        try{
            for (int i = 0; i < parameters.length ; i++) {
                int index = i +1;
                if(parameters[i] instanceof String){
                    statement.setString(index, (String) parameters[i]);
                }else if(parameters[i] instanceof Integer){
                    statement.setInt(index, (Integer) parameters[i]);
                }else if(parameters[i] instanceof Timestamp){
                    statement.setTimestamp(index, (Timestamp) parameters[i]);
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private Connection getConnection() {
        String jdbcURL = "jdbc:mysql://localhost:3306/facebookdb";
        String jdbcUsername="root";
        String jdbcPassword="1406";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        }catch(ClassNotFoundException | SQLException e){
            return null;
        }
    }
}
