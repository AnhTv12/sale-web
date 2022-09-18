package com.tvaprodut.saleweb.handle;

import com.tvaprodut.saleweb.dao.CustomerDao;
import com.tvaprodut.saleweb.model.Customers;
import com.tvaprodut.saleweb.until.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import java.util.Set;



public class T2 {
    public static void main(String[] args) {
        Customers customer = new Customers();
        customer = new CustomerDao().findCustomerByID(112);
        System.out.printf(customer.toString() + "\n");
        System.out.print(customer instanceof Customers);
//        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            CriteriaQuery<Customers> criteriaQuery = builder.createQuery(Customers.class);
//            Set<EntityType<?>> entityTypes = session.getEntityManagerFactory()
//                    .getMetamodel()
//                    .getEntities();
//            EntityType<Customers> entityType = null;
//            for (EntityType i : entityTypes) {
//                if (i.getName().equals("Customers")) entityType = i;
//            }
//            Root<Customers> root = criteriaQuery.from(entityType);
//            criteriaQuery.select(root).where(builder.equal(root.get("customerNumber"),112));
//            customer = session.createQuery(criteriaQuery).getSingleResult();
//            session.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
