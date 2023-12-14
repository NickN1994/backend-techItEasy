package nl.novi.techiteasyhw.dto.Wallbracket;

public class WallbracketInputDto {

    private Long id;
    private String size;
    private boolean ajustable;
    private String name;
    private double price;

    public WallbracketInputDto(String size, boolean ajustable, String name, double price) {
        this.size = size;
        this.ajustable = ajustable;
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

    public boolean isAjustable() {
        return ajustable;
    }

    public void setAjustable(boolean ajustable) {
        this.ajustable = ajustable;
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
