package ru.rstqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.rstqa.pft.addressbook.model.ContactData;

import static org.testng.Assert.fail;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {

    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Alex", "John", "Dr", "Germany", "gmail@gmail.com"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    app.logout();
  }


}

