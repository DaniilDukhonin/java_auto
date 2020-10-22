package ru.rstqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.rstqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test99", "test99", "test99"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();


  }
}
