package com.product.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.dto.ProductDTO;
import com.product.dto.ProductSaveDTO;
import com.product.model.MyFile;
import com.product.model.Product;
import com.product.model.ProductDetail;
import com.product.repo.CustomerRepository;
import com.product.service.FileService;
import com.product.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

@RequestMapping("/product")
@Controller
public class ProductController {
    private final ProductService productService;
    private final CustomerRepository customerRepository;
    final private FileService fileService;

    public ProductController(ProductService productService, CustomerRepository customerRepository, FileService fileService) {
        this.productService = productService;
        this.customerRepository = customerRepository;
        this.fileService = fileService;
    }

    @GetMapping
    public String home(Model model,@CookieValue(value = "username",defaultValue = "") String username) {

        System.out.println(username);
        ArrayList<Product> list = productService.getAll();
        model.addAttribute("list", list);
        return "home";
    }

    @GetMapping("/detail")
    public String detail(Model model, @RequestParam("pid") int pid) {
        Map<String, Objects> map = productService.getProductDetail(pid);
        ObjectMapper mapper = new ObjectMapper();
        ProductDTO dto = mapper.convertValue(map, ProductDTO.class);
        model.addAttribute("dto", dto);
        return "detail";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new ProductSaveDTO());
        return "create";
    }

    @GetMapping("/file")
    public String addFile(Model model, @RequestParam("pid") int pid) {
        model.addAttribute("pid", pid);
        return "add-file";
    }

    @PostMapping("/file")
    public String saveFile(@RequestParam("pfile") MultipartFile file,
                           @RequestParam("pid") int pid) {
        fileService.saveFile(file, pid);
        return "redirect:/product";
    }

    @GetMapping("/download-file")
    public ResponseEntity<?> download( @RequestParam("pid") int pid) {
        try {
            MyFile file =fileService.findFile(pid);
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.parseMediaType(file.getCtype()))
                    .body(file.getContent());
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw  new RuntimeException();
        }




    }




    @Transactional
    @PostMapping("/save")
    public String save(@ModelAttribute("product") @Validated ProductSaveDTO productSaveDTO
            , BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Product product = new Product();
        product.setStatus(productSaveDTO.getStatus());
        product.setPname(productSaveDTO.getPname());
        product.setCdate(productSaveDTO.getCdate());
        Product product1 = productService.create(product);
        ProductDetail productDetail =
                new ProductDetail(product1.getPid(),
                        productSaveDTO.getCateid(), productSaveDTO.getPrice(),
                        productSaveDTO.getProducer());

        productService.insertDetail(productDetail);

//        productService.create(product);
        return "redirect:/product/file?pid=" + product1.getPid();
    }

}
