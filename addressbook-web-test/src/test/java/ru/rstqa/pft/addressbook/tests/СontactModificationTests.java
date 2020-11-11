package ru.rstqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.rstqa.pft.addressbook.model.ContactData;
import ru.rstqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class СontactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecond() {
    app.contact().homePage();
    if (app.contact().all().size() ==0) {
      app.contact().create(new ContactData().withFirstname("Alex"));

    }

  }
  @Test(enabled = true)
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().
    withId(modifiedContact.getId()).withFirstname("Alex1").withLastname("John1").withTitle("Dr1").withAddress("Germany1").withEmail1("gmail@gmail.com").withGroup(null);
    app.contact().modify(contact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));


  }


}
