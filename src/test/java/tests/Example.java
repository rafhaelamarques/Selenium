package tests;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.regex.Pattern;

public class Example {

//    admin
//    rafhaela.marques
//    nyna
//    joaor
//    lucimara.marques
//    otoniel.lacerda
//    randel.ricardo
//    raniel.adan
//    luciana.gade
//    taiseane.caetano

    WebDriver driver = new ChromeDriver();

    public void login(String usuario, String senha) throws InterruptedException {
        //input usuário
        WebElement user = driver.findElement(By.id("userInput"));
        //input senha
        WebElement password = driver.findElement(By.id("pwdInput"));
        //assert de verificação de acesso ao site
        Assert.assertTrue(driver.findElement(By.id("loginForm")).isDisplayed());

        //envio do primeiro dado do input usuário
        user.click();
        user.sendKeys("rafhaela@primeresults.com.br");
        //asserts de validação de entrada de dados
        Assert.assertTrue(user.getText().contains("@primeresults.com.br"));
        Assert.assertTrue(user.getText().endsWith("@primeresults.com.br"));
        Assert.assertTrue(Pattern.matches("/^[a-z0-9.]+@[a-z0-9]+\\.[a-z]+\\.([a-z]+)?$/i\n", user.getText()));

        //encontrando elemento por id
        driver.findElement(By.id("loginInput"));
        //encontrando elemento por xpath
        driver.findElement(By.xpath("//*[@id=\"loginInput\"]"));
        //encontrando elemento por css selector
        driver.findElement(By.cssSelector("input[id='loginInput']"));


        //encontrando elemento por id
        driver.findElement(By.id("mailInput"));

        //encontrando elemento pelo nome
        driver.findElement(By.name("mail"));

        //encontrando elemento pelo xpath
        driver.findElement(By.xpath("//form[@id='mailInput']/input[1]"));

        //encontrando elemento por css selector
        driver.findElement(By.cssSelector("input[name='mail']"));
        driver.findElement(By.cssSelector("input#mailInput"));
        driver.findElement(By.cssSelector("div#loginForm > input[class='primaryInput']"));

        //trabalhando com alerts
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().accept();
        driver.switchTo().alert().getText();

        //manipulando a aba do browser
        driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.manage().window().fullscreen();


        //campo email
        WebElement mail = driver.findElement(By.id("mailInput"));
        //preenche o email
        mail.sendKeys("rafhaela@primeresults.com.br");
        //verifica se o texto inserido atende a regra de email
        Assert.assertTrue(mail.getText().endsWith("@primeresults.com.br"));


        //campo senha
        WebElement pwd = driver.findElement(By.id("pwdInput"));
        //preenche a senha
        pwd.sendKeys("1");
        //valida se o objeto passado não é nulo
        try {
            Assert.assertNull("Senha obrigatória", pwd.getText());
        } catch (AssertionError e) {
            System.out.println("Primeiro acesso");
        } finally {
            Assert.assertNotNull(pwd.getText());
        }


        //botão login
        WebElement btnLogin = driver.findElement(By.id("btnLogin"));
        btnLogin.click();
        //alert após tentantiva de login
        Alert alert = driver.switchTo().alert();
        //verifica a mensagem do alert
        Assert.assertEquals("Bem vindo(a)!", alert.getText());
        Thread.sleep(3000);
        //fecha o alert
        alert.accept();

    }

    public void tryCatch() {
        WebElement login = driver.findElement(By.id("userInput"));
        WebElement passwd = driver.findElement(By.id("pwdInput"));
        WebElement btnLogin = driver.findElement(By.id("btnLogin"));
        WebElement msgError = driver.findElement(By.id("mensagemErro"));

        login.sendKeys("rafhaela.marques");
        passwd.sendKeys("1");
        btnLogin.click();

        try {
            Assert.assertTrue(msgError.isDisplayed());
        } catch (AssertionError e) {
            if (e.toString().toLowerCase().contains("primeiro acesso")) {
                System.out.println("Primeiro acesso");
                //do something
            } else if (e.toString().toLowerCase().contains("redefinir senha")) {
                driver.findElement(By.id("oldpwd")).sendKeys("1");
                driver.findElement(By.id("newpwd")).sendKeys("1");
            } else {
                Alert popup = driver.switchTo().alert();
                popup.accept();
            }
            throw (e);
        } finally {
            btnLogin.click();
        }
    }
}
