package com.appbootup.explore.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTJSNI implements EntryPoint
{

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad()
	{
		final Button sendButton = new Button( "Send" );
		final TextBox nameField = new TextBox();
		nameField.setText( "GWT User" );
		final Label errorLabel = new Label();

		// We can add style names to widgets
		sendButton.addStyleName( "sendButton" );

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get( "nameFieldContainer" ).add( nameField );
		RootPanel.get( "sendButtonContainer" ).add( sendButton );
		RootPanel.get( "errorLabelContainer" ).add( errorLabel );

		// Focus the cursor on the name field when the app loads
		nameField.setFocus( true );
		nameField.selectAll();

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler
		{
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick( ClickEvent event )
			{
				sendNameToServer();
			}

			public void onKeyUp( KeyUpEvent event )
			{
				if ( event.getNativeKeyCode() == KeyCodes.KEY_ENTER )
				{
					sendNameToServer();
				}
			}

			private void sendNameToServer()
			{
				PersonJSO person = PersonJSOUtil.createPerson();
				person.setName( nameField.getText() );
				person.setAge( 20 );
				person.addContact( "9741155365", "Me" );
				person.addContact( "9972095705", "R" );
				person.addSkill( person, "Plumbing" );
				PersonJSOUtil.addSkill( person, "Driving" );
				GWT.log( "No Of Contacts -> " + person.getContacts().size() );
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler( handler );
		nameField.addKeyUpHandler( handler );
	}
}
