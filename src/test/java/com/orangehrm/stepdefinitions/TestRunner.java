package com.orangehrm.stepdefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\\\Users\\\\Kavya Para\\\\git\\\\github.com\\\\Kasturi-biradar\\\\Saritha_Mam_Wipro\\\\Wipro\\\\src\\\\test\\\\resources\\\\Features",
    glue = {"com.orangehrm.stepdefinitions"},
    dryRun = false,
    monochrome = true
)
public class TestRunner {
}
