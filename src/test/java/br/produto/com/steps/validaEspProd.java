package br.produto.com.steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import br.produto.com.AbstractPages;
import br.produto.com.xPaths;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class validaEspProd extends AbstractPages {

	private static final String URL = "https://advantageonlineshopping.com";
	private static final Boolean MAXIMIZE = Boolean.TRUE;

	@Given("que acesso o site de compras advantage shopping")
	public void acessoSiteDeComprasAdvantageShopping() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "c:\\Desenvolvimento\\Drives\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);

		if (MAXIMIZE) {
			driver.manage().window().maximize();

		}
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("clico no menu Special Offer")
	public void clicaMenuSpecialOffer() throws Throwable {
		buscarElementoPorXPath(xPaths.menuSpecialOffer).click();
	}

	@When("clico no botão See Offer")
	public void clicaBotaoSeeOffer() throws Throwable {
		buscarElementoPorXPath(xPaths.botaoSEEOFFER).click();

	}

	@Then("valido as especificações retornada do produto")
	public void validaEspecificacaoDoProduto() throws Throwable {

		// Retorna as especificações do produto
		String textoProductSpecifications = driver.findElement(By.xpath("//html/body/div[3]/section/article[2]/h2"))
				.getText();
		String validaNomeDoProduto = driver.findElement(By.xpath("//*[@id=\"Description\"]/h1")).getText();

		String validaCUSTOMIZATION = driver
				.findElement(By.xpath("/html/body/div[3]/section/article[2]/div[1]/label[2]")).getText();

		String validaDISPLAY = driver.findElement(By.xpath("/html/body/div[3]/section/article[2]/div[2]/label[2]"))
				.getText();

		String validaDISPLAYRESOLUTION = driver
				.findElement(By.xpath("/html/body/div[3]/section/article[2]/div[3]/label[2]")).getText();

		String validaDISPLAYSIZE = driver.findElement(By.xpath("/html/body/div[3]/section/article[2]/div[4]/label[2]"))
				.getText();

		String validaMEMORY = driver.findElement(By.xpath("/html/body/div[3]/section/article[2]/div[5]/label[2]"))
				.getText();

		String validaOPERATINGSYSTEM = driver
				.findElement(By.xpath("/html/body/div[3]/section/article[2]/div[6]/label[2]")).getText();

		String validaPROCESSOR = driver.findElement(By.xpath("/html/body/div[3]/section/article[2]/div[7]/label[2]"))
				.getText();

		String validaTOUCHSCREEN = driver.findElement(By.xpath("/html/body/div[3]/section/article[2]/div[8]/label[2]"))
				.getText();

		String validaWEIGHT = driver.findElement(By.xpath("/html/body/div[3]/section/article[2]/div[9]/label[2]"))
				.getText();
		System.out.println(textoProductSpecifications);
		Assert.assertEquals("PRODUCT SPECIFICATIONS", textoProductSpecifications);

		Connection conexao = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco_teste_automacao", "root", "root");
			ResultSet rsMassas = conexao.createStatement().executeQuery(
					"SELECT NAME_PRODUCT,customization,DISPLAY,DISPLAY_RESOLUTION,DISPLAY_SIZE, MEMORY, OPERATING_SYSTEM,PROCESSOR,TOUCHSCREEN,WEIGHT from massas");

			while (rsMassas.next()) {

				if (((validaNomeDoProduto == "HP PAVILION 15Z TOUCH LAPTOP") && (validaCUSTOMIZATION == "Gaming")
						&& (validaCUSTOMIZATION == "DISPLAY") && (validaDISPLAYRESOLUTION == "DISPLAY_RESOLUTION")
						&& (validaDISPLAYSIZE == "DISPLAY_SIZE") && (validaMEMORY == "MEMORY")
						&& (validaOPERATINGSYSTEM == "OPERATING_SYSTEM") && (validaPROCESSOR == "PROCESSOR")
						&& (validaTOUCHSCREEN == "TOUCHSCREEN") && (validaWEIGHT == "WEIGHT"))) {
					break;
				}
				System.out.println("Nome do PRODUTO é: " + rsMassas.getString("NAME_PRODUCT"));
				System.out.println("CUSTOMIZATION: " + rsMassas.getString("customization"));
				System.out.println("DISPLAY: " + rsMassas.getString("DISPLAY"));
				System.out.println("DISPLAY_RESOLUTION: " + rsMassas.getString("DISPLAY_RESOLUTION"));
				System.out.println("DISPLAY_SIZE: " + rsMassas.getString("DISPLAY_SIZE"));
				System.out.println("MEMORY: " + rsMassas.getString("MEMORY"));
				System.out.println("OPERATING_SYSTEM: " + rsMassas.getString("OPERATING_SYSTEM"));
				System.out.println("PROCESSOR: " + rsMassas.getString("PROCESSOR"));
				System.out.println("TOUCHSCREEN: " + rsMassas.getString("TOUCHSCREEN"));
				System.out.println("WEIGHT: " + rsMassas.getString("WEIGHT"));
			}

		} catch (ClassNotFoundException ex) {
			System.out.println("Driver do banco de dados não localizado");
		} catch (SQLException ex) {
			System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
		} finally {
			if (conexao != null) {
				conexao.close();
			}
		}

	}

}
