package com.breno.exercise.service;

import com.google.gson.JsonObject;

/**
 * @author Breno
 *
 */
public interface IRestClient {

	/**
	 * @param json
	 * 
	 *            Method responsible to post a Json object to a webservice.
	 */
	void postJson(JsonObject json);

}
