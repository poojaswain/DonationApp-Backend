package com.pooja.donation.payloads;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostCardDto {
	
	private int id;
	private String postTitle;
	private String userFullName;
	private String Address;
	private LocalDateTime postDate;
	private String postImageId;

}
