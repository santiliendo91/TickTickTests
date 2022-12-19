package testSuite.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CrudTickTick extends TestBase{
    @Test
    public void CrudTickTickApp() {
        String taskListName = "TestList"+new Date().getTime();
        String taskListNameUp = "TestListUpdated"+new Date().getTime();
        //navegar a tick tick
        mainPage.loginLabel.click();
        // login
        loginSection.emailTxtBox.setText(user);
        loginSection.passwordTxtBox.setText(password);
        loginSection.loginButton.click();
        //task page
        //addlist
        taskSection.addListButton.click();
        taskSection.inputListName.setText(taskListName);
        taskSection.saveBtn.click();
        Assertions.assertTrue(taskSection.TaskListDisplayedonList(taskListName),"Error");
        //editList
        taskSection.moreBtn.click();
        taskSection.editOption.click();
        taskSection.inputListName.clearText("");
        taskSection.inputListName.setText(taskListNameUp);
        taskSection.saveBtn.click();
        Assertions.assertTrue(taskSection.TaskListDisplayedonList(taskListNameUp),"Error");
        //deleteList
        taskSection.moreBtn.click();
        taskSection.deleteOption.click();
        taskSection.confirmDelete.click();
        Assertions.assertFalse(taskSection.TaskListDisplayedonList(taskListNameUp), "Error");

    }
}
