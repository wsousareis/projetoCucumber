package br.produto.com.steps;

import org.junit.Assert;
import org.openqa.selenium.By;

import br.produto.com.AbstractPages;
import br.produto.com.xPaths;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class validaRemocaoDoProdutoNoCarrinho extends AbstractPages {

	@When("clico no carrinho de compras")
	public void clicaNoCarrinhoDeCompras() throws Throwable {
		buscarElementoPorXPath(xPaths.clicaCarrinho).click();
		buscarElementoPorXPath(xPaths.botaoRemoverProdutoDoCarrinho).click();
	}

	@When("removo o produto do carrinho de compras")
	public void removeProdutoDoCarrinhoDeCompras() throws Throwable {

	}

	@Then("valido que o carrinho de compras esta vazio")
	public void validaQueCarrinhoEstaVazio() throws Throwable {

		String validaCarrinhoVazio = driver.findElement(By.xpath("//*[@id=\"shoppingCart\"]/div/label")).getText();

		Assert.assertEquals("Your shopping cart is empty", validaCarrinhoVazio);
		System.out.println(validaCarrinhoVazio);
	}

}
