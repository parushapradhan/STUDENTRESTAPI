package com.mycompany.mavenproject6.entity;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Table(name="students")
@Entity
public class Student implements Serializable{
private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="studID",unique=true)
    private long id;
    @Column(name="FirstName",unique=false)
    private String fname;
    @Column(name="LastName",unique=false)
    private String lname;
    @Column(name="Email",unique=false)
    private String email;
    @Column(name="GuardianNo",unique=false)
    private String gno;
    @Column (name="Balance",unique=false)
    private long balance;
       public Student() {
    }

    public Student(long id, String fname, String lname, String email, String gno,long balance) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.gno = gno;
        this.balance=balance;
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
        return "Student{" + "id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", gno=" + gno + ", balance=" + balance + '}';
    }

}