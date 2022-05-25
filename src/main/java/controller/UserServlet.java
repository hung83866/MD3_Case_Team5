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
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    private BlogDAO blogDAO = new BlogDAO();

    public void init() {
        userDAO = new UserDAO();
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
                case "edit1":
                    showEditForm1(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;

                case "deleteUser":
                    deleteForm(request, response);
                    break;
                case "search":
                    showSearchForm(request, response);
                    break;
                case "search1":
                    showSearchForm1(request, response);
                    break;
                case "logout":
                    logoutAccount(request, response);
                    break;
                case "profile":
                    showProfile(request, response);
                    break;
                case "profile1":
                    showProfile1(request, response);
                    break;
                case "userlist":
                    showUserList(request, response);
                    break;
                case "myblog":
                    showMyBlogList(request, response);
                    break;
                case "myblog1":
                    showMyBlogList1(request, response);
                    break;
                case "myblog2":
                    showMyBlogList2(request, response);
                    break;
                case "newpass":
                    showNewPass(request, response);
                    break;
                case "newpass1":
                    showNewPass1(request, response);
                    break;
                case "adminBlog":
                    showListBlog1(request, response);
                    break;
                default:
                    showListBlog(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void deleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        User user = userDAO.select(id);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/deleteUser.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/newpass.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewPass1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/newpass1.jsp");
        dispatcher.forward(request, response);
    }

    private void showListBlog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        List<Blog> blogs = blogDAO.selectAll();
        request.setAttribute("blogs", blogs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog/home.jsp");
        dispatcher.forward(request, response);
    }

    private void showListBlog1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Blog> blogs = blogDAO.selectAll();
        request.setAttribute("blogs", blogs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/home1.jsp");
        dispatcher.forward(request, response);
    }

    private void showMyBlogList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        List<Blog> blogs = blogDAO.selectByIDuser(id);
        request.setAttribute("blogs", blogs);
        if (blogs.size() == 0) {
            String mes = "not blogs!";
            request.setAttribute("mes", mes);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog/myBlog.jsp");
        dispatcher.forward(request, response);
    }

    private void showMyBlogList2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        int iduser = Integer.parseInt(request.getParameter("iduser"));
        request.setAttribute("iduser", iduser);
        List<Blog> blogs = blogDAO.selectByIDuser(id);
        request.setAttribute("blogs", blogs);
        User user = userDAO.select(id);
        request.setAttribute("user", user);
        if (blogs.size() == 0) {
            String mes = "not blogs!";
            request.setAttribute("mes", mes);
        }

        if (id == iduser) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("blog/myBlog.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("blog/myblog1.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void showMyBlogList1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        List<Blog> blogs = blogDAO.selectByIDuser(id);
        request.setAttribute("blogs", blogs);
        if (blogs.size() == 0) {
            String mes = "not blogs!";
            request.setAttribute("mes", mes);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/myblog.jsp");
        dispatcher.forward(request, response);
    }


    private void showUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userDAO.selectAll();
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/admin.jsp");
        dispatcher.forward(request, response);
    }

    private void showProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        User existingUser = userDAO.select(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/profile.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    private void showProfile1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        User existingUser = userDAO.select(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/profile1.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    private void logoutAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }


    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        request.setAttribute("id", id);
        String name = request.getParameter("name");
        request.setAttribute("name", name);
        List<User> users = userDAO.searchByName(name);
        if (users.size() == 0) {
            String mes = "not found !";
            request.setAttribute("mes", mes);
        }
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/search.jsp");
        dispatcher.forward(request, response);
    }

    private void showSearchForm1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        String name = request.getParameter("name");
        request.setAttribute("name", name);
        List<Blog> blogs = blogDAO.searchByName(name);
        if (blogs.size() == 0) {
            String mes = "not found !";
            request.setAttribute("mes", mes);
        }
        request.setAttribute("blogs", blogs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog/search.jsp");
        dispatcher.forward(request, response);
    }
    private void showSearchForm2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        request.setAttribute("name", name);
        List<Blog> blogs = blogDAO.searchByName(name);
        if (blogs.size() == 0) {
            String mes = "not found !";
            request.setAttribute("mes", mes);
        }
        request.setAttribute("blogs", blogs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/search1.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.delete(id);
        request.setAttribute("id", id);
        String mes = "successful delete!";
        request.setAttribute("mes", mes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteUser1(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.delete(id);
        request.setAttribute("id", id);
        List<User> listUser = userDAO.selectAll();
        request.setAttribute("users", listUser);
        String mes = "successful delete!";
        request.setAttribute("mes", mes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/admin.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        User existingUser = userDAO.selectAll().get(id - 1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    private void showEditForm1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        User existingUser = userDAO.selectAll().get(id - 1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/edit1.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
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
                    insertUser1(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
                case "edit1":
                    updateUser1(request, response);
                    break;
                case "deleteUser":
                    deleteUser1(request, response);
                    break;
                case "search":
                    showSearchForm(request, response);
                    break;
                case "search1":
                    showSearchForm1(request, response);
                    break;
                case "search2":
                    showSearchForm2(request, response);
                    break;
                case "newpass":
                    newPass(request, response);
                    break;
                case "newpass1":
                    newPass1(request, response);
                    break;
                default:
                    loginAccount(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void newPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String oldPass = request.getParameter("oldpassword");
        String newPass = request.getParameter("newpassword");
        String rePass = request.getParameter("repassword");
        request.setAttribute("id", id);
        User user = userDAO.select(id);
        if (newPass.equals(rePass)) {
            if (user.getPassWord().equals(oldPass)) {
                String mes1 = "*Đổi mật khẩu thành công!*";
                request.setAttribute("mes1", mes1);
                userDAO.editPassword(id, newPass);
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            } else {
                String mes = "*Mật khẩu không chính xác!*";
                request.setAttribute("mes", mes);
                RequestDispatcher dispatcher = request.getRequestDispatcher("user/newpass.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            String mess = "*Mật khẩu không khớp!*";
            request.setAttribute("mess", mess);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/newpass.jsp");
            dispatcher.forward(request, response);
        }

    }

    private void newPass1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String oldPass = request.getParameter("oldpassword");
        String newPass = request.getParameter("newpassword");
        String rePass = request.getParameter("repassword");
        request.setAttribute("id", id);
        User user = userDAO.select(id);
        if (newPass.equals(rePass)) {
            if (user.getPassWord().equals(oldPass)) {
                String mes1 = "*Đổi mật khẩu thành công!*";
                request.setAttribute("mes1", mes1);
                List<User> users = userDAO.selectAll();
                request.setAttribute("users", users);
                userDAO.editPassword(id, newPass);
                RequestDispatcher dispatcher = request.getRequestDispatcher("admin/admin.jsp");
                dispatcher.forward(request, response);
            } else {
                String mes = "*Mật khẩu không chính xác!*";
                request.setAttribute("mes", mes);
                RequestDispatcher dispatcher = request.getRequestDispatcher("admin/newpass1.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            String mess = "*Mật khẩu không khớp!*";
            request.setAttribute("mess", mess);
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin/newpass1.jsp");
            dispatcher.forward(request, response);
        }

    }

    private void loginAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<User> userList = userDAO.selectAll();
        boolean check = true;
        if (username.equals("Admin_Hung") && password.equals("hungdz") ||
                username.equals("Admin_Binh") && password.equals("binhdz") ||
                username.equals("Admin_Thanh") && password.equals("thanhdz")) {
            check = false;
            List<User> users = userDAO.selectAll();
            request.setAttribute("users", users);
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin/admin.jsp");
            dispatcher.forward(request, response);
        }
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUserName())) {
                if (password.equals(userList.get(i).getPassWord())) {
                    check = false;
                    int id = i + 1;
                    request.setAttribute("id", id);
                    List<Blog> blogs = blogDAO.selectAll();
                    request.setAttribute("blogs", blogs);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("blog/home.jsp");
                    dispatcher.forward(request, response);
                }
            }
        }

        if (check) {
            String mes = "*sai thông tin đăng nhập!hãy thử lại!* ";
            request.setAttribute("mes", mes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }


    private void insertUser1(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("repass");
        List<User> userList = userDAO.selectAll();
        boolean check = true;
        if (password.equals(rePassword)) {
        } else {
            check = false;
            String messs1 = "password incorrect!";
            request.setAttribute("mes4", messs1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
            dispatcher.forward(request, response);
        }
        if (username.equals("") || email.equals("") || password.equals("")) {
            check = false;
            String messs = " Not null! ";
            request.setAttribute("mes3", messs);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
            dispatcher.forward(request, response);
        }
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUserName())) {
                check = false;
                String mes = " Used password! ";
                request.setAttribute("mes1", mes);
                RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
                dispatcher.forward(request, response);
            }
            if (email.equals(userList.get(i).getEmail())) {
                check = false;
                String mess = " Used Email! ";
                request.setAttribute("mes2", mess);
                RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
                dispatcher.forward(request, response);
            }
        }
        if (check) {
            User newUser = new User(username, email, password);
            userDAO.insertLogin(newUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }



    private void updateUser1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String img = request.getParameter("img");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String address = request.getParameter("address");
        String telephonenumber = request.getParameter("telephonenumber");
        request.setAttribute("id", id);
        User user = new User(id, username, email, password, img, firstname, lastname, address, telephonenumber);
        userDAO.update(user);
        String mes = "edit done!";
        request.setAttribute("mes", mes);
        User existingUser = userDAO.selectAll().get(id - 1);
        request.setAttribute("user", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
//        int idblog = Integer.parseInt(request.getParameter("idblog"));
//        request.setAttribute("idblog",idblog);
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String img = request.getParameter("img");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String address = request.getParameter("address");
        String telephonenumber = request.getParameter("telephonenumber");
        request.setAttribute("id", id);
        User user = new User(id, username, email, password, img, firstname, lastname, address, telephonenumber);
        userDAO.update(user);
        String mes = "edit done!";
        request.setAttribute("mes", mes);
        User existingUser = userDAO.selectAll().get(id - 1);
        request.setAttribute("user", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/edit1.jsp");
        dispatcher.forward(request, response);
    }

    private void searchUserByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        List<User> listUser = userDAO.searchByName(username);
        request.setAttribute("listUsers", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/searchListUser.jsp");
        dispatcher.forward(request, response);
    }
}
