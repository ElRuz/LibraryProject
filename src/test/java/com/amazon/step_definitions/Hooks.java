package com.amazon.step_definitions;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.DB_Util;
import com.amazon.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setup() {
        DB_Util.createConnection(ConfigurationReader.getProperty("url"), ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
    }

    @After
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        DB_Util.destroy();
        Driver.closeDriver();

    }



}
