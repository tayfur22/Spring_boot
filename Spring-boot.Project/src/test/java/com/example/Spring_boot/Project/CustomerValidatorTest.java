//package com.example.Spring_boot.Project;
//
//import com.example.Project.annotation.ValidEmail;
//import com.example.Project.entity.Customer;
//import jakarta.validation.*;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.Set;
//
//@SpringBootTest
//public class CustomerValidatorTest {
//
//    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//    private static final Validator validator = factory.getValidator();
//
//    @Test
//    public void testValidEmail() {
//        Customer customer = new Customer();
//        customer.setName("John Doe");
//        customer.setEmail("john.doe@example.com");
//
//        // Validate the customer object
//        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
//
//        // Assert that there are no validation errors
//        assertTrue(violations.isEmpty(), "Expected no validation errors for valid email");
//    }
//
//    @Test
//    public void testInvalidEmail() {
//        Customer customer = new Customer();
//        customer.setName("John Doe");
//        customer.setEmail("invalid-email");
//
//        // Validate the customer object
//        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
//
//        // Assert that there is a validation error for invalid email
//        assertFalse(violations.isEmpty(), "Expected validation errors for invalid email");
//
//        // Assert that the email validation error is present
//        for (ConstraintViolation<Customer> violation : violations) {
//            if ("email".equals(violation.getPropertyPath().toString())) {
//                assertEquals("Invalid email format", violation.getMessage());
//            }
//        }
//    }
//
//    @Test
//    public void testNullEmail() {
//        Customer customer = new Customer();
//        customer.setName("John Doe");
//        customer.setEmail(null);
//
//        // Validate the customer object
//        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
//
//        // Assert that there is a validation error for null email
//        assertFalse(violations.isEmpty(), "Expected validation errors for null email");
//
//        // Assert that the email validation error is present
//        for (ConstraintViolation<Customer> violation : violations) {
//            if ("email".equals(violation.getPropertyPath().toString())) {
//                assertEquals("Invalid email format", violation.getMessage());
//            }
//        }
//    }
//
//    @Test
//    public void testEmptyEmail() {
//        Customer customer = new Customer();
//        customer.setName("John Doe");
//        customer.setEmail("");
//
//        // Validate the customer object
//        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
//
//        // Assert that there is a validation error for empty email
//        assertFalse(violations.isEmpty(), "Expected validation errors for empty email");
//
//        // Assert that the email validation error is present
//        for (ConstraintViolation<Customer> violation : violations) {
//            if ("email".equals(violation.getPropertyPath().toString())) {
//                assertEquals("Invalid email format", violation.getMessage());
//            }
//        }
//    }
//}