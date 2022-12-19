package testSuite.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CrudTickTickLists extends TestBase{
    @Test
    public void VerifyCrudLists() throws InterruptedException {
        String taskListName = "TestList";
        String taskListNameUp = "TestListUpdated";
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
