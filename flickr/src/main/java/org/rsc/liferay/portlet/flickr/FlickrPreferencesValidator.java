package org.rsc.liferay.portlet.flickr;

import com.liferay.portal.kernel.util.Validator;

import java.util.HashSet;
import java.util.Set;

import javax.portlet.PortletPreferences;
import javax.portlet.PreferencesValidator;
import javax.portlet.ValidatorException;

/**
 * @author Rutger Heijmerikx
 * 
 */
public class FlickrPreferencesValidator implements PreferencesValidator {

    public void validate(PortletPreferences prefs) throws ValidatorException {

        Set<String> errorsSet = new HashSet<String>();
        errorsSet.clear();

        String apiKey = prefs.getValue(FlickrConstants.FIELD_FLICKR_API_KEY, null);
        String numberOfPhotos = prefs.getValue(FlickrConstants.FIELD_FLICKR_NUMBER_PHOTOS, null);
        String emailAddress = prefs.getValue(FlickrConstants.FIELD_FLICKR_EMAIL, null);
        String secretKey = prefs.getValue(FlickrConstants.FIELD_FLICKR_SECRET_KEY, null);
        
        if (!Validator.isEmailAddress(emailAddress)) {
            throw new ValidatorException("Bad email address", errorsSet);
        }
        if (!Validator.isNumber(numberOfPhotos)) {
            throw new ValidatorException("Not number", errorsSet);
        }
    }
}