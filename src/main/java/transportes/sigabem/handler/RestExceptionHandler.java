package transportes.sigabem.handler;

import java.time.LocalDateTime;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import feign.FeignException;
import transportes.sigabem.exceptions.BadRequestException;
import transportes.sigabem.exceptions.BadRequestExceptionDetails;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<BadRequestExceptionDetails> handleBadRequestException(BadRequestException bre) {
		return new ResponseEntity<>(
				BadRequestExceptionDetails.builder()
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.BAD_REQUEST.value())
				.title("Bad Request Exception, Leia a documentação")
				.details(bre.getMessage())
				.developerMessage(bre.getClass().getName())
				.build(), HttpStatus.BAD_REQUEST
				);
	}
	
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<BadRequestExceptionDetails> handleFeignException(FeignException fee) {
		return new ResponseEntity<>(
				BadRequestExceptionDetails.builder()
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.BAD_REQUEST.value())
				.title("Cep inválido: por favor, leia a documentação")
				.details(HttpStatus.BAD_REQUEST.getReasonPhrase())
				.developerMessage(fee.getClass().getName())
				.build(), HttpStatus.BAD_REQUEST
				);
	}
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<BadRequestExceptionDetails> handleConstraintViolationExceptionn(ConstraintViolationException cv2) {
		return new ResponseEntity<>(
				BadRequestExceptionDetails.builder()
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.BAD_REQUEST.value())
				.title("o nome deve ter de 2 a 30 caracteres, leia a documentação")
				.details(HttpStatus.BAD_REQUEST.getReasonPhrase())
				.developerMessage(cv2.getClass().getName())
				.build(), HttpStatus.BAD_REQUEST
				);
	}
	
	
}
