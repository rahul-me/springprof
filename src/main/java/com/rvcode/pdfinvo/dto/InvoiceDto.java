package com.rvcode.pdfinvo.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceDto {
	@JsonProperty("user_id")
	@NotBlank
	private String userId;
	
	@Min(10)
	@Max(50)
	private Integer amount;
}
