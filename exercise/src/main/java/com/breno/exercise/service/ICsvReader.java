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
	 * Method responsible to read a CSV file, transform records into JSON format and return a JsonArray 
	 */
	JsonArray csvToJson(String filePath);

}
