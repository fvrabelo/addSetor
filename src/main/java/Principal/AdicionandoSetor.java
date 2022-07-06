package Principal;


import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class AdicionandoSetor {

    public String enderecoGSSHomologLOGIN = "https://hml-gss.aegea.com.br/ords/portal/aegea/r/portal/selecionar-unidade";
    public String enderecoGSSHomolog2 = "https://hml-gss.aegea.com.br";
    public String enderecoGSSProd = "https://gss.aegea.com.br";
    public String enderecoGSS = enderecoGSSHomolog2;
    public String enderecoAcatamento = enderecoGSS+"/ords/prolagos/aegea/r/gss101/cad3010s1?session=";
    public String session;

    public void Gerar() throws InterruptedException {

        System.out.println("=========================================================================");
        System.out.println("========================== INICIANDO ATIVIDADE ==========================");
        System.out.println("============================ GERADOR DE O.S. =============================");
        System.out.println("=========================================================================");
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");


        System.out.println("iniciando janela maximizada");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");


        //url inicial é enderecoGSSHomologLOGIN, nao mexe aqui pq vai entrar na tela inicial p homologar
        System.out.println("passando URL");
        WebDriver browser = new ChromeDriver(options);
        browser.get(enderecoGSSHomologLOGIN);

        JOptionPane.showMessageDialog(null,"Clique ok após realizar login");

        System.out.println("Iniciando Sessão");
        WebDriverWait wait = (new WebDriverWait(browser, 60));
        String currentUrl = browser.getCurrentUrl();
        session = currentUrl.toString().substring(currentUrl.toString().indexOf("session=")+8);

        browser.get(enderecoAcatamento+session);


// ----------------------AQUI COMEÇA NA TELA INICIAL ---- INICIA CLICANDO NA LUPA------------------------------

        System.out.println("Vai pegar ID do botão");
        WebElement lupa = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("R49514668791716612889_column_search_root")));
        System.out.println("Vou clicar na lupa");
        lupa.click();
        System.out.println("Cliquei na lupa");

        //continuar com seletor N
        WebElement lupaSelecao = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("R49514668791716612889_column_search_drop")));
        System.out.println("Vou clicar na opção");
        lupaSelecao.sendKeys("N");
        lupaSelecao.sendKeys(Keys.ENTER);

    }


}
