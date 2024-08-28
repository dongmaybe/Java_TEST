package com.samsung.tddspringboot;


import com.samsung.tddspringboot.repository.models.Customer;
import com.samsung.tddspringboot.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService();
    }

    @Test
    void testAddCustomerSuccessfully() {
        Customer customer = new Customer("Dong", "C001", "duke@java.org");
        customerService.addCustomer(customer);
        assertEquals(1, customerService.getAllCustomers().size());
        assertEquals("Dong", customerService.getAllCustomers().get(0).getName());
    }

    @Test
    void testAddCustomerWithDuplicateEmail() {
        Customer customer1 = new Customer("Dong", "C001", "Dong@java.org");
        Customer customer2 = new Customer("Dong", "C002", "Dong@java.org");

        customerService.addCustomer(customer1);

        // Kiểm tra rằng khi thêm khách hàng với email trùng, sẽ ném ra ngoại lệ
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            customerService.addCustomer(customer2);
        });

        String expectedMessage = "Email already exists!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
