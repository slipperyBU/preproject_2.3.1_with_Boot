package web.springtask231.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.springtask231.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext(unitName = "entityManagerFactory")
    private  EntityManager entityManager;

    @Transactional
    @Override
    public List<User> index() {
        List<User> users = entityManager.createQuery("FROM User", User.class).getResultList();
        return users;
    }

    @Transactional
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
    @Transactional
    @Override
    public User show(int id) {
        return entityManager.find(User.class,id);
    }
    @Transactional
    @Override
    public void update(int id,User updatedUser) {
        User user = show(id);

        user.setName(updatedUser.getName());
        user.setLastName(updatedUser.getLastName());
        user.setAge(updatedUser.getAge());
        user.setEmail(updatedUser.getEmail());
        user.setAddress(updatedUser.getAddress());
    }
    @Transactional
    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class,id));
    }
}
