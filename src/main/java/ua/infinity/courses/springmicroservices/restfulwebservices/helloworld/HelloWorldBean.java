package ua.infinity.courses.springmicroservices.restfulwebservices.helloworld;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class HelloWorldBean {

    private String message;
}
