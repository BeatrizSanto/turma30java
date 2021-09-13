package org.generation.blogPessoal.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;


import io.swagger.models.Contact;
import io.swagger.models.HttpMethod;
import io.swagger.models.Response;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


public class SwaggerConfig {
	@Bean
	public Docket api () {
		return new  Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.org.generation.blogpessoal.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metadata())
				.useDefaultResponseMessages(false)
				.globalResponses(HttpMethod.GET, responseMessage())
				.globalResponses(HttpMethod.POST, responseMessage())
				.globalResponses(HttpMethod.PUT, responseMessage())
				.globalResponses(HttpMethod.DELETE, responseMessage());
	}
	
	public static ApiInfo metadata() {
		return new ApiInfoBuilder()
				.title("API - Blog Pessoal")
				.description("Projeto API Spring - Blog Pessoal")
				.version("1.0.0")
				.license("Apache License Version 2.0")
				.licenseUrl("https://github.com/BeatrizSanto")
				.contact(contact())
				.build();
		}
	       private static Contact contact() {
	    	   return new Contact("Beatriz Santos",
	    			   "https://github.com/BeatrizSanto",
	    			   "beatriz.santos204@gmail.com");
	    	   }
	       private static List<Response> responseMessage() {
	    	   return new ArrayList<Response>() {
	    	   private static final long serialVersionUID = 1L;
	    	   
	    	   {
	    		   add(new ResponseBuilder().code("200")
	    		   .description("Sucesso!").build());
	    		   add(new ResponseBuilder().code("201")
	    		   .description("Criado!").build());
	    		   add(new ResponseBuilder().code("400")
	    		   .description("Erro na requisição!").build());
	    		   add(new ResponseBuilder().code("401")
	    		   .description("Não Autorizado!").build());
	    		   add(new ResponseBuilder().code("403")
	    		   .description("Proibido!").build());
	    		   add(new ResponseBuilder().code("404")
	    		   .description("Não Encontrado!").build());
	    		   add(new ResponseBuilder().code("500")
	    		   .description("Erro!").build());
	    	   }
	    	   };
	    	   }
	    	   }

				



