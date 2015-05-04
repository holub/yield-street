package yieldstreet.test.roi.model;

import javax.persistence.*;

@Entity
public class Investor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    public Investor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
