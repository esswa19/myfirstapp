import configuration.config;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageFactory_pom.MercuryHomePage;
import pageFactory_pom.MercurySignOnPage;

public class firstTest {

    config configBrowser = new config();
    MercuryHomePage homepage = new MercuryHomePage();
    MercurySignOnPage signonpage = new MercurySignOnPage();

    @BeforeTest
    public void startBrowser(){
        configBrowser.startDriver();
    }

    @AfterTest
    public void stopBrowser(){
        configBrowser.stopDriver();
    }

    public void main(){

        homepage.signon();
        signonpage.login();

    }
}
