package ru.rstqa.pft.addressbook.tests;


import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.rstqa.pft.addressbook.model.GroupData;
import ru.rstqa.pft.addressbook.model.Groups;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
   Groups before = app.group().all();
    app.group().wd.findElement(By.xpath("//form[@action='/addressbook/group.php']")).click();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    Groups after = app.group().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo
            (before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));



  }


}
