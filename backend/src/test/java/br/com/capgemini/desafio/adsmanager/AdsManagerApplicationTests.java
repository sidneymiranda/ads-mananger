package br.com.capgemini.desafio.adsmanager;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.capgemini.desafio.adsmanager.dto.AnnouncementDTO;
import br.com.capgemini.desafio.adsmanager.entities.Announcement;
import br.com.capgemini.desafio.adsmanager.entities.Client;
import br.com.capgemini.desafio.adsmanager.mapper.IAnnouncementMapper;

@SpringBootTest
class AdsManagerApplicationTests {

	@Test
	void contextLoads() {

		// Given
		Client client = Client.builder()
								 .nome("Simone")
								 .build();
		// Given
		Announcement ads = Announcement.builder()
											.nomeDoAnuncio("Simone avó")
											.cliente(client)
											.dataDeInicio(LocalDate.of(2021,06,19))
											.dataDeTermino(LocalDate.of(2021,06,20))
											.investimentoPorDia(5.0)
											.build();

//		When
		AnnouncementDTO adsDTO = IAnnouncementMapper.INSTANCE.toDTO(ads);

//		Then
		assertThat(adsDTO).isNotNull();
		assertThat(adsDTO.getNomeDoAnuncio()).isEqualTo("Simone avó");
		assertThat(adsDTO.getCliente().getNome()).isEqualTo("Simone");
		assertThat(adsDTO.getDataDeInicio()).isEqualTo("2021-06-19");
		assertThat(adsDTO.getDataDeTermino()).isEqualTo("2021-06-20");
		assertThat(adsDTO.getInvestimentoPorDia()).isEqualTo(5.0);
	}
}
