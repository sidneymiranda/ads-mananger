package br.com.capgemini.desafio.adsmanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.capgemini.desafio.adsmanager.dto.PostAdDTO;
import br.com.capgemini.desafio.adsmanager.entities.Announcement;

@Mapper(componentModel = "spring")
public interface IAnnouncementMapper {

	IAnnouncementMapper INSTANCE = Mappers.getMapper(IAnnouncementMapper.class);
	
	@Mapping(source = "dataDeInicio", target = "dataDeInicio", dateFormat = "yyyy-MM-dd")
	@Mapping(source = "dataDeTermino", target = "dataDeTermino", dateFormat = "yyyy-MM-dd")

	Announcement toModel(PostAdDTO dto);

	PostAdDTO toDTO(Announcement entity);

}
