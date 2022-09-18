package com.tvaprodut.saleweb.dao;

import com.tvaprodut.saleweb.model.Customers;
import com.tvaprodut.saleweb.until.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.SecondaryTable;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class CustomerDao{
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//    private static final Session a session = sessionFactory.openSession();

    public CustomerDao() {

    }

    public static CustomerDao getCustomerDao(SessionFactory entityManager) {
        return new CustomerDao();
    }

    public List<Customers> getCustomersList() {
        List<Customers> customers = new ArrayList<>();
        try(Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Customers> criteriaQuery = builder.createQuery(Customers.class);
//            Set<EntityType<?>> entityTypes = session.getEntityManagerFactory()
//                    .getMetamodel()
//                    .getEntities();
//            EntityType<Customers> entityType = null;
//            for (EntityType i : entityTypes) {
//                if (i.getName().equals("Customers")) entityType = i;
//            }
            Root<Customers> root = criteriaQuery.from(Customers.class);
            criteriaQuery.select(root);
            customers = session.createQuery(criteriaQuery).getResultList();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return customers;
    }

    public Customers addCustomer(Customers customer) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction.begin();
            session.save(customer);
            transaction.commit();
            session.close();
        }catch (Exception e) {
            if (transaction == null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return customer;
    }

    public Customers findCustomerByID(int customerID) {
        Customers customer = new Customers();
        try(Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Customers> criteriaQuery = builder.createQuery(Customers.class);
            Set<EntityType<?>> entityTypes = session.getEntityManagerFactory()
                    .getMetamodel()
                    .getEntities();
            EntityType<Customers> entityType = null;
            for (EntityType i : entityTypes) {
                if (i.getName().equals("Customers")) entityType = i;
            }
            Root<Customers> root = criteriaQuery.from(entityType);
            criteriaQuery.select(root).where(builder.equal(root.get("customerNumber"),customerID));
            List<Customers> test = session.createQuery(criteriaQuery).getResultList();
            System.out.printf("123");
            customer = session.createQuery(criteriaQuery).getSingleResult();
//            customer = session.createQuery(criteriaQuery).getSingleResult();
            System.out.printf("123");
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return customer;
    }
}

