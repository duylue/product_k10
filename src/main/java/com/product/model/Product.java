package com.product.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pid;
    @Size(min = 2,max = 20,message = "Số từ không được ít hơn 2 và nhiều hơn 20 từ")
    private String pname;
    @Min(value = 1,message = "So khong duoc nho hon 1")
    @Max(value = 5,message = "So khong duoc lon hon 5")
    private int status;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date cdate;

    public Product() {
    }

    public Product(int pid, String pname, int status, Date cdate) {
        this.pid = pid;
        this.pname = pname;
        this.status = status;
        this.cdate = cdate;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }
}
