package org.rsc.liferay.webflowform;

import org.springframework.webflow.mvc.portlet.AbstractFlowHandler;

public class ViewFlowHandler extends AbstractFlowHandler {
	public String getFlowId() {
		return "view";
	}
}