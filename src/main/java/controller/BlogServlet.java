package controller;

import dao.blogDAO.BlogDAO;
import model.Blog;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BlogServlet", value = "/BlogServlet")
public class BlogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BlogDAO blogDAO;

    @Override
    public void init() {
        blogDAO = new BlogDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteBlog(request, response);
                    break;
                case "search":
                    showSearchForm(request, response);
                    break;
                case "view":
                    viewBlog(request, response);
                    break;
                default:
                    listBlog(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void viewBlog(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
    }

    private void listBlog(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
        List<Blog> blogs = blogDAO.selectAll();
        System.out.println(blogs);
        request.setAttribute("listAll", blogs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("myBlog.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog/blogCreate.jsp");
        dispatcher.forward(request, response);
    }
    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog/search.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
        Blog existingBlog = blogDAO.select(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog/edit.jsp");
        request.setAttribute("product", existingBlog);
        dispatcher.forward(request, response);
    }
    private void deleteBlog(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
        List<Blog> blogs = blogDAO.selectAll();
        request.setAttribute("listAll", blogs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
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
                    insertBlog(request, response);
                    break;
                case "edit":
                    updateBlog(request, response);
                    break;
                case "search":
                    searchUserByName(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void insertBlog(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String title = request.getParameter("title");
        String date = request.getParameter("date");
        String content = request.getParameter("content");
//        String img = request.getParameter("img");
        String description = request.getParameter("description");
//        int role = Integer.parseInt(request.getParameter("role"));
        Blog newblog= new Blog(title, date, content, description);
        blogDAO.insert(newblog);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog/myBlog.jsp");
        dispatcher.forward(request, response);
    }

    private void updateBlog(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String date = request.getParameter("date");
        String content = request.getParameter("content");
        String img = request.getParameter("img");
        String description = request.getParameter("description");
        int role = Integer.parseInt(request.getParameter("role"));

        Blog newblog= new Blog(id,title, date, content, img,description,role);
        blogDAO.update(newblog);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog/edit.jsp");
        dispatcher.forward(request, response);
    }
    private void searchUserByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        List<Blog> blogs = blogDAO.searchByName(title);
        request.setAttribute("listTitle", blogs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog/searchListUser.jsp");
        dispatcher.forward(request, response);
    }
}
