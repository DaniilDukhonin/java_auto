package ru.rstqa.pft.addressbook.tests;


import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.rstqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase{


  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().wd.findElement(By.xpath("//form[@action='/addressbook/group.php']")).click();
    app.getGroupHelper().createGroup(new GroupData(null, "test1", "test1"));

    app.getGroupHelper().wd.findElement(By.linkText("Logout")).click();
  }


}
