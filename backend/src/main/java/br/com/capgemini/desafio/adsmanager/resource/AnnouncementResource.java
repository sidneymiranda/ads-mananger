package br.com.capgemini.desafio.adsmanager.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.capgemini.desafio.adsmanager.dto.AnnouncementDTO;
import br.com.capgemini.desafio.adsmanager.dto.MessageResponseDTO;
import br.com.capgemini.desafio.adsmanager.service.AnnouncementService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/announcements")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class AnnouncementResource {
	
	private AnnouncementService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createAds(@RequestBody AnnouncementDTO adsDTO) {
		return service.createAds(adsDTO);
	}
}