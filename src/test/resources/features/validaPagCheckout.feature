# language: en
# endcoding: utf-8

Feature: Checkout
Como cliente
Quero valida página de checkout

Scenario: Validar Página Checkout do Produto
	Given que acesso o site de compras advantage shopping
	When realizo pesquisa do produto com a lupa
	And seleciono o produto
	And altero a cor do produto
	And altero a quantidade do produto
	And clico no botão Add to cart
	And acesso a página de checkout
	And valido a soma dos preços