package com.kbrtz.guiaedecomer.guiaedecomer.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.kbrtz.guiaedecomer.guiaedecomer.helper.DataBaseHelper;
import com.kbrtz.guiaedecomer.guiaedecomer.helper.DbEntry;
import com.kbrtz.guiaedecomer.guiaedecomer.model.Categories;
import com.kbrtz.guiaedecomer.guiaedecomer.model.WorkingHours;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamila.brito on 09/06/2016.
 */
public class WorkingHoursDAO {

    private SQLiteDatabase database;
    private DataBaseHelper dbHelper;
    private String [] allColumns = {DbEntry.WORKING_HOURS_ID, DbEntry.WORKING_HOURS_WEEKDAY,
            DbEntry.WORKING_HOURS_HOUR_START, DbEntry.WORKING_HOURS_HOUR_FINISH};

    public WorkingHoursDAO(DataBaseHelper dbHelper) {
        this.dbHelper = dbHelper;
        database = this.dbHelper.getWritableDatabase();
    }

    public List<WorkingHours> getAllWorkingHours() {
        List <WorkingHours> workingHourses = new ArrayList<>();

        Cursor cursor = database.query(DbEntry.TABLE_WORKING_HOURS, allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            WorkingHours workingHours = cursorToWorkingHours(cursor);
            workingHourses.add(workingHours);
            cursor.moveToNext();
        }
        cursor.close();
        return workingHourses;
    }

    public WorkingHours getWorkingHoursById(int workingHoursId) {
        WorkingHours workingHours = new WorkingHours();

        Cursor cursor = database.query(DbEntry.TABLE_WORKING_HOURS, allColumns,
                DbEntry.WORKING_HOURS_ID + "='" + workingHoursId + "'", null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            workingHours = cursorToWorkingHours(cursor);
        }

        return workingHours;
    }

    public void createWorkingHours(WorkingHours workingHours) {
        ContentValues values = new ContentValues();
        values.put(DbEntry.WORKING_HOURS_WEEKDAY, workingHours.getWeek_day());
        values.put(DbEntry.WORKING_HOURS_HOUR_START, workingHours.getStart_hour());
        values.put(DbEntry.WORKING_HOURS_HOUR_FINISH, workingHours.getFinish_hour());
        database.insert(DbEntry.TABLE_WORKING_HOURS, null, values);
    }


    private WorkingHours cursorToWorkingHours(Cursor cursor) {
        WorkingHours workingHours = new WorkingHours();
        workingHours.setId(cursor.getInt(0));
        workingHours.setStart_hour(cursor.getString(1));
        workingHours.setFinish_hour(cursor.getString(2));
        workingHours.setWeek_day(cursor.getString(3));
        return workingHours;
    }

    public void closeDatabase () {
        database.close();
    }

}
