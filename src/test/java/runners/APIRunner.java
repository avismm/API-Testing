package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        //features is used to provide the path of all the feature files
        features ="src/test/resources/features",

        //glue is where we find implementation of gherkin steps
        //we provide path of the package where we define all the step definition
        glue ="steps",

        //if we set the value of dry run to true, it will stop the execution
        //it quickly scans all the gherkin steps in all the feature files and will give you the missing step definition for actual execution, we need to set the value of dryRun to false
        dryRun = false,

        //tags will identify the scenarios in a group and will execute the scenarios having these tags
        //We use 'and' and 'or' keywords to execute based on conditions

        tags ="@test",

        //generating the test report
        //pretty is responsible for printing the step definition in the console during local execution
        //In your framework, all reports should be generated under target folder. Target folder is created by default in all projects.
        //We will generate html report in target folder
        //rerun plugin will create a failed.txt under the target folder for all failed test cases.

        plugin = {"pretty", "html:target/cucumber.html","json:target/cucumber.json","rerun:target/failed.txt"}

)

public class APIRunner {
    //it will be empty

}
