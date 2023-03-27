package br.produto.com;

public class AbstractPages extends AbstractTest {

	// CAMPOS TELA INCLUS�O DE USU�RIO
	public static void escreveCampoNome(String nome) {
		escreveEmElemento(xPaths.campoNome, nome);
	}

	public static void escrevecampoUltimoNome(String ultimonome) {
		escreveEmElemento(xPaths.campoUltimoNome, ultimonome);
	}

	public static void escrevecampoEmail(String email) {
		escreveEmElemento(xPaths.campoEmail, email);
	}

	public static void escrevecampoEndereco(String endereco) {
		escreveEmElemento(xPaths.campoEndereco, endereco);
	}

	public static void escrevecampoUniversidade(String universidade) {
		escreveEmElemento(xPaths.campoUniversidade, universidade);
	}

	public static void escrevecampoProfissao(String profissao) {
		escreveEmElemento(xPaths.campoProfissao, profissao);
	}

	public static void escrevecampoGenero(String genero) {
		escreveEmElemento(xPaths.campoGenero, genero);
	}

	public static void escrevecampoIdade(String idade) {
		escreveEmElemento(xPaths.campoIdade, idade);
	}

	// BUSCA NO GOOGLE
	public static void escrevecampoPesquisa(String pesquisa) {
		escreveEmElemento(xPaths.campoPesquisa, pesquisa);
		
		}
	// BOT�O PESQUISAR
		public static String clicarBotaoPesquisar() {
			return clicaEmElemento(xPaths.clicaPesquisar);
		}	
	
		public static String clicarNotebook() {
			return clicaEmElemento(xPaths.clicaNotebook);
		}	
		
		public static String clicarSelecaoNotebook() {
			return clicaEmElemento(xPaths.clicaSelecaoNotebook);
		}	
		
		
	// MENU/SUBMENU
	public static String clicarMenuFormulario() {
		return clicaEmElemento(xPaths.menuSpecialOffer);
	}

	// RadioButton

	public static void clicarRadio01() {
		clicaEmElemento(xPaths.radio01);
	}

	public String lerMensagemSistema() throws Exception {
		try {
			return lerValorElemento(xPaths.popUpMensagemSistema);
		} catch (Exception e) {
			throw new Exception("Erro em captura de mensagem em pop-up do sistema", e);
		}
	}

	public String lerValorElemento(xPaths popupmensagemsistema) {
		// TODO Auto-generated method stub
		return null;
	}

}