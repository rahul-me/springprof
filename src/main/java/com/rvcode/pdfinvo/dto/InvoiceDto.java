package com.rvcode.pdfinvo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceDto {
	@JsonProperty("user_id")
	private String userId;
	private Integer amount;
}
