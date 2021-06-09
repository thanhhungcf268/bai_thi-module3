package com.sevice;

import com.model.SQLconnection.SQLConnection;
import com.model.product.Category;
import com.model.product.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private Connection connection = SQLConnection.getConnection();

    public List<Category> selectALLC() {
        List<Category> list = new ArrayList<>();
        connection = SQLConnection.getConnection();
        try {
            String SELECT_ALL_USER = "select * from category";
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String category = resultSet.getString("category");
                int id = resultSet.getInt("id");
                list.add(new Category(category,id));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<Product> selectALL() {
        List<Product> list = new ArrayList<>();
        connection = SQLConnection.getConnection();
        try {
            String SELECT_ALL_USER = "select * from product p left join category c on p.id_category = c.id";
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("nameProduct");
                double price = resultSet.getDouble("price");
                int soL = resultSet.getInt("soL");
                String color = resultSet.getString("color");
                String moTa = resultSet.getString("moTa");
                String category = resultSet.getString("id_category");
                list.add(new Product(id, name, price, soL, color, moTa, category));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Product selectById(int ids) {
        Product list = new Product();
        connection = SQLConnection.getConnection();
        try {
            String SELECT_ALL_USER = "select * from product where id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            preparedStatement.setInt(1,ids);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("nameProduct");
                double price = resultSet.getDouble("price");
                int soL = resultSet.getInt("soL");
                String color = resultSet.getString("color");
                String moTa = resultSet.getString("moTa");
                String category = resultSet.getString("id_category");
                list = new Product(id, name, price, soL, color, moTa, category);
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
    public boolean create(Product product) throws SQLException {
        int rowInserted = 0;
        connection = SQLConnection.getConnection();
        String INSERT_USER = "insert into product (nameProduct , price, soL, color, moTa,id_category) VALUE (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setInt(3, product.getSoL());
        preparedStatement.setString(4, product.getColor());
        preparedStatement.setString(5, product.getMoTa());
        String a = product.getCategory();
        preparedStatement.setInt(6, Integer.parseInt(product.getCategory()));
        rowInserted = preparedStatement.executeUpdate();
        return rowInserted != 0;
    }
    public boolean update(int id,Product product){
        int rowInserted = 0;
        try {
            String UPDATE_USER = "update product set nameProduct = ?,price = ?,soL = ?,color = ? ,moTa =?,id_category=? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getSoL());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getMoTa());
            preparedStatement.setInt(6, Integer.parseInt(product.getCategory()));
            preparedStatement.setInt(7, id);
            rowInserted = preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return rowInserted != 0;
    }
    public void delete(int id) throws SQLException {
        String delete = "delete from product where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }

}
