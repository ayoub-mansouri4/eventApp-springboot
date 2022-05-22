package springboot_auth.abstractFactoryPattern;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springboot_auth.entities.Post;


@Component
public class ConcreteFactoryPost extends AbstractFactoryPost{
    @Override
    public  Post createPost(String title, String date_post, String time_post, String description) {
        return new Post(title,date_post,time_post,description);
    }
}
