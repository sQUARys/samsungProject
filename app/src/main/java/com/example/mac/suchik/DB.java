package com.example.mac.suchik;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DB {

    private static final String DB_NAME = "clothes";
    private static final int DB_VERSION = 1;
    private static final String DB_TABLE = "clothes";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TEMP_MAX = "tempMax";
    public static final String COLUMN_TEMP_MIN = "tempMin";
    public static final String COLUMN_RAIN = "rain";
    public static final String COLUMN_WIND = "wind";
    public static final String COLUMN_CLOUD = "cloud";
    public static final String COLUMN_COLOR = "color";


    private static final String CATEGORY_TABLE_NAME = "categories";
    public static final String CATEGORY_COLUMN_ID = "_id";
    public static final String CATEGORY_COLUMN_NAME = "name";


    private static final String CATEGORY_TABLE_CREATE =
            "CREATE TABLE " + CATEGORY_TABLE_NAME + "(" +
                    CATEGORY_COLUMN_ID + " integer primary key autoincrement, " +
                    CATEGORY_COLUMN_NAME + " varchar(255) "
                    + ");";

    private static final String DB_CREATE =
            "create table " + DB_TABLE + "(" +
                    COLUMN_ID + " integer primary key autoincrement, " +
                    COLUMN_CATEGORY + " integer, " +
                    COLUMN_NAME + " text, " +
                    COLUMN_TEMP_MIN + " integer, " +
                    COLUMN_TEMP_MAX + " integer, " +
                    COLUMN_RAIN + " integer, " +
                    COLUMN_WIND + " integer, " +
                    COLUMN_CLOUD + "integer, " +
                    COLUMN_COLOR + " text, " +
                    "FOREIGN KEY (" + COLUMN_CATEGORY + ") REFERENCES " + CATEGORY_TABLE_NAME + "(" + CATEGORY_COLUMN_ID + ")" +
                    ");";


    private final Context mCtx;


    private DBHelper mDBHelper;
    private SQLiteDatabase mDB;


    public DB(Context ctx) {
        mCtx = ctx;
    }

    // открыть подключение
    public void open() {
        mDBHelper = new DBHelper(mCtx, DB_NAME, null, DB_VERSION);
        mDB = mDBHelper.getWritableDatabase();
    }

    // закрыть подключение
    public void close() {
        if (mDBHelper != null) mDBHelper.close();
    }


    // получить данные из таблицы DB_TABLE
    public Cursor getData(String name, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return mDB.query(name, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    // класс по созданию и управлению БД
    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, CursorFactory factory,
                        int version) {
            super(context, name, factory, version);
        }

        // создаем и заполняем БД
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CATEGORY_TABLE_CREATE);
            db.execSQL(DB_CREATE);
            db.execSQL("alter table clothes add column cloud;");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("alter table clothes add column cloud;");
        }
    }
}
