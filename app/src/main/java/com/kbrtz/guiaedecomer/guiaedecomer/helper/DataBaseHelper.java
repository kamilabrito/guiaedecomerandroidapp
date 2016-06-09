package com.kbrtz.guiaedecomer.guiaedecomer.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.kbrtz.guiaedecomer.guiaedecomer.model.Contact;

/**
 * Created by kamila.brito on 08/06/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "guiaedecomer.db";

    private static final String CREATE_TABLE_CONTACT = "CREATE TABLE "
            + DbEntry.TABLE_CONTACT + "(" + DbEntry.CONTACT_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
            + DbEntry.CONTACT_FACEBOOK + " TEXT,"
            + DbEntry.CONTACT_TWITTER + " TEXT,"
            + DbEntry.CONTACT_INSTAGRAM + " TEXT,"
            + DbEntry.CONTACT_PHONE + " TEXT,"
            + DbEntry.CONTACT_WEBSITE + " TEXT" + ")";

    private static final String CREATE_TABLE_CATEGORY = "CREATE TABLE "
            + DbEntry.TABLE_CATEGORY + "(" + DbEntry.CATEGORY_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
            + DbEntry.CATEGORY_NAME + " TEXT" + ")";

    private static final String CREATE_TABLE_WORKING_HOURS = "CREATE TABLE "
            + DbEntry.TABLE_WORKING_HOURS + "(" + DbEntry.WORKING_HOURS_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
            + DbEntry.WORKING_HOURS_HOUR_START + " INTEGER,"
            + DbEntry.WORKING_HOURS_HOUR_FINISH + " INTEGER,"
            + DbEntry.WORKING_HOURS_WEEKDAY + " TEXT" + ")";

    private static final String CREATE_TABLE_SPECIALS = "CREATE TABLE "
            + DbEntry.TABLE_SPECIALS + "(" + DbEntry.SPECIALS_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
            + DbEntry.SPECIALS_NAME + " TEXT,"
            + DbEntry.SPECIALS_DESCRIPTION + " TEXT" + ")";

    private static final String CREATE_TABLE_SERVICES = "CREATE TABLE "
            + DbEntry.TABLE_SERVICES + "(" + DbEntry.SERVICES_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
            + DbEntry.SERVICES_NAME + " TEXT,"
            + DbEntry.SERVICES_FREE + " INTEGER,"
            + DbEntry.SERVICES_PRICE + " REAL,"
            + DbEntry.SPECIALS_DESCRIPTION + " TEXT" + ")";

    private static final String CREATE_TABLE_RESTAURANT = "CREATE TABLE "
            + DbEntry.TABLE_RESTAURANT + "(" + DbEntry.RESTAURANT_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
            + DbEntry.RESTAURANT_NAME + " TEXT,"
            + DbEntry.RESTAURANT_ADDRESS + " TEXT,"
            + DbEntry.RESTAURANT_HEADER_PHOTO + " BLOB,"
            + DbEntry.CONTACT_ID + " INTEGER,"
            + "FOREIGN KEY(" + DbEntry.CONTACT_ID + ") REFERENCES " + DbEntry.TABLE_CONTACT + "(" + DbEntry.CONTACT_ID + "))";

    private static final String CREATE_TABLE_RESTAURANT_CATEGORY = "CREATE TABLE "
            + DbEntry.TABLE_RESTAURANT_CATEGORY + "("
            + DbEntry.CATEGORY_ID + " INTEGER,"
            + DbEntry.RESTAURANT_ID + " INTEGER,"
            + "FOREIGN KEY(" + DbEntry.CATEGORY_ID + ") REFERENCES " + DbEntry.TABLE_CATEGORY + "(" + DbEntry.CATEGORY_ID + "), "
            + "FOREIGN KEY(" + DbEntry.RESTAURANT_ID + ") REFERENCES " + DbEntry.TABLE_RESTAURANT + "(" + DbEntry.RESTAURANT_ID + "))";

    private static final String CREATE_TABLE_RESTAURANT_WORKING_HOURS = "CREATE TABLE "
            + DbEntry.TABLE_RESTAURANT_WORKING_HOURS + "("
            + DbEntry.WORKING_HOURS_ID + " INTEGER,"
            + DbEntry.RESTAURANT_ID + " INTEGER,"
            + "FOREIGN KEY(" + DbEntry.WORKING_HOURS_ID + ") REFERENCES " + DbEntry.TABLE_WORKING_HOURS + "(" + DbEntry.WORKING_HOURS_ID + "), "
            + "FOREIGN KEY(" + DbEntry.RESTAURANT_ID + ") REFERENCES " + DbEntry.TABLE_RESTAURANT + "(" + DbEntry.RESTAURANT_ID + "))";

    private static final String CREATE_TABLE_RESTAURANT_SPECIALS = "CREATE TABLE "
            + DbEntry.TABLE_RESTAURANT_SPECIALS + "("
            + DbEntry.SPECIALS_ID + " INTEGER,"
            + DbEntry.RESTAURANT_ID + " INTEGER,"
            + "FOREIGN KEY(" + DbEntry.SPECIALS_ID + ") REFERENCES " + DbEntry.TABLE_SPECIALS + "(" + DbEntry.SPECIALS_ID + "), "
            + "FOREIGN KEY(" + DbEntry.RESTAURANT_ID + ") REFERENCES " + DbEntry.TABLE_RESTAURANT + "(" + DbEntry.RESTAURANT_ID + "))";

    private static final String CREATE_TABLE_RESTAURANT_SERVICES = "CREATE TABLE "
            + DbEntry.TABLE_RESTAURANT_SERVICES + "("
            + DbEntry.SERVICES_ID + " INTEGER,"
            + DbEntry.RESTAURANT_ID + " INTEGER,"
            + "FOREIGN KEY(" + DbEntry.SERVICES_ID + ") REFERENCES " + DbEntry.TABLE_SERVICES + "(" + DbEntry.SERVICES_ID + "), "
            + "FOREIGN KEY(" + DbEntry.RESTAURANT_ID + ") REFERENCES " + DbEntry.TABLE_RESTAURANT + "(" + DbEntry.RESTAURANT_ID + "))";

    private static final String CREATE_TABLE_SPECIAL_WORKING_HOURS = "CREATE TABLE "
            + DbEntry.TABLE_SPECIAL_WORKING_HOURS + "("
            + DbEntry.WORKING_HOURS_ID + " INTEGER,"
            + DbEntry.SPECIALS_ID + " INTEGER,"
            + "FOREIGN KEY(" + DbEntry.WORKING_HOURS_ID + ") REFERENCES " + DbEntry.TABLE_WORKING_HOURS + "(" + DbEntry.WORKING_HOURS_ID + "), "
            + "FOREIGN KEY(" + DbEntry.SPECIALS_ID + ") REFERENCES " + DbEntry.TABLE_SPECIALS + "(" + DbEntry.SPECIALS_ID + "))";

    private static final String CREATE_TABLE_SERVICE_WORKING_HOURS = "CREATE TABLE "
            + DbEntry.TABLE_SERVICE_WORKING_HOURS + "("
            + DbEntry.WORKING_HOURS_ID + " INTEGER,"
            + DbEntry.SERVICES_ID + " INTEGER,"
            + "FOREIGN KEY(" + DbEntry.WORKING_HOURS_ID + ") REFERENCES " + DbEntry.TABLE_WORKING_HOURS + "(" + DbEntry.WORKING_HOURS_ID + "), "
            + "FOREIGN KEY(" + DbEntry.SERVICES_ID + ") REFERENCES " + DbEntry.TABLE_SERVICES + "(" + DbEntry.SERVICES_ID + "))";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CONTACT);
        db.execSQL(CREATE_TABLE_CATEGORY);
        db.execSQL(CREATE_TABLE_WORKING_HOURS);
        db.execSQL(CREATE_TABLE_SPECIALS);
        db.execSQL(CREATE_TABLE_SERVICES);
        db.execSQL(CREATE_TABLE_RESTAURANT);
        db.execSQL(CREATE_TABLE_RESTAURANT_CATEGORY);
        db.execSQL(CREATE_TABLE_RESTAURANT_WORKING_HOURS);
        db.execSQL(CREATE_TABLE_RESTAURANT_SPECIALS);
        db.execSQL(CREATE_TABLE_RESTAURANT_SERVICES);
        db.execSQL(CREATE_TABLE_SPECIAL_WORKING_HOURS);
        db.execSQL(CREATE_TABLE_SERVICE_WORKING_HOURS);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL("DROP TABLE IF EXISTS " + DbEntry.TABLE_CONTACT);
        db.execSQL("DROP TABLE IF EXISTS " + DbEntry.TABLE_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + DbEntry.TABLE_SERVICES);
        db.execSQL("DROP TABLE IF EXISTS " + DbEntry.TABLE_SPECIALS);
        db.execSQL("DROP TABLE IF EXISTS " + DbEntry.TABLE_WORKING_HOURS);
        db.execSQL("DROP TABLE IF EXISTS " + DbEntry.TABLE_RESTAURANT);
        db.execSQL("DROP TABLE IF EXISTS " + DbEntry.TABLE_RESTAURANT_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + DbEntry.TABLE_RESTAURANT_SERVICES);
        db.execSQL("DROP TABLE IF EXISTS " + DbEntry.TABLE_RESTAURANT_SPECIALS);
        db.execSQL("DROP TABLE IF EXISTS " + DbEntry.TABLE_RESTAURANT_WORKING_HOURS);
        db.execSQL("DROP TABLE IF EXISTS " + DbEntry.TABLE_SERVICE_WORKING_HOURS);
        db.execSQL("DROP TABLE IF EXISTS " + DbEntry.TABLE_SPECIAL_WORKING_HOURS);

        this.onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}


