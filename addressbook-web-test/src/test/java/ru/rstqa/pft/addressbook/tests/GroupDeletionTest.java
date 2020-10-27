package ru.rstqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.rstqa.pft.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase {

    @Test
    public void testGroupDeletion() throws Exception {

      app.getNavigationHelper().gotoGroupPage();
      if (!app.getGroupHelper().isThereAGroup()) {
        app.getGroupHelper().createGroup(new GroupData(null, "test1", "test1"));
      }
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().deleteSelectedGroup();
      app.getGroupHelper().returnToGroupPage();
    }


}

