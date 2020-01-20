package Mail.ruTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features/LoginIn.feature", glue="Mail.ru")
public class LoginStepsTest {}