package StepDefinitions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPage {

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public AuthPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    /**
     * определение локатора поля логина
     */
    @FindBy(xpath = "/html/body/ng-view/main/section/div[1]/form/div[1]/input")
    private WebElement fldLogin;

    /**
     * определение локатора поля пароля
     */
    @FindBy(xpath = "/html/body/ng-view/main/section/div[1]/form/div[2]/cmp-password/div[1]/input")
    private WebElement fldPassword;

    /**
     * определение локатора кнопки авторизации
     */
    @FindBy(xpath = "/html/body/ng-view/main/section/div[1]/form/div[4]/button")
    private WebElement btnLogin;

    /**
     * определение локатора авторизации
     */
    @FindBy(xpath = "/html/body/site-header/header/section[1]/div[2]/div/button")
    private WebElement sLogin;

    /**
     * определение локатора ника
     */
    @FindBy(xpath = "/html/body/site-header/header/section[1]/div[2]/div/a")
    private WebElement lLogin;

    /**
     * определение локатора ошибки
     */
    @FindBy(xpath = "/html/body/ng-view/main/section/div[1]/feedback-message/div/div[2]")
    private WebElement lError;

    /**
     * метод для ввода логина
     */
    public void inputLogin(String login) {
        fldLogin.sendKeys(login); }

    /**
     * метод для ввода пароля
     */
    public void inputPassword(String password) {
        fldPassword.sendKeys(password); }

    /**
     * метод для нажатия кнопки авторизации
     */
    public void clickLogin() {
        btnLogin.click(); }

    /**
     * метод для определения удачной авторизации
     */
    public void sLogin() {
        Boolean isLogin = lLogin.getText().contains(ConfProperties.getProperty("s_login"));
        Assert.assertEquals(true, isLogin);
    }

    /**
     * метод для определения не удачной авторизации
     */
    public void fLogin() {
        Boolean isLogin = lError.isEnabled();
        Assert.assertEquals(true, isLogin);
    }

}
