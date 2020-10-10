package ru.rstqa.pft.addressbook;


import org.testng.annotations.*;
import org.openqa.selenium.*;

public class GroupCreationTests extends TestBase{


  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    wd.findElement(By.xpath("//form[@action='/addressbook/group.php']")).click();
    initGroupCreation();
    fillGroupForm(new GroupData("test1", "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();
    wd.findElement(By.linkText("Logout")).click();
  }


}
