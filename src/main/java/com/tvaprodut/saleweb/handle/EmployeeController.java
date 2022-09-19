package com.tvaprodut.saleweb.handle;

import com.tvaprodut.saleweb.model.Customers;
import com.tvaprodut.saleweb.model.Employees;
import com.tvaprodut.saleweb.model.Response;
import com.tvaprodut.saleweb.service.CustomerService;
import com.tvaprodut.saleweb.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static javax.security.auth.callback.ConfirmationCallback.OK;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    public EmployeeController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    private EmployeesService employeesService;

    @GetMapping("/list-employee")
    public ResponseEntity<Response> getCustomerList() {
        List<Employees> employees = employeesService.getEmployeesList();
        return ResponseEntity.ok(
                Response.builder()
                        .time(LocalDateTime.now())
                        .statusCode(OK)
                        .message("Success")
                        .reason("")
                        .data(Map.of("customers",employees))
                        .build()
        );
    }

    @PostMapping("/add-employee")
    public ResponseEntity<Response> addCustomer(@RequestBody Employees employees) {
        return ResponseEntity.ok(
                Response.builder()
                        .time(LocalDateTime.now())
                        .statusCode(OK)
                        .message("Success")
                        .reason("")
                        .data(Map.of("customer", employeesService.addEmployee(employees)))
                        .build()
        );
    }

    @GetMapping("/ID={employeeNumber}")
    public ResponseEntity<Response> findEmployee(@PathVariable("employeeNumber") int employeeNumber) {
        return ResponseEntity.ok(
                Response.builder()
                        .time(LocalDateTime.now())
                        .statusCode(OK)
                        .message("Success")
                        .reason("")
                        .data(Map.of("customers", employeesService.findEmployeeByID(employeeNumber)))
                        .build()
        );
    }

    @GetMapping("/delete/ID={id}")
    public ResponseEntity<Response> deleteCustomer(@PathVariable("id") int id) {
        return ResponseEntity.ok(
                Response.builder()
                        .time(LocalDateTime.now())
                        .statusCode(OK)
                        .message("Success")
                        .reason("")
                        .data(Map.of("response", employeesService.deleteEmployee(id)))
                        .build()
        );
    }
}
