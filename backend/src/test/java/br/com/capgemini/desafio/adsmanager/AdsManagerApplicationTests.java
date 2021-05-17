package br.com.capgemini.desafio.adsmanager;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.capgemini.desafio.adsmanager.dto.PostAdDTO;
import br.com.capgemini.desafio.adsmanager.dto.PostClientDTO;
import br.com.capgemini.desafio.adsmanager.entities.Announcement;
import br.com.capgemini.desafio.adsmanager.entities.Client;
import br.com.capgemini.desafio.adsmanager.mapper.IAnnouncementMapper;
import br.com.capgemini.desafio.adsmanager.mapper.IClientMapper;

@SpringBootTest
class AdsManagerApplicationTests {
	
	private static final IClientMapper mapper = IClientMapper.INSTANCE;
	
//	@Test
	void quandoCadastrarUmAnuncio_EntaoOk() {
		Client client = Client.builder().name("Sidney Miranda").build();
		Announcement ads = Announcement.builder()
										.adName("Academia Técnica Capgemini")
										.client(client)
										.startDate(LocalDate.of(2021,4,07))
										.endDate(LocalDate.of(2021,9,03))
										.investedTotal(5.0)
										.build();
		PostAdDTO adsDTO = IAnnouncementMapper.INSTANCE.toAdDTO(ads);

		assertThat(adsDTO).isNotNull();
		assertThat(adsDTO.getAdName()).isEqualTo("Academia Técnica Capgemini");
		assertThat(adsDTO.getClient().getName()).isEqualTo("Sidney Miranda");
		assertThat(adsDTO.getStartDate()).isEqualTo("2021-04-07");
		assertThat(adsDTO.getEndDate()).isEqualTo("2021-09-03");
		assertThat(adsDTO.getInvestedTotal()).isEqualTo(5.0);
	}

	@Test
	void quandoConverterDtoParaEntidade_EntaoOK() {
		PostClientDTO dto = new PostClientDTO().builder().name("usuário").build();
		Client entidade = mapper.toModel(dto);
		
		assertThat(dto.getName()).isEqualTo(entidade.getName());
	}
	
	@Test
	void quandoConverterEntidadeParaDto_EntaoOK() {
		Client entidade = new Client().builder().name("usuário").build(); 
		PostClientDTO dto = mapper.toDTO(entidade);

		assertThat(entidade.getName()).isEqualTo(dto.getName());
	}
	
}
