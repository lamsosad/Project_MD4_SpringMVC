package lam.model.entity;

public class OrderItem {
    private int idOrder;
    private boolean status;
    private String userName;
    private String nameReceiver;
    private String phone;
    private String address;
    private String date;
    private String nameProduct;
    private String image;
    private String nameCatalog;
    private float price;
    private float total;
    private int quantity;

    public OrderItem() {
    }

    public OrderItem(boolean status, String userName, String nameReceiver, String phone, String address, String date, String nameProduct, String image, String nameCatalog, float price, float total, int quantity) {
        this.status = status;
        this.userName = userName;
        this.nameReceiver = nameReceiver;
        this.phone = phone;
        this.address = address;
        this.date = date;
        this.nameProduct = nameProduct;
        this.image = image;
        this.nameCatalog = nameCatalog;
        this.price = price;
        this.total = total;
        this.quantity = quantity;
    }

    public OrderItem(int id, String userName, String nameReceiver, String phone, String address, String date, String nameProduct, String image, String nameCatalog, float price, float total, int quantity) {
        this.idOrder = id;
        this.userName = userName;
        this.nameReceiver = nameReceiver;
        this.phone = phone;
        this.address = address;
        this.date = date;
        this.nameProduct = nameProduct;
        this.image = image;
        this.nameCatalog = nameCatalog;
        this.price = price;
        this.total = total;
        this.quantity = quantity;
    }

    public int getId() {
        return idOrder;
    }

    public void setId(int id) {
        this.idOrder = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNameReceiver() {
        return nameReceiver;
    }

    public void setNameReceiver(String nameReceiver) {
        this.nameReceiver = nameReceiver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getNameCatalog() {
        return nameCatalog;
    }

    public void setNameCatalog(String nameCatalog) {
        this.nameCatalog = nameCatalog;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
