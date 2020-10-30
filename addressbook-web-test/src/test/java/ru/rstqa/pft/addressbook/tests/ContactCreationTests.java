package ru.rstqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.rstqa.pft.addressbook.model.ContactData;
import ru.rstqa.pft.addressbook.model.GroupData;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import static org.testng.Assert.fail;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("test2", "John", "Dr", "Germany", "gmail@gmail.com", "test1");
    app.getContactHelper().createContact(contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
    //contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }


}

