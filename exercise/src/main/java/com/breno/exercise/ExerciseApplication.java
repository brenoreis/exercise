package com.breno.exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.breno.exercise.service.ICsvReader;
import com.breno.exercise.service.IRestClient;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

/**
 * @author Breno
 *
 *         Application that reads a csv file, converts the records in to Json
 *         and sends them to a webservice. The webservice is also implemented.
 */
@SpringBootApplication
public class ExerciseApplication implements CommandLineRunner {

	@Autowired
	private ICsvReader cvsReader;

	@Autowired
	private IRestClient client;

	@Autowired(required = true)
	private ConfigurableApplicationContext context;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * @param args
	 * 
	 *            Main method must receive CVS file path
	 */
	public static void main(String args[]) {
		SpringApplication app = new SpringApplication(ExerciseApplication.class);

		app.run(args);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) {

		if (args.length != 0) {

			// read csv file and convert to Json
			JsonArray jsonArray = cvsReader.csvToJson(args[0]);

			// post each Json element to a webservice
			for (JsonElement json : jsonArray) {
				client.postJson(json.getAsJsonObject());
			}
		} else {

			log.error("Please provide file path.");
		}

		// shutdown app
		context.close();

	}

}