package model;

import javax.swing.text.StringContent;
import java.util.Date;

public class Blog {
    private int id;
    private String title;
    private Date date;
    private String content,img,description;
    private int role;

    public Blog(int id, String title, Date date, String content, String img, String description, int role) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.content = content;
        this.img = img;
        this.description = description;
        this.role = role;
    }

    public Blog(String title, Date date, String content, String img, String description, int role) {
        this.title = title;
        this.date = date;
        this.content = content;
        this.img = img;
        this.description = description;
        this.role = role;
    }

    public Blog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
