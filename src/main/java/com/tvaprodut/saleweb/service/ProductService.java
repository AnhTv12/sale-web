package com.tvaprodut.saleweb.service;

import com.tvaprodut.saleweb.model.Employees;
import com.tvaprodut.saleweb.model.Product;
import com.tvaprodut.saleweb.until.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductService {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public List<Product> getEmployeesList() {
        List<Product> products = new ArrayList<>();
        try(Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);

            Root<Product> root = criteriaQuery.from(Product.class);
            criteriaQuery.select(root);
            products = session.createQuery(criteriaQuery).getResultList();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }

    public Employees addEmployee(Employees employee) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
            session.close();
        }catch (Exception e) {
            if (transaction == null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return employee;
    }

    public Employees findEmployeeByID(int employeesID) {
        Employees employee = new Employees();
        try(Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Employees> criteriaQuery = builder.createQuery(Employees.class);
            Root<Employees> root = criteriaQuery.from(Employees.class);
            criteriaQuery.select(root).where(builder.equal(root.get("employeeNumber"),employeesID));
            employee = session.createQuery(criteriaQuery).getSingleResult();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return employee;
    }

    public String deleteEmployee(int id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaDelete<Employees> criteriaQuery = builder.createCriteriaDelete(Employees.class);
            Root<Employees> root = criteriaQuery.from(Employees.class);
            criteriaQuery.where(builder.equal(root.get("id"),id));
            session.createQuery(criteriaQuery).executeUpdate();
            transaction.commit();
            session.close();
        }catch (Exception e) {
            if (transaction == null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return "delete Employee having Employee's ID: "+id ;
    }

}
