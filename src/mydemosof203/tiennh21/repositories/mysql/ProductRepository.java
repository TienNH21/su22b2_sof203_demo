package mydemosof203.tiennh21.repositories.mysql;

import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import mydemosof203.tiennh21.models.Product;
import mydemosof203.tiennh21.utils.JdbcUtil;

public class ProductRepository implements BaseRepositoryInterface<Integer, Product> {

    @Override
    public Product insert(Product entity) {
        Connection conn = JdbcUtil.getConnection();
        String sql = "INSERT INTO products(name, color, quantity, price, category_id) "
            + "VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getColor());
            ps.setInt(3, entity.getQuantity());
            ps.setDouble(4, entity.getPrice());
            ps.setInt(5, entity.getCategoryId());
            
            ps.executeUpdate();
            
            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Product update(Integer key, Product entity) {
        Connection conn = JdbcUtil.getConnection();
        String sql = "UPDATE products SET "
            + " name = ?,"
            + " color = ?,"
            + " quantity = ?,"
            + " price = ?,"
            + " category_id = ? "
            + " WHERE id = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getColor());
            ps.setInt(3, entity.getQuantity());
            ps.setDouble(4, entity.getPrice());
            ps.setInt(5, entity.getCategoryId());
            ps.setInt(6, key);
            
            ps.executeUpdate();
            
            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Product delete(Product entity) {
        String sql = "DELETE FROM products WHERE id = ?";
        Connection conn = JdbcUtil.getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, entity.getId());
            ps.executeUpdate();
            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public ArrayList<Product> paginate(int page, int limit) {
        int offset = (page - 1) * limit;
        String sql = "SELECT * FROM products LIMIT ? OFFSET ?";
        Connection conn = JdbcUtil.getConnection();
        ArrayList<Product> listProd = new ArrayList<>();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String color = rs.getString("color");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                int cateId = rs.getInt("category_id");
                
                Product p = new Product(id, name, quantity, price, color, cateId);
                listProd.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listProd;
    }

    @Override
    public Product findById(Integer key) {
        String sql = "SELECT * FROM products WHERE id = ?";
        Connection conn = JdbcUtil.getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, key);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String color = rs.getString("color");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                int cateId = rs.getInt("category_id");
                
                Product p = new Product(id, name, quantity, price, color, cateId);

                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
}
