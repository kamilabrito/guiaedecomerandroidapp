package com.kbrtz.guiaedecomer.guiaedecomer.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.kbrtz.guiaedecomer.guiaedecomer.helper.DataBaseHelper;
import com.kbrtz.guiaedecomer.guiaedecomer.helper.DbEntry;
import com.kbrtz.guiaedecomer.guiaedecomer.model.Categories;
import com.kbrtz.guiaedecomer.guiaedecomer.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamila.brito on 09/06/2016.
 */
public class CategoryDAO {

    private SQLiteDatabase database;
    private DataBaseHelper dbHelper;
    private String [] allColumns = {DbEntry.CONTACT_ID, DbEntry.CATEGORY_NAME};

    public CategoryDAO(DataBaseHelper dbHelper) {
        this.dbHelper = dbHelper;
        database = this.dbHelper.getWritableDatabase();
    }

    public List<Categories> getAllCategories() {
        List <Categories> categories = new ArrayList<>();

        Cursor cursor = database.query(DbEntry.TABLE_CATEGORY, allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Categories category = cursorToCategory(cursor);
            categories.add(category);
            cursor.moveToNext();
        }
        cursor.close();
        return categories;
    }

    public Categories getContactById (int categoryId) {
        Categories contact = new Categories();

        Cursor cursor = database.query(DbEntry.TABLE_CATEGORY, allColumns,
                DbEntry.CATEGORY_ID + "='" + categoryId + "'", null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            contact = cursorToCategory(cursor);
        }

        return contact;
    }

    public void createCategory(Categories contact) {
        ContentValues values = new ContentValues();
        values.put(DbEntry.CATEGORY_NAME, contact.getName());
        database.insert(DbEntry.TABLE_CATEGORY, null, values);
    }


    private Categories cursorToCategory(Cursor cursor) {
        Categories category = new Categories();
        category.setId(cursor.getInt(0));
        category.setName(cursor.getString(1));
        return category;
    }

    public void closeDatabase () {
        database.close();
    }

}
