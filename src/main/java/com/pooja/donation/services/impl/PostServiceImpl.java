package com.pooja.donation.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooja.donation.entities.Item;
import com.pooja.donation.entities.Post;
import com.pooja.donation.entities.UserEntity;
import com.pooja.donation.payloads.PostCardDto;
import com.pooja.donation.payloads.PostDto;
import com.pooja.donation.repositories.PostRepo;
import com.pooja.donation.services.PostService;
import com.pooja.donation.services.UserService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
    private PostRepo postRepository;

	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private UserService userService;
	
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
	public Post getPostById(int id) {
	    Optional<Post> post = postRepository.findById(id);
	    return post.orElse(null);
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

	@Override
	public Post uploadPost(Integer userId, PostDto postDto, String fileUuid) {
		List<Item> allItems = new ArrayList<>();

		postDto.getItemList().forEach(item -> {
			Item postItem = new Item(item.getItemName(), item.getItemDescription(), item.getItemCategory(),
					item.getQuantity(), item.getQuantityUnit());
			allItems.add(postItem);
		});

		Post post = new Post(userId, postDto.getPostTitle(), postDto.getDonationType(), postDto.getDescription(),
				LocalDateTime.now(), fileUuid);
		post.setItems(allItems);

		return postRepository.save(post);
	}

	@Override
	public List<PostCardDto> getAllPostsForFeed() {
		List<Post> allPosts = postRepository.findAll();
		List<PostCardDto> resultList = new ArrayList<>();

		allPosts.forEach(post -> {
			UserEntity userEntity = userService.getUserEntity(post.getUserId());
			PostCardDto cardDto = new PostCardDto(post.getId(), post.getDescription(), userEntity.getFullName(),
					userEntity.getAddress(), post.getPostDate(), post.getCoverImage());
			resultList.add(cardDto);
		});

		return resultList;
	}
		

}
