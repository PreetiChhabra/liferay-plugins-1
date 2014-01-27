package org.rsc.liferay.contact.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import org.rsc.liferay.contact.service.ClpSerializer;
import org.rsc.liferay.contact.service.ContactLocalServiceUtil;
import org.rsc.liferay.contact.service.ContactServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            ContactLocalServiceUtil.clearService();

            ContactServiceUtil.clearService();
        }
    }
}
