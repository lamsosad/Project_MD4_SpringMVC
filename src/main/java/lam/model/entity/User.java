package lam.model.entity;

public class User {
    private int idUser;
    private String fullname;
    private String username;
    private String email;
    private String password;
    private boolean status;
    private boolean role;

    public User() {
    }

    public User(int idUser, String password) {
        this.idUser = idUser;
        this.password = password;
    }

    public User(int idUser, String fullname, String email) {
        this.idUser = idUser;
        this.fullname = fullname;
        this.email = email;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(int idUser,boolean status){
        this.idUser = idUser;
        this.status = status;
    }

    public User(int idUser, String fullname, String email, String password) {
        this.idUser = idUser;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
    }

    public User(String fullname, String username, String email, String password) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(int idUser, String fullname, String username, String email, String password, boolean status, boolean role) {
        this.idUser = idUser;
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
        this.role = role;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }
}
