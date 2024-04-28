package com.pooja.donation.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Posts")
@NoArgsConstructor
@Getter
@Setter
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "post_title")
	private String postTitle;

	@Column(name = "donation_type")
	private String donationType;

	@Column(name = "description")
	private String description;

	@Column(name = "post_Date")
	private LocalDateTime postDate;
	
	@Column(name = "post_image")
	private String coverImage;

//	@ManyToOne
//	private UserEntity user;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Item> items = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Request> requests = new ArrayList<>();

	public Post(int userId, String postTitle, String donationType, String description, LocalDateTime postDate,
			String coverImage) {
		super();
		this.userId = userId;
		this.postTitle = postTitle;
		this.donationType = donationType;
		this.description = description;
		this.postDate = postDate;
		this.coverImage = coverImage;
	}

	

}
