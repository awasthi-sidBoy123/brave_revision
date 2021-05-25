package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features = {"C:\\Users\\Admin\\eclipse-workspace\\ApiCompleteProject\\src\\test\\java\\feature\\AddPlace.feature"},
		features = "src/test/java/feature",
		glue = {"stepDefination"}
		)

public class TestRunner {

}
