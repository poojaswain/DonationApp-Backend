package com.pooja.donation.entities;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Requests")
@NoArgsConstructor
@Getter
@Setter
public class Request {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int reqId;
	
//	@Column(name="user_id")
//	private String userId;
	
	@Column(name="request_Date")
	private LocalDateTime requestDate;
	
	@Column(name="status")
	private Boolean status;
	
	@ManyToOne
	private Post post;
	
	@ManyToOne
	private User user;

}
