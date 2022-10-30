package web.springtask231.dao;

import web.springtask231.models.User;

import java.util.List;

public interface UserDAO {
    List<User> index();

    void save(User user);

    User show(int id);

    void update(int id,User updatedUser);

    void delete(int id);
}
