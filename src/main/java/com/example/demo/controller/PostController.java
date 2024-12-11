package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Post;
import com.example.demo.model.Usuario;
import com.example.demo.service.PostService;
import com.example.demo.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public PostController(PostService postService, UsuarioRepository usuarioRepository) {
        this.postService = postService;
        this.usuarioRepository = usuarioRepository;
    }

    // create a new post
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        Usuario usuario = usuarioRepository.findById(1L).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        post.setUser(usuario);
        return postService.createPost(post);
    }

    // get all posts
    @GetMapping
    public Iterable<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    // get post by id
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        return post != null ? ResponseEntity.ok(post) : ResponseEntity.notFound().build();
    }

    // delete a post
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }


    
}