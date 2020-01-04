package com.spectrum.crm.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "USER")
public class User {

    @Id
    private Long id;
    private String idNo;
    private String idType;
    private String custName;
    private String custNo;
    private String mobile;
    private String email;
    private String age;
    private String sex;
}
