package dao.userDAO;

import dao.IDAO;
import model.User;

import java.sql.SQLException;

public interface IUserDAO extends IDAO<User> {
    void insertLogin(User user) throws SQLException;
}
