package com.ueventsserver.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDTO {
    private String token;
    private String refresh_token;
    private String type = "Bearer";
}
