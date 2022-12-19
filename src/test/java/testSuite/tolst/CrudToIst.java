package testSuite.tolst;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static java.lang.Thread.*;

public class CrudToIst extends TestBase{

    @Test
    public void VerifyCRUDProject(){
        //CrudProjects
        String projectCreated="Project"+new Date().getTime();
        String projectUpdated="Bootcamp"+new Date().getTime();
        //Login
        mainPage.loginLabel.click();
        loginSection.emailTxtBox.setText(user);
        loginSection.passwordTxtBox.setText(password);
        loginSection.loginButton.click();
        //add project
        projectSection.addNewProjectButton.click();
        projectSection.nameProjectTxtBox.cleanSetText(projectCreated);
        projectSection.addButton.click();
        Assertions.assertTrue(projectSection.isProjectDisplayedInList(projectCreated),"ERROR! the project was not created!!");
        //Edit
        projectSection.moreButton.click();
        projectSection.editButton.click();
        projectSection.nameProjectTxtBox.cleanSetText(projectUpdated);
        projectSection.saveButton.click();
        Assertions.assertTrue(projectSection.isProjectDisplayedInList(projectUpdated),"ERROR! the project was not updated!!");
        //delete
        projectSection.moreButton.click();
        projectSection.deleteButton.click();
        projectSection.confirmDeleteButton.click();
        projectSection.getProject(projectUpdated).waitControlIsNotInThePage();
        Assertions.assertFalse(projectSection.isProjectDisplayedInList(projectUpdated),"ERROR! the project was not deleted!!");

    }
}
