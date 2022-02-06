package transportes.sigabem.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import transportes.sigabem.response.FreteResponseBody;

public class FreteResponseBodyCreator {

	public static FreteResponseBody createFreteResponseBody() {
		return new FreteResponseBody(20.0D, LocalDate.now().plus(1, ChronoUnit.DAYS), "50860160", "50771710");
	}
	
}
