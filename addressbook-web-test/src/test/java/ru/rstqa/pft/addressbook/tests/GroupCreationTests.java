package ru.rstqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.rstqa.pft.addressbook.model.GroupData;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    //int before = app.getGroupHelper().getGroupCount(); //4.3 добоваили счетчик для подсчета групп до и после
    app.getGroupHelper().wd.findElement(By.xpath("//form[@action='/addressbook/group.php']")).click();
    GroupData group = new GroupData("test", "test1", "test1");
    app.getGroupHelper().createGroup(group);


    List<GroupData> after = app.getGroupHelper().getGroupList();
    //int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after.size(), before.size() + 1); //считает кол-во до и после

//    int max = 0;
//    for (GroupData g : after) {
//      if (g.getId() > max) {
//        max = g.getId();
//      }
//    }
    //app.getGroupHelper().wd.findElement(By.linkText("Logout")).click();
    //group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }


}
