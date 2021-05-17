package br.com.capgemini.desafio.adsmanager.resource;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.capgemini.desafio.adsmanager.dto.GetReportDTO;
import br.com.capgemini.desafio.adsmanager.dto.PostAdDTO;
import br.com.capgemini.desafio.adsmanager.service.AnnouncementService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/announcements")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class AnnouncementResource {

	private AnnouncementService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PostAdDTO createAd(@RequestBody PostAdDTO adDTO) {
		return service.createAd(adDTO);
	}

	@GetMapping("/reports")
	@ResponseStatus(HttpStatus.OK)
	public List<GetReportDTO> findAllReport() throws Exception {
		return service.findAllReports();
	}
	
	@GetMapping("/reports/report-by-client/{client}")
	@ResponseStatus(HttpStatus.OK)
	public List<GetReportDTO> findReportByClient(@PathVariable String client) throws Exception {
		return service.findReportByClient(client);
	}

	@GetMapping("/reports/report-by-period/{startDate}/{endDate}")
	@ResponseStatus(HttpStatus.OK)
	public List<GetReportDTO> findReportByPeriod(@PathVariable LocalDate startDate, LocalDate endDate) throws Exception {
		return service.findReportByPeriod(startDate, endDate);
	}
}