create table contact_Foo (
	uuid_ VARCHAR(75) null,
	fooId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	field1 VARCHAR(75) null,
	field2 BOOLEAN,
	field3 INTEGER,
	field4 DATE null,
	field5 VARCHAR(75) null
);

create table rsc_Contact (
	personId LONG not null primary key,
	companyId LONG,
	lastName VARCHAR(75) null,
	firstName VARCHAR(75) null,
	mail VARCHAR(75) null,
	phone VARCHAR(75) null
);

create table rsc_contact (
	personId LONG not null primary key,
	companyId LONG,
	lastName VARCHAR(75) null,
	firstName VARCHAR(75) null,
	mail VARCHAR(75) null,
	phone VARCHAR(75) null
);