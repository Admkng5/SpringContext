package ru.javapro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager em;

    // CRUD-операции

    @Transactional
    public void save(User user) {
        em.persist(user);
    }

    public User getById(Long id) {
        return em.find(User.class, id);
    }

    @Transactional
    public void update(User user) {
        em.merge(user);
    }

    @Transactional
    public void delete(Long id) {
        em.remove(em.find(User.class, id));
    }

    public List<User> getAll() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
}
