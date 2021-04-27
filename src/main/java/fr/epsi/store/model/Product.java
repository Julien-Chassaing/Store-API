package fr.epsi.store.model;

public class Product {

    private int id;
    private String name;
    private String detail;
    private String price;
    private String quantity;
    private String info;
    private String image;

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Product(int id, String name, String detail, String price, String quantity, String info, String image) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.price = price;
        this.quantity = quantity;
        this.info = info;
        this.image = image;
    }
}
