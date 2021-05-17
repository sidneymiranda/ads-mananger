package br.com.capgemini.desafio.adsmanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.capgemini.desafio.adsmanager.dto.PostClientDTO;
import br.com.capgemini.desafio.adsmanager.entities.Client;

@Mapper(componentModel = "spring")
public interface IClientMapper {

	IClientMapper INSTANCE = Mappers.getMapper(IClientMapper.class);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "ads", ignore = true)
	Client toModel(PostClientDTO dto);

	PostClientDTO toDTO(Client model);
}
