package com.tvaprodut.saleweb.handle;


import com.tvaprodut.saleweb.entity.Student;
import com.tvaprodut.saleweb.model.Customers;
import com.tvaprodut.saleweb.model.Product;
import com.tvaprodut.saleweb.until.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import java.util.List;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Customers> criteriaQuery = builder.createQuery(Customers.class);
        Root<Customers> root = criteriaQuery.from(Customers.class);
        criteriaQuery.select(root);

            EntityType<Customers> entityType = session.getEntityManagerFactory()
                    .getMetamodel()
                    .entity(Customers.class);
        Set<EntityType<?>> entityTypes = session.getEntityManagerFactory()
                    .getMetamodel()
                    .getEntities();
        Boolean contain = entityTypes.contains(entityType);
            System.out.print(contain);
            System.out.print(contain);
            System.out.print(contain);
            System.out.print(contain);
        }catch (Exception e){
        e.printStackTrace();
        }
/*
//        Session a session = HibernateUtil.getSessionFactory().openSession();

 */

    }
}