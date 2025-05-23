package au.com.telstra.simcardactivator.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.telstra.simcardactivator.pojo.CreateRequest;
import au.com.telstra.simcardactivator.service.SCAServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping({"/v1/simcard/activate/","/v1/simcard/activate"})
@Slf4j
@RequiredArgsConstructor
public class SCAController {
	
	private final SCAServiceImpl scaService;
	
	@PostMapping
	public String activateSim(
			@RequestBody CreateRequest requestBody) {
		log.info("requestBody:{}",requestBody);
		log.info("Calling activateSim service...");
		
		boolean response = scaService.activateSim(requestBody);
		
		if(!response) {
			log.info("Error! Sim activation failed.");
			return "ERROR! Sim activation was not successful!";
		}
		log.info("Sim activation successful. Returning response string.");
		return "Sim activation was successful!";
		
	}

}
