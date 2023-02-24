package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runners.Runner;

import java.time.Duration;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils extends Runner {

    public void aguardarElemento(By element, Duration tempo) {
        WebDriverWait wait = new WebDriverWait(driver, tempo);
        wait.until(ExpectedConditions.elementToBeClickable((element)));
    }

    public void aguardarAcao(Duration tempo) {
        WebDriverWait wait = new WebDriverWait(driver, tempo);
    }

    public String getRandomEmail() {
        String mail_init = "fulano_";
        String mail_final = "@gmail.com.br";

        Random random = new Random();
        int min = 1;
        int max = 9999999;
        int result = random.nextInt(max - min + 1) + min;

        return mail_init + result + mail_final;
    }

    public String getRandomPasswd(int len) {
        Random random = new Random();
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        return IntStream.range(0, len)
                .map(i -> random.nextInt(chars.length()))
                .mapToObj(randomIndex -> String.valueOf(chars.charAt(randomIndex)))
                .collect(Collectors.joining());
    }

    public int getRandomNumber() {
        Random random = new Random();
        int min = 1;
        int max = 999999999;
        return random.nextInt(max - min + 1) + min;
    }

    public double getRandomLargeNumber(){
        Random random = new Random();
        return random.nextLong();
    }
}
