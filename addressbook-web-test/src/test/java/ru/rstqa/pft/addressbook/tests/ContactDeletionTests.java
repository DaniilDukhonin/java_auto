package ru.rstqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.rstqa.pft.addressbook.model.ContactData;
import ru.rstqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {
  private Properties properties;


  @BeforeMethod
  public void ensurePrecond() throws IOException {
    properties = new Properties();

    String target  =  System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    app.contact().homePage();
    if (app.contact().all().size() ==0) {
      app.contact().create(new ContactData().withFirstname(properties.getProperty("web.firstname")));

    }
  }

    @Test(enabled = false)
    public void testContactDeletion () {
      Contacts before = app.contact().all();
      ContactData deletedContact = before.iterator().next();
      int index = before.size() - 1;
      app.contact().delete(deletedContact);
      Contacts after = app.contact().all();
      assertEquals(after.size(), before.size() - 1);
      assertThat(after, equalTo(before.without(deletedContact)));


    }


}
