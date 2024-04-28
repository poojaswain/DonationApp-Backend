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
public class PostRequestDTO {
	

	private String createdBy;
	private String reqMessage;
	private LocalDateTime requestDate;
	private Boolean status;

}
