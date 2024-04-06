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
//@Table(name="Receivers")
//@NoArgsConstructor
//@Getter
//@Setter
//public class Receiver {
//
//	@Id
//	@GeneratedValue(strategy =GenerationType.IDENTITY)
//	private int rid;
//	
//	@Column(name="Domain", nullable= false)
//	private String domain;
//	
//	@Column(name="Website_Link", nullable= false)
//	private String webLink;
//	
//	@Column(name="Verified_Code", nullable= false)
//	private String VerCode;
//	
////	@OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
////	private List<Request> requests = new ArrayList<>();
////	
////	@OneToOne(mappedBy = "receiver", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
////	private User users;
//
//	
//}
//
//
//
//
//
//
//
