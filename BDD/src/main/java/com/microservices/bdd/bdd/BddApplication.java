package com.microservices.bdd.bdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BddApplication {

	//private static DocumentReference markdowncollection = db.collection("microservices").document("markdown");
	//private static DocumentReference latexcollection = db.collection("microservices").document("latex");

	public static void main(String[] args) {
		SpringApplication.run(BddApplication.class, args);
	}

	@PostMapping("/bdd")
	public String hello() {
		return "alooooo";
	}

	public void AddMarkdown(){

	}

	public void AddLatex(){

	}
}
