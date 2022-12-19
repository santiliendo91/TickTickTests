package testSuite.yopmail;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.yopmail.*;
import session.Session;
import util.GetProperties;

public class TestBase {
   SendMailInboxSection sendMailSection = new SendMailInboxSection();

   MainPage mainPage = new MainPage();

   EditEmailSection sendEditEmailSection = new EditEmailSection();

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
