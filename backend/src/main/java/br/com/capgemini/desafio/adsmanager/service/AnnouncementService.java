package br.com.capgemini.desafio.adsmanager.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.capgemini.desafio.adsmanager.dto.GetReportDTO;
import br.com.capgemini.desafio.adsmanager.dto.PostAdDTO;
import br.com.capgemini.desafio.adsmanager.entities.Announcement;
import br.com.capgemini.desafio.adsmanager.mapper.IAnnouncementMapper;
import br.com.capgemini.desafio.adsmanager.repositories.AnnouncementRepository;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class AnnouncementService {

	private AnnouncementRepository repository;
	
	private static final IAnnouncementMapper mapper = IAnnouncementMapper.INSTANCE;
	
	private static final int originalViewsForEach1Real = 30;
	private static final double percentClick = 0.12;
	private static final double percentShare = 0.15;
	private static int clicks = 0;
	private static int views = 0;
	private static int shares = 0;
	private static int newViews = 0;
	private static int sharingLink = 0;
	private static double amountInvested = 0.0;
	private static int amountClicks = 0;
	private static int amountShares = 0;
	private static int amountViews = 0;

	
	@Transactional(readOnly = false)
	public PostAdDTO createAd(PostAdDTO adDTO) {
		Announcement ad = mapper.toAdModel(adDTO);
		Announcement adSaved = repository.save(ad);
		return mapper.toAdDTO(adSaved);
	}
	
	public List<GetReportDTO> findAllReports() throws Exception {
		
		List<Announcement> announcements = repository.findAll();
		
		return reportBuild(announcements);
	}
	
	
	
	@Transactional(readOnly = true)
	public List<GetReportDTO> findReportByClient(String client) throws Exception {
		
		List<Announcement> announcements = repository.findByClient(client);
		
		return reportBuild(announcements);
	}
	
	@Transactional(readOnly = true)
	public List<GetReportDTO> findReportByPeriod(LocalDate start, LocalDate end) throws Exception {
		List<Announcement> announcements = 
				repository.findByStartDateBetweenStartDateAndEndDate(start, end);
		
		return reportBuild(announcements);
	}
	
	/**
	 * 
	 * @param lista de anúncios que servirá como base para a contrução do(s) relatório(s)
	 * @return retorna uma lista com um ou mais relatórios dependendo do número de anúncios presente no parâmetro
	 */
	
	
	private List<GetReportDTO> reportBuild(List<Announcement> ads) throws Exception{
		List<GetReportDTO> reports = new ArrayList<GetReportDTO>();
		
		for(Announcement ad : ads) {
			long days = ChronoUnit.DAYS.between(ad.getStartDate(), ad.getEndDate());
			
			double amount = ad.getInvestedTotal();
			
			amountClicks = 0;
			amountShares = 0;
			amountViews = 0;
			sharingLink = 0;
			
			projectOriginalViews(amount);
			projectClicks();
			projectSharing();
			recalcParams();
			
			GetReportDTO report = GetReportDTO.builder()
			.id(ad.getId())
			.investedTotal(amountInvested = ad.getInvestedTotal() * days)
			.clicks(amountClicks *= days)
			.shares(amountShares *= days)
			.views(amountViews *= days)
			.build();
			
			reports.add(report);
		}
		return reports;
	}
	
/**
 * Métodos estáticos responsáveis pelo algoritmo que calcula as projeções para o relatório.
 */
	
	private static void projectOriginalViews(double amountInvested) throws Exception {
		if (amountInvested < 1.0)
			throw new Exception("O valor informado é inválido!");
		views = (int) ((amountInvested >= 1.0) ? amountInvested * originalViewsForEach1Real : 0.0);
		amountViews += views;
	}

	private static void projectClicks() {
		if (newViews == 0) {
			clicks = (int) Math.ceil(views * percentClick);
		} else {
			clicks = (int) Math.ceil(newViews * percentClick);
		}
		amountClicks += clicks;
	}

	private static void projectSharing() throws InterruptedException {
		shares = (int) ((clicks >= 1) ? (clicks * percentShare) : 0);
		amountShares += shares;
		if (shares > 0) {
			sharingLink++;
			computeNewViews();
		}
	}

	private static void computeNewViews() {
		newViews = (shares > 0) ? shares * 40 : 0;
		if (newViews > 0) {
			amountViews += newViews;
		}
	}

	private static void recalcParams() throws InterruptedException {
		while (newViews > 0) {
			projectClicks();
			if (sharingLink < 4) {
				projectSharing();
			} else {
				newViews = 0;
			}
		}
	}
}
