package lam.model.entity;

public class Catalog {
    private int idCatalog;
    private String nameCatalog;
    private boolean status;

    public Catalog() {
    }

    public Catalog(String nameCatalog) {
        this.nameCatalog = nameCatalog;
    }

    public Catalog(int idCatalog, String nameCatalog, boolean status) {
        this.idCatalog = idCatalog;
        this.nameCatalog = nameCatalog;
        this.status = status;
    }

    public int getIdCatalog() {
        return idCatalog;
    }

    public void setIdCatalog(int idCatalog) {
        this.idCatalog = idCatalog;
    }

    public String getNameCatalog() {
        return nameCatalog;
    }

    public void setNameCatalog(String nameCatalog) {
        this.nameCatalog = nameCatalog;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
