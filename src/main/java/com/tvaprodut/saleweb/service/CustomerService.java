package com.tvaprodut.saleweb.service;

import com.tvaprodut.saleweb.model.Customers;
import com.tvaprodut.saleweb.until.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class CustomerService {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//    private static final Session a session = sessionFactory.openSession();

    public CustomerService() {

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
            transaction = session.beginTransaction();
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

    public String deleteCustomer(int customerNumber) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaDelete<Customers> criteriaQuery = builder.createCriteriaDelete(Customers.class);
            Root<Customers> root = criteriaQuery.from(Customers.class);
            criteriaQuery.where(builder.equal(root.get("customerNumber"),customerNumber));
            session.createQuery(criteriaQuery).executeUpdate();
            transaction.commit();
            session.close();
        }catch (Exception e) {
            if (transaction == null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return "delete customter having Customer's Number: "+customerNumber ;
    }

}

