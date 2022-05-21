package controller;

import dao.userDAO.UserDAO;
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

    public void init() {
        userDAO = new UserDAO();
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
                    deleteUser(request, response);
                    break;
                case "search":
                    showSearchForm(request, response);
                    break;
                case "logout":
                    logoutAccount(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void logoutAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listUser = userDAO.selectAll();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/search.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.delete(id);

        List<User> listUser = userDAO.selectAll();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDAO.selectAll().get(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
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
                    insertUser1(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
                case "search":
                    searchUserByName(request, response);
                    break;
                default:
                    loginAccount(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void loginAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<User> userList = userDAO.selectAll();
        boolean check = true;
        if (username.equals("Admin_Hung")&&password.equals("hungdz")||
                username.equals("Admin_Binh")&&password.equals("binhdz")||
                        username.equals("Admin_Thanh")&&password.equals("thanhdz")){
            check = false;
            RequestDispatcher dispatcher = request.getRequestDispatcher("blog/admin.jsp");
            dispatcher.forward(request, response);
        }
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUserName())) {
                if (password.equals(userList.get(i).getPassWord())) {
                    check = false;
                    RequestDispatcher dispatcher = request.getRequestDispatcher("blog/home.jsp");
                    dispatcher.forward(request, response);
                }
            }
        }
        if (check) {
            String mes = "*sai thông tin đăng nhập!hãy thử lại!*";
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
        if (password.equals(rePassword)){
        }else {
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

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String img = request.getParameter("img");
        User newUser = new User(username, email, password, img);
        userDAO.insert(newUser);
//      ***
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/login.jsp");
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String img = request.getParameter("img");

        User book = new User(id, username, email, password, img);
        userDAO.update(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
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
