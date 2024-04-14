package com.pooja.donation.services;

import java.util.List;

import com.pooja.donation.payloads.PostDto;

public interface PostService {

	PostDto createPost(PostDto post);

	PostDto getPostById(int id);

	List<PostDto> getAllPosts();

	PostDto updatePost(int id, PostDto post);

	void deletePost(int id);
}