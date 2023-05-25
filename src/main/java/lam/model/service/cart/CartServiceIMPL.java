package lam.model.service.cart;

import lam.model.entity.Cart;
import lam.model.entity.CartDetail;

import lam.model.util.ConnectionToDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartServiceIMPL implements ICartService {
    @Override
    public List<Cart> findAll() {
        return null;
    }

    @Override
    public boolean save(Cart cart) {
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call PROC_ADDTOCART(?,?)}");
            callableStatement.setInt(1, cart.getIdProduct());
            callableStatement.setInt(2, cart.getIdUser());
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
    public boolean update(Cart cart) {
        Connection conn = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_CHECKCOINCIDECART(?,?)}");
            callSt.setInt(1, cart.getIdUser());
            callSt.setInt(2, cart.getIdProduct());
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
    public Cart findById(int id) {
        Connection conn = null;
        Cart cart = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_FINDBYID(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                cart = new Cart();
                cart.setIdCart(rs.getInt(1));
                cart.setIdProduct(rs.getInt(2));
                cart.setIdUser(rs.getInt(3));
                cart.setQuantityBuy(rs.getInt(4));
                cart.setStatus(rs.getBoolean(5));
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
        return cart;
    }

    @Override
    public boolean delete(int id) {
        Connection conn = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_DELETECARTITEM(?)}");
            callSt.setInt(1, id);
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
    public List<CartDetail> showCart(int userLogin) {
        List<CartDetail> cartDetailList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call PROC_SHOWCART(?)}");
            callableStatement.setInt(1, userLogin);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                CartDetail cartDetail = new CartDetail();
                cartDetail.setIdCartDetail(rs.getInt(1));
                cartDetail.setProductName(rs.getString(2));
                cartDetail.setProductPrice(rs.getFloat(3));
                cartDetail.setProductImage(rs.getString(4));
                cartDetail.setCatalogName(rs.getString(5));
                cartDetail.setQuantityBuy(rs.getInt(6));
                cartDetail.setProductTotal(rs.getFloat(7));
                cartDetailList.add(cartDetail);
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
        return cartDetailList;
    }

    @Override
    public Cart findByIdProAndIdUser(int userId, int proId) {
        Connection conn = null;
        Cart cart = null;
        try {

            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_FINDBY_USERID_AND_PRODUCTID(?,?)}");
            callSt.setInt(1, userId);
            callSt.setInt(2, proId);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                cart = new Cart();
                cart.setIdCart(rs.getInt(1));
                cart.setIdProduct(rs.getInt(2));
                cart.setIdUser(rs.getInt(3));
                cart.setQuantityBuy(rs.getInt(4));
                cart.setStatus(rs.getBoolean(5));
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
        return cart;
    }

    @Override
    public Cart findByIdUser(int userId) {
        Connection conn = null;
        Cart cart = null;
        try {

            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_FINDBY_USERID(?)}");
            callSt.setInt(1, userId);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                cart = new Cart();
                cart.setIdCart(rs.getInt(1));
                cart.setIdProduct(rs.getInt(2));
                cart.setIdUser(rs.getInt(3));
                cart.setQuantityBuy(rs.getInt(4));
                cart.setStatus(rs.getBoolean(5));
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
        return cart;
    }

    @Override
    public boolean changeStatus(int id) {
        Connection conn = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_CHANGESTATUSCARTITEM(?)}");
            callSt.setInt(1, id);
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
    public boolean quantityUp(Cart cart) {
        Connection conn = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_QUANTITYUP(?)}");
            callSt.setInt(1, cart.getIdCart());
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
    public boolean quantityDown(Cart cart) {
        Connection conn = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_QUANTITYDOWN(?)}");
            callSt.setInt(1, cart.getIdCart());
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
    public float total(List<CartDetail> cartDetailList) {
        float total = 0;
        for (int i = 0; i < cartDetailList.size(); i++) {
            total += cartDetailList.get(i).getProductTotal();
        }
        return total;
    }
}
