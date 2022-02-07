package transportes.sigabem.service;

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

import transportes.sigabem.domain.Endereco;
import transportes.sigabem.repository.FreteRepository;
import transportes.sigabem.response.FreteResponseBody;
import transportes.sigabem.util.FreteResponseBodyCreator;

@ExtendWith(SpringExtension.class)
public class FreteServiceTest {

	@InjectMocks
	private FreteService freteService;
	
	@Mock 
	private CepService cepServiceMock;
	
	@BeforeEach
	void setUp() {
		Endereco endereco = new Endereco();
		BDDMockito.when(cepServiceMock.buscaEnderecoPorCep(ArgumentMatchers.anyString())).thenReturn(endereco);
	}
	
	@Test
	@DisplayName("Retorna Endereco quando sucesso")
	void retorna_Endereco_QuandoSucesso() {
		
		Endereco endereco = cepServiceMock.buscaEnderecoPorCep("50860160");
		
		Assertions.assertThat(endereco).isNotNull();				
	}
}
