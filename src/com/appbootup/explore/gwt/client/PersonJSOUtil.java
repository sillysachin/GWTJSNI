package com.appbootup.explore.gwt.client;


public final class PersonJSOUtil
{
	public static PersonJSO createPerson()
	{
		return PersonJSO.createPerson();
	}

	public static native void addSkill( PersonJSO person, String skill ) /*-{
		// Read instance field on this
		var val = person.counter;

		// Write instance field on person
		person.counter = val + 10;
		alert(person.name)
	}-*/;
}