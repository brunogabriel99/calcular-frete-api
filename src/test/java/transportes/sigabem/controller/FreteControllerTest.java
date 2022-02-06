package transportes.sigabem.controller;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import transportes.sigabem.response.FreteResponseBody;
import transportes.sigabem.service.FreteService;
import transportes.sigabem.util.FreteResponseBodyCreator;

@ExtendWith(SpringExtension.class)
public class FreteControllerTest {

	@InjectMocks
	private FreteController freteController;
	
	@Mock
	private FreteService freteServiceMock;
	
	@BeforeEach
	void setUp() {
		BDDMockito.when(freteServiceMock.retornarValorDoFrete(ArgumentMatchers.anyDouble(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(FreteResponseBodyCreator.createFreteResponseBody());
	}
	
	@Test
	@DisplayName("Retorna valor e data do frete quando sucesso")
	void retorna_ValorDataDoFrete_QuandoSucesso() {
		Double expectedValue = FreteResponseBodyCreator.createFreteResponseBody().getVlTotalFreteEmReais();
		LocalDate expectedDate = FreteResponseBodyCreator.createFreteResponseBody().getDataPrevistaEntrega();
		
		FreteResponseBody frete = freteController.retornarValorDoFrete(20.0D, "50860160", "50771710", "Bruno").getBody();
		
		Assertions.assertThat(frete).isNotNull();
		Assertions.assertThat(frete.getVlTotalFreteEmReais()).isNotNull().isEqualTo(expectedValue);
		Assertions.assertThat(frete.getDataPrevistaEntrega()).isNotNull().isEqualTo(expectedDate);
		Assertions.assertThat(frete.getCepDestino()).isNotNull();
		Assertions.assertThat(frete.getCepOrigem()).isNotNull();
		
		
		
	}
}
