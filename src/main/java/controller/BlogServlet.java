package controller;

import dao.blogDAO.BlogDAO;
import dao.userDAO.UserDAO;
import model.Blog;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

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
                case "delete1":
                    deleteBlog1(request, response);
                    break;
                case "search":
                    showSearchForm(request, response);
                    break;
                case "view":
                    viewBlog(request, response);
                    break;
                case "view1":
                    viewBlog1(request, response);
                    break;
                default:
                    listBlog(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void viewBlog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
        int idblog = Integer.parseInt(request.getParameter("idblog"));
        request.setAttribute("idblog",idblog);
        Blog blog = blogDAO.select(idblog);
        request.setAttribute("view",blog);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog/view.jsp");
        dispatcher.forward(request, response);
    }
    private void viewBlog1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
        int idblog = Integer.parseInt(request.getParameter("idblog"));
        request.setAttribute("idblog",idblog);
        Blog blog = blogDAO.select(idblog);
        request.setAttribute("view",blog);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/view.jsp");
        dispatcher.forward(request, response);
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
        int idblog = Integer.parseInt(request.getParameter("idblog"));
        request.setAttribute("idblog",idblog);
        Blog existingBlog = blogDAO.select(idblog);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog/edit.jsp");
        request.setAttribute("blog", existingBlog);
        dispatcher.forward(request, response);
    }
    private void deleteBlog(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
        int idblog = Integer.parseInt(request.getParameter("idblog"));
        request.setAttribute("idblog",idblog);
        Blog existingBlog = blogDAO.select(idblog);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog/delete.jsp");
        request.setAttribute("blog", existingBlog);
        dispatcher.forward(request, response);
    }
    private void deleteBlog1(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
        int idblog = Integer.parseInt(request.getParameter("idblog"));
        request.setAttribute("idblog",idblog);
        Blog existingBlog = blogDAO.select(idblog);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/delete.jsp");
        request.setAttribute("blog", existingBlog);
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

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
                case "delete":
                    delete_SQL_Blog(request, response);
                    break;
                case "delete1":
                    delete_SQL_Blog1(request, response);
                    break;
                case "search":
                    showSearchForm(request, response);
                    break;
                case "view":
                    viewBlog(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void delete_SQL_Blog(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
        int idblog = Integer.parseInt(request.getParameter("idblog"));
        request.setAttribute("idblog",idblog);
        blogDAO.delete2(id,idblog);
        List<Blog> blogs= blogDAO.selectByIDuser(id);
        request.setAttribute("blogs",blogs);
        if (blogs.size()==0){
            String mes = "not blogs!";
            request.setAttribute("mes",mes);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog/myBlog.jsp");
        dispatcher.forward(request, response);
    }
    private void delete_SQL_Blog1(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
        int idblog = Integer.parseInt(request.getParameter("idblog"));
        request.setAttribute("idblog",idblog);
        blogDAO.delete2(id,idblog);
        List<Blog> blogs= blogDAO.selectByIDuser(id);
        request.setAttribute("blogs",blogs);
        if (blogs.size()==0){
            String mes = "not blogs!";
            request.setAttribute("mes",mes);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/myblog.jsp");
        dispatcher.forward(request, response);
    }

    private void insertBlog(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        UserDAO userDAO =new UserDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
        String title = request.getParameter("title");
        String date = new Date()+"";
        String content = request.getParameter("content");
        String img = request.getParameter("img");
        String description = request.getParameter("description");
        int role = Integer.parseInt(request.getParameter("role"));
        User user = userDAO.select(id);
        Blog newblog= new Blog(title, date, content,img, description,role,user);
        blogDAO.insert(newblog);
        List<Blog> blogs = blogDAO.selectByIDuser(id);
        request.setAttribute("blogs",blogs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog/myBlog.jsp");
        dispatcher.forward(request, response);
    }

    private void updateBlog(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        UserDAO userDAO = new UserDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
        int idblog = Integer.parseInt(request.getParameter("idblog"));
        request.setAttribute("idblog",idblog);
        String title = request.getParameter("title");
        String date = blogDAO.select(idblog).getDate();
        String content = request.getParameter("content");
        String img = request.getParameter("img");
        String description = request.getParameter("description");
        int role = Integer.parseInt(request.getParameter("role"));
        User user = userDAO.select(id);
        Blog newblog= new Blog(idblog,title, date, content, img,description,role,user);
        blogDAO.update(newblog);
        Blog blog = blogDAO.select(idblog);
        request.setAttribute("view",blog);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog/view.jsp");
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
