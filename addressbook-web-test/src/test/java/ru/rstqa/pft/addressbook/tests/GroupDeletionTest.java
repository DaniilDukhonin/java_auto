package ru.rstqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.rstqa.pft.addressbook.model.GroupData;
import java.util.List;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {

    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData(null, "test1", "test1"));
    }

    List<GroupData> before = app.getGroupHelper().getGroupList();
    //int before = app.getGroupHelper().getGroupCount(); //4.3 добоваили счетчик для подсчета групп до и после
    app.getGroupHelper().selectGroup(before.size()-1); // в скобах индекс 0 - хотим удалить превый элемент, before-1 -последний
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();

    List<GroupData> after = app.getGroupHelper().getGroupList();
    //int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after.size(), before.size() - 1); //считает кол-во до и после, стало мньше чем было
    before.remove(before.size() - 1);
      Assert.assertEquals(before, after);
    }
  }




