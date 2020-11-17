package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Date;
import java.util.Calendar;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.apache.commons.*;

public class EmailTest {
	private static final String [] TEST_EMAILS = { "ab@bc.com", "a.b@c.org", 
	 "abcdefghijklmnopqrst@abcdefghijklmnopqrst.com.bd"};
private static final String TEST_EMAIL ="ab@bc.com";
private static final String TEST_NAME = "BatMan";
private static final String VALUE = "3";
private EmailConcrete email;
private static final String NULL_NAME = null;
private static final String NULL_VALUE = null;
private static final String EMPTY_NAME = "";
private static final String EMPTY_VALUE = "";
MimeMessage mime;
Session s;
Date d;
Date d2;
Calendar c = Calendar.getInstance();
InternetAddress a;
BodyPart bp;
MimeMultipart mp;

@Before
public void setUpEmailTest() throws Exception {
email = new EmailConcrete();

}


@After
public void tearDownEmailTest() throws Exception{ 

}

/*
 * Test AddBcc (String email...) function
 */
@Test
public void testAddBcc() throws Exception {
	   
	 email.addBcc(TEST_EMAILS);
	   
	   assertEquals(3, email.getBccAddresses().size());
	   
}

//code to test addCc(String)
@Test
public void testAddCc() throws Exception {
	   
	 email.addCc(TEST_EMAIL);
	 
	   assertEquals(1, email.getCcAddresses().size());
	   
}

//code to test AddHeader(String, String) function
@Test
public void testAddHeadernotnull() throws Exception {
	 email.addHeader(TEST_NAME, VALUE);
	 assertNotNull(email.getHeaders());
}

//code to test for the exception of empty or null name for AddHeader(String, String)
@Test (expected = IllegalArgumentException.class)
public void testAddHeadersnameNull() throws Exception {
	 email.addHeader(EMPTY_NAME, VALUE);
}

//code to test for the exception of empty or null value
@Test (expected = IllegalArgumentException.class)
public void testAddHeadersValueNull() throws Exception {
	 email.addHeader(TEST_NAME, EMPTY_VALUE);
}

//code to test AddReplyTo(String, String)
@Test
public void testAddReplyTo() throws Exception{
	 email.addReplyTo(TEST_EMAIL, TEST_NAME);
	 
}

//test for getHostName(String)
@Test
public void testGetHostName() throws Exception{
	email.setHostName("chad");
	email.getHostName();
}

//test for getHostName(String) with a null String
@Test
public void testGetHostNameNull() throws Exception{
	email.setHostName(null);
	email.getHostName();
}

//the test code for GetMailSession
@Test
public void testGetMailSession() throws Exception {
	 email.setAuthentication("Test", "Test01");
		email.bounceAddress = "Test";
		email.setHostName("chad");
		email.getMailSession();
}


}
