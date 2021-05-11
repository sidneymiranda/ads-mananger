package br.com.capgemini.desafio.adsmanager.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nomeDoAnuncio;
	private ClientDTO cliente;
	private String dataDeInicio;
	private String dataDeTermino;
	private Double investimentoPorDia;

}
