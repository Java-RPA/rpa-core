package ru.consyst_os;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        // creating an RPA that will view the current temperature from Yandex

        WebDriver driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver", "./chromedriver");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://ya.ru");

        driver.findElement(By.xpath("//*[@id=\"text\"]")).sendKeys("Погода\n");

        String text = driver.findElement(By.xpath("//*[@id=\"search-result\"]/li[1]/div/div[2]/div/a[1]/div[1]")).getText();

        log.info("Температура = " + text);

        //driver.close();
        driver.quit();

    }
}
