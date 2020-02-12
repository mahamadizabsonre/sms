package com.stock.mvc.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.flickr4java.flickr.FlickrException;
import com.stock.mvc.dao.impl.FlickrDaoImpl;

public class TestFlickr {

	public static void main(String[] args) throws FlickrException {
        try {
    		FlickrDaoImpl flickr = new FlickrDaoImpl();
    		//flickr.auth();
    		
    		InputStream stream = new FileInputStream(new File("C:\\Users\\user\\Documents\\FORMATIONS_JAVA\\RESOURCES\\SMS_STOCK\\login-image-1.jpg"));
    		String url = flickr.savePhoto(stream, "myImageFlickrTest");
    		System.out.println(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);

	}

}
