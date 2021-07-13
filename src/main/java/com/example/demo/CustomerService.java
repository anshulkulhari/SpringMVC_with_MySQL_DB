package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private List<Customer> customerList = new ArrayList<>();
    public static int count = 1;
    public List<Customer> getAllCustomerList(){
        return customerList;
    }
    public Customer getCustomer(String id){
        return customerList.stream().filter(customer -> customer.getId().equals(id)).findFirst().get();
    }
    public void addCustomer(Customer topic){
        count++;
        customerList.add(topic);
    }

    public void updateCustomer(Customer topic,String id){
        int counter = 0;
        topic.setId(id);
        for(Customer c : customerList){
            if(c.getId().equals(id)){
                customerList.set(counter,topic);
            }
            counter++;
        }
    }
    public void deleteCustomer(String id){
        customerList.removeIf(customer->customer.getId().equals(id));
    }
    public void deleteAll(){
        customerList.clear();
    }
}
