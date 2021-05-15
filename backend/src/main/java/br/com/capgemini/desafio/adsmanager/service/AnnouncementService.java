package br.com.capgemini.desafio.adsmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.capgemini.desafio.adsmanager.entities.Announcement;
import br.com.capgemini.desafio.adsmanager.repositories.AnnouncementRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class AnnouncementService {

	private AnnouncementRepository repository;


	@Transactional(readOnly = false)
	public Announcement createAds(Announcement ad) {
		return repository.save(ad);
	}

	public void getReportByClient() {

	}

	public void getReportByTimeInterval() {

	}

	public void getReports() {

	}
}
