package styleMateRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"E:\\\\STS\\\\workspace-spring-tools-for-eclipse-4.31.0.RELEASE\\\\TheSentinelStack\\\\StyleMate Features\\\\Homepage.feature",
				    "E:\\\\\\\\STS\\\\\\\\workspace-spring-tools-for-eclipse-4.31.0.RELEASE\\\\\\\\TheSentinelStack\\\\\\\\StyleMate Features\\\\\\\\Catalog.feature"},
		glue = {"styleMateAutomation"}
		)

public class Runner extends AbstractTestNGCucumberTests {

}
