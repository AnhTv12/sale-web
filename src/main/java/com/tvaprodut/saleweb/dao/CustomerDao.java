package com.tvaprodut.saleweb.dao;

import com.tvaprodut.saleweb.model.Customers;
import com.tvaprodut.saleweb.until.HibernateUtil;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private static HibernateCriteriaBuilder builder;
    private static JpaCriteriaQuery<Customers> criteriaQuery;

    private CustomerDao() {
        if (builder == null) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                builder = session.getCriteriaBuilder();
                criteriaQuery = builder.createQuery(Customers.class);
            } catch (NoResultException exception) {
                exception.printStackTrace();
            }
        }
    }

    public static CustomerDao getCustomerDao(){
        return new CustomerDao();
    }

    public List<Customers> getCustomersList(){
        List<Customers> customers = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            JpaRoot<Customers> root1 = criteriaQuery.from(Customers.class);
            criteriaQuery.select(root1);
            customers = session.createQuery(criteriaQuery).getResultList();
        } catch (NoResultException exception) {
            exception.printStackTrace();
        }
        return customers;
    }

    public static HibernateCriteriaBuilder getBuilder() {
        return builder;
    }

    public static JpaCriteriaQuery<Customers> getCriteriaQuery() {
        return criteriaQuery;
    }
}
