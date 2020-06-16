package pl.piotr.demo.post;

import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PostResource {

  private PostService postService;

  private PostRepository postRepository;

  public PostResource(PostService postService, PostRepository postRepository) {
    this.postService = postService;
    this.postRepository = postRepository;
  }

  @GetMapping("/api/posts")
  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }

  @GetMapping("/api/posts/{id}")
  public Post get(@PathVariable long id) {
    return postRepository.findById(id).get();
  }

  @PostMapping("/api/posts")
  public ResponseEntity<Void> createPost(@RequestBody Post post) {
    Post postUpdated = postRepository.save(post);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id")
        .buildAndExpand(postUpdated.getId())
        .toUri();

    return ResponseEntity.created(uri).build();
  }
}
