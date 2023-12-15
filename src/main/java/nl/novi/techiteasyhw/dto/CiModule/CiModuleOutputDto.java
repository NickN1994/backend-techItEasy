package nl.novi.techiteasyhw.dto.CiModule;

public class CiModuleOutputDto {

    private Long id;
    private String name;
    private String type;
    private Double price;

    public CiModuleOutputDto(Long id, String name, String type, Double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public CiModuleOutputDto (){

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

    public void setPrice(Double price) {
        this.price = price;
    }
}

