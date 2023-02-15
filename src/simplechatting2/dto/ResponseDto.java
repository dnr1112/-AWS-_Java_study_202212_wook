package simplechatting2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {
	private String resource;
	private String status;
	private String body;
	
}