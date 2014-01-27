<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />

<h3>Contacts</h3>
<liferay-ui:search-container searchContainer="${searchContainer}" 
headerNames="firstName,lastName,mail,phone"
    orderByCol="${searchContainer.orderByCol}" orderByType="${searchContainer.orderByType}">
    <liferay-ui:search-container-row
        className="org.rsc.liferay.contact.model.Contact"
        escapedModel="<%= true %>"
        keyProperty="personId"
        modelVar="curPerson">
        <liferay-ui:search-container-column-text
            name="lastName"
            property="lastName"
            orderable="true"
        />      
        <liferay-ui:search-container-column-text
            name="firstName"
            property="firstName"
            orderable="true"
        />
        <liferay-ui:search-container-column-text
            name="mail"
            property="mail"
        />
        <liferay-ui:search-container-column-text
            name="phone"
            property="phone"
        />      
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator type="regular"/>
</liferay-ui:search-container>


