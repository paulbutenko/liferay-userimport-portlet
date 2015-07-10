<%
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>

<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<%@ taglib prefix="liferay-util" uri="http://liferay.com/tld/util" %>
<%@ taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet" %>
<%@ taglib prefix="liferay-theme" uri="http://liferay.com/tld/theme" %>


<portlet:defineObjects />

<portlet:actionURL var="importUrl"/>

<aui:form action="<%= importUrl %>" method="post" name="fm">
    <aui:button-row>
        <aui:button type="submit" value="Import"/>
    </aui:button-row>
</aui:form>