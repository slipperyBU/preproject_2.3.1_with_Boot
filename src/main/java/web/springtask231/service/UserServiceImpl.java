package web.springtask231.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.springtask231.dao.UserDAO;
import web.springtask231.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> index() {
        return userDAO.index();
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public User show(int id) {
        return userDAO.show(id);
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Override
    public void update(int id,User updatedUser) {
        userDAO.update(id,updatedUser);
    }
}
