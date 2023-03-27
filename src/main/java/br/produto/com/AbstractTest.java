package br.produto.com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")
public abstract class AbstractTest {
	protected static WebDriver driver;
	// URI DEFINIDA PELO USU�RIO
	static String URI = "";

	private static final Integer RETRY_COUNT = 3;

	protected static final Boolean MAXIMIZE = Boolean.TRUE;
	private static final Integer WAIT_PADRAO = 0;
	private static final Integer WAIT_CHECAGEM = 0;
	private static final Integer WAIT_VALIDACAO = 0;
	public static final Integer RETRY_MILLISECONDS = 300;

	@Rule
	public TestName name = new TestName();

	public void clear(xPaths xpath) {
		WebElement webElement = buscarElementoPorXPath(xpath);
		webElement.clear();
	}

	private static void aguarda() {
		try {
			Thread.sleep(RETRY_MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static boolean checaInputNumeroIgual(WebElement element, String texto) {
		return checaNumeroIgual(element.getAttribute("value"), texto);
	}

	public static boolean checaCampoNumeroIgual(WebElement element, String texto) {
		return checaNumeroIgual(element.getText(), texto);
	}

	private static boolean checaNumeroIgual(String valor, String texto) {
		if (valor.replaceAll("\\D", "").equals(texto.replaceAll("\\D", "")) || valor.equals(texto))
			return valor.replaceAll("\\D", "").equals(texto.replaceAll("\\D", "")) || valor.equals(texto);
		int tamanho;
		if (valor.length() > texto.length() && texto.length() > 0) {
			tamanho = valor.length();
			texto = String.format("%0" + tamanho + "d", new Integer(texto));
		}
		if (texto.length() > valor.length() && valor.length() > 0) {
			tamanho = texto.length();
			valor = String.format("%0" + tamanho + "d", valor);
		}
		return valor.equals(texto);
	}

	public static void esperaLoadingSpinner() {
		try {
			WebElement loading = driver.findElement(By.xpath(xPaths.loadingSpinner.getXpathValue()));
			if (loading != null) {
				System.out.println("encontrou loading....");
				int count = 0;
				while (loading != null && count < 140) {
					aguarda();
					loading = driver.findElement(By.xpath(xPaths.loadingSpinner.getXpathValue()));
					count++;
				}
			}
		} catch (Exception e) {
		}
	}

	public void confirm() {
		driver.switchTo().alert().accept();
	}

	private static void reduzirImpliticWait() {
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}

	private static void isLancaSkippedTest() {
		System.out.print("Teste");
	}

	public static WebDriver getDriver() {
		return driver;
	}

	/**
	 * Efetua busca por elemento aguardando ele surgir antes
	 */
	public static WebElement devolveElementoPorBy(By locator, String titulo, String corpo) {
		isLancaSkippedTest();
		WebDriverWait wait = new WebDriverWait(driver, WAIT_PADRAO);
		try {
			esperaLoadingSpinner();
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			element = wait.until(ExpectedConditions.elementToBeClickable(element));
			return element;
		} catch (Exception e) {
			System.out.print("falhou na localiza��o da presen�a do elemento ");
		}
		return null;
	}

	/**
	 * Efetua busca por elemento aguardando ele surgir antes
	 */
	public static WebElement devolveElementoPorByNaoClicavel(By locator, String titulo, String corpo) {
		isLancaSkippedTest();
		if (titulo != "")
			System.out.print("busca elemento ");
		WebDriverWait wait = new WebDriverWait(driver, WAIT_PADRAO);
		try {
			esperaLoadingSpinner();
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return element;
		} catch (Exception e) {
			System.out.print("falhou na localiza��o da presen�a do elemento: ");
		}
		return null;
	}

	/**
	 * Efetua busca por elemento aguardando ele surgir antes
	 */
	public static WebElement checaElementoPorBy(By locator, String titulo, String corpo) {
		isLancaSkippedTest();
		if (titulo != "")
			System.out.print("checa elemento ");
		WebDriverWait wait = new WebDriverWait(driver, WAIT_CHECAGEM);
		try {
			esperaLoadingSpinner();
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return element;
		} catch (Exception e) {
			System.out.print("falhou na localiza��o da presen�a do elemento: ");
		}
		return null;
	}

	/**
	 * Efetua busca por elemento aguardando ele surgir antes
	 */
	public static WebElement validaElementoPorBy(By locator) {
		isLancaSkippedTest();
		WebDriverWait wait = new WebDriverWait(driver, WAIT_VALIDACAO);
		try {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return element;
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * Efetua busca por elemento aguardando ele surgir antes
	 */
	public static String validaTextElementoPorBy(By locator) {
		isLancaSkippedTest();
		WebDriverWait wait = new WebDriverWait(driver, WAIT_VALIDACAO);
		try {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return element.getText();
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * Efetua busca por elemento aguardando ele surgir antes
	 */
	public static WebElement checaElementoPorXPath(xPaths xPath) {
		return checaElementoPorBy(By.xpath(xPath.getXpathValue()), xPath.name(), xPath.getXpathValue());
	}

	/**
	 * Efetua busca por elemento aguardando ele surgir antes
	 */
	public static WebElement buscarElementoPorXPath(xPaths xPath) {
		return devolveElementoPorByNaoClicavel(By.xpath(xPath.getXpathValue()), xPath.name(), xPath.getXpathValue());
	}

	/**
	 * Efetua busca por elemento aguardando ele surgir antes
	 */
	public static WebElement buscarElementoPorNome(String nome) {
		return devolveElementoPorByNaoClicavel(By.name(nome), nome, "");
	}

	/**
	 * Efetua busca por elemento aguardando ele surgir antes
	 */
	public static WebElement buscarElementoPorXpath(String campolocalidade) {
		return devolveElementoPorByNaoClicavel(By.xpath(campolocalidade), "", "");
	}

	public static boolean validaElementoPorXPath(xPaths xPath) {
		if (checaElementoPorXPath(xPath) != null)
			return true;
		return false;
	}

	/**
	 * Efetua busca por elemento aguardando ele surgir antes
	 */
	public static List<WebElement> buscarListaElementos(By locator, String titulo, String mensagem) {
		isLancaSkippedTest();
		System.out.print("busca lista de elementos por xPath");
		WebDriverWait wait = new WebDriverWait(driver, WAIT_CHECAGEM);
		try {
			esperaLoadingSpinner();
			List<WebElement> listOfElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			return listOfElements;
		} catch (Exception e) {
			System.out.print("falhou na localiza��o da lista");
		}
		return null;
	}

	/**
	 * Efetua busca por elemento aguardando ele surgir antes
	 */
	public static List<WebElement> buscarListaElementosPorXPath(String xPath) {
		return buscarListaElementos(By.xpath(xPath), xPath, "");
	}

	/**
	 * Efetua busca por elemento aguardando ele surgir antes
	 */
	public static List<WebElement> buscarListaElementosPorXPath(xPaths xPath) {
		return buscarListaElementos(By.xpath(xPath.getXpathValue()), xPath.name(), xPath.getXpathValue());
	}

	/**
	 * Clica em elemento, porem antes espera ele aparecer e ser clicavel
	 * 
	 * @param element
	 */
	public static String clicaEmElemento(WebElement element, String titulo, String corpo) {
		isLancaSkippedTest();
		if (element != null) {
			esperaLoadingSpinner();
			System.out.print("clica no elemento");

			element.click();
			if (!isDialogPresent()) {
				String mensagemSistema = null;
				if (driver.getWindowHandles().size() == 1)
					mensagemSistema = validaTextElementoPorBy(By.xpath(xPaths.popUpMensagemSistema.getXpathValue()));
				if (mensagemSistema != null && mensagemSistema != "") {
					System.out.print("Sistema apresentou mensagem");
					if (mensagemSistema.equals("SISTEMA EM MANUTEN��O. AGUARDE O T�RMINO DA ATUALIZA��O DOS DADOS"))
						System.out.print("Sistema esta em manuten��o, possivelmente diaria esta rodando...");
					return mensagemSistema;
				}
			}
			return "ok";
		} else {
			System.out.print("falhou em clicar no elemento");
			return "falhou";
		}
	}

	/**
	 * Clica em elemento, porem antes espera ele aparecer e ser clicavel
	 * 
	 * @param xPath
	 */
	public static String clicaEmElemento(By locator, String titulo, String corpo) {
		WebElement element = devolveElementoPorBy(locator, titulo, corpo);
		return clicaEmElemento(element, titulo, corpo);
	}

	/**
	 * Clica em elemento, porem antes espera ele aparecer e ser clicavel
	 * 
	 * @param xPath
	 */
	public static String clicaEmElemento(String xPath) {
		return clicaEmElemento(By.xpath(xPath), xPath, "");
	}

	/**
	 * Clica em elemento, porem antes espera ele aparecer e ser clicavel
	 * 
	 * @param xPath
	 */
	public static String clicaEmElemento(xPaths xPath) {
		return clicaEmElemento(By.xpath(xPath.getXpathValue()), xPath.name(), xPath.getXpathValue());
	}

	/**
	 * Clica em elemento, porem antes espera ele aparecer e ser clicavel
	 * 
	 * @param element
	 */
	public static String clicaEmElemento(WebElement element) {
		return clicaEmElemento(element, element.getTagName(), element.getText());
	}

	/**
	 * Clica em elemento, porem antes espera ele aparecer e ser clicavel
	 */
	public static boolean escreveEmElemento(By locator, String texto, String titulo, String corpo) {
		WebElement element = devolveElementoPorBy(locator, titulo, corpo);
		if (element != null) {
			esperaLoadingSpinner();
			System.out.print("escrever no elemento ");
		}
		
		if (texto.equals("") && !element.getAttribute("value").equals("")) {
			String valor = element.getAttribute("value");
			for (int i = 0; i < valor.length(); i++)
				element.sendKeys(Keys.BACK_SPACE);
		} else {
			if (element.getAttribute("value").length() > 0) {
				element.clear();
				element.sendKeys("");
			}
			element.sendKeys(texto);
		}
		int count = 0;
		while (!checaInputNumeroIgual(element, texto) && count < RETRY_COUNT) {
			element.click();
			try {
				Thread.sleep(RETRY_MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			element.sendKeys(texto);
			count++;
		}
		if (!checaInputNumeroIgual(element, texto)) {
			System.out.print("N�o foi poss�vel escrever no campo. ");

			return false;
		}
		return false;
	}

	/**
	 * Escreve em elemento, porem antes espera ele aparecer e ser clicavel
	 */
	public static boolean escreveEmElemento(xPaths xPath, String texto) {
		return escreveEmElemento(By.xpath(xPath.getXpathValue()), texto, xPath.name(), xPath.getXpathValue());
	}

	public String lerValorElemento(xPaths xPath) {
		String resultado = null;
		try {
			resultado = buscarElementoPorXPath(xPath).getText();
			System.out.print("Valor da tela lido. ");
		} catch (Exception e) {
		}
		if (resultado != null)
			return resultado;
		return "";
	}

	public String lerValorElemento(String xPath) {
		String resultado = buscarElementoPorXpath(xPath).getText();
		System.out.print("Valor da tela lido: " + resultado);
		if (resultado != null)
			return resultado;
		return "";
	}

	public boolean cancelPrintPreview() {
	
		long endTime = System.currentTimeMillis() + 5000;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 5);
		while (true) {
			try {
				WebElement cancelButton = (WebElement) jse.executeScript(
						"return document.querySelector('print-preview-app')." + "shadowRoot.querySelector('#sidebar')."
								+ "shadowRoot.querySelector('print-preview-button-strip')."
								+ "shadowRoot.querySelectorAll('cr-button')[1]");
				if (cancelButton instanceof WebElement) {
					cancelButton.click();
					driver.switchTo().window((new ArrayList<String>(driver.getWindowHandles())).get(1));
					return true;
				}
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (System.currentTimeMillis() > endTime) {
					driver.switchTo().window((new ArrayList<String>(driver.getWindowHandles())).get(1));
					return false;
				}
				break;
			}
		}
		return false;
	}

	public static boolean isDialogPresent() {
		Alert alert = ExpectedConditions.alertIsPresent().apply(driver);
		return (alert != null);
	}
}