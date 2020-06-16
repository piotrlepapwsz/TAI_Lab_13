package pl.piotr.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  private static ArrayList<Post> posts = new ArrayList<>();
  private static int idCounter = 0;

  static {
    for (int i = 0; i < 10; i++) {
      posts.add(createPost());
    }
  }

  public List<Post> getAll() {
    return posts;
  }

  public Post getById(int id) {
    return posts.get(id);
  }

  private static Post createPost() {
    return new Post(++idCounter,
        "title" + (idCounter - 1),
        "http://osnews.pl/wp-content/uploads/2016/06/it-grafika.jpg",
        "Bacon ipsum dolor amet filet mignon drumstick picanha ribeye jerky pork belly cupim tail boudin"
            +
            " turducken porchetta kielbasa hamburger pancetta pork chop. Doner meatball kielbasa kevin swine."
            +
            " Andouille shankle brisket filet mignon ball tip, cupim chicken swine tail shank t-bone. "
            +
            "Drumstick pig tenderloin, chicken pork belly ribeye picanha pork chop alcatra t-bone strip "
            +
            "steak salami shankle boudin. Swine porchetta shankle rump spare ribs kielbasa landjaeger "
            +
            "brisket sirloin turducken. Shoulder alcatra chuck fatback bacon cow ribeye tail frankfurter "
            +
            "chicken ham short ribs pork belly tenderloin kielbasa. Pig capicola short loin, ham hock "
            +
            "swine frankfurter doner pork belly pork drumstick ham.");
  }
}
