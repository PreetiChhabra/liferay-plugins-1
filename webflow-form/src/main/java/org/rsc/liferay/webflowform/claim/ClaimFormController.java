package org.rsc.liferay.webflowform.claim;

import org.springframework.stereotype.Controller;

@Controller
public class ClaimFormController {

	
	public ClaimBean buildClaimBean() {
		return new ClaimBean();
	}
	
}
