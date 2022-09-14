package com.tvaprodut.saleweb.handle;

import com.tvaprodut.saleweb.dao.CustomerDao;
import com.tvaprodut.saleweb.model.Customers;
import com.tvaprodut.saleweb.model.Response;
import com.tvaprodut.saleweb.until.HibernateUtil;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static javax.security.auth.callback.ConfirmationCallback.OK;


@RestController
@RequestMapping("/Customer")
public class CustomerController {

    @GetMapping("/list-customers")
    public List<Customers> getCustomerList() {

        CustomerDao customerDao = CustomerDao.getCustomerDao();
        List<Customers> customers = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        JpaCriteriaQuery<Customers> criteriaQuery = builder.createQuery(Customers.class);
        JpaRoot<Customers> root = criteriaQuery.from(Customers.class);
        criteriaQuery.select(root);
        try {
            customers = session.createQuery(criteriaQuery).getResultList();
        } catch (NoResultException exception) {
            exception.printStackTrace();
        }
        return customers;
    }
}
//        return ResponseEntity.ok(
//                Response.builder()
//                        .time(LocalDateTime.now())
//                        .statusCode(OK)
//                        .message("Success")
//                        .reason("")
//                        .data(Map.of("customers",customers))
//                        .build()
//        );
//        return customers;
//    }
//
//
//
//}
