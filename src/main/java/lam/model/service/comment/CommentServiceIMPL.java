package lam.model.service.comment;

import lam.model.entity.Comment;
import lam.model.util.ConnectionToDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentServiceIMPL implements ICommentService{

    @Override
    public List<Comment> findAll() {
        List<Comment> commentList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call PROC_SHOWFEEDBACK()}");
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
               Comment comment=new Comment();
              comment.setId(rs.getInt(1));
              comment.setFullname(rs.getString(2));
              comment.setComment(rs.getString(3));
              comment.setIdUser(rs.getInt(4));
              comment.setIdOrderDetail(rs.getInt(5));
              comment.setStatus(rs.getBoolean(6));
              commentList.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectionToDB.close(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return commentList;
    }

    @Override
    public boolean save(Comment comment) {
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callSt = connection.prepareCall("{call PROC_CreateComment(?,?,?)}");
            callSt.setString(1, comment.getComment());
            callSt.setInt(2, comment.getIdOrderDetail());
            callSt.setInt(3, comment.getIdUser());
            callSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionToDB.close(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean update(Comment comment) {
        Connection conn = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_ChangeStatusComment(?)}");
            callSt.setInt(1, comment.getId());
            callSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionToDB.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public Comment findById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Comment> showAllToProduct(int id) {
        List<Comment> commentList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call PROC_SHOWFEEDBACKtoProduct(?)}");
            callableStatement.setInt(1,id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                Comment comment=new Comment();
                comment.setId(rs.getInt(1));
                comment.setFullname(rs.getString(2));
                comment.setComment(rs.getString(3));
                comment.setIdUser(rs.getInt(4));
                comment.setIdOrderDetail(rs.getInt(5));
                comment.setStatus(rs.getBoolean(6));
                commentList.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectionToDB.close(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return commentList;
    }
}
