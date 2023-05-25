package lam.model.entity;

public class OrderDetail {
    private int id;
    private int idOrder;
    private int idCart;


    public OrderDetail() {
    }

    public OrderDetail(int idOrder, int idCart) {
        this.idOrder = idOrder;
        this.idCart = idCart;
    }

    public OrderDetail(int id, int idOrder, int idCart) {
        this.id = id;
        this.idOrder = idOrder;
        this.idCart = idCart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }
}
