package com.tvaprodut.saleweb.handle;

import com.tvaprodut.saleweb.service.CustomerService;
import com.tvaprodut.saleweb.model.Customers;


public class T2 {
    public static void main(String[] args) {
        Customers customer = new Customers();
        customer = new CustomerService().findCustomerByID(112);
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
