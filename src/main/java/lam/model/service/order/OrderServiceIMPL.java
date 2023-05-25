package lam.model.service.order;



import lam.model.entity.Order;

import lam.model.entity.OrderDetail;
import lam.model.entity.OrderItem;
import lam.model.util.ConnectionToDB;
import lam.model.util.Validate;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceIMPL implements IOrderService {

    // thầy đại code bẩn
    public int idAutoIncrementOder() {
        final String SQL = "select max(id) from `order`";
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall(SQL);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                return rs.getInt(1) + 1;
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
        return 1;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public boolean save(Order order) {
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call PROC_CREATEORDER(?,?,?,?,?)}");
            callableStatement.setInt(1, order.getIdOrder());
            callableStatement.setString(2, order.getNameReceiver());
            callableStatement.setString(3, order.getPhone());
            callableStatement.setString(4, order.getAddress());
            callableStatement.setFloat(5, order.getTotal());
            callableStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionToDB.close(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    @Override
    public boolean update(Order order) {
        Connection conn = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_EDITSTATUS(?)}");
            callSt.setInt(1, order.getIdOrder());
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
    public Order findById(int id) {
        Connection conn = null;
        Order order = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_FINDBYIDORDER(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                order = new Order();
                order.setIdOrder(rs.getInt(1));
                order.setNameReceiver(rs.getString(2));
                order.setPhone(rs.getString(3));
                order.setAddress(rs.getString(4));
                order.setDate(rs.getString(5));
                order.setStatus(rs.getBoolean(6));
                order.setTotal(rs.getFloat(7));

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
        return order;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Order findByIdToUserLogin(int id) {
        Connection conn = null;
        Order order = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_FINDBYIDORDERtoUserLogin(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                order = new Order();
                order.setIdOrder(rs.getInt(1));
                order.setNameReceiver(rs.getString(2));
                order.setPhone(rs.getString(3));
                order.setAddress(rs.getString(4));
                order.setDate(rs.getString(5));
                order.setStatus(rs.getBoolean(6));
                order.setTotal(rs.getFloat(7));

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
        return order;
    }

    @Override
    public List<OrderItem> showOrder() {
        List<OrderItem> orderItemList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call PROC_SHOWOrderDetailToAdmin()}");
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setId(rs.getInt(1));
                orderItem.setNameReceiver(rs.getString(2));
                orderItem.setPhone(rs.getString(3));
                orderItem.setAddress(rs.getString(4));
                orderItem.setDate(rs.getString(5));
                orderItem.setStatus(rs.getBoolean(6));
                orderItem.setTotal(rs.getFloat(7));
                orderItemList.add(orderItem);
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
        return orderItemList;
    }

    @Override
    public List<OrderItem> showOrderToAccount(int id) {
        List<OrderItem> orderItemList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call PROC_FINDBYIDORDERtoUserLogin(?)}");
            callableStatement.setInt(1,id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setId(rs.getInt(1));
                orderItem.setNameReceiver(rs.getString(2));
                orderItem.setPhone(rs.getString(3));
                orderItem.setAddress(rs.getString(4));
                orderItem.setDate(rs.getString(5));
                orderItem.setStatus(rs.getBoolean(6));
                orderItem.setTotal(rs.getFloat(7));
                orderItemList.add(orderItem);
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
        return orderItemList;
    }

    @Override
    public List<OrderItem> showOrderItem(int id) {
        List<OrderItem> orderItemList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call PROC_SHOWOrderDetail(?)}");
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setId(rs.getInt(1));
                orderItem.setStatus(rs.getBoolean(2));
                orderItem.setNameProduct(rs.getString(3));
                orderItem.setPrice(rs.getFloat(4));
                orderItem.setImage(rs.getString(5));
                orderItem.setQuantity(rs.getInt(6));
                orderItem.setUserName(rs.getString(7));
                orderItem.setNameReceiver(rs.getString(8));
                orderItem.setPhone(rs.getString(9));
                orderItem.setAddress(rs.getString(10));
                orderItem.setTotal(rs.getFloat(11));
                orderItem.setNameCatalog(rs.getString(12));
                orderItemList.add(orderItem);
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
        return orderItemList;
    }

    @Override
    public List<OrderItem> showOrderToUser(int id) {
        List<OrderItem> orderItemList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call PROC_SHOWOrderDetailToUser(?)}");
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setId(rs.getInt(1));
                orderItem.setStatus(rs.getBoolean(2));
                orderItem.setNameProduct(rs.getString(3));
                orderItem.setPrice(rs.getFloat(4));
                orderItem.setImage(rs.getString(5));
                orderItem.setQuantity(rs.getInt(6));
                orderItem.setUserName(rs.getString(7));
                orderItem.setNameReceiver(rs.getString(8));
                orderItem.setPhone(rs.getString(9));
                orderItem.setAddress(rs.getString(10));
                orderItem.setTotal(rs.getFloat(11));
                orderItem.setNameCatalog(rs.getString(12));
                orderItem.setDate(rs.getString(13));
                orderItemList.add(orderItem);
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
        return orderItemList;
    }

    @Override
    public boolean checkValidatePhone(String phone) {
        return Validate.setValidatePhone(phone);
    }

    @Override
    public boolean saveOrderDetail(OrderDetail orderDetail) {
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call PROC_CREATEOrderDetail(?,?)}");

            callableStatement.setInt(1, orderDetail.getIdOrder());
            callableStatement.setInt(2, orderDetail.getIdCart());
            callableStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionToDB.close(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
}
