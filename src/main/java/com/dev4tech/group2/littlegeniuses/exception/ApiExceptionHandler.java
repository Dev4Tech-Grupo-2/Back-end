package com.dev4tech.group2.littlegeniuses.exception;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	// MÉTODO PARA TRATAR ERRO NA VALIDAÇÃO DOS CAMPOS DA ENTIDADE
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleValidationInternal(ex, headers, status, request, ex.getBindingResult());
	}

	// METODO PARA TRATAR EXCEÇÕES DENTRO DO CONTROLADOR
	@ExceptionHandler(ResourceNotFoundException.class)
	private ResponseEntity<?> handleEntityNotFoundException(RuntimeException ex, WebRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		String detail = ex.getMessage();

		Problem problem = Problem.builder().timestamp(OffsetDateTime.now()).status(status.value())
				.title("Entity not found").detail(detail)
				.userMessage("An unexpected internal system error has occurred.").build();
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	private ResponseEntity<Object> handleValidationInternal(Exception ex, HttpHeaders headers, HttpStatus status,
			WebRequest request, BindingResult bindingResult) {
		String detail = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.";

		List<Problem.Object> problemObjects = bindingResult.getAllErrors().stream().map(objectError -> {
			String message = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());
			String name = objectError.getObjectName();

			if (objectError instanceof FieldError) {
				name = ((FieldError) objectError).getField();
			}
			return Problem.Object.builder().name(name).userMessage(message).build();
		}).collect(Collectors.toList());

		Problem problem = Problem.builder().timestamp(OffsetDateTime.now()).status(status.value())
				.title("Dados Inválidos").detail(detail).userMessage(detail).objects(problemObjects).build();

		return handleExceptionInternal(ex, problem, headers, status, request);
	}

}
