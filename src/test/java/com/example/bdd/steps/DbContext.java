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
    private final List<String> tables;

    public DbContext(EntityManager entityManager) {
        this.entityManager = entityManager;
        tables = List.of("users");
    }

    @Before
    public void truncate() {
        tables.forEach(this::truncate);
    }

    private void truncate(String table) {
        entityManager.createNativeQuery(String.format("TRUNCATE TABLE %s", table)).executeUpdate();
    }
}
