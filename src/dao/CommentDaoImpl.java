package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Comment;
import entity.User;

public class CommentDaoImpl implements CommentDao{

	@Override
	public Comment addComment(int post_id, String author, String comment_text) {
		// TODO Auto-generated method stub
		Comment comment = null;
		Connection connection=null;
        PreparedStatement preparedStatement=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try{
            connection=ConnectionSource.getConnection();
            String sql="INSERT INTO comments values (0,?,?,?,now());";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,post_id);
            preparedStatement.setString(2,author);
            preparedStatement.setString(3,comment_text);
            preparedStatement.execute();
            sql="SELECT LAST_INSERT_ID();";
            statement = connection.createStatement();
            resultSet=statement.executeQuery(sql);
            
            comment=new Comment();
            
            comment.setPost_id(post_id);
            comment.setAuthor(author);
            comment.setComment(comment_text);

            while (resultSet.next()){
                comment.set_id(resultSet.getInt("LAST_INSERT_ID()"));
            }
            
            sql="SELECT createdDate FROM user WHERE _id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,comment.get_id());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                comment.setCreatedDate(resultSet.getDate("createdDate"));
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
		return comment;
	}

}
