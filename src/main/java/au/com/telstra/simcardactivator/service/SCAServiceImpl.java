package au.com.telstra.simcardactivator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import au.com.telstra.simcardactivator.pojo.CreateRequest;
import au.com.telstra.simcardactivator.pojo.SimRequest;
import au.com.telstra.simcardactivator.pojo.SimResponse;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SCAServiceImpl implements SCAService{
	
	@Autowired
	private RestTemplate restTemplate;
	

	@Override
	public boolean activateSim(CreateRequest requestBody) {
		
		log.info("Inside activateSim service...");
		
		SimRequest simRequest = new SimRequest();
		simRequest.setIccid(requestBody.getIccid());
		
		log.info("simRequest:{}",simRequest);
		
//		HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        log.info("headers:{}",headers);
        
//        HttpEntity<SimRequest> entity = new HttpEntity<>(simRequest, headers);
//        log.info("entity:{}",entity);
		SimResponse simResponse =null;
		try {
		    simResponse = restTemplate.postForObject("http://localhost:8444/actuate", simRequest, SimResponse.class);
		    log.info("Response: {}", simResponse);
		} catch (Exception e) {
		    log.error("Error calling endpoint", e);
		}
		
//		SimResponse simResponse = response.getBody();
//		log.info("simResponse:{}",simResponse);
		
		return simResponse.isSuccess();
	}

}
