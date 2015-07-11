package com.breno.exercise.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;

@Service
public class RestClient implements IRestClient{
	
	@Value("${url.post}")
	private String url;
	
	public void postJson(JsonObject json) {
		
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(json.toString(),headers);
        String response = restTemplate.postForObject(url, entity, String.class);
        System.out.println(response.toString());
    }
	

}
