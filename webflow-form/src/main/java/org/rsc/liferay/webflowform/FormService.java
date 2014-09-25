package org.rsc.liferay.webflowform;

public interface FormService {

	FormBean buildStepOne();

	FormBean validateStepOne(FormBean form);

}
