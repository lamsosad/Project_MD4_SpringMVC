package lam.model.service.catalog;

import lam.model.entity.Catalog;
import lam.model.util.ConnectionToDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogServiceIMPL implements ICatalogService {
    @Override
    public List<Catalog> findAll() {
        List<Catalog> catalogList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call PROC_SHOWALLCATALOG()}");
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                Catalog catalog = new Catalog();
//                product.setNameProduct(rs.getString("p.name"));
                catalog.setIdCatalog(rs.getInt("idCatalog"));
                catalog.setNameCatalog(rs.getString("name"));
                catalog.setStatus(rs.getBoolean("status"));
                catalogList.add(catalog);
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
        return catalogList;
    }

    @Override
    public boolean save(Catalog catalog) {
        Connection connection = null;
        try {
            connection = ConnectionToDB.getConnection();
            CallableStatement callSt = connection.prepareCall("{call PROC_CREATECATALOG(?)}");
            callSt.setString(1, catalog.getNameCatalog());
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
    public boolean update(Catalog catalog) {
        Connection conn = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_EDITCATALOG(?,?,?)}");
            callSt.setInt(1, catalog.getIdCatalog());
            callSt.setString(2, catalog.getNameCatalog());
            callSt.setBoolean(3, catalog.isStatus());
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
    public Catalog findById(int id) {
        Connection conn = null;
        Catalog catalog = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_FINDBYIDCATALOG(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                catalog = new Catalog();
                catalog.setIdCatalog(rs.getInt(1));
                catalog.setNameCatalog(rs.getString(2));
                catalog.setStatus(rs.getBoolean(3));
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
        return catalog;
    }

    @Override
    public boolean delete(int id) {
        Connection conn = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_DELETECATALOG(?)}");
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
    public Catalog findByName(String name) {
        Connection conn = null;
        Catalog catalog = null;
        try {
            conn = ConnectionToDB.getConnection();
            CallableStatement callSt = conn.prepareCall("{call PROC_FINDBYNAMECATALOG(?)}");
            callSt.setString(1, name);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                catalog = new Catalog();
                catalog.setIdCatalog(rs.getInt(1));
                catalog.setNameCatalog(rs.getString(2));
                catalog.setStatus(rs.getBoolean(3));
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
        return catalog;
    }
}
