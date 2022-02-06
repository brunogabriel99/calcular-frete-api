package transportes.sigabem.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import transportes.sigabem.domain.Frete;
import transportes.sigabem.util.FreteCreator;

@DataJpaTest
@DisplayName("Tests for frete repository")
public class FreteRepositoryTest {

	@Autowired
	private FreteRepository freteRepository;
	
	@Test
	@DisplayName("Save persists Frete when successful")
	public void save_PersistFrete_WhenSuccessful() {
		Frete createFreteToBeSaved = FreteCreator.createFreteToBeSaved();
		Frete freteSaved = freteRepository.save(createFreteToBeSaved);
		Assertions.assertThat(freteSaved).isNotNull();
		Assertions.assertThat(freteSaved.getId()).isNotNull();
		Assertions.assertThat(freteSaved.getCepDestino()).isEqualTo(createFreteToBeSaved.getCepDestino());
		Assertions.assertThat(freteSaved.getCepOrigem()).isEqualTo(createFreteToBeSaved.getCepOrigem());
		Assertions.assertThat(freteSaved.getNomeDestinatario()).isEqualTo(createFreteToBeSaved.getNomeDestinatario());
		Assertions.assertThat(freteSaved.getPesoEmKg()).isEqualTo(createFreteToBeSaved.getPesoEmKg());
		Assertions.assertThat(freteSaved.getVlTotalFrete()).isEqualTo(createFreteToBeSaved.getVlTotalFrete());
		Assertions.assertThat(freteSaved.getDataConsulta()).isEqualTo(createFreteToBeSaved.getDataConsulta());
		Assertions.assertThat(freteSaved.getDataPrevistaEntrega()).isEqualTo(createFreteToBeSaved.getDataPrevistaEntrega());
	}
}
