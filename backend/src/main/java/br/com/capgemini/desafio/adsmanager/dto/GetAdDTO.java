package br.com.capgemini.desafio.adsmanager.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAdDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String adName;
	private String client;
	private LocalDate startDate;
	private LocalDate endDate;
	private Double amountInvested;

}
