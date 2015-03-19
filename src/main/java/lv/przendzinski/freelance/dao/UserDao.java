package lv.przendzinski.freelance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import lv.przendzinski.freelance.domain.User;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getUserCount() {
        return this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users", Integer.class);
    }

    public Boolean authenticateUser(String userName, String password) {
        Integer result = this.jdbcTemplate.queryForObject("SELECT count(*) FROM users WHERE name = ? AND password = ?", Integer.class, userName, password);
        return result != 0;
    }

    public void createUser(User user) {
        this.jdbcTemplate.update("INSERT INTO users (name, password, role) VALUES (?,?,?)", user.getName(), user.getPassword(), user.getRole());
    }

    public List<User> getAllUsers() {
        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User result = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                return result;
            }
        };
        return this.jdbcTemplate.query("SELECT id, name, password, role FROM users", rowMapper);
    }

    public User getByName(String userName) {
        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User result = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                return result;
            }
        };
        List<User> result = this.jdbcTemplate.query("SELECT id, name, password, role FROM users WHERE name = ?", rowMapper, userName);
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    public User getById(long userID) {
        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User result = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                return result;
            }
        };
        List<User> result = this.jdbcTemplate.query("SELECT id, name, password, role FROM users WHERE id = ?", rowMapper, userID);
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }
}
