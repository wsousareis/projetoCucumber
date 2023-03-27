# language: en
# endcoding: utf-8

Feature: Especificação
Como cliente
Quero valida as especificações do produto

Scenario: Validar Especificações do Produto
	Given que acesso o site de compras advantage shopping
	When clico no menu Special Offer
	And clico no botão See Offer
	Then valido as especificações retornada do produto