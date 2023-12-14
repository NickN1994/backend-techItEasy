package nl.novi.techiteasyhw.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CiModule")
public class CiModule {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String type;
    private double price;

    @OneToMany (mappedBy = "ciModule")
    private Set<Television> televisions = new HashSet<>();


    public CiModule(long id, String name, String type, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public CiModule (){

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
