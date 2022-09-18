package com.tvaprodut.saleweb.handle;

import com.tvaprodut.saleweb.dao.CustomerDao;
import com.tvaprodut.saleweb.model.Customers;

import com.tvaprodut.saleweb.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static javax.security.auth.callback.ConfirmationCallback.OK;


@RestController
@RequestMapping("/Customer")
public class CustomerController {

    @GetMapping("/list-customers")
    public ResponseEntity<Response> getCustomerList() {
        CustomerDao customerDao = new CustomerDao();
        List<Customers> customers = customerDao.getCustomersList();
        return ResponseEntity.ok(
                Response.builder()
                        .time(LocalDateTime.now())
                        .statusCode(OK)
                        .message("Success")
                        .reason("")
                        .data(Map.of("customers",customers))
                        .build()
        );
    }

    @PostMapping("/add-customer")
    public ResponseEntity<Response> addCustomer(@RequestBody Customers customer) {
        CustomerDao customerDao = new CustomerDao();
        return ResponseEntity.ok(
                Response.builder()
                        .time(LocalDateTime.now())
                        .statusCode(OK)
                        .message("Success")
                        .reason("")
                        .data(Map.of("customer",customerDao.addCustomer(customer)))
                        .build()
        );
    }

    @GetMapping("/ID={customerID}")
    public ResponseEntity<Response> findCustomer(@PathVariable("customerID") int customerID) {
        CustomerDao customerDao = new CustomerDao();
        return ResponseEntity.ok(
                Response.builder()
                        .time(LocalDateTime.now())
                        .statusCode(OK)
                        .message("Success")
                        .reason("")
                        .data(Map.of("customers",customerDao.findCustomerByID(customerID)))
                        .build()
        );
    }

    @GetMapping("/delete/ID={customerID}")
    public ResponseEntity<Response> deleteCustomer(@PathVariable("customerID") int customerID) {
        CustomerDao customerDao = new CustomerDao();
        return ResponseEntity.ok(
                Response.builder()
                        .time(LocalDateTime.now())
                        .statusCode(OK)
                        .message("Success")
                        .reason("")
                        .data(Map.of("response",customerDao.deleteCustomer(customerID)))
                        .build()
        );
    }
}
