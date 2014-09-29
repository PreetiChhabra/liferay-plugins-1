package org.rsc.liferay.webflowform.claim;

import org.springframework.stereotype.Service;

@Service("claimFormService")
public class ClaimFormServiceImpl implements ClaimFormService{

	@Override
	public ClaimBean buildStepOne() {
		return new ClaimBean();
	}
	
	@Override
	public ClaimBean validateStepOne(ClaimBean form) {
		return form;
	}
	
}
