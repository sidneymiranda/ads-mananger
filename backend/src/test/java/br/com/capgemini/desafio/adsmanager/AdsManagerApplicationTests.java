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
	
	@Test
	void quandoCadastrarUmAnuncio_EntaoOk() {
		Client client = Client.builder().nome("Sidney Miranda").build();
		Announcement ads = Announcement.builder()
										.nomeDoAnuncio("Academia Técnica Capgemini")
										.cliente(client)
										.dataDeInicio(LocalDate.of(2021,4,07))
										.dataDeTermino(LocalDate.of(2021,9,03))
										.investimentoPorDia(5.0)
										.build();
		PostAdDTO adsDTO = IAnnouncementMapper.INSTANCE.toDTO(ads);

		assertThat(adsDTO).isNotNull();
		assertThat(adsDTO.getNomeDoAnuncio()).isEqualTo("Academia Técnica Capgemini");
		assertThat(adsDTO.getCliente().getNome()).isEqualTo("Sidney Miranda");
		assertThat(adsDTO.getDataDeInicio()).isEqualTo("2021-04-07");
		assertThat(adsDTO.getDataDeTermino()).isEqualTo("2021-09-03");
		assertThat(adsDTO.getInvestimentoPorDia()).isEqualTo(5.0);
	}

	@Test
	void quandoConverterDtoParaEntidade_EntaoOK() {
		PostClientDTO dto = new PostClientDTO().builder().nome("usuário").build();
		Client entidade = mapper.toModel(dto);
		
		assertThat(dto.getNome()).isEqualTo(entidade.getNome());
	}
	
	@Test
	void quandoConverterEntidadeParaDto_EntaoOK() {
		Client entidade = new Client().builder().nome("usuário").build(); 
		PostClientDTO dto = mapper.toDTO(entidade);

		assertThat(entidade.getNome()).isEqualTo(dto.getNome());
	}
	
}
