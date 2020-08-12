package com.arobs.sbw.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@DynamicUpdate
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee extends BaseEntityIntegerAuditing {

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private String role;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;
}
