package ru.rstqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.rstqa.pft.addressbook.model.ContactData;
import ru.rstqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTests extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() throws Exception {
    app.contact().homePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("test2").withLastname("John");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));



  }


}

