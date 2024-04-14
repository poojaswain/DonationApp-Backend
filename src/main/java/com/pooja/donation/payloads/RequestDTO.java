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
public class RequestDTO {
	private int reqId;
	private LocalDateTime requestDate;
	private Boolean status;
//    private PostDTO post;
//    private UserDTO user;

}
