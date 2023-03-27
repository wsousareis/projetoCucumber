package br.produto.com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/validaEspProd.feature", plugin = "pretty",
		glue = { "br.produto.com.steps" }, monochrome = true, dryRun = false, snippets = SnippetType.CAMELCASE)

public class Runner {

}
  