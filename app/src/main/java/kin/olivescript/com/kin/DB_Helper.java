package kin.olivescript.com.kin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sudaraka on 10/12/16.
 */
public class    DB_Helper extends SQLiteOpenHelper {
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Contract.Items.TABLE_NAME + " (" +
                    Contract.Items._ID + " INTEGER PRIMARY KEY," +
                    Contract.Items.COLUMN_NAME_LIST + TEXT_TYPE + COMMA_SEP +
                    Contract.Items.COLUMN_NAME_ITEM + TEXT_TYPE +COMMA_SEP +
                    Contract.Items.COLUMN_NAME_ID + "INTEGER" +COMMA_SEP +
                    Contract.Items.COLUMN_NAME_QUANTITY + TEXT_TYPE + COMMA_SEP +
                    Contract.Items.COLUMN_NAME_SYNCED + "BOOLEAN" + COMMA_SEP +
                    Contract.Items.COLUMN_NAME_DELETED + "BOOLEAN" + COMMA_SEP +
                    Contract.Items.COLUMN_NAME_DELETEREQUESTED + TEXT_TYPE + COMMA_SEP + " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Contract.Items.TABLE_NAME;

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "kin.db";

    public DB_Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


}