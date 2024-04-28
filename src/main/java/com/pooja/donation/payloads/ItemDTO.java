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
	

	private String itemName;
	private String itemDescription;
	private String itemCategory;
	private Integer quantity;
	private String quantityUnit;
}
