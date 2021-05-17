package br.com.capgemini.desafio.adsmanager.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.capgemini.desafio.adsmanager.entities.Announcement;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

  List<Announcement> findByClient(String client);
  
  
  
  
  @Query("select ad from Announcement ad where ad.startDate = ?1 and ad.endDate = ?2")
  List<Announcement> findByStartDateBetweenStartDateAndEndDate(LocalDate start, LocalDate end);
}
