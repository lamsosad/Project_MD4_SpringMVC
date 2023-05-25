package lam.model.entity;

public class CartDetail {
    private int idCartDetail;
    private String productName;
    private String productImage;
    private String catalogName;
    private float productPrice;
    private float productTotal;
    private int quantityBuy;

    public CartDetail() {
    }

    public CartDetail(int idCartDetail, String productName, String productImage, String catalogName, float productPrice, float productTotal, int quantityBuy) {
        this.idCartDetail = idCartDetail;
        this.productName = productName;
        this.productImage = productImage;
        this.catalogName = catalogName;
        this.productPrice = productPrice;
        this.productTotal = productTotal;
        this.quantityBuy = quantityBuy;
    }

    public int getIdCartDetail() {
        return idCartDetail;
    }

    public void setIdCartDetail(int idCartDetail) {
        this.idCartDetail = idCartDetail;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public float getProductTotal() {
        return productTotal;
    }

    public void setProductTotal(float productTotal) {
        this.productTotal = productTotal;
    }

    public int getQuantityBuy() {
        return quantityBuy;
    }

    public void setQuantityBuy(int quantityBuy) {
        this.quantityBuy = quantityBuy;
    }
}
