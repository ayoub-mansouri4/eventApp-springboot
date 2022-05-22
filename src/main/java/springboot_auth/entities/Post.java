package springboot_auth.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "posts")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_post;
    private  String title;
    private String date_post;
    private  String time_post;
    private  String description;



    public Post(String title, String date_post, String time_post, String description) {
        this.title = title;
        this.date_post = date_post;
        this.time_post = time_post;
        this.description = description;
    }

    public  Post(){}

    public Long getId_post() {
        return id_post;
    }

    public void setId_post(Long id_post) {
        this.id_post = id_post;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate_post() {
        return date_post;
    }

    public void setDate_post(String date_post) {
        this.date_post = date_post;
    }

    public String getTime_post() {
        return time_post;
    }

    public void setTime_post(String time_post) {
        this.time_post = time_post;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
