package StepDefinitions;
import cucumber.api.PendingException;
import cucumber.api.java.ru.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    public static WebDriver driver;
    public static AuthPage authPage;


    @Дано("^Пользователь зашел на страницу авторизации$")
    public void пользователь_зашел_на_страницу_авторизации() throws Throwable {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.navigate().to(ConfProperties.getProperty("loginpage"));
        //throw new PendingException();
    }

    @Когда("^Пользователь ввел правильный логин и пароль$")
    public void пользователь_ввел_правильный_логин_и_пароль() throws Throwable {
        authPage = new AuthPage(driver);
        // вводим логин
        authPage.inputLogin(ConfProperties.getProperty("s_login"));
        // вводим пароль
        authPage.inputPassword(ConfProperties.getProperty("s_password"));
        //throw new PendingException();
    }

    @Когда("^Пользователь нажал кнопку Ввойти$")
    public void пользователь_нажал_кнопку_Ввойти() throws Throwable {
        //нажимаеи на кнопку авторизации
        authPage.clickLogin();
        //throw new PendingException();
    }

    @Тогда("^Пользователь должен пройти авторизацию$")
    public void пользователь_должен_пройти_авторизацию() throws Throwable {
        authPage.sLogin();
        //throw new PendingException();
    }

    @Когда("^Пользователь ввел не правильный логин и пароль$")
    public void пользователь_ввел_не_правильный_логин_и_пароль() throws Throwable {
        authPage = new AuthPage(driver);
        // вводим логин
        authPage.inputLogin(ConfProperties.getProperty("w_login"));
        // вводим пароль
        authPage.inputPassword(ConfProperties.getProperty("w_password"));
        //throw new PendingException();
    }

    @Тогда("^Пользователь не должен пройти авторизацию$")
    public void пользователь_не_должен_пройти_авторизацию() throws Throwable {
        authPage.fLogin();
        //throw new PendingException();
    }

}
