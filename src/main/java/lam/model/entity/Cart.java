package lam.model.entity;

public class Cart {
    private int idCart;
    private int idUser;
    private int idProduct;
    private int quantityBuy;
    private boolean status;

    public Cart() {
    }

    public Cart(int idCart) {
        this.idCart = idCart;
    }

    public Cart(int idUser, int idProduct) {
        this.idUser = idUser;
        this.idProduct = idProduct;
    }

    public Cart(int idCart, int idUser, int idProduct, int quantityBuy,boolean status) {
        this.idCart = idCart;
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.quantityBuy = quantityBuy;
        this.status=status;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantityBuy() {
        return quantityBuy;
    }

    public void setQuantityBuy(int quantityBuy) {
        this.quantityBuy = quantityBuy;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
