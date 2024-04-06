//package com.pooja.donation.entities;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Table(name = "Donors")
//@NoArgsConstructor
//@Getter
//@Setter
//public class Donor {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int did;
//
//	@Column(name = "Donor_Type", nullable = false)
//	private String dtype;
//
//	@Column(name = "Verified_Code", nullable = false)
//	private String VerCode;
//	
////	@OneToMany(mappedBy = "donor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
////	private List<Post> posts = new ArrayList<>();
////
////	@OneToOne(mappedBy = "donor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
////	private User users;
//	
//}
