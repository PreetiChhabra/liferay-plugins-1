<%@page import="com.liferay.portal.kernel.template.TemplateHandlerRegistryUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.template.TemplateHandler"%>
<%@ include file="/html/flickr/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationURL" />

To retreive your Flickr api key
<a href="http://www.flickr.com/services/api/keys/" target="_blank" title="API Info">this</a> is the place to go.
<br />

<aui:form action="<%=configurationURL%>" method="post" name="fm">
    <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
    <liferay-ui:error key="emailFromAddress" message="please-enter-a-valid-email-address" />
    <liferay-ui:error exception="<%= ValidatorException.class %>">
        <%ValidatorException ve = (ValidatorException)errorException;%>        
        <strong><%= ve.getMessage() %></strong>
    </liferay-ui:error>    
	<aui:fieldset>
		<aui:input
			label="flickr.config.flickrapikey" title="flickr.config.flickrapikey"
			name="preferences--flickrapikey--" type="text" value="<%=apiKey%>"
			showRequiredLabel="false">
			<aui:validator name="required" />
		</aui:input>
		<aui:input
			title="flickr.config.numberofphotos"
			label="flickr.config.numberofphotos"
			name="preferences--numberofphotos--" type="text"
			value="<%=numberOfPhotos%>" showRequiredLabel="false">
			<aui:validator name="required" />
			<aui:validator name="digits"/>
		</aui:input>
		<aui:input
			label="flickr.config.emailaddress" title="flickr.config.emailaddress"
			name="preferences--emailaddress--" type="text"
			value="<%=emailAddress%>" showRequiredLabel="false">
			<aui:validator name="required" />
			<aui:validator name="email"/>
		</aui:input>
		<aui:input
			label="flickr.config.secretKey" title="flickr.config.secretKey"
			name="preferences--secretKey--" type="text" value="<%=secretKey%>"
			showRequiredLabel="false">
			<aui:validator name="required" />
		</aui:input>
        <aui:input
            label="flickr.config.paginate" title="flickr.config.paginate"
            name="preferences--paginate--" type="checkbox" value="<%=paginate%>"
            showRequiredLabel="false">
            <aui:validator name="required" />
        </aui:input>
	</aui:fieldset>
    <aui:fieldset>
        <div class="display-template">
            <%
            TemplateHandler templateHandler = TemplateHandlerRegistryUtil.getTemplateHandler(Photo.class.getName());
            %>
            <liferay-ui:ddm-template-selector
                classNameId="<%= PortalUtil.getClassNameId(templateHandler.getClassName()) %>"
                displayStyle="<%= displayStyle %>"
                displayStyleGroupId="<%= displayStyleGroupId %>"
                refreshURL="<%= PortalUtil.getCurrentURL(request) %>"
                showEmptyOption="<%= true %>"
            />
        </div>
    </aui:fieldset>	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

