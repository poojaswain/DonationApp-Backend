package com.pooja.donation.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
	private int id;
	private String itemName;
	private String itemCategory;
	private Integer quantity;
	private String quantityUnit;
//    private PostDTO post;

}
