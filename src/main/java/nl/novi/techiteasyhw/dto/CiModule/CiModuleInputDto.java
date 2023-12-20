package nl.novi.techiteasyhw.dto.CiModule;

public class CiModuleInputDto {

    private Long id;
    private String name;
    private String type;
    private Double price;

    public CiModuleInputDto(String name, String type, Double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public CiModuleInputDto (){

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
