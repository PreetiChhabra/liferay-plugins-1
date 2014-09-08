package org.rsc.liferay.portlet.flickr;

import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.people.User;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portletdisplaytemplate.BasePortletDisplayTemplateHandler;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.portletdisplaytemplate.util.PortletDisplayTemplateConstants;

import java.util.Locale;
import java.util.Map;

public class FlickrPortletDisplayTemplateHandler extends
		BasePortletDisplayTemplateHandler {

	@Override
	public String getClassName() {
		return Photo.class.getName();
	}

	@Override
	public String getName(Locale locale) {
		String portletTitle = PortalUtil.getPortletTitle(
			"flickr", locale);

		return portletTitle.concat(StringPool.SPACE).concat(
			LanguageUtil.get(locale, "template"));
	}

	@Override
	public String getResourceName() {
		return "flickr_WAR_flickrportlet";
	}

	@Override
	protected String getTemplatesConfigPath() {
		return "org/rsc/liferay/portlet/flickr/dependencies/portlet-display-templates.xml";
	}
	
	@Override
	public Map<String, TemplateVariableGroup> getTemplateVariableGroups(
			long classPK, String language, Locale locale)
		throws Exception {

		Map<String, TemplateVariableGroup> templateVariableGroups =
			super.getTemplateVariableGroups(classPK, language, locale);

		TemplateVariableGroup templateVariableGroup =
			templateVariableGroups.get("fields");

		templateVariableGroup.empty();

		templateVariableGroup.addCollectionVariable(
			"photos", PhotoList.class, PortletDisplayTemplateConstants.ENTRIES,
			"photo", Photo.class, "photo", "name");
		templateVariableGroup.addVariable("user", User.class, "user", "username");
		
		return templateVariableGroups;
	}

	
}
