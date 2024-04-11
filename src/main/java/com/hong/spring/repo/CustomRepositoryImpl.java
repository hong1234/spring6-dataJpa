package com.hong.spring.repo;

import java.util.List;
// import java.util.Objects;

import org.springframework.stereotype.Repository;

import org.springframework.beans.factory.annotation.Qualifier;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;

import jakarta.persistence.TypedQuery;
// import jakarta.transaction.Transactional;

import com.hong.spring.entity.Customer;

@Repository
public class CustomRepositoryImpl implements CustomRepository {

    // private final JdbcTemplate jdbcTemplate;
    // private final SessionFactory sessionFactory;
    // private final EntityManager entityManager;

    @PersistenceContext
    private EntityManager entityManager;

    // public CustomRepositoryImpl(
        // JdbcTemplate jdbcTemplate,
        // SessionFactory sessionFactory,
        // @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {

        // this.jdbcTemplate = jdbcTemplate;
        // this.sessionFactory = sessionFactory;
        // this.entityManager = entityManagerFactory.createEntityManager();
    // }

    /**
     * An example using entityManager for fetching entity list.
     */
    // @Override
    // public List<Customer> getAll() {
    //     CriteriaQuery<Customer> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Customer.class);
    //     criteriaQuery.from(Customer.class);
    //     return entityManager.createQuery(criteriaQuery).getResultList();

    // }

    @Override
    public List<Customer> getAll() {
        String jpql = "SELECT c FROM Customer c";
        TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
        return query.getResultList();
    }

}