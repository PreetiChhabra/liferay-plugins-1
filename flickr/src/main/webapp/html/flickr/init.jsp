<%@page import="com.liferay.portlet.portletdisplaytemplate.util.PortletDisplayTemplateUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="javax.portlet.ValidatorException"%>
<%@page import="org.rsc.liferay.portlet.flickr.FlickrConstants"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.flickr4java.flickr.FlickrException"%>
<%@page import="com.flickr4java.flickr.REST"%>
<%@page import="com.flickr4java.flickr.photos.Photo"%>
<%@page import="com.flickr4java.flickr.people.User"%>
<%@page import="com.flickr4java.flickr.people.PeopleInterface"%>
<%@page import="com.flickr4java.flickr.Flickr"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ include file="/html/init.jsp" %>

<%
    PortletPreferences portletSetup = renderRequest.getPreferences();

    String apiKey = portletSetup.getValue(FlickrConstants.FIELD_FLICKR_API_KEY, null);
    String emailAddress = portletSetup.getValue(FlickrConstants.FIELD_FLICKR_EMAIL, null);
    int numberOfPhotos = GetterUtil.get(portletSetup.getValue(FlickrConstants.FIELD_FLICKR_NUMBER_PHOTOS, null), 5);
    String secretKey = portletSetup.getValue(FlickrConstants.FIELD_FLICKR_SECRET_KEY, null);
    boolean paginate = GetterUtil.get(portletSetup.getValue(FlickrConstants.FIELD_FLICKR_PAGINATE, null), false);
    
    String displayStyle = GetterUtil.getString(portletPreferences.getValue("displayStyle", StringPool.BLANK));
    long displayStyleGroupId = GetterUtil.getLong(portletPreferences.getValue("displayStyleGroupId", null), scopeGroupId);
    long portletDisplayDDMTemplateId = PortletDisplayTemplateUtil.getPortletDisplayTemplateDDMTemplateId(displayStyleGroupId, displayStyle);
    
    
%>