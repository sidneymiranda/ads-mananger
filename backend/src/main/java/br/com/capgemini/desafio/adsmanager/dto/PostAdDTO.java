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
public class PostAdDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nomeDoAnuncio;
	private PostClientDTO cliente;
	private String dataDeInicio;
	private String dataDeTermino;
	private Double investimentoPorDia;

}
