package com.pooja.donation.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooja.donation.entities.Post;
import com.pooja.donation.payloads.PostDto;
import com.pooja.donation.repositories.PostRepo;
import com.pooja.donation.services.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
    private PostRepo postRepository;

	@Autowired
    private ModelMapper modelMapper;
	
	public Post dtoToPost(PostDto postDTO) {
	    return modelMapper.map(postDTO, Post.class);
	}

	public PostDto postToDto(Post post) {
	    return modelMapper.map(post, PostDto.class);
	}


	@Override
	public PostDto createPost(PostDto postDTO) {
	    Post post = dtoToPost(postDTO);
	    Post savedPost = postRepository.save(post);
	    return postToDto(savedPost);
	}

	@Override
	public PostDto getPostById(int id) {
	    Optional<Post> post = postRepository.findById(id);
	    return post.map(this::postToDto).orElse(null);
	}

	@Override
	public List<PostDto> getAllPosts() {
	    List<Post> posts = postRepository.findAll();
	    return posts.stream()
	            .map(this::postToDto)
	            .collect(Collectors.toList());
	}

	@Override
	public PostDto updatePost(int id, PostDto postDTO) {
	    if (postRepository.existsById(id)) {
	        Post post = dtoToPost(postDTO);
	        post.setId(id);
	        Post updatedPost = postRepository.save(post);
	        return postToDto(updatedPost);
	    }
	    return null;
	}

	@Override
	public void deletePost(int id) {
		postRepository.deleteById(id);
	}

}
