package ru.rstqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.rstqa.pft.addressbook.model.GroupData;
import ru.rstqa.pft.addressbook.model.Groups;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {
  private Properties properties;


  @BeforeMethod
  public void ensurePrecond() throws IOException {
    properties = new Properties();
    String target  =  System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName(properties.getProperty("web.groupName")));
    }
  }

  @Test
  public void testGroupModification() {
    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName(properties.getProperty("web.groupName"))
            .withHeader(properties.getProperty("web.groupHeader"))
            .withFooter(properties.getProperty("web.groupFooter"));
    app.group().modify(group);
    assertThat(app.group().count(), equalTo(before.size() ));
    Groups after = app.group().all();

    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));


  }


}
