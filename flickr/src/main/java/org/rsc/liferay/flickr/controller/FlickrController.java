package org.rsc.liferay.flickr.controller;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.PhotosInterface;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller("flickrController")
@RequestMapping("VIEW")
public class FlickrController {

	private static final Log LOG = LogFactoryUtil.getLog(FlickrController.class);
	
	private static final String VIEW = "flickr/view";
	
	@RenderMapping
	public String view(RenderRequest renderRequest,
			RenderResponse renderResponse, Map<String, Object> map) {
		
		String apiKey = "da1d8780252d3047adcf9fef2675742c";
		String secretKey = "";
		
		REST rest = new REST();
        rest.setHost("api.flickr.com");
		
		Flickr flickr = new Flickr(apiKey, secretKey, rest);
		
        PhotosInterface iface = flickr.getPhotosInterface();
        Set<String> extras = new HashSet<String>();
        try {
			PhotoList<Photo> photos = iface.getRecent(extras, 0, 0);
		} catch (FlickrException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return VIEW;
	}
	
}
