package model;

public class User {
    private int id;
    private String userName,email,passWord,img;

    public User(int id, String userName, String email, String passWord, String img) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.passWord = passWord;
        this.img = img;
    }

    public User(String userName, String email, String passWord, String img) {
        this.userName = userName;
        this.email = email;
        this.passWord = passWord;
        this.img = img;
    }

    public User(String userName,String email,String passWord){
        this.userName = userName;
        this.email = email;
        this.passWord = passWord;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", passWord='" + passWord + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
