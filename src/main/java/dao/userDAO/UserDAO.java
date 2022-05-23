package dao.userDAO;

import dao.blogDAO.BlogDAO;
import model.Blog;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static config.DBconnection.getConnection;

public class UserDAO implements IUserDAO{
    private static final String INSERT_USER_SQL = "insert into user(username, email, password, img) VALUES (?, ?, ?, ?);";
    private static final String INSERT_LOGIN = "insert into user(username, email, password,img) VALUES (?, ?, ?,'');";
    private static final String SELECT_USER_BY_ID = "select id,username,email,password,img from user where id =?";
    private static final String SELECT_ALL_USER = "select * from user;";
    private static final String DELETE_USER_SQL = "delete from user where id = ?;";
    private static final String UPDATE_USER_SQL = "update user set username = ?,email= ?,password= ?,img= ? where id = ?;";
    private static final String SEARCH_BY_NAME = "select id,username,email,password,img from user where username = ?;";
    private static final String EDIT_USER_SQL = "update user set email =?,img =?, firstname =?, lastname =?, address= ?, telephoneNumber =? where id= ?";

    public UserDAO() {
    }

    @Override
    public void insert(User user) throws SQLException {
        System.out.println(INSERT_USER_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassWord());
            preparedStatement.setString(4,user.getImg());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    public static void main(String[] args) throws SQLException {
        UserDAO userDAO = new UserDAO();
        userDAO.insertLogin(new User("hungdz","hung@gmail.com","hung789"));
        System.out.println(userDAO.selectAll());
    }
    @Override
    public void insertLogin(User user) throws SQLException {
        System.out.println(INSERT_LOGIN);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LOGIN)) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassWord());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


    @Override
    public User select(int id) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String img=rs.getString("img");
                user = new User(id, username,email,password,img);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> selectAll() {
        BlogDAO blogDAO = new BlogDAO();
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String img = rs.getString("img");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String address = rs.getString("address");
                String telephonenumber = rs.getString("telephonenumber");
//                List<Blog> blogs = blogDAO.selectByIDuser(id);
                users.add(new User(id, username, email, password,img,firstname,lastname,address,telephonenumber));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(EDIT_USER_SQL);) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getImg());
            statement.setString(3, user.getFirstname());
            statement.setString(4, user.getLastname());
            statement.setString(5, user.getAddress());
            statement.setString(6, user.getTelephoneNumber());
            statement.setInt(7, user.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean editUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL);) {
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassWord());
            statement.setString(4, user.getImg());
            statement.setInt(5, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<User> searchByName(String name) {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME);) {
            preparedStatement.setString(1,name);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String img = rs.getString("img");
                users.add(new User(id, username, email, password,img));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }
}
