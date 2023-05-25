package lam.model.entity;

public class Comment {
    private int id;
    private String comment;
    private int idOrderDetail;
    private int idUser;
    private  String fullname;
    private boolean status;

    public Comment() {
    }

    public Comment(int id) {
        this.id = id;
    }

    public Comment(int id, String comment, int idOrder, int idUser) {
        this.id = id;
        this.comment = comment;
        this.idOrderDetail = idOrder;
        this.idUser = idUser;
    }

    public Comment(String comment, int idOrderDetail, int idUser) {
        this.comment = comment;
        this.idOrderDetail = idOrderDetail;
        this.idUser = idUser;
    }

    public Comment(int id, String comment, int idOrder, int idUser, String username, boolean status) {
        this.id = id;
        this.comment = comment;
        this.idOrderDetail = idOrder;
        this.idUser = idUser;
        this.fullname = username;
        this.status=status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(int idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
