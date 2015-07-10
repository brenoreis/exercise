package com.breno.exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@SpringBootApplication
public class ReaderApplication {

	CsvMapper r;

	@Value("${path}")
	private String path;

	@Value("${delimiter}")
	private String delimiter;

	public static void main(String args[]) {
		SpringApplication.run(ReaderApplication.class, args);

		ReaderApplication readerApp = new ReaderApplication();

	}

	public void read() {

		String line = "";
		List<Employee> empList = new ArrayList<Employee>();

		try {

			BufferedReader br = new BufferedReader(new FileReader(path));
			while ((line = br.readLine()) != null) {

				String[] employee = line.split(delimiter);

				JsonObject jo = Json
						.createObjectBuilder()
						.add("employees",
								Json.createArrayBuilder().add(
										Json.createObjectBuilder()
												.add("firstName", "John")
												.add("lastName", "Doe")))
						.build();

				System.out.println("Country [code= " + country[4] + " , name="
						+ country[5] + "]");

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void test() {
		List<Map<?, ?>> data = readObjectsFromCsv(new File(path));
		//writeAsJson(data, output);
	}

	public static List<Map<?, ?>> readObjectsFromCsv(File file)
			throws IOException {
		CsvSchema bootstrap = CsvSchema.emptySchema().withHeader();
		CsvMapper csvMapper = new CsvMapper();
		MappingIterator<Map<?, ?>> mappingIterator = csvMapper
				.reader(Map.class).with(bootstrap).readValues(file);

		return mappingIterator.readAll();
		mappingIterator.getParser().
	}

	public static void writeAsJson(List<Map<?, ?>> data, File file)
			throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(file, data);
	}

}
