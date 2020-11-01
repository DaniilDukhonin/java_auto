package ru.rstqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.rstqa.pft.addressbook.model.ContactData;
import ru.rstqa.pft.addressbook.model.Contacts;
import ru.rstqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);

  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("address"), contactData.getAddress());
    type(By.name("email"), contactData.getEmail());


    if (creation) {
      new Select(wd.findElement(By.name("add new"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("add new")));
    }

  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }


  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void initContactDeletion() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void closeDialogWindow() {
    wd.switchTo().alert().accept();
    wd.findElement(By.cssSelector("div.msgbox"));
  }


  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm((contact), true);
    submitContactCreation();
    homePage();
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    initContactModification();
    fillContactForm(contact, false);
    submitContactModification();
    homePage();
  }


  public void delete(ContactData contact){
    selectContactById(contact.getId());
    initContactDeletion();
    closeDialogWindow();
    homePage();

  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.tagName("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String firstname = cells.get(1).getText();
      String lastname = cells.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return contacts;
  }




}
