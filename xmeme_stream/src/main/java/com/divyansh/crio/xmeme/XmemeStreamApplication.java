package com.divyansh.crio.xmeme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class XmemeStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmemeStreamApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.divyansh.crio.xmeme.Controller"))
				.build()
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, getCustomizedGetResponseMessages())
				.globalResponseMessage(RequestMethod.POST, getCustomizedPostResponseMessages())
				.globalResponseMessage(RequestMethod.PATCH, getCustomizedPatchResponseMessages())
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"XMEME STREAM REST API", 
				"This Dashboard lists all API which helps to interact with Application.", 
				"API TOS", 
				"Terms of service", 
				new Contact("Divyansh Rahangdale", "https://www.linkedin.com/in/divyansh-rahangdale-27600311b/", "divyansh.1999.dr@gmail.com"), 
				"License of API", 
				"API license URL", 
				Collections.emptyList());	
	}

	private List<ResponseMessage> getCustomizedGetResponseMessages(){
		List<ResponseMessage> responseMessages = new ArrayList<>();
		responseMessages.add(new ResponseMessageBuilder().code(500).message("Internal Server Error!").responseModel(new ModelRef("Error")).build());
		responseMessages.add(new ResponseMessageBuilder().code(403).message("Forbidden!").build());
		responseMessages.add(new ResponseMessageBuilder().code(404).message("Id doesn't exist!").build());

		return responseMessages;
	}

	private List<ResponseMessage> getCustomizedPostResponseMessages(){
		List<ResponseMessage> responseMessages = new ArrayList<>();
		responseMessages.add(new ResponseMessageBuilder().code(500).message("Internal Server Error!").responseModel(new ModelRef("Error")).build());
		responseMessages.add(new ResponseMessageBuilder().code(403).message("Forbidden!").build());
		responseMessages.add(new ResponseMessageBuilder().code(404).message("Id doesn't exist!").build());
		responseMessages.add(new ResponseMessageBuilder().code(409).message("Conflict! Same Parameters Exists").build());

		return responseMessages;
	}

	private List<ResponseMessage> getCustomizedPatchResponseMessages(){
		List<ResponseMessage> responseMessages = new ArrayList<>();
		responseMessages.add(new ResponseMessageBuilder().code(500).message("Internal Server Error!").responseModel(new ModelRef("Error")).build());
		responseMessages.add(new ResponseMessageBuilder().code(403).message("Forbidden!").build());
		responseMessages.add(new ResponseMessageBuilder().code(404).message("Id doesn't exist!").build());
		responseMessages.add(new ResponseMessageBuilder().code(409).message("Conflict! Same Parameters Exists").build());

		return responseMessages;
	}

}
