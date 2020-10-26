package testeDextra.steps;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class cadastroUsuarios {
    @Test
    public void cadastroInformacoesUsuario(){

        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "/Users/vivianlarrea/drivers/chromedriver");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Validar a mensagem de e-mail já cadastrado
        navegador.get("https://www.americanas.com.br/");
        navegador.findElement(By.linkText("ou cadastre-se")).click();
        navegador.findElement(By.linkText("Cliente novo? Cadastrar")).click();
        navegador.findElement(By.name("email")).sendKeys("teste@hotmail.com");
        navegador.findElement(By.name("password")).sendKeys("teste");
        navegador.findElement((By.xpath("//*[@id=\"root\"]/div/div[2]/form/button"))).click();
        assertEquals("E-mail já cadastrado", navegador.findElement(By.xpath("//*[@id=\"email\"]/div")).getText());
        navegador.quit();


        //Validar a mensagem de senha fraca
        navegador.get("https://www.americanas.com.br/");
        navegador.findElement(By.linkText("ou cadastre-se")).click();
        navegador.findElement(By.linkText("Cliente novo? Cadastrar")).click();
        navegador.findElement(By.name("email")).sendKeys("soxic83441@iazhy.com");
        navegador.findElement(By.name("password")).sendKeys("12");
        assertEquals("fraca", navegador.findElement(By.className("passwordWrapper-msg")).getText());
        navegador.quit();

        //Validar a mensagem de cpf inválido
        navegador.get("https://www.americanas.com.br/");
        navegador.findElement(By.linkText("ou cadastre-se")).click();
        navegador.findElement(By.linkText("Cliente novo? Cadastrar")).click();
        navegador.findElement(By.name("email")).sendKeys("soxic83441@iazhy.com");
        navegador.findElement(By.name("password")).sendKeys("teste");
        navegador.findElement(By.name("cpf")).sendKeys(""444"");
        navegador.findElement((By.xpath("//*[@id=\"root\"]/div/div[2]/form/button"))).click();
        assertEquals("CPF inválido.", navegador.findElement(By.className("inputGroup-error")).getText());
        navegador.quit();



    }
}
