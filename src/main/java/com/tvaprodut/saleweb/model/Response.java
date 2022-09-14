package com.tvaprodut.saleweb.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    protected LocalDateTime time;
    protected int statusCode;
    protected String reason;
    protected String message;
    protected Map<?,?> data;
}
