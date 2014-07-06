create table rsc_contact (
	personId LONG not null primary key,
	companyId LONG,
	lastName VARCHAR(75) null,
	firstName VARCHAR(75) null,
	mail VARCHAR(75) null,
	phone VARCHAR(75) null
);