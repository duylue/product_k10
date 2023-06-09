package com.product.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductSaveDTO {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date cdate;
    private  String pname;
    private float price;
    private String producer;
    private int cateid;
    private int status;

}
