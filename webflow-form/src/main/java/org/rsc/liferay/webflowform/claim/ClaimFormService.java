package org.rsc.liferay.webflowform.claim;


public interface ClaimFormService {

	ClaimBean buildStepOne();

	ClaimBean validateStepOne(ClaimBean form);

}
