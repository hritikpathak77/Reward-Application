package com.charter.reward.controller;

import com.charter.reward.model.Customer;
import com.charter.reward.model.Purchase;
import com.charter.reward.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    // Sample test data
    private Customer customer;
    private List<Customer> customers;
    private List<Purchase> purchases;

    @BeforeEach
    void setUp() {
        // Initialize test data here
        customer = new Customer(); // set properties
        customer.setName("Hritik");
        customer.setId(1L);
        customers = Arrays.asList(customer);
        purchases = Arrays.asList(new Purchase()); // set properties
    }

    @Test
    void createCustomersTest() throws Exception {
        given(customerRepository.saveAll(any())).willReturn(customers);

        mockMvc.perform(post("/api/v1/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customers)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(customers)));
    }


    @Test
    void createPurchasesTest() throws Exception {
        given(customerRepository.findById(anyLong())).willReturn(Optional.of(customer));
        given(customerRepository.save(any())).willReturn(customer);

        mockMvc.perform(post("/api/v1/customers/" + customer.getId() + "/purchases")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(purchases)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(customer)));
    }

    @Test
    void getAllCustomersTest() throws Exception {
        given(customerRepository.findAll()).willReturn(customers);

        mockMvc.perform(get("/api/v1/customers"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(customers)));
    }
}
