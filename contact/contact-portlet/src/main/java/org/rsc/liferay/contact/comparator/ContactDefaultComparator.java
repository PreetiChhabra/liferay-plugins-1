package org.rsc.liferay.contact.comparator;

import org.rsc.liferay.contact.model.Contact;

import com.liferay.portal.kernel.util.OrderByComparator;

public class ContactDefaultComparator extends OrderByComparator {

	private static final long serialVersionUID = 1404387257783555734L;

	public static final String ORDER_BY_ASC = "Contact.lastName ASC, Contact.firstName ASC";

	public static final String ORDER_BY_DESC = "Contact.lastName DESC, Contact.firstName DESC";

	public static final String[] ORDER_BY_FIELDS = { "lastName", "firstName" };

	public ContactDefaultComparator() {
		this(false);
	}

	public ContactDefaultComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		Contact person1 = (Contact) obj1;
		Contact person2 = (Contact) obj2;

		String lastName1 = person1.getLastName();
		String lastName2 = person2.getLastName();

		String firstName1 = person1.getFirstName();
		String firstName2 = person2.getFirstName();

		int value = lastName1.compareTo(lastName2);
		if (value == 0) {
			value = firstName1.compareTo(firstName2);
		}
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
