//package com.booking.test;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.rmi.RemoteException;
//import java.util.Calendar;
//
//import javax.xml.namespace.QName;
//import javax.xml.rpc.ServiceException;
//
//import org.apache.axis.AxisFault;
//import org.apache.axis.client.Service;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//import booking.BookingWebServiceSoapBindingStub;
//
//public class MovieServiceTest {
//	
//	private BookingWebServiceSoapBindingStub client;
//	
//	@Before
//	public void init() throws AxisFault, MalformedURLException, ServiceException {
//		client = new BookingWebServiceSoapBindingStub(new URL("http://localhost:8080/LazyBooking/service/BookingWebService"),
//				new Service("http://localhost:8080/LazyBooking/service/BookingWebService", new QName("BookingWebService")));
//		// should usually -> create entry in database
//		// test in @test method for it
//		// delete entry in @After
//	}
//	
//	@Test
//	public void testGetAllMoviesByDate() throws RemoteException {
//		Object[] allMoviesByDate = client.getAllMoviesByDate(Calendar.getInstance());
//		assertNotNull("Web service movies response is null", allMoviesByDate);
//		assertFalse("No movies found", allMoviesByDate.length == 0);
//	}
//	
//	@After
//	public void tearDown() {
//		
//	}
//
//}
