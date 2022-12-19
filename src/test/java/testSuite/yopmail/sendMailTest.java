package testSuite.yopmail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.sql.SQLOutput;
import java.util.Date;

public class sendMailTest extends TestBase{

    @Test
    public void VerifySendMail() throws InterruptedException {
        String mail = "santi.liendo234";
        String mail2 = "santi.liendo234@yopmail.com";
        String subject = "random"+new Date().getTime();
        String descr = "Desc"+new Date().getTime();
        //login
        mainPage.inputMailField.setText(mail);
        mainPage.sendButton.click();
        //editar mail
        sendMailSection.newMailBtn.click();
        Session.getInstance().getBrowser().switchTo().frame("ifmail");
        sendEditEmailSection.Contactmail.setText(mail);
        sendEditEmailSection.mailSubject.setText(subject);
        sendEditEmailSection.mailBody.setText(descr);
        sendEditEmailSection.sendMailBtn.click();
        Session.getInstance().getBrowser().switchTo().defaultContent();
        sendMailSection.refreshBtn.click();
        Session.getInstance().getBrowser().switchTo().frame("ifinbox");
        Assertions.assertTrue(sendMailSection.isMailDisplayedInList(mail2),"Error, mail is not listed");


    }


}
