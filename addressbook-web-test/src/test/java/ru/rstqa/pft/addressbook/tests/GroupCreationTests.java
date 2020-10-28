package ru.rstqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.rstqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase{


  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount(); //4.3 добоваили счетчик для подсчета групп до и после

    app.getGroupHelper().wd.findElement(By.xpath("//form[@action='/addressbook/group.php']")).click();
    app.getGroupHelper().createGroup(new GroupData(null, "test1", "test1"));
    app.getGroupHelper().wd.findElement(By.linkText("Logout")).click();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before+1); //считает кол-во до и после
  }


}
