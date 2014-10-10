package com.appbootup.explore.gwt.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;

public final class PersonJSO extends JavaScriptObject
{
	protected PersonJSO()
	{
	}

	public static native PersonJSO createPerson()/*-{
		return {};
	}-*/;

	private static int counter;

	static List<String> contacts = new ArrayList<String>();


	private static void addContact( String contact )
	{
		GWT.log( "addContact -> " + contact );
		contacts.add( contact );
	}

	public native void addSkill(PersonJSO person, String skill ) /*-{
	}-*/;

	public native void addContact(String contact, String name ) /*-{
		// Call static method addContact()
		@com.appbootup.explore.gwt.client.PersonJSO::addContact(Ljava/lang/String;)(contact);

		// Read static field (no qualifier)
		var val = @com.appbootup.explore.gwt.client.PersonJSO::counter;

		// Write static field (no qualifier)
		@com.appbootup.explore.gwt.client.PersonJSO::counter = val + 1;
	}-*/;

	public native List<String> getContacts() /*-{
		return @com.appbootup.explore.gwt.client.PersonJSO::contacts;
	}-*/;

	public final native String getName()
	/*-{
		return this.name;
	}-*/;

	public final native void setName( String name )
	/*-{
		this.name = name;
	}-*/;

	public final native int getAge()
	/*-{
		return this.age;
	}-*/;

	public final native void setAge( int age )
	/*-{
		this.age = age;
	}-*/;
}