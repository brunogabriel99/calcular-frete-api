package transportes.sigabem.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import transportes.sigabem.domain.Frete;

public class FreteCreator {

	public static Frete createFreteToBeSaved() {
		return new Frete(20.0D, "50860160", "50771710", "Bruno", 10.0D, LocalDate.now().plus(1, ChronoUnit.DAYS), Instant.now());
	}
	
	public static Frete createValidFrete() {
		Frete frete = new Frete(20.0D, "50860160", "50771710", "Bruno", 10.0D, LocalDate.now().plus(1, ChronoUnit.DAYS), Instant.now());
		frete.setId(1L);
		return frete;
	}
}
