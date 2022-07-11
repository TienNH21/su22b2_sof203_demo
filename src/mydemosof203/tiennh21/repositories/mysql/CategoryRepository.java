package mydemosof203.tiennh21.repositories.mysql;

import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import mydemosof203.tiennh21.models.Category;

import mydemosof203.tiennh21.models.Product;
import mydemosof203.tiennh21.utils.JdbcUtil;

public class CategoryRepository implements CategoryRepositoryInterface {

    @Override
    public Category insert(Category entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Category update(Integer key, Category entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Category delete(Category entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Category> paginate(int page, int limit) {
        int offset = (page - 1) * limit;
        String sql = "SELECT * FROM categories LIMIT ? OFFSET ?";
        Connection conn = JdbcUtil.getConnection();
        ArrayList<Category> listCate = new ArrayList<>();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("----" + name);
                
                Category c = new Category(id, name);
                listCate.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listCate;
    }

    @Override
    public Category findById(Integer key) {
//        String sql = "SELECT * FROM products WHERE id = ?";
//        Connection conn = JdbcUtil.getConnection();
//        
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, key);
//            System.out.println(ps.toString());
//            ResultSet rs = ps.executeQuery();
//            
//            if (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String color = rs.getString("color");
//                int quantity = rs.getInt("quantity");
//                double price = rs.getDouble("price");
//                int cateId = rs.getInt("category_id");
//                
//                Product p = new Product(id, name, quantity, price, color, cateId);
//
//                return p;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        
        return null;
    }
    
    @Override
    public Category findByNameEqual(String name)
    {
        String sql = "SELECT * FROM categories WHERE name = ?";
        Connection conn = JdbcUtil.getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("id");
                Category c = new Category(id, name);

                return c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
}
