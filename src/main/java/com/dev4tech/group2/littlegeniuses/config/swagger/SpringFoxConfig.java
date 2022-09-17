package com.dev4tech.group2.littlegeniuses.config.swagger;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.dev4tech.group2.littlegeniuses.api.exceptionhandler.Problem;
import com.dev4tech.group2.littlegeniuses.api.model.response.ClassModelResponse;
import com.dev4tech.group2.littlegeniuses.api.model.response.StudentModelResponse;
import com.dev4tech.group2.littlegeniuses.api.model.response.TeacherModelResponse;
import com.dev4tech.group2.littlegeniuses.api.openapi.model.ClassModelOpenApi;
import com.dev4tech.group2.littlegeniuses.api.openapi.model.PageableModelOpenApi;
import com.dev4tech.group2.littlegeniuses.api.openapi.model.StudentModelOpenApi;
import com.dev4tech.group2.littlegeniuses.api.openapi.model.TeacherModelOpenApi;
import com.fasterxml.classmate.TypeResolver;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RepresentationBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Response;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.json.JacksonModuleRegistrar;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

	@Bean
	public Docket apiDocket() {
		TypeResolver typeResolver = new TypeResolver();
		return new Docket(DocumentationType.OAS_30).select()
				.apis(RequestHandlerSelectors.basePackage("com.dev4tech.group2.littlegeniuses.api"))
				.paths(PathSelectors.ant("/**")).build()
				.globalResponses(HttpMethod.GET, globalGetResponseMessages()) // Adicionando Exceções globais para todas as tags
				.globalResponses(HttpMethod.POST, globalPostPutResponseMessages())
				.globalResponses(HttpMethod.PUT, globalPostPutResponseMessages())
				.globalResponses(HttpMethod.DELETE, globalDeleteResponseMessages())
				.additionalModels(typeResolver.resolve(Problem.class))
				.directModelSubstitute(Pageable.class, PageableModelOpenApi.class).useDefaultResponseMessages(false)
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(Page.class, ClassModelResponse.class), ClassModelOpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(Page.class, StudentModelResponse.class), StudentModelOpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(Page.class, TeacherModelResponse.class), TeacherModelOpenApi.class))
				.apiInfo(apiInfo())
				.tags(new Tag("Student", "Manage Students"), 
					new Tag("Teacher", "Manage Teachers"),
					new Tag("Class", "Manage Class"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Little Geniuses API").description("API open for Little Geniuses School")
				.version("1").build();
	}

	// List Error 500
	private List<Response> globalGetResponseMessages() {
		return Arrays.asList(
				new ResponseBuilder().code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
						.description("Internal server error").representation(MediaType.APPLICATION_JSON)
						.apply(getProblemaModelReference()).build());
	}

	// List Error 400, 415 and 500 
	private List<Response> globalPostPutResponseMessages() {
		return Arrays.asList(
				new ResponseBuilder().code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
						.description("Invalid request (client error)").representation(MediaType.APPLICATION_JSON)
						.apply(getProblemaModelReference()).build(),
				new ResponseBuilder().code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
						.description("Internal server error").representation(MediaType.APPLICATION_JSON)
						.apply(getProblemaModelReference()).build(),
				new ResponseBuilder().code(String.valueOf(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()))
						.description("Request refused because the body is in an unsupported format.")
						.representation(MediaType.APPLICATION_JSON).apply(getProblemaModelReference()).build());
	}

	// List Error 400 and 500
	private List<Response> globalDeleteResponseMessages() {
		return Arrays.asList(
				new ResponseBuilder().code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
						.description("Invalid request (client error)").representation(MediaType.APPLICATION_JSON)
						.apply(getProblemaModelReference()).build(),
				new ResponseBuilder().code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
						.description("Internal server error").representation(MediaType.APPLICATION_JSON)
						.apply(getProblemaModelReference()).build());
	}

	private Consumer<RepresentationBuilder> getProblemaModelReference() {
		return r -> r.model(m -> m.name("Problem").referenceModel(ref -> ref.key(k -> k.qualifiedModelName(
				q -> q.name("Problem").namespace("com.dev4tech.group2.littlegeniuses.api.exceptionhandler")))));
	}

	@Bean
	public JacksonModuleRegistrar springFoxJacksonConfig() {
		return objectMapper -> objectMapper.registerModule(new JavaTimeModule());
	}
}
