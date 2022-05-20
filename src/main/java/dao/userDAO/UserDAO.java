package dao.userDAO;

import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserDAO implements IUserDAO{
    @Override
    public void insert(User user) throws SQLException {

    }

    @Override
    public User select(int id) {
        return null;
    }

    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(User user) throws SQLException {
        return false;
    }

    @Override
    public List<User> searchByName(String name) {
        return null;
    }
}
