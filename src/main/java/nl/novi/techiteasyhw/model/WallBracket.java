package nl.novi.techiteasyhw.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class WallBracket {

    @Id
    @GeneratedValue

    private Long id;
    private String size;
    private boolean adjustable;
    private String name;
    private double price;

    @ManyToMany (mappedBy = "wallBrackets")
    private Set<Television> televisions = new HashSet<>();

    public WallBracket(Long id, String size, boolean adjustable, String name, double price) {
        this.id = id;
        this.size = size;
        this.adjustable = adjustable;
        this.name = name;
        this.price = price;
    }

    public WallBracket () {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isAdjustable() {
        return adjustable;
    }

    public void setAdjustable(boolean adjustable) {
        this.adjustable = adjustable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
