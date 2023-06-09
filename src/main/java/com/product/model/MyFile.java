package com.product.model;

import jakarta.persistence.*;

@Entity
public class MyFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int fid;
    private int pid;
    private String fname;
    private String ctype;

    public MyFile(int pid, String fname, String ctype, byte[] content) {
        this.pid = pid;
        this.fname = fname;
        this.ctype = ctype;
        this.content = content;
    }

    public MyFile() {
    }

    @Lob
    @Column(length = 20971520)
    private byte[] content;

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
