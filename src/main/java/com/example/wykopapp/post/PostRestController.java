package com.example.wykopapp.post;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/posts")
@RestController
public class PostRestController {

    private final PostRepository postRepository;

    public PostRestController(PostRepository postRepository) {
        this.postRepository = postRepository;

    }



    @GetMapping("")
    public List<Post> findAll(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("newPost", new Post());
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id) {
        Optional<Post> taskOptional = postRepository.findById(id);
        return taskOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/add")
    public ResponseEntity<Post> addPost(@RequestBody Post post) {
        if (post.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        postRepository.save(post);
        return ResponseEntity.ok(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> addPost(@PathVariable Long id, @RequestBody Post post) {

        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isPresent()) {
            Post postInDb = postOptional.get();
            postInDb.setName(post.getName());
            postInDb.setCreatedAt(post.getCreatedAt());
            postRepository.save(postInDb);

            return ResponseEntity.ok(postInDb);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        try {
            postRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ignore) {
            // ignore
        }
    }


}
