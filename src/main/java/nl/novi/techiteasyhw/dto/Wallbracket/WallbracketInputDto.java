package nl.novi.techiteasyhw.dto.Wallbracket;

public class WallbracketInputDto {

    private Long id;
    private String size;
    private Boolean adjustable;
    private String name;

    private Double price;

    public WallbracketInputDto(String size, boolean adjustable, String name, double price) {
        this.size = size;
        this.adjustable = adjustable;
        this.name = name;
        this.price = price;
    }

    public WallbracketInputDto () {

    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean isAdjustable() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
