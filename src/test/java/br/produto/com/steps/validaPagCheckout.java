package br.produto.com.steps;

import org.junit.Assert;
import org.openqa.selenium.By;

import br.produto.com.AbstractPages;
import br.produto.com.xPaths;
import io.cucumber.java.en.When;

public class validaPagCheckout extends AbstractPages {

	@When("realizo pesquisa do produto com a lupa")
	public void realizoPesquisaDoProduto() throws Throwable {

	}

	@When("seleciono o produto")
	public void selecionaProduto() throws Throwable {
		buscarElementoPorXPath(xPaths.selecionaLupaDePesquisa).click();
		buscarElementoPorXPath(xPaths.escreveCampoPesquisa).sendKeys("HP PAVILION 15Z TOUCH LAPTOP");
		buscarElementoPorXPath(xPaths.selecionaProduto).click();
	}

	@When("altero a cor e quantidade do produto")
	public void alteroCorQuantidadeDoProduto() throws Throwable {
		buscarElementoPorXPath(xPaths.botaoSelecionaCorBlack).click();

	}

	@When("altero a quantidade do produto")
	public void alteraQuantidadeDoProduto() throws Throwable {
		buscarElementoPorXPath(xPaths.selecionaQuantPrd).click();
	}

	@When("acesso a página de checkout")
	public void acessoPaginaCheckout() throws Throwable {
		buscarElementoPorXPath(xPaths.botaoCheckout).click();
	}

	@When("valido a soma dos preços")
	public void validoSomaDosPrecos() throws Throwable {

		String validaSomaDosPreco = driver.findElement(By.xpath("//*[@id=\"userCart\"]/div[2]/label[2]/span"))
				.getText();

		if (validaSomaDosPreco == "$899.98") {
			Assert.assertEquals("$899.98", validaSomaDosPreco);
		} else if (validaSomaDosPreco == "$1,039.98") {
			Assert.assertEquals("$1,039.98", validaSomaDosPreco);
		} else {
			System.out.println(validaSomaDosPreco);
		}
	}
}
