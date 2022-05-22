package springboot_auth.abstractFactoryPattern;

import springboot_auth.entities.Post;

public   abstract  class AbstractFactoryPost {
    public abstract  Post createPost(String title,String date_post,String time_post, String description) ;
}
