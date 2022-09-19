package com.tvaprodut.saleweb;

import com.tvaprodut.saleweb.service.CustomerService;
import com.tvaprodut.saleweb.model.Customers;
import com.tvaprodut.saleweb.until.HibernateUtil;
import org.hibernate.Session;
import org.springframework.boot.CommandLineRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.EntityType;


public class Test implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        CustomerService customerService = new CustomerService();
        customerService.getCustomersList().forEach(System.out::println);
        EntityType<Customers> entityType;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Customers> criteriaQuery = builder.createQuery(Customers.class);
            entityType = session.getEntityManagerFactory()
                    .getMetamodel()
                    .entity(Customers.class);
        }

    }
}