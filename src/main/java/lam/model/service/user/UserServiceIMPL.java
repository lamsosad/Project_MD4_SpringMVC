package lam.model.service.user;

import lam.model.entity.User;
import lam.model.util.ConnectionToDB;
import lam.model.util.Validate;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceIMPL implements IUserService {

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call PROC_SHOWUSER()}");
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setIdUser(rs.getInt("id"));
                user.setFullname(rs.getString("fullname"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setStatus(rs.getBoolean("status"));
                user.setRole(rs.getBoolean("role"));
                userList.add(user);
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
        return userList;
    }

    @Override
    public User login(User user) {
        User userLogin = null;
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callSt = connection.prepareCall("{call PROC_LOGIN(?,?)}");
            callSt.setString(1, user.getUsername());
            callSt.setString(2, user.getPassword());
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                userLogin = new User();
                userLogin.setIdUser(rs.getInt(1));
                userLogin.setFullname(rs.getString(2));
                userLogin.setUsername(rs.getString(3));
                userLogin.setEmail(rs.getString(4));
                userLogin.setPassword(rs.getString(5));
                userLogin.setStatus(rs.getBoolean(6));
                userLogin.setRole(rs.getBoolean(7));
                if (!userLogin.isStatus()){
                    return null;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                ConnectionToDB.close(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userLogin;
    }

    @Override
    public boolean changeStatus(User user) {
        Connection conn = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_EDITSTATUSUSER(?,?)}");
            callSt.setInt(1, user.getIdUser());
            callSt.setBoolean(2, !user.isStatus());
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
    public boolean changePassword(User user) {
        Connection conn = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_CHANGEPASSWORD(?,?)}");
            callSt.setInt(1, user.getIdUser());
            callSt.setString(2, user.getPassword());
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
    public boolean checkExitUserLogin(String username) {
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callSt = connection.prepareCall("{call PROC_FINDBYUSERNAME(?)}");
            callSt.setString(1, username);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                ConnectionToDB.close(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean checkValidateEmail(String email) {
        return Validate.setValidateEmail(email);
    }

    @Override
    public boolean checkValidatePassword(String password) {
        return Validate.setValidatePassword(password);
    }

    @Override
    public boolean checkValidateUsername(String username) {
        return Validate.setValidateUserName(username);
    }

    @Override
    public boolean checkRePassword(String rePassword, String password) {
        return rePassword.equals(password);
    }

    @Override
    public boolean save(User user) {
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callSt = connection.prepareCall("{call PROC_REGISTER(?,?,?,?)}");
            callSt.setString(1, user.getFullname());
            callSt.setString(2, user.getUsername());
            callSt.setString(3, user.getEmail());
            callSt.setString(4, user.getPassword());
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
    public boolean update(User user) {
        Connection conn = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_EDITUSER(?,?,?)}");
            callSt.setInt(1, user.getIdUser());
            callSt.setString(2, user.getFullname());
            callSt.setString(3, user.getEmail());
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
    public User findById(int id) {
        Connection conn = null;
        User user=null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_FINDBYIDUSER(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setIdUser(rs.getInt(1));
                user.setFullname(rs.getString(2));
                user.setUsername(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setStatus(rs.getBoolean(6));
                user.setRole(rs.getBoolean(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectionToDB.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }


}
