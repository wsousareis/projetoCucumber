package br.produto.com;

public enum xPaths {

//TELA xPaths( Inspeciona os elementos da tela)

	// MENU
	menuSpecialOffer("/html/body/header/nav/ul/li[7]/a"),

	// CARRINHO
	clicaCarrinho("//*[@id=\"menuCart\"]"),

	// SELEÇÃO DO PRODUTO (Pesquisa)
	selecionaLupaDePesquisa("//*[@id=\"menuSearch\"]"), escreveCampoPesquisa("//*[@id=\"autoComplete\"]"),
	selecionaProduto("//*[@id=\"output\"]/div/div[2]/a[2]/span"),

	// QUANTIDADE DO PRODUTO
	selecionaQuantPrd("//*[@id=\"productProperties\"]/div[2]/e-sec-plus-minus/div/div[3]"),

	// BOTOES DE NAVEGACAO
	botaoSEEOFFER("//*[(self::button or self::a) and contains(text(), 'SEE OFFER')]"),
	botaoADDTOCART("//*[(self::button or self::a) and contains(text(), 'ADD TO CART')]"),
	botaoSelecionaCorBlack("//body/div[3]/section[1]/article[1]/div[2]/div[2]/div[1]/div[1]/div[2]/span[2]"),
	botaoCheckout("//button[@id='checkOutPopUp']"),
	botaoRemoverProdutoDoCarrinho("//*[(self::button or self::a) and contains(text(), 'REMOVE')]"),

	// TELA FORMULARIO
	divContainerCarregada("/html[1]/body[1]/header[1]"),

	// MENSAGENS DE SISTEMA
	popUpMensagemSistema(""), popUpFechaMensagemSistema(""),

	// CAMPOS DA TELA DE INCLUS�O DE USU�RIO
	campoLocalidade("//*[@id=\"Geral\"]/div/div/span[3]/label/input"), campoNome("//*[@id=\"user_name\"]"),
	campoUltimoNome("//*[@id=\"user_lastname\"]"), campoEmail("//*[@id=\"user_email\"]"),
	campoEndereco("//*[@id=\"user_address\"]"), campoUniversidade("//*[@id=\"user_university\"]"),
	campoProfissao("//*[@id=\"user_profile\"]"), campoGenero("//*[@id=\"user_gender\"]"),
	campoIdade("//*[@id=\"user_age\"]"),

	// BUSCO NO GOOGLE
	campoPesquisa("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"),
	clicaPesquisar("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]"),
	clicaNotebook("//*[@id=\"list-level-1\"]/li[5]/a"),
	clicaSelecaoNotebook(
			"//*[@id=\"content-middle\"]/div[3]/div/div/section/section/div/div/div/div/div/div/div/div[1]/div/section/a/div[2]/h3"),
	escreverCEP("//*[@id=\"root\"]/div/div[3]/div[2]/div[2]/form/div/div[1]/input"),
	botaoFechar("//*[@id=\"lgpd-accept\"]"),
	botaoCalcularFrete("//*[@id=\"root\"]/div/div[3]/div[2]/div[2]/form/div/div[2]/button"),
	botaoComprar("//*[@id=\"buy-button\"]"),

	botaoModalConfirmarComprar("//*[@id=\"root\"]/div[2]/div/div/div/div[2]/a[2]"),

	// RADIO - CHECKBOX
	radio01("/html/body/div[2]/div[2]/div[3]/div[1]/form/p[1]/label"),
	checkbox01("/html/body/div[2]/div[2]/div[3]/div[2]/p[1]/label"),

	// GERAL
	loadingSpinner("//div[contains(@class, 'loading')]"),
	valorMensagemPaginaNaoCarregada("//*[@id='main-message']/h1/span[text()='N�o � poss�vel acessar esse site']"),
	indefinido("indefinido");

	private String xpathValue;

	private xPaths(String xpathValue) {
		this.xpathValue = xpathValue;
	}

	public String getXpathValue() {
		return xpathValue;
	}

}