package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.getUser().isLoginLinkPresent()){
      app.getUser().login();
      app.getContact().addContact();
    } else  {
      app.getUser().clickOnSignOutButton();
    }
  }

  @Test
  public void removeContactTest() {
    int sizeBefore = app.getContact().sizeOfContacts();

    app.getContact().removeContact();
    app.getContact().pause(2000);

    int sizeAfter = app.getContact().sizeOfContacts();

    Assert.assertEquals(sizeAfter,sizeBefore-1);
  }
}
