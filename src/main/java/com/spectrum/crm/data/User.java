package com.spectrum.crm.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@ToString
@Entity
@Table(name = "USER")
public class User {

    @Id
    private String id;
    private String idNo;
    private String idType;
    private String custName;
    private String mobile;
    private String email;
    private String age;
    private String sex;
    private String insertTime;
    private String updateTime;
}
