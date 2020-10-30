package ru.rstqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String title;
  private final String address;
  private final String email;
  private String group;

  public void setId(int id) {
    this.id = id;
  }

  private int id;

  public ContactData(String firstname, String lastname, String title, String address, String email, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.title = title;
    this.address = address;
    this.email = email;
    this.group = group;
    this.id = Integer.MAX_VALUE;

  }

  public ContactData(int id, String firstname, String lastname, String title, String address, String email, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.title = title;
    this.address = address;
    this.email = email;
    this.group = group;
    this.id = id;

  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
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

  public String getGroup() { return group;  }



  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", id='" + id + '\'' +
            '}';
  }
}
