package org.rsc.liferay.webflowform.claim;

import org.springframework.stereotype.Controller;

@Controller("claimFormController")
public class ClaimFormController {

	
	public ClaimBean buildClaimBean() {
		ClaimBean claim = new ClaimBean();
		claim.setFirstname("test");
		claim.setLastname("test");
		return claim;
	}
	
}
