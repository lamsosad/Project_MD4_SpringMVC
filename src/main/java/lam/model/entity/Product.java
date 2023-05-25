package lam.model.entity;

public class Product {
    private int idProduct;
    private String nameProduct;
    private String image;
    private String title;
    private int quantity;
    private float price;
    private boolean status;
    private Catalog catalog;
    public Product() {
    }

    public Product(String nameProduct, String image, String title, int quantity, float price, Catalog catalog) {
        this.nameProduct = nameProduct;
        this.image = image;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
        this.catalog = catalog;
    }

    public Product(int idProduct, String nameProduct, String image, String title, int quantity, float price, boolean status, Catalog catalog) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.image = image;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.catalog = catalog;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
