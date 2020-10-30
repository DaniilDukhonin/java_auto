package ru.rstqa.pft.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.rstqa.pft.addressbook.model.ContactData;
import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Mila", "John", "Dr", "Germany", "gmail@gmail.com", "test1"));

    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().closeDialogWindow();

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after, before.size()-1);
    app.getNavigationHelper().goToHomePage();
    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);



  }
}
