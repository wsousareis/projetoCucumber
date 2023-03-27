package br.produto.com.steps;

import org.junit.Assert;
import org.openqa.selenium.By;

import br.produto.com.AbstractPages;
import br.produto.com.xPaths;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class alteraCorDoProd extends AbstractPages {

	@When("altero a cor do produto")
	public void alteroCorDoProduto() throws Throwable {
		buscarElementoPorXPath(xPaths.botaoSelecionaCorBlack).click();
	}

	@When("clico no botão Add to cart")
	public void clicaBotaoAddToCart() throws Throwable {
		buscarElementoPorXPath(xPaths.botaoADDTOCART).click();
	}

	@Then("valida alteração da cor do produto no carrinho")
	public void validaAlteracaoDaCorDoProdutoNoCarrinho() throws Throwable {
		buscarElementoPorXPath(xPaths.botaoCheckout).click();

		String validaCorNoCarrinho = driver.findElement(By.xpath("//*[@id=\"product\"]/td[2]/a/label[2]/span"))
				.getText();
		System.out.println(validaCorNoCarrinho);
		Assert.assertEquals("BLACK", validaCorNoCarrinho);
	}
}
