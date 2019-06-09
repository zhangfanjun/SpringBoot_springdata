package com.qf.springdata_test.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="c_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String password;
    private Date date;
}
