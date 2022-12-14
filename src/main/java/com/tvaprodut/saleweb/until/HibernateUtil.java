package com.tvaprodut.saleweb.until;

import com.tvaprodut.saleweb.entity.Student;
import com.tvaprodut.saleweb.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;

import java.util.Properties;
@Component

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.mariadb.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mariadb://mariadb-tutorial.clicssmtjld8.ap-northeast-2.rds.amazonaws.com/qlsv_VA");
                settings.put(Environment.USER, "administrator");
                settings.put(Environment.PASS, "6i6Z&9ooKjFK");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MariaDB103Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(Customers.class);
                configuration.addAnnotatedClass(Product.class);
                configuration.addAnnotatedClass(ProductLines.class);
                configuration.addAnnotatedClass(Cart.class);
                configuration.addAnnotatedClass(CartItem.class);
                configuration.addAnnotatedClass(OrderDetail.class);
                configuration.addAnnotatedClass(Order.class);
                configuration.addAnnotatedClass(Employees.class);
//                configuration.addAnnotatedClass(Payment.class);
                configuration.addAnnotatedClass(Office.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
