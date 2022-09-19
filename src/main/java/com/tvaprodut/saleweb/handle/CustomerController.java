package com.tvaprodut.saleweb.handle;

import com.tvaprodut.saleweb.service.CustomerService;
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
        CustomerService customerService = new CustomerService();
        List<Customers> customers = customerService.getCustomersList();
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
        CustomerService customerService = new CustomerService();
        return ResponseEntity.ok(
                Response.builder()
                        .time(LocalDateTime.now())
                        .statusCode(OK)
                        .message("Success")
                        .reason("")
                        .data(Map.of("customer", customerService.addCustomer(customer)))
                        .build()
        );
    }

    @GetMapping("/ID={customerID}")
    public ResponseEntity<Response> findCustomer(@PathVariable("customerID") int customerID) {
        CustomerService customerService = new CustomerService();
        return ResponseEntity.ok(
                Response.builder()
                        .time(LocalDateTime.now())
                        .statusCode(OK)
                        .message("Success")
                        .reason("")
                        .data(Map.of("customers", customerService.findCustomerByID(customerID)))
                        .build()
        );
    }

    @GetMapping("/delete/ID={customerID}")
    public ResponseEntity<Response> deleteCustomer(@PathVariable("customerID") int customerID) {
        CustomerService customerService = new CustomerService();
        return ResponseEntity.ok(
                Response.builder()
                        .time(LocalDateTime.now())
                        .statusCode(OK)
                        .message("Success")
                        .reason("")
                        .data(Map.of("response", customerService.deleteCustomer(customerID)))
                        .build()
        );
    }
}
