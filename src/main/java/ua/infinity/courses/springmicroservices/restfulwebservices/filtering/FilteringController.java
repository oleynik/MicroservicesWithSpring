package ua.infinity.courses.springmicroservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean retrieveSomeBean() {
        return new SomeBean("value1", "value2", "value3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> retrieveListOfSomeBeans() {
        return Arrays.asList(
                new SomeBean("value11", "value12", "value13"),
                new SomeBean("value21", "value22", "value23")
        );
    }

    @GetMapping("/dynamic-filtering")
    public MappingJacksonValue retrieveSomeOtherBean() {
        SomeOtherBean someOtherBean = new SomeOtherBean("value1", "value2", "value3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");

        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("SomeOtherBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(someOtherBean);
        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping("/dynamic-filtering-list")
    public MappingJacksonValue retrieveListOfSomeOtherBeans() {
        List<SomeOtherBean> beans = Arrays.asList(
                new SomeOtherBean("value11", "value12", "value13"),
                new SomeOtherBean("value21", "value22", "value23"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");

        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("SomeOtherBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(beans);
        mapping.setFilters(filters);
        return mapping;
    }
}
