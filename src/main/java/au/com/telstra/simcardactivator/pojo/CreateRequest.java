package au.com.telstra.simcardactivator.pojo;

import lombok.Data;

@Data
public class CreateRequest {
	private String iccid;
	private String customerEmail;

}
