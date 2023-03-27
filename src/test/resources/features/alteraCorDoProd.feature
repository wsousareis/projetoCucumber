# language: en
# endcoding: utf-8

Feature: Cor do produto
Como cliente
Quero altera cor do produto

Scenario: Validar Alteração da Cor do Produto
	Given que acesso o site de compras advantage shopping
	When clico no menu Special Offer
	And clico no botão See Offer
	And altero a cor do produto
	And clico no botão Add to cart
	Then valida alteração da cor do produto no carrinho