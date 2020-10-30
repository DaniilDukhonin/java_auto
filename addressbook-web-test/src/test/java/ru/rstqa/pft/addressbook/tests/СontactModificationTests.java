package ru.rstqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.rstqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class СontactModificationTests extends TestBase{


  @Test
  public void testContactModification () {
    app.getContactHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Alex", "John", "Dr", "Germany", "gmail@gmail.com", "test1"));

    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().initContactModification();

    ContactData contact = new  ContactData(before.get(before.size()-1).getId(),"Alex1", "John1", "Dr1", "Germany1", "gmail@gmail.com", null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().goToHomePage();


    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(before.size()-1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);







  }
}
