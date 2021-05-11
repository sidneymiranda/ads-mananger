package br.com.capgemini.desafio.adsmanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.capgemini.desafio.adsmanager.dto.ClientDTO;
import br.com.capgemini.desafio.adsmanager.entities.Client;

@Mapper
public interface IClientMapper {

	IClientMapper INSTANCE = Mappers.getMapper(IClientMapper.class);

	@Mapping(source = "nome", target = "nome")
	
	Client toModel(ClientDTO dto);

	ClientDTO toDTO(Client model);
}
