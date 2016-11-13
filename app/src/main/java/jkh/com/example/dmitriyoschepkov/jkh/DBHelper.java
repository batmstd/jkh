package jkh.com.example.dmitriyoschepkov.jkh;

/**
 * Created by Dmitriy.Oschepkov on 18.04.2016.
 */

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by Dmitriy.Oschepkov on 13.04.2016.
 */
public class DBHelper extends SQLiteOpenHelper implements BaseColumns {


    //name BD
    private static final String DATABASE_NAME = "mydb.db";
    //version
    public static final int DATABASE_VERSION = 3;


    //name  table
    public static final String DATABASE_TABLE = "jkh";
    public static final String DATABASE_TABLE2 = "tarif";
    //name column
    public static final String VODA_GOR_COLUMN = "voda_gor";
    public static final String VODA_HOL_COLUMN = "voda_hol";
    public static final String VODOOTVOD_COLUMN = "vodootvod";
    public static final String SVET_NOCH_COLUMN = "svet_noch";
    public static final String SVET_DEN_COLUMN = "svet_den";
    public static final String RESULT_COLUMN = "result";
    public static final String DATE_COLUMN = "date";
    public static final String VODA_HOL_TARIF_COLUMN = "tarif_vh";
    public static final String VODA_GOR_TARIF_COLUMN = "tarif_vg";
    public static final String SVET_DEN_TARIF_COLUMN = "tarif_sd";
    public static final String SVET_NOCH_TARIF_COLUMN = "tarif_sh";
    public static final String VODOOTVOD_TARIF_COLUMN = "tarif_vo";
    //create
   private static final String DATABASE_CREATE_SCRIPT = "create table "
            + DATABASE_TABLE + " (" +BaseColumns._ID
            + " integer primary key autoincrement, " + VODA_GOR_COLUMN
            + " CHAR, " + VODA_HOL_COLUMN
            + " CHAR, " +VODOOTVOD_COLUMN
            + " CHAR, " +SVET_NOCH_COLUMN
            + " CHAR, " +SVET_DEN_COLUMN
            + " money, " +RESULT_COLUMN
            + " CHAR, " +DATE_COLUMN
            + " date);";
    private static final String DATABASE_CREATE_SCRIPT2 = "create table IF NOT EXISTS "
            + DATABASE_TABLE2 + " (" + VODA_GOR_TARIF_COLUMN
            + " CHAR, " + VODA_HOL_TARIF_COLUMN
            + " CHAR, " + SVET_DEN_TARIF_COLUMN
            + " CHAR, " + SVET_NOCH_TARIF_COLUMN
            + " CHAR, " + VODOOTVOD_TARIF_COLUMN
            + " CHAR);";

            DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler){
        super(context, name, factory, version, errorHandler);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DATABASE_CREATE_SCRIPT);
        db.execSQL(DATABASE_CREATE_SCRIPT2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Запишем в журнал
        Log.w("SQLite", "Обновляемся с версии " + oldVersion + " на версию " + newVersion);

        // Удаляем старую таблицу и создаём новую
        /*db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE2);
        // Создаём новую таблицу
        onCreate(db);*/
    }
    @Override
    public void onDowngrade (SQLiteDatabase db, int oldVersion, int newVersion){

    }
}

