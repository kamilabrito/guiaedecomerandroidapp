package com.kbrtz.guiaedecomer.guiaedecomer.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.kbrtz.guiaedecomer.guiaedecomer.helper.DataBaseHelper;
import com.kbrtz.guiaedecomer.guiaedecomer.helper.DbEntry;
import com.kbrtz.guiaedecomer.guiaedecomer.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamila.brito on 09/06/2016.
 */
public class ContactDAO {

    private SQLiteDatabase database;
    private DataBaseHelper dbHelper;
    private String [] allColumns = {DbEntry.CONTACT_ID, DbEntry.CONTACT_FACEBOOK,
            DbEntry.CONTACT_TWITTER, DbEntry.CONTACT_INSTAGRAM, DbEntry.CONTACT_PHONE,
            DbEntry.CONTACT_WEBSITE};

    public ContactDAO (DataBaseHelper dbHelper) {
        this.dbHelper = dbHelper;
        database = this.dbHelper.getWritableDatabase();
    }

    public List<Contact> getAllContacts() {
        List <Contact> contacts = new ArrayList<>();

        Cursor cursor = database.query(DbEntry.TABLE_CONTACT, allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Contact contact = cursorToContact(cursor);
            contacts.add(contact);
            cursor.moveToNext();
        }
        cursor.close();
        return contacts;
    }

    public Contact getContactById (int contactId) {
        Contact contact = new Contact();

        Cursor cursor = database.query(DbEntry.TABLE_CONTACT, allColumns,
                DbEntry.CONTACT_ID + "='" + contactId + "'", null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            contact = cursorToContact(cursor);
        }

        return contact;
    }

    public void createContact(Contact contact) {
        ContentValues values = new ContentValues();
        values.put(DbEntry.CONTACT_FACEBOOK, contact.getFacebook());
        values.put(DbEntry.CONTACT_TWITTER, contact.getTwitter());
        values.put(DbEntry.CONTACT_INSTAGRAM, contact.getInstagram());
        values.put(DbEntry.CONTACT_PHONE, contact.getPhone());
        values.put(DbEntry.CONTACT_WEBSITE, contact.getWebsite());
        database.insert(DbEntry.TABLE_CONTACT, null, values);
    }


    private Contact cursorToContact(Cursor cursor) {
        Contact contact = new Contact();
        contact.setId(cursor.getInt(0));
        contact.setFacebook(cursor.getString(1));
        contact.setTwitter(cursor.getString(2));
        contact.setInstagram(cursor.getString(3));
        contact.setPhone(cursor.getString(4));
        contact.setWebsite(cursor.getString(5));
        return contact;
    }

    public void closeDatabase () {
        database.close();
    }

}
