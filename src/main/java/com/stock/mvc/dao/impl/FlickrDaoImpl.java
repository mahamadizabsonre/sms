package com.stock.mvc.dao.impl;

import java.io.InputStream;


import javax.swing.JOptionPane;



import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuth1Token;
import com.stock.mvc.dao.IFlickrDao;

public class FlickrDaoImpl implements IFlickrDao{

	
	private Flickr flickr;
	private UploadMetaData uploadMetaData = new  UploadMetaData();
	
	private String apiKey = "510d1983c2cdef93a3e86e2d1aa92948";
	private String sharedSecret = "e108146d9a8878f6";
	
	
	private void connect() {
		flickr = new Flickr(apiKey, sharedSecret, new REST());
		Auth auth = new Auth();
		auth.setPermission(Permission.READ);
		//very important token : 72157712178588342-ce660150908ee456
		auth.setToken("72157712178588342-ce660150908ee456");
		//Very important tokenSecret: 382d5887afe120d5
		auth.setTokenSecret("382d5887afe120d5");
		RequestContext requestContext = RequestContext.getRequestContext();
		requestContext.setAuth(auth);
		flickr.setAuth(auth);
	}
	
	@Override
	public String savePhoto(InputStream stream, String fileName) throws Exception {
		connect();
		uploadMetaData.setTitle(fileName);
		String photoId = flickr.getUploader().upload(stream, uploadMetaData);
		return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
	}

	public void auth() throws FlickrException {
		flickr = new Flickr(apiKey, sharedSecret, new REST());
		
		AuthInterface authInterface = flickr.getAuthInterface();
		
		OAuth1RequestToken token = authInterface.getRequestToken();
		
		System.out.println("token: " + token);
		
		// Scanner scanner = new Scanner(System.in);
		String url = authInterface.getAuthorizationUrl(token, Permission.DELETE);
		
		System.out.println("Follow URL to authorise yourself on Flickr");
		
		System.out.println(url);
		System.out.println("Paste in the token it gives you:");
		System.out.print(">>");
		
		String tokenKey = JOptionPane.showInputDialog(null); 
		
       // String tokenKey = scanner.nextLine();
        //scanner.close();

        OAuth1Token accessToken = authInterface.getAccessToken(token, tokenKey);
        System.out.println("Authentication success");

        Auth auth = authInterface.checkToken(accessToken);

        // This token can be used until the user revokes it.
        System.out.println("Token: " + accessToken.getToken());
        System.out.println("Secret: " + accessToken.getTokenSecret());
        System.out.println("nsid: " + auth.getUser().getId());
        System.out.println("Realname: " + auth.getUser().getRealName());
        System.out.println("Username: " + auth.getUser().getUsername());
        System.out.println("Permission: " + auth.getPermission().getType());
	}
}
