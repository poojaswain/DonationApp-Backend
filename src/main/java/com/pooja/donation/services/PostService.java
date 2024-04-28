package com.pooja.donation.services;

import java.util.List;

import com.pooja.donation.entities.Post;
import com.pooja.donation.payloads.PostCardDto;
import com.pooja.donation.payloads.PostDto;

public interface PostService {

	PostDto createPost(PostDto post);

	Post getPostById(int id);

	List<PostDto> getAllPosts();
	
	List<PostCardDto> getAllPostsForFeed();

	PostDto updatePost(int id, PostDto post);

	void deletePost(int id);

	Post uploadPost(Integer userId, PostDto postDto, String fileUuid);
}