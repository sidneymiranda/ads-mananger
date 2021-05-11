package br.com.capgemini.desafio.adsmanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.capgemini.desafio.adsmanager.dto.AnnouncementDTO;
import br.com.capgemini.desafio.adsmanager.entities.Announcement;

@Mapper
public interface IAnnouncementMapper {

	IAnnouncementMapper INSTANCE = Mappers.getMapper(IAnnouncementMapper.class);
	
	@Mapping(source = "dataDeInicio", target = "dataDeInicio", dateFormat = "dd-MM-yyyy")
	@Mapping(source = "dataDeTermino", target = "dataDeTermino", dateFormat = "dd-MM-yyyy")
	
	Announcement toModel(AnnouncementDTO dto);

	AnnouncementDTO toDTO(Announcement entity);

}
