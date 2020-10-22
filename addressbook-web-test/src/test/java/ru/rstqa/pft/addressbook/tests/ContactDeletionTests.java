package ru.rstqa.pft.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{


@Test
public void testContactDeletion() {

  app.getContactHelper().selectContact();
  app.getContactHelper().initContactDeletion();
  app.getContactHelper().closeDialogWindow();



}
}
