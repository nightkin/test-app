package lv.przendzinski.freelance.dao;

import lv.przendzinski.freelance.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */

@Repository
public class TaskDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    RowMapper<Task> rowMapper = new RowMapper<Task>() {
        @Override
        public Task mapRow(ResultSet resultSet, int i) throws SQLException {
            Task result = new Task();
            result.setId(resultSet.getInt(1));
            result.setTitle(resultSet.getString(2));
            result.setDescription(resultSet.getString(3));
            result.setDateCreated(resultSet.getLong(4));
            result.setDeadline(resultSet.getLong(5));
            result.setReporter(resultSet.getLong(6));
            result.setAssignee(resultSet.getLong(7));
            result.setBounty(resultSet.getLong(8));

            return result;
        }
    };

    public void createTask(Task task) {
        this.jdbcTemplate.update("INSERT INTO tasks (title, body, created, deadline, owner_id, bounty) VALUES (?,?,?,?,?,?)",
                task.getTitle(), task.getDescription(), System.currentTimeMillis(), task.getDeadline(), task.getReporter(), task.getBounty());
    }

    public void deleteTask(long taskId, long ownerId) {
        this.jdbcTemplate.update("DELETE FROM tasks WHERE id=? AND owner_id=?", taskId, ownerId);
    }

    public void setAssignee(long userId, long taskId, long ownerId) {
        this.jdbcTemplate.update("UPDATE tasks SET assignee_id = ? WHERE id = ? AND owner_id = ?", userId, taskId, ownerId);
    }

    public Task getTaskById(long taskId) {
        List<Task> result = this.jdbcTemplate.query("SELECT * FROM tasks WHERE id=?", rowMapper, taskId);
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    public Task viewTask(long taskId, long ownerId) {
        List<Task> result = this.jdbcTemplate.query("SELECT * FROM tasks WHERE id=? AND (owner_id=? OR deadline < ?)", rowMapper, taskId, ownerId, System.currentTimeMillis());
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    public List<Task> getOpenTasks() {
        return this.jdbcTemplate.query("SELECT * FROM tasks WHERE deadline < ? AND assignee_id = null", rowMapper, System.currentTimeMillis());
    }

    public List<Task> getUserOwnedTasks(long userId) {
        return this.jdbcTemplate.query("SELECT * FROM tasks WHERE owner_id = ?", rowMapper, userId);
    }

    public List<Task> getUserAssignedTasks(long userId) {
        return this.jdbcTemplate.query("SELECT * FROM tasks WHERE assignee_id = ?", rowMapper, userId);
    }

}
