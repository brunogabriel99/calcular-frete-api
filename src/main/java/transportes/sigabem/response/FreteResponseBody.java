package transportes.sigabem.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FreteResponseBody {

	private Double vlTotalFreteEmReais;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT")
	private LocalDate dataPrevistaEntrega;
	private String cepOrigem;
	private String cepDestino;
	
	
	public FreteResponseBody() {
	}

	public FreteResponseBody(Double vlTotalFreteEmReais, LocalDate dataPrevistaEntrega, String cepOrigem,
			String cepDestino) {
		this.vlTotalFreteEmReais = vlTotalFreteEmReais;
		this.dataPrevistaEntrega = dataPrevistaEntrega;
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
	}

	public Double getVlTotalFreteEmReais() {
		return vlTotalFreteEmReais;
	}

	public void setVlTotalFreteEmReais(Double vlTotalFreteEmReais) {
		this.vlTotalFreteEmReais = vlTotalFreteEmReais;
	}

	public LocalDate getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}

	public void setDataPrevistaEntrega(LocalDate dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}

	public String getCepOrigem() {
		return cepOrigem;
	}

	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}

	public String getCepDestino() {
		return cepDestino;
	}

	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}
}
