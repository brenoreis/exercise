package com.breno.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.breno.exercise.service.ICsvReader;
import com.breno.exercise.service.IRestClient;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

@SpringBootApplication
public class ExerciseApplication implements CommandLineRunner {

	@Autowired
	private ICsvReader cvsReader;

	@Autowired
	private IRestClient client;

	public static void main(String args[]) {
		SpringApplication app = new SpringApplication(ExerciseApplication.class);

		app.run(args);

	}

	@Override
	public void run(String... args) {

		if (args.length != 0 && args[0] != null) {
			
			JsonArray jsonArray = cvsReader.csvToJson(args[0]);

			for (JsonElement json : jsonArray) {
				client.postJson(json.getAsJsonObject());
			}
		} else {
			
			System.out.println("Please provide file path.");
		}

	}

}