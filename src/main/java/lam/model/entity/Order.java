package lam.model.entity;

public class Order {
    private int idOrder;
    private String nameReceiver;
    private String phone;
    private String address;
    private String date;
    private float total;
    private boolean status;

    public Order() {
    }

    public Order(int idOrder) {
        this.idOrder = idOrder;
    }

    public Order(int newIdOrder, String nameReceiver, String phone, String address, float total) {
        this.idOrder = newIdOrder;
        this.nameReceiver = nameReceiver;
        this.phone = phone;
        this.address = address;
        this.total = total;
    }

    public Order(int idOrder, String nameReceiver, String phone, String address, String date, float total, boolean status) {
        this.idOrder = idOrder;
        this.nameReceiver = nameReceiver;
        this.phone = phone;
        this.address = address;
        this.date = date;
        this.total = total;
        this.status = status;
    }

    public Order(int idOrder, String nameReceiver, String phone, String address, String date, float total) {
        this.idOrder = idOrder;
        this.nameReceiver = nameReceiver;
        this.phone = phone;
        this.address = address;
        this.date = date;
        this.total = total;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
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

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
