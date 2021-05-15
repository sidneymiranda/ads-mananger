package br.com.capgemini.desafio.adsmanager.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.capgemini.desafio.adsmanager.dto.PostAdDTO;
import br.com.capgemini.desafio.adsmanager.entities.Announcement;
import br.com.capgemini.desafio.adsmanager.mapper.IAnnouncementMapper;
import br.com.capgemini.desafio.adsmanager.service.AnnouncementService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/announcements")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class AnnouncementResource {
	
	private AnnouncementService service;
	private static final IAnnouncementMapper mapper = IAnnouncementMapper.INSTANCE;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PostAdDTO createAds(@RequestBody PostAdDTO adDTO) {
		Announcement ad = mapper.toModel(adDTO);
		Announcement adSaved = service.createAds(ad);
		return mapper.toDTO(adSaved);
	}
}