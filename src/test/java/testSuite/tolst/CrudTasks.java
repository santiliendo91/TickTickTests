package testSuite.tolst;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



import java.util.Date;

import static java.lang.Thread.sleep;

public class CrudTasks extends TestBase {

    @Test
    public void VerifyCrudToListTasks() throws InterruptedException {
        String projectCreated="MOJIX"+new Date().getTime();
        String projectUpdated="QA"+new Date().getTime();
        String TaskAdd="Test"+new Date().getTime();
        String TaskEdit="Test"+new Date().getTime();


        //login
        mainPage.loginLabel.click();
        loginSection.emailTxtBox.setText(user);
        loginSection.passwordTxtBox.setText(password);
        loginSection.loginButton.click();
        //add project
        projectSection.addNewProjectButton.click();
        projectSection.nameProjectTxtBox.cleanSetText(projectCreated);
        projectSection.addButton.click();
        Assertions.assertTrue(projectSection.isProjectDisplayedInList(projectCreated),"ERROR! the project was not created!!");
        //addTask

        taskSection.addTaskButton.click();
        taskSection.taskName.setText(TaskAdd);
        taskSection.taskDesc.setText(projectUpdated);
        taskSection.sendAddTaskBtn.click();
        Assertions.assertTrue(taskSection.isTaskDisplayedOnList(TaskAdd),"Error, task was not created!!!");
        //Edit Task
        taskSection.clickTasktoEdit.click();
        taskSection.clickTaskNametoEdit.click();
        taskSection.EditTaskName.selectText(" ");
        taskSection.EditTaskName.setText(TaskEdit);
        taskSection.SendEditTaskBtn.click();
        taskSection.closeModal.click();
        Assertions.assertTrue(taskSection.isTaskDisplayedOnList(TaskEdit),"Error, task was not created!!!");

        //Delete Task
        taskSection.clickTasktoEdit.click();
        taskSection.moreTaskOptions.click();
        taskSection.deleteTaskButton.click();
        taskSection.confirmTaskDeleteButton.click();
        taskSection.getTask(TaskEdit).waitControlIsNotInThePage();
        Assertions.assertFalse(taskSection.isTaskDisplayedOnList(TaskEdit),"Error, task was not deleted!!!");



    }


}
