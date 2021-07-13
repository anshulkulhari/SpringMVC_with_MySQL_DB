package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @RequestMapping(method=RequestMethod.GET)
    public List<Customer> all_customers(){
        return customerService.getAllCustomerList();
    }

    @RequestMapping(method = RequestMethod.GET,value= "/{id}")
    public Customer getCustomer(@PathVariable("id")String id) {
        return customerService.getCustomer(id);
    }

  @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addCustomer(@Valid @RequestBody Customer customer, BindingResult result){
        if(result.hasErrors()){
            String response="";
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors ) {
                response+= (error.getObjectName() + " - " + error.getDefaultMessage()+"\n");

            }
           return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
        }
        customerService.addCustomer(customer);
        return ResponseEntity.ok(customer.getName()+" Successfully Added!");
  }

  @RequestMapping(method = RequestMethod.PUT,value="/{id}")
    public void updateCustomer(@RequestBody Customer customer,@PathVariable("id") String id){
        customerService.updateCustomer(customer,id);
  }

  @RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
    public void deleteCustomer(@PathVariable("id")String id){
        customerService.deleteCustomer(id);
  }
  @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllCustomer(){
        customerService.deleteAll();
  }



}
