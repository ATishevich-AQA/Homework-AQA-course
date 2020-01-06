package Mail.ruTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features/MoveToSpam.feature", glue="Mail.ru")
public class MovetoSpamSteps {}