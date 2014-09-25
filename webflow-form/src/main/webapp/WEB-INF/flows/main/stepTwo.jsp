<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>View Form</h2>
<portlet:actionURL var="actionUrl">
    <portlet:param name="execution" value="${flowExecutionKey}" />
</portlet:actionURL>
<form:form id="form" modelAttribute="form" action="${actionUrl}">
    <input type="hidden" name="execution" value="${flowExecutionKey}" />
    <fieldset>
        <table>
            <tr class="field">
                <td class="label">Last Name:</td>
                <td class="output">${form.lastname}</td>
            </tr>
            <tr class="field">
                <td class="label">First Name:</td>
                <td class="output">${form.firstname}</td>
            </tr>
            <tr class="field">
                <td class="label">Email:</td>
                <td class="output">${form.email}</td>
            </tr>
            <tr class="field">
                <td colspan="2" class="buttonGroup">
                    <input type="submit" name="_eventId_next" value="Book Hotel" />&#160;
                    <input type="submit" name="_eventId_cancel" value="Back to Search" />&#160;
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>