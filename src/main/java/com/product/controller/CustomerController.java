package com.product.controller;

import com.product.model.Product;
import com.product.response.Response;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/kh")
public class CustomerController {
    @Autowired
    ProductService service;
    private Response response = new Response();
    @GetMapping
    public Response get(@RequestParam("id") int id){
        List<Product> list = service.getAll();
        response.setData(list);
        response.setMess("OK");
        response.setStatus(200);
        return response;
    }
    @GetMapping("/home")
    public ModelAndView getHome(){
        ModelAndView modelAndView = new ModelAndView("customer/home");
        modelAndView.addObject("pro",new Product());
        return modelAndView;


    }

}
