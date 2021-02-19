package ua.infinity.courses.springmicroservices.restfulwebservices.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExceptionResponse {

    private Date timestamp;
    private String message;
    private String details;
}
