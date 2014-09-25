package org.rsc.liferay.webflowform;

import org.springframework.stereotype.Service;

@Service("formService")
public class FormServiceImpl implements FormService{

	@Override
	public FormBean buildStepOne() {
		return new FormBean();
	}
	
	@Override
	public FormBean validateStepOne(FormBean form) {
		return form;
	}
	
}
