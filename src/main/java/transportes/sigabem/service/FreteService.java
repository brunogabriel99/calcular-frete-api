package transportes.sigabem.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transportes.sigabem.domain.Endereco;
import transportes.sigabem.domain.Frete;
import transportes.sigabem.exceptions.BadRequestException;
import transportes.sigabem.repository.FreteRepository;
import transportes.sigabem.response.FreteResponseBody;

@Service
public class FreteService {
	
	@Autowired
	private CepService cepService;

	@Autowired
	private FreteRepository freteRepository;
	
	
	public FreteResponseBody retornarValorDoFrete(Double peso, String cepOrigem, String cepDestino, String nomeDestinatario) {
		Endereco endereco1 = cepService.buscaEnderecoPorCep(cepOrigem);
		Endereco endereco2 = cepService.buscaEnderecoPorCep(cepDestino); 
		
		FreteResponseBody retorno = calcularValorDoFreteMaisDataPrevista(endereco1, endereco2, peso);
		
		freteRepository.save(new Frete(peso, cepOrigem, cepDestino, nomeDestinatario, retorno.getVlTotalFreteEmReais(), retorno.getDataPrevistaEntrega(), Instant.now()));
		
		return retorno;
	}
	
	private FreteResponseBody calcularValorDoFreteMaisDataPrevista(Endereco origem, Endereco destino, Double pesoEmKg) {
	
		Double valorFreteKg = 1.00D;
		Double valorTotalRetorno = valorFreteKg * pesoEmKg;
		LocalDate previsaoEntrega = LocalDate.now();
		
		if (pesoEmKg <= 0) {
			throw new BadRequestException("Peso tem que ser acima de 0");
		}
		
		if (origem.getUf().equals(destino.getUf())) {
			valorTotalRetorno -= valorTotalRetorno * 0.75D;
			previsaoEntrega = previsaoEntrega.plus(3, ChronoUnit.DAYS);
		} else if (origem.getDdd().equals(destino.getDdd())) {
			valorTotalRetorno -= valorTotalRetorno * 0.50D;
			previsaoEntrega = previsaoEntrega.plus(1, ChronoUnit.DAYS);
		} else {
			previsaoEntrega = previsaoEntrega.plus(10, ChronoUnit.DAYS);
		}
		
		return new FreteResponseBody(valorTotalRetorno, previsaoEntrega, destino.getCep(), origem.getCep());
	}
}
