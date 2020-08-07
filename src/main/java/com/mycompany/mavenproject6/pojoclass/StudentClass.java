package com.mycompany.mavenproject6.pojoclass;

import java.io.Serializable;

public class StudentClass implements Serializable {

    private long id;

    private String fname;

    private String lname;

    private String email;

    private String gno;
    private long balance;

    public StudentClass(long id, String fname, String lname, String email, String gno, long balance) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.gno = gno;
        this.balance=balance;
    }

    public StudentClass() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGno() {
        return gno;
    }

    public void setGno(String gno) {
        this.gno = gno;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
    
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", gno=" + gno +",balance=" + balance + '}';
    }

}
