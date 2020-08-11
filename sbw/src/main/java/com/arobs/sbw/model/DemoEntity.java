package com.arobs.sbw.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@DynamicUpdate
@Getter
@Setter
@Entity
@Table(name = "demo_entity")
public class DemoEntity extends BaseEntityIntegerAuditing {

    @Column(name = "description")
    private String description;

    @Column(name = "error_msg")
    private String errorMsg;

    public DemoEntity() {
    }
}
