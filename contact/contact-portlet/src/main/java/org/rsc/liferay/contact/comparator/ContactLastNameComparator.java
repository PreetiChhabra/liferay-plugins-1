package org.rsc.liferay.contact.comparator;

import org.rsc.liferay.contact.model.Contact;

import com.liferay.portal.kernel.util.OrderByComparator;

public class ContactLastNameComparator extends OrderByComparator {

	private static final long serialVersionUID = 1404387257783555734L;

	public static final String ORDER_BY_ASC = "Contact.lastName ASC";

	public static final String ORDER_BY_DESC = "Contact.lastName DESC";

	public static final String[] ORDER_BY_FIELDS = { "lastName" };

	public ContactLastNameComparator() {
		this(false);
	}

	public ContactLastNameComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		Contact person1 = (Contact) obj1;
		Contact person2 = (Contact) obj2;

		String lastName1 = person1.getLastName();
		String lastName2 = person2.getLastName();

		int value = lastName1.compareTo(lastName2);

		if (_ascending) {
			return value;
		} else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		} else {
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
