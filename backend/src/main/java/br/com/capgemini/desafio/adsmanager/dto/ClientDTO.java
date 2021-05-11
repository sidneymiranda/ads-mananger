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
public class ClientDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
}
