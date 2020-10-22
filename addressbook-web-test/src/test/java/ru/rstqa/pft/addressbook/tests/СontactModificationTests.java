package ru.rstqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.rstqa.pft.addressbook.model.ContactData;

public class СontactModificationTests extends TestBase{


  @Test
  public void testContactModification () {

    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Alex1", "John1", "Dr1", "Germany1", "gmail@gmail.com", null), false);

    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();




  }
}
