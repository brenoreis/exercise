package com.breno.exercise.service;

import com.google.gson.JsonArray;

/**
 * @author Breno
 *
 */
public interface ICsvReader {

	/**
	 * @param filePath
	 * @return {@link JsonArray}
	 * 
	 *         Method responsible to read a CSV file, transform records into
	 *         JSON format and return a JsonArray. Any CSV file can be read. It
	 *         must have a header.
	 */
	JsonArray csvToJson(String filePath);

}
