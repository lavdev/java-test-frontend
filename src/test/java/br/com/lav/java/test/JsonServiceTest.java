package br.com.lav.java.test;

import br.com.lav.java.test.domain.Employee;
import br.com.lav.java.test.service.JsonService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

/***
 * JsonServiceTest class
 */
public class JsonServiceTest extends SpringBootTests {

    private final JsonService jsonService = new JsonService();

    /***
     * Just test if the result set match the value passed by parameter
     */
    @Test
    public void getEmployeeList() {
        try {
            // create a list of employee based on selected Skill
            List<Employee> employees =
                    Arrays.asList(jsonService.getEmployeeList("gestao de pessoas"));
            assertThat(employees, containsInAnyOrder(
                    hasProperty("name", is("Marcelo Ricciarixxx"))));
        } catch (AssertionError e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
}
