package br.com.capgemini.desafio.adsmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.capgemini.desafio.adsmanager.dto.AnnouncementDTO;
import br.com.capgemini.desafio.adsmanager.dto.MessageResponseDTO;
import br.com.capgemini.desafio.adsmanager.entities.Announcement;
import br.com.capgemini.desafio.adsmanager.mapper.IAnnouncementMapper;
import br.com.capgemini.desafio.adsmanager.repositories.AnnouncementRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class AnnouncementService {

	private AnnouncementRepository repository;

	private static final IAnnouncementMapper mapper = IAnnouncementMapper.INSTANCE;

	public MessageResponseDTO messageResponse(Long id, String message) {
		return MessageResponseDTO.builder().message(message + id).build();
	}

	@Transactional(readOnly = true)
	public MessageResponseDTO createAds(AnnouncementDTO adsDto) {
		Announcement adsToSave = mapper.toModel(adsDto);
		Announcement adsSave = repository.save(adsToSave);

		return messageResponse(adsSave.getId(), "Created Announcement with id:: ");
	}

	public void getReportByClient() {

	}

	public void getReportByTimeInterval() {

	}

	public void getReports() {

	}
}
