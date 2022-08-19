package org.example;


import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class seleniumclass {

    public static WebDriver driver;


    @BeforeAll
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pamela\\Desktop\\untitled1\\src\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        System.out.println("Cargando la pagina web");
        driver.get("https://www.consultoriaglobal.com.ar/cgweb/");
        System.out.println(driver.getTitle());

        System.out.println("Redireccionando a la seccion de Contactos");

        WebElement registerLinkLocator = driver.findElement(By.linkText("Contáctenos"));
        registerLinkLocator.click();
    }

    //Login
    @Test

    public void Login() throws InterruptedException {

        //Localizadores
        Thread.sleep(2000);

        WebElement nameLocator = driver.findElement(By.name("your-name"));
        WebElement emailLocator = driver.findElement(By.name("your-email"));
        WebElement subjectLocator = driver.findElement(By.name("your-subject"));
        WebElement messageLocator = driver.findElement(By.name("your-message"));
        WebElement sendbbtn = driver.findElement(By.xpath("//input[@value='Enviar']"));

        System.out.println("Cargando datos para el envio del formulario");
        nameLocator.sendKeys("aaa");
        emailLocator.sendKeys("aaa");
        subjectLocator.sendKeys("test");
        messageLocator.sendKeys("new test");
        Thread.sleep(4000);
        System.out.println("Envio de datos");
        sendbbtn.click();

        WebElement invalidEmail = driver.findElement(By.xpath("//span[@class='wpcf7-not-valid-tip']"));
        String value = invalidEmail.getText();
        assertEquals("La dirección e-mail parece inválida.", value);

        System.out.println("Verificamos que existe un error al validar el email");

    }

    @AfterAll
    public static void close() {
        driver.quit();
    }
}
