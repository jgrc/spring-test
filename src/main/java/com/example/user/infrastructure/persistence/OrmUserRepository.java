package com.example.user.infrastructure.persistence;

import com.example.user.domain.model.User;
import com.example.user.domain.model.UserNotFoundException;
import com.example.user.domain.model.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class OrmUserRepository implements UserRepository {
    @PersistenceContext
    private final EntityManager em;

    public OrmUserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<User> all() {
        return em.createQuery("SELECT e FROM User e", User.class).getResultList();
    }

    @Override
    public User get(String id) {
        User user = em.find(User.class, id);
        if (user == null) {
            throw UserNotFoundException.fromId(id);
        }

        return user;
    }

    @Override
    @Transactional
    public void save(User user) {
        em.persist(user);
        em.flush();
    }
}
