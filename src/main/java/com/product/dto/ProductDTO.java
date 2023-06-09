package com.product.dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
   private int pid;
    private Date cdate;
    private  String pname;
    private float price;
    private String producer;
    private String catename;
    private String sname;



}
