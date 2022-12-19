package testSuite.tolst;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.todoistprojects.*;
import session.Session;
import util.GetProperties;

public class TestBase {
    MainPage mainPage= new MainPage();
    LoginSection loginSection = new LoginSection();
    ProjectSection projectSection= new ProjectSection();
    TaskSection taskSection= new TaskSection();

    String user= GetProperties.getInstance().getUser();
    String password =GetProperties.getInstance().getPwd();


    @BeforeEach
    public void openBrowser(){
        // todo create property file
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }

    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }
}

