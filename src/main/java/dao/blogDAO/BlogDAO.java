package dao.blogDAO;

import config.DBconnection;
import dao.userDAO.UserDAO;
import model.Blog;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogDAO implements IBlogDAO{

    private static final String INSERT_BLOG_SQL = "INSERT INTO blog (title, date, content, img, description, role) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_BLOG_BY_ID = "select * from blog where id =?";
    private static final String SELECT_ALL_BLOGS = "select * from blog";
    private static final String DELETE_BLOGS_SQL = "delete from blog where id = ?;";
    private static final String UPDATE_BLOGS_SQL = "update blog set title=?, date=?, content=?, img=?, description=?, role=? where id = ?;";
    private static final String SEARCH_BY_NAME = "select title, date, content, img, description, role from blog where title = ?;";
    private static final String SELECT_BY_IDUSER = "SELECT * from BLOG where iduser=?;";
    public BlogDAO() {
    }


    @Override
    public void insert(Blog blog) throws SQLException {
        System.out.println(INSERT_BLOG_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DBconnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BLOG_SQL)) {
            preparedStatement.setString(1, blog.getTitle());
            preparedStatement.setString(2, blog.getDate());
            preparedStatement.setString(3, blog.getContent());
            preparedStatement.setString(4, blog.getImg());
            preparedStatement.setString(5, blog.getDescription());
            preparedStatement.setInt(6, blog.getRole());
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
    public Blog select(int id) {
        UserDAO userDAO = new UserDAO();
        Blog blog = null;
        // Step 1: Establishing a Connection
        try (Connection connection = DBconnection.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BLOG_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String title = rs.getString("title");
                String date = rs.getString("date");
                String content = rs.getString("content");
                String img = rs.getString("img");
                String descripttion = rs.getString("description");
                int role = Integer.parseInt(rs.getString("role"));
                int iduser = Integer.parseInt(rs.getString("iduser"));
                User user = userDAO.select(id);
                blog = new Blog(id, title, date, content, img,descripttion,role,user);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return blog;
    }

    public static void main(String[] args) {
        BlogDAO blogDAO = new BlogDAO();
        System.out.println(blogDAO.select(2));
    }

    @Override
    public List<Blog> selectAll() {
        UserDAO userDAO = new UserDAO();
        List<Blog> blogs = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = DBconnection.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BLOGS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String date = rs.getString("date");
                String content = rs.getString("content");
                String img = rs.getString("img");
                String descripttion = rs.getString("description");
                int role = rs.getInt("role");
                int iduser = rs.getInt("iduser");
                User user = userDAO.select(iduser);
                blogs.add(new Blog(id, title, date, content, img,descripttion,role,user));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return blogs;
    }

    public List<Blog> selectByIDuser(int iduser) {
        UserDAO userDAO = new UserDAO();
        List<Blog> blogs = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = DBconnection.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_IDUSER);) {
            preparedStatement.setInt(1, iduser);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String date = rs.getString("date");
                String content = rs.getString("content");
                String img = rs.getString("img");
                String descripttion = rs.getString("description");
                int role = rs.getInt("role");
                User user = userDAO.select(iduser);
                blogs.add(new Blog(id, title, date, content, img,descripttion,role,user));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return blogs;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBconnection.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_BLOGS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Blog blog) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBconnection.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_BLOGS_SQL);) {
            statement.setString(1, blog.getTitle());
            statement.setString(2, blog.getDate());
            statement.setString(3, blog.getContent());
            statement.setString(4, blog.getImg());
            statement.setString(5, blog.getDescription());
            statement.setInt(6, blog.getRole());
            statement.setInt(7,blog.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<Blog> searchByName(String name) {
        UserDAO userDAO = new UserDAO();
        List<Blog> blogs = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = DBconnection.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME);) {
            preparedStatement.setString(1, name);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String date = rs.getString("date");
                String content = rs.getString("content");
                String img = rs.getString("img");
                String descripttion = rs.getString("description");
                int role = rs.getInt("role");
                User user = userDAO.select(id);
                blogs.add(new Blog(id, title, date, content, img,descripttion,role,user));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return blogs;

    }
}
