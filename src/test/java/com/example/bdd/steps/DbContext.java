package com.example.bdd.steps;

import io.cucumber.java.Before;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class DbContext {
    @PersistenceContext
    private final EntityManager entityManager;

    public DbContext(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Before
    public void truncate() {
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate();
        getTables().forEach(this::truncate);
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate();
    }

    private List<String> getTables() {
        return (List<String>) entityManager
                .createNativeQuery("SELECT table_name FROM information_schema.tables WHERE table_schema = SCHEMA()")
                .getResultList();
    }

    private void truncate(String table) {
        entityManager.createNativeQuery(String.format("TRUNCATE TABLE %s", table)).executeUpdate();
    }
}
