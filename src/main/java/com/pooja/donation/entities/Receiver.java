package com.pooja.donation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Receivers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Receiver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int userId;

	private String website;

	private String receiverDescription;

	private String verificationDocumentation;

	public Receiver(int userId) {
		super();
		this.userId = userId;
	}

}
