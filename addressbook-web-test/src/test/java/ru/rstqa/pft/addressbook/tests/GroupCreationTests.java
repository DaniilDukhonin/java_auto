package ru.rstqa.pft.addressbook.tests;


import com.thoughtworks.xstream.XStream;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.rstqa.pft.addressbook.model.GroupData;
import ru.rstqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GroupCreationTests extends TestBase {
  private Properties properties;



  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;

        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(GroupData.class);
      List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
      return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }


  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) throws Exception {
    properties = new Properties();
    String target  =  System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));


    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().wd.findElement(By.xpath("//form[@action='/addressbook/group.php']")).click();
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo
            (before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadGroupCreation() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().wd.findElement(By.xpath("//form[@action='/addressbook/group.php']")).click();
    GroupData group = new GroupData().withName(properties.getProperty("web.groupBadName"));
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));


  }


}
