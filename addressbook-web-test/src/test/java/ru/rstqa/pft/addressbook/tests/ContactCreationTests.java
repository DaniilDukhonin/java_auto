package ru.rstqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.rstqa.pft.addressbook.model.ContactData;

import static org.testng.Assert.fail;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {

app.getContactHelper().goToHomePage();
app.getContactHelper().createContact(new ContactData ("Alex", "John", "Dr", "Germany", "gmail@gmail.com", "test1"));

  }


}

