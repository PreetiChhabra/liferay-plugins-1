package org.rsc.liferay.contact.comparator;

import org.rsc.liferay.contact.model.Contact;

import com.liferay.portal.kernel.util.OrderByComparator;

public class ContactMailComparator  extends OrderByComparator{

	private static final long serialVersionUID = 1404387257783555734L;

	public static final String ORDER_BY_ASC = "Contact.mail ASC";

	public static final String ORDER_BY_DESC = "Contact.mail DESC";

	public static final String[] ORDER_BY_FIELDS = {"mail"};
	
	public ContactMailComparator() {
		this(false);
	}

	public ContactMailComparator(boolean ascending) {
		_ascending = ascending;
	}
	
	@Override
	public int compare(Object obj1, Object obj2) {
		Contact person1 = (Contact)obj1;
		Contact person2 = (Contact)obj2;

		String mail1 = person1.getMail();
		String mail2 = person2.getMail();

		int value = mail1.compareTo(mail2);

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}
	
	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;
}
