package com.rtsoftworld.contactmanager_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.rtsoftworld.contactmanager_sqlite.Data.DatabaseHandler;
import com.rtsoftworld.contactmanager_sqlite.Model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHandler(this);

        // Insert contacts
        Log.d("Insert: ", "Inserting...");
        //Contact contact = new Contact("Raju","01759000004");
        //db.addContact(contact);
        //db.addContact(new Contact("Tithi","01759000019"));
        //db.addContact(new Contact("Rahajul","01529000093"));
        //db.addContact(new Contact("Amin","01829000855"));

        // Read all contacts
        Log.d("Read: ", "Reading all contacts from the table");
        List<Contact> contactList = db.getAllContacts();

        for (Contact c : contactList){
            String log = "ID: " + c.getId() + ", Name: " + c.getName() + ", Phone Number: " + c.getPhoneNumber();

            Log.d("Name: ", log);
            Toast.makeText(this, log, Toast.LENGTH_LONG).show();
        }

        //get one contact by id
       // Contact oneContact = db.getContact(1);

        //update contact
        //oneContact.setName("Rahajul");
        //oneContact.setPhoneNumber("01521418593");
        //int newContact = db.updateContact(oneContact);
       // db.deleteContact(oneContact);

        //Log.d("One contact", "update contact: " + String.valueOf(newContact)+ " Name: " + oneContact.getName() + " Phone: " + oneContact.getPhoneNumber());

        Log.d("count: ",String.valueOf(db.getContactsCount()));
    }
}