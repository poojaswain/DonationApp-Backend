package com.pooja.donation.payloads;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

	private int id;
	private String donationType;
	private String description;
	private LocalDateTime postDate;
	private String coverImage;
//    private List<Item> items;
//    private List<Request> requests;

}