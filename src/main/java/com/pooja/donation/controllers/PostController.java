package com.pooja.donation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pooja.donation.payloads.PostDto;
import com.pooja.donation.services.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDTO) {
    	PostDto createdPost = postService.createPost(postDTO);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<PostDto> getPostById(@PathVariable int id) {
//    	PostDto postDTO = postService.getPostById(id);
//        if (postDTO != null) {
//            return new ResponseEntity<>(postDTO, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

//    @GetMapping
//    public ResponseEntity<List<PostDto>> getAllPosts() {
//        List<PostDto> postDTOs = postService.getAllPosts();
//        return new ResponseEntity<>(postDTOs, HttpStatus.OK);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable int id, @RequestBody PostDto postDTO) {
    	PostDto updatedPost = postService.updatePost(id, postDTO);
        if (updatedPost != null) {
            return new ResponseEntity<>(updatedPost, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable int id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
