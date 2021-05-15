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
public class PostClientDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nome;
}
