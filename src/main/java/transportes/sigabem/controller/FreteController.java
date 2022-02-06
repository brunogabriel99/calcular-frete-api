package transportes.sigabem.controller;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import transportes.sigabem.response.FreteResponseBody;
import transportes.sigabem.service.FreteService;

@RestController
@Validated
@RequestMapping("fretes")
public class FreteController {
	
	@Autowired
	private FreteService freteService;

	@GetMapping(path = "/{peso}/{cepOrigem}/{cepDestino}/{nomeDestinatario}/json")
	public ResponseEntity<FreteResponseBody> retornarValorDoFrete(@PathVariable Double peso,@PathVariable String cepOrigem,@PathVariable String cepDestino,@PathVariable @Size(min = 2, max = 30)String nomeDestinatario) {
		FreteResponseBody frete = freteService.retornarValorDoFrete(peso, cepOrigem, cepDestino, nomeDestinatario);
		return frete != null ? ResponseEntity.ok().body(frete) : ResponseEntity.notFound().build(); 
	}
}
