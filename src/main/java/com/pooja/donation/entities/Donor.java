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
@Table(name = "Donors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Donor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int userId;

	private String donarDescription;

	private String verificationDocumentation;

	public Donor(int userId) {
		super();
		this.userId = userId;
	}

}
