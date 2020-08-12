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
@Table(name = "book")
public class Book extends BaseEntityIntegerAuditing {

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;
}
