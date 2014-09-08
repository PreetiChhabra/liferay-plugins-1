<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.flickr4java.flickr.photos.PhotoList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/flickr/init.jsp"%>

<portlet:renderURL var="portletURL" windowState="normal">
    
</portlet:renderURL>

<%
if (Validator.isNotNull(secretKey) && Validator.isNotNull(apiKey)) {
	int curPage = ParamUtil.getInteger(renderRequest, "cur", 0);

	REST rest = new REST();
    Flickr flickr = new Flickr(apiKey, secretKey, rest);

    PeopleInterface people = flickr.getPeopleInterface();
    User flickUser = null;
    PhotoList<Photo> photos = null;
    try {
        flickUser = people.findByEmail(emailAddress);
        flickUser = people.getInfo(flickUser.getId());
        photos = people.getPublicPhotos(flickUser.getId(), numberOfPhotos, curPage);
    } catch (Exception fe) {
        out.print(fe.getMessage());
    }
    if (photos != null) {%>   
        <div class="flickr">
            <div class="row-fluid">
                <c:choose>
			        <c:when test="<%= portletDisplayDDMTemplateId > 0 %>">
			            <%
			            Map<String, Object> contextObjects = new HashMap<String, Object>();
			            contextObjects.put("user", flickUser);
			            %>
			            <%= PortletDisplayTemplateUtil.renderDDMTemplate(pageContext, portletDisplayDDMTemplateId, photos, contextObjects) %>
			        </c:when>    
			        <c:otherwise> 		        
			            <h2 class="flickr-entete">
			                <liferay-ui:message key="flickr.entete" />
			            </h2>
			            <ul class="flickr-feed">
				        <% for (Photo photo : photos) { %>
				            <li class="flickr-photo">
				                <a href="<%=photo.getUrl() %>" target="blank" title="<%=photo.getTitle()%>"> 
				                    <img src="<%=photo.getSmall320Url()%>" alt="<%=photo.getTitle()%>"/>
				                </a>
				            </li>                  
				        <% } %>
			            </ul>
		                <p class="align-center">
		                    <a href="<%=flickUser.getPhotosurl()%>" class="btn btn-info" title='<liferay-ui:message key="flickr.more.title" />' target="blank">
		                        <liferay-ui:message key="flickr.more.link" /> <i class="icon-white icon-edit"></i>
		                    </a>                
		                </p>			            
                    </c:otherwise>
                </c:choose> 			            
	            <c:if test="<%=paginate %>">
		            <liferay-ui:page-iterator 
		                url="<%= portletURL.toString()%>"
		                total="<%=photos.getTotal()%>" curParam="cur" 
		                cur="<%=curPage %>" delta="<%=numberOfPhotos%>"
		                type="more"
		                deltaConfigurable="false">
		            </liferay-ui:page-iterator>
	            </c:if>
	        </div>
	    </div>
    <% } else {
    renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
    %>
    <div class="portlet-msg-info">
        <liferay-ui:message key="please-configure-this-portlet-to-make-it-visible-to-all-users" />
    </div>	
    <% }
} else {
    renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
    %>
    <div class="portlet-msg-info">
        <liferay-ui:message key="please-configure-this-portlet-to-make-it-visible-to-all-users" />
    </div>
<% } %>