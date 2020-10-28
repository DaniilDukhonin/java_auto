package ru.rstqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.rstqa.pft.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {

    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount(); //4.3 добоваили счетчик для подсчета групп до и после


    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData(null, "test1", "test1"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();

    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before - 1); //считает кол-во до и после, стало мньше чем было
  }


}

