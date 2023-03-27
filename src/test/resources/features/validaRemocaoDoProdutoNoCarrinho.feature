# language: en
# endcoding: utf-8

Feature: Remover produto do carrinho
Como cliente
Quero remove produto do carrinho

Scenario: Remover produto do carrinho de compras
	Given que acesso o site de compras advantage shopping
	When clico no menu Special Offer
	And clico no botão See Offer
	And clico no botão Add to cart
	And clico no carrinho de compras
	And removo o produto do carrinho de compras
	Then valido que o carrinho de compras esta vazio