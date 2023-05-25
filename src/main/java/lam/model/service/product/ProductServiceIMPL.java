package lam.model.service.product;

import lam.model.entity.Product;
import lam.model.service.catalog.CatalogServiceIMPL;
import lam.model.util.ConnectionToDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPL implements IProductService {
    CatalogServiceIMPL catalogServiceIMPL = new CatalogServiceIMPL();

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call PROC_SHOWALL()}");
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setIdProduct(rs.getInt("p.id"));
                product.setNameProduct(rs.getString("p.name"));
                product.setImage(rs.getString("p.image"));
                product.setTitle(rs.getString("p.title"));
                product.setQuantity(rs.getInt("p.quantity"));
                product.setPrice(rs.getFloat("p.price"));
                product.setStatus(rs.getBoolean("p.status"));
                product.setCatalog(catalogServiceIMPL.findByName(rs.getString("c.name")));
                productList.add(product);
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
        return productList;
    }

    @Override
    public boolean save(Product product) {
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call PROC_CREATEPRODUCT(?,?,?,?,?,?)}");
            callableStatement.setString(1, product.getNameProduct());
            callableStatement.setString(2, product.getImage());
            callableStatement.setString(3, product.getTitle());
            callableStatement.setInt(4, product.getQuantity());
            callableStatement.setFloat(5, product.getPrice());
            callableStatement.setInt(6, product.getCatalog().getIdCatalog());
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
    public boolean update(Product product) {
        Connection conn = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_EDITPRODUCT(?,?,?,?,?,?,?,?)}");
            callSt.setInt(1, product.getIdProduct());
            callSt.setString(2, product.getNameProduct());
            callSt.setString(3, product.getImage());
            callSt.setString(4, product.getTitle());
            callSt.setInt(5, product.getQuantity());
            callSt.setFloat(6, product.getPrice());
            callSt.setInt(7, product.getCatalog().getIdCatalog());
            callSt.setBoolean(8, product.isStatus());
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
    public Product findById(int id) {
        Connection conn = null;
        Product product = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_FINDBYIDPRODUCT(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                product = new Product();
                product.setIdProduct(rs.getInt(1));
                product.setNameProduct(rs.getString(2));
                product.setImage(rs.getString(3));
                product.setTitle(rs.getString(4));
                product.setQuantity(rs.getInt(5));
                product.setPrice(rs.getFloat(6));
                product.setStatus(rs.getBoolean(7));
                product.setCatalog(catalogServiceIMPL.findById(rs.getInt(8)));
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
        return product;
    }

    @Override
    public boolean delete(int id) {
        Connection conn = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_DELETEPRODUCT(?)}");
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
    public List<Product> searchProduct(String nameSearch) {
        List<Product> product = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call PROC_SEARCHPRODUCT(?)}");
            callableStatement.setString(1, nameSearch);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setIdProduct(rs.getInt("p.id"));
                p.setNameProduct(rs.getString("p.name"));
                p.setImage(rs.getString("p.image"));
                p.setTitle(rs.getString("p.title"));
                p.setQuantity(rs.getInt("p.quantity"));
                p.setPrice(rs.getFloat("p.price"));
                p.setStatus(rs.getBoolean("p.status"));
                p.setCatalog(catalogServiceIMPL.findByName(rs.getString("c.name")));
                product.add(p);
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
        return product;
    }

    @Override
    public List<Product> showByCatalog(int id) {
        List<Product> list = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call PROC_SHOWALLBYCATALOG(?)}");
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setIdProduct(rs.getInt("p.id"));
                p.setNameProduct(rs.getString("p.name"));
                p.setImage(rs.getString("p.image"));
                p.setTitle(rs.getString("p.title"));
                p.setQuantity(rs.getInt("p.quantity"));
                p.setPrice(rs.getFloat("p.price"));
                p.setStatus(rs.getBoolean("p.status"));
                p.setCatalog(catalogServiceIMPL.findByName(rs.getString("c.name")));
                list.add(p);
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
        return list;
    }

    @Override
    public List<Product> findProductByPage(int page, int count) {
        List<Product> productList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call PROC_FINDPRODUCTBYPAGE(?,?)}");
            callableStatement.setInt(1,page);
            callableStatement.setInt(2,count);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setIdProduct(rs.getInt("p.id"));
                product.setNameProduct(rs.getString("p.name"));
                product.setImage(rs.getString("p.image"));
                product.setTitle(rs.getString("p.title"));
                product.setQuantity(rs.getInt("p.quantity"));
                product.setPrice(rs.getFloat("p.price"));
                product.setStatus(rs.getBoolean("p.status"));
                product.setCatalog(catalogServiceIMPL.findByName(rs.getString("c.name")));
                productList.add(product);
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
        return productList;
    }
}
