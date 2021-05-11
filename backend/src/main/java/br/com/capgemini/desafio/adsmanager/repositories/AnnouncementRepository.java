package br.com.capgemini.desafio.adsmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.capgemini.desafio.adsmanager.entities.Announcement;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

}
