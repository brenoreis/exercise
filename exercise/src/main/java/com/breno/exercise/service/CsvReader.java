package com.breno.exercise.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @author Breno
 * 
 *         Class to read and transform CSV files.
 */
@Service
public class CsvReader implements ICsvReader {

	@Value("${delimiter}")
	private String delimiter;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.breno.exercise.ICsvReader#csvToJson(java.lang.String)
	 */
	public JsonArray csvToJson(String filePath) {

		JsonArray jsonArray = new JsonArray();

		String line = "";
		BufferedReader br = null;
		int count = 0;
		String[] csv = null;
		String[] header = null;

		try {
			br = new BufferedReader(new FileReader(filePath));
			while ((line = br.readLine()) != null) {
				count++;
				csv = line.split(delimiter);
				// get header
				if (count == 1) {
					header = csv;
				} else {
					JsonObject json = new JsonObject();
					for (int i = 0; i < header.length; i++) {
						json.addProperty(header[i], csv[i]);
					}
					jsonArray.add(json);
					log.info("Record #" + (count - 1) + ": CVS to JSON "
							+ json.toString());
				}
			}
		} catch (FileNotFoundException e) {
			log.error("File not Found. " + e.getMessage());
		} catch (IOException e) {
			log.error("Error reading file. " + e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return jsonArray;
	}
}
