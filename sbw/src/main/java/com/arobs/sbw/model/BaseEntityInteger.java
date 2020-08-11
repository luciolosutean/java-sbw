package com.arobs.sbw.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntityInteger implements Identifiable<Integer> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BaseEntityInteger)) {
            return false;
        }
        return id != null && id.equals(((BaseEntityInteger) o).getId());
    }

    //to make sure that in each Hibernate state the hashcode is the same
    //WARN: don't change this unless you know what you are doing!
    @Override
    public int hashCode() {
        return 41 * 37;
    }

}
