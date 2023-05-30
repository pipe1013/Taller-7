package model.repository;

import util.ConnectionPool;
import model.Category;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements model.repository.Repository<Category>{
    private  String sql = null;
    @Override
    public List<Category> listAllObj() throws SQLException {
        sql = "select c.Category_id, c.Category_name";

        List<Category> categories= new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                Category c = createObj(rs);
                categories.add(c);
            }//While
        }// try

        return categories;
    } // listAllObj


    @Override
    public Category byIdObj(Integer id) throws SQLException {
        sql = "select c.Category_id, .Category_name";
        Category category =null;
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    category = createObj(rs);
                }
            }
        }//Try
        return category;
    }//byIdObj

    @Override
    public Integer saveObj(Category category) throws SQLException {
        int rowsAffected =0;
        if (category.getCategory_id()!=null && category.getCategory_id()>0){
            sql = "update Category_tbl set Category_name=?"
                    +" where Category_id=?";

        } else {
            sql = "insert into Category_tbl(Category_name)"+
                    "values(upper(?))";
        }
        try(Connection conn =ConnectionPool.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, category.getCategory_name());
            if (category.getCategory_id()!=null) {
                ps.setInt(5, category.getCategory_id());
            }
            rowsAffected =ps.executeUpdate();
        }
        return rowsAffected;
    }//saveObj

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql= "delete from Category_tbl where c.Category_id=?";
        try(Connection conn = ConnectionPool.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }//try
    }//deleteObj

    @Override
    public Category createObj(ResultSet rs) throws SQLException {
        Category category = new Category();
        category.setCategory_id(rs.getInt("Category_id"));
        category.setCategory_name(rs.getString("Category_name"));

        return category;
    }
}
