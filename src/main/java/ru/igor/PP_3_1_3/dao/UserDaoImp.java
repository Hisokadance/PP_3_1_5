package ru.igor.PP_3_1_3.dao;

import org.springframework.stereotype.Repository;
import ru.igor.PP_3_1_3.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT user FROM User user ", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByUsername(String username) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    @Override
    public void updateUser(User updateUser) {
        entityManager.merge(updateUser);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
