package com.pooja.donation.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Items")
@NoArgsConstructor
@Getter
@Setter
public class Item {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	
    @Column(name="item_name")
	private String itemName;
	
    
//    @Column(name="image")
//	private String itemImage;
	
    
    @Column(name="item_category")
	private String itemCategory;
	
    
    @Column(name="quantity")
	private Integer quantity;
    
    @Column(name="quantity_unit")
	private String quantityUnit;

    @ManyToOne
    private Post post;
}
