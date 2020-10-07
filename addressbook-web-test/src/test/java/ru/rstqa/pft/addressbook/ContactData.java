package ru.rstqa.pft.addressbook;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String title;
  private final String address;
  private final String email;

  public ContactData(String firstname, String middlename, String title, String address, String email) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.title = title;
    this.address = address;
    this.email = email;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getTitle() {
    return title;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }
}
