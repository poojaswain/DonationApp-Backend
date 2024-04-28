package com.pooja.donation.payloads;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
	
	private String postTitle;
	private String donationType;
	private String description;
	private List<ItemDTO> itemList; 
}