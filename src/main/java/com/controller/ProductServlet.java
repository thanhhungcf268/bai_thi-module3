package com.controller;

import com.model.product.Category;
import com.model.product.Product;
import com.sevice.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {

            switch (action) {
                case "create":
                    showCreatProduct(request, response);
                    break;
                case "edit":
                    updateShow(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                default:
                    showList(request, response);
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.delete(id);
        response.sendRedirect("/products");
    }

    private void showCreatProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> list = productDAO.selectALLC();
        request.setAttribute("category", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/addNew.jsp");
        dispatcher.forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = productDAO.selectALL();
        List<Category> listCategory = productDAO.selectALLC();
        request.setAttribute("category", listCategory);
        request.setAttribute("product", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }

    private void updateShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.selectById(id);
        List<Category> list = productDAO.selectALLC();
        request.setAttribute("category", list);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        List<Category> list = productDAO.selectALLC();
        request.setAttribute("category", list);
        if (name.equals("")) {
            request.setAttribute("message", "Error!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/addNew.jsp");
            dispatcher.forward(request, response);
            return;
        }
        int soL = Integer.parseInt(request.getParameter("soL"));
        String color = request.getParameter("color");
        String moTa = request.getParameter("moTa");
        String id_category = request.getParameter("id_category");
        Product product = new Product(name, price, soL, color, moTa, id_category);
        boolean check = productDAO.create(product);
        if (!check) {
            request.setAttribute("message", "Error!");
        } else {
            request.setAttribute("message", "Success!");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/addNew.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {

            switch (action) {
                case "create":
                    createProduct(request, response);
                    break;
                case "edit":
                    update(request, response);
                    break;
                default:
                    showListSearch(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void showListSearch(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String search = request.getParameter("search");
        List<Product> list = productDAO.showSearch(search);
        List<Category> listCategory = productDAO.selectALLC();
        request.setAttribute("category", listCategory);
        if (search.equals("")) {
            showList(request, response);
        } else {
            request.setAttribute("product", list);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        if (name.equals("")){
            request.setAttribute("message", "Error!");
            updateShow(request,response);
            return;
        }
        double price = Double.parseDouble(request.getParameter("price"));
        int soL = Integer.parseInt(request.getParameter("soL"));
        String color = request.getParameter("color");
        String moTa = request.getParameter("moTa");
        String id_category = request.getParameter("id_category");
        Product product = new Product(name, price, soL, color, moTa, id_category);
        request.setAttribute("product", product);
        boolean isUpdate = productDAO.update(id, product);
        if (!isUpdate) {
            request.setAttribute("message", "Error!");
        } else {
            request.setAttribute("message", "Success!");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        dispatcher.forward(request, response);
    }
}
