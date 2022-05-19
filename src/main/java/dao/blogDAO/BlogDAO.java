package dao.blogDAO;

import model.Blog;

import java.sql.SQLException;
import java.util.List;

public class BlogDAO implements IBlogDAO{
    @Override
    public void insert(Blog blog) throws SQLException {

    }

    @Override
    public Blog select(int id) {
        return null;
    }

    @Override
    public List<Blog> selectAll() {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Blog blog) throws SQLException {
        return false;
    }
}
