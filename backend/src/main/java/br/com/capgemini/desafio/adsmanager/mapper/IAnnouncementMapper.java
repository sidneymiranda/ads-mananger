package br.com.capgemini.desafio.adsmanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.capgemini.desafio.adsmanager.dto.GetReportDTO;
import br.com.capgemini.desafio.adsmanager.dto.PostAdDTO;
import br.com.capgemini.desafio.adsmanager.entities.Announcement;

@Mapper(componentModel = "spring")
public interface IAnnouncementMapper {

	IAnnouncementMapper INSTANCE = Mappers.getMapper(IAnnouncementMapper.class);

	@Mapping(target = "startDate", dateFormat = "yyyy-MM-dd")
	@Mapping(target = "endDate", dateFormat = "yyyy-MM-dd")

	@Mapping(target = "id", ignore = true)
	Announcement toAdModel(PostAdDTO dto);
//	Client toClientModel(PostClientDTO clientDto);

	PostAdDTO toAdDTO(Announcement entity);

	GetReportDTO toGetReportDTO(Announcement entity);

}
