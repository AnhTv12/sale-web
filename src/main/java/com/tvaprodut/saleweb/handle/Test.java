package com.tvaprodut.saleweb.handle;

import com.tvaprodut.saleweb.dao.CustomerDao;
import com.tvaprodut.saleweb.model.Customers;
import com.tvaprodut.saleweb.model.Order;
import com.tvaprodut.saleweb.until.HibernateUtil;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;
import java.util.List;


public class Test {
    public static void main(String[] args) {
        Transaction transaction = null;
        CustomerDao customerDao = CustomerDao.getCustomerDao();
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
//            JpaCriteriaQuery<Customers> criteriaQuery = builder.createQuery(Customers.class);
//            JpaRoot<Customers> root = CustomerDao.getCriteriaQuery().from(Customers.class);
//            CustomerDao.getCriteriaQuery().select(root);
            List<Customers> customers;
            try {
                customers = customerDao.getCustomersList();
//                orders = session.createQuery(criteriaQuery).getResultList();
                customers.forEach(x->System.out.println(x.getContactFirstName()));
            } catch (NoResultException exception) {
                exception.printStackTrace();
            }
//        }
    }
}