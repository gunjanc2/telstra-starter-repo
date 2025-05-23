package au.com.telstra.simcardactivator.service;

import au.com.telstra.simcardactivator.pojo.CreateRequest;

public interface SCAService {
	
	public boolean activateSim(CreateRequest requestBody);

}
