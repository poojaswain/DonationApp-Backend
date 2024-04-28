package com.pooja.donation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pooja.donation.entities.Post;
import com.pooja.donation.payloads.PostCardDto;
import com.pooja.donation.payloads.PostDto;
import com.pooja.donation.payloads.ResponseDTO;
import com.pooja.donation.services.PostService;

@RestController
@RequestMapping("/api/post")
public class MainPostController {
	
	@Autowired
    PostService postService;
	
	//Create a post along with post image and all items
	@PostMapping("/user/{userId}/upload/{fileUuid}")
	public ResponseEntity<ResponseDTO> uploadPost(@RequestBody PostDto postDto,
			 @PathVariable("userId") Integer uid, @PathVariable("fileUuid") String fileUuid) {
		ResponseDTO response = new ResponseDTO();
		String fileMessage = "";
		if(fileUuid!=null) {
			fileMessage = "Uploaded the image successfully. ";
			Post uploadPost = postService.uploadPost(uid, postDto, fileUuid);

			response.setResponseObject(uploadPost);
			response.setMessage("New Post Created Successfully & " + fileMessage);
			response.setHttpStatus(HttpStatus.CREATED);
		} else {
			fileMessage = "Could not upload the image. ";
			Post uploadPost = postService.uploadPost(uid, postDto, null);

			response.setResponseObject(uploadPost);
			response.setMessage("New Post Created Successfully & " + fileMessage);
			response.setHttpStatus(HttpStatus.PARTIAL_CONTENT);
		}

		return new ResponseEntity<>(response, response.getHttpStatus());
	}
	
	//Get post by id, contains list of items and requests
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getPostById(@PathVariable int id) {
    	ResponseDTO response = new ResponseDTO();
    	
    	Post post = postService.getPostById(id);
    	
        if (post != null) {
        	response.setResponseObject(post);
			response.setMessage("Feteching Post by " + id);
			response.setHttpStatus(HttpStatus.OK);
        }else {
        	response.setMessage("No post is available by " + id);
			response.setHttpStatus(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
    
    
	// Get API for list of all post in a form of card dto
	@GetMapping("/cards")
	public ResponseEntity<ResponseDTO> getAllPostsForFeed() {
		List<PostCardDto> postDTOs = postService.getAllPostsForFeed();
		ResponseDTO response = new ResponseDTO(postDTOs, "All Post cards for feed", HttpStatus.OK);
		return new ResponseEntity<>(response, response.getHttpStatus());

	}

}
