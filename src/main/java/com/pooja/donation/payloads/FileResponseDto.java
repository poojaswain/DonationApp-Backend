package com.pooja.donation.payloads;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FileResponseDto {
	private String name;
	private String url;
	private String type;
	private long size;
}
