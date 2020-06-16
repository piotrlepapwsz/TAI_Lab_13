package pl.piotr.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PostController {

  private PostService postService;

  @Autowired
  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/api/posts")
  public List<Post> getAll() {
    return postService.getAll();
  }

  @GetMapping("/api/posts/{id}")
  public Post getById(@PathVariable int id) {
    return postService.getById(id);
  }
}
