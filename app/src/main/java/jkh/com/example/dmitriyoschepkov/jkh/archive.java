package jkh.com.example.dmitriyoschepkov.jkh;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.opengl.EGLDisplay;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class archive extends AppCompatActivity {

    private EditText voda_hol_1, voda_gor_1, vodootvod_1, svet_den_1, svet_noch_1, voda_hol_2, voda_gor_2, vodootvod_2, svet_den_2, svet_noch_2, voda_hol_3, voda_gor_3, vodootvod_3, svet_den_3, svet_noch_3, voda_hol_4, voda_gor_4, vodootvod_4, svet_den_4, svet_noch_4, voda_hol_5, voda_gor_5, vodootvod_5, svet_den_5, svet_noch_5, voda_hol_6, voda_gor_6, vodootvod_6, svet_den_6, svet_noch_6, voda_hol_7, voda_gor_7, vodootvod_7, svet_den_7, svet_noch_7,  voda_hol_8, voda_gor_8, vodootvod_8, svet_den_8, svet_noch_8, voda_hol_9, voda_gor_9, vodootvod_9, svet_den_9, svet_noch_9, voda_hol_10, voda_gor_10, vodootvod_10, svet_den_10, svet_noch_10;
    private TextView text_date, text_result, text_date0, text_result0, text_date1, text_result1, text_date2, text_result2, text_date3, text_result3, text_date4, text_result4, text_date5, text_result5, text_date6, text_result6, text_date7, text_result7, text_date8, text_result8, text_date9, text_result9;
    private DBHelper mDatabaseHelper;
    private DBHelper mDBHelper;
    private SQLiteDatabase mSqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive);
        //card 1
        TextView text_date = (TextView) findViewById(R.id.text_date);
        TextView text_result = (TextView) findViewById(R.id.text_result);
        EditText voda_hol_1 = (EditText)findViewById(R.id.voda_hol_1);
        EditText voda_gor_1 = (EditText)findViewById(R.id.voda_gor_1);
        EditText vodootvod_1 = (EditText)findViewById(R.id.vodootvod_1);
        EditText svet_den_1 = (EditText)findViewById(R.id.svet_den_1);
        EditText svet_noch_1 = (EditText)findViewById(R.id.svet_noch_1);
        text_date.setRawInputType(0x00000000);
        text_result.setRawInputType(0x00000000);
        voda_gor_1.setRawInputType(0x00000000);
        voda_hol_1.setRawInputType(0x00000000);
        vodootvod_1.setRawInputType(0x00000000);
        svet_den_1.setRawInputType(0x00000000);
        svet_noch_1.setRawInputType(0x00000000);
        //card2
        TextView text_date2 = (TextView) findViewById(R.id.text_date2);
        TextView text_result2 = (TextView) findViewById(R.id.text_result2);
        EditText voda_hol_2 = (EditText)findViewById(R.id.voda_hol_2);
        EditText voda_gor_2 = (EditText)findViewById(R.id.voda_gor_2);
        EditText vodootvod_2 = (EditText)findViewById(R.id.vodootvod_2);
        EditText svet_den_2= (EditText)findViewById(R.id.svet_den_2);
        EditText svet_noch_2 = (EditText)findViewById(R.id.svet_noch_2);
        text_date2.setRawInputType(0x00000000);
        text_result2.setRawInputType(0x00000000);
        voda_gor_2.setRawInputType(0x00000000);
        voda_hol_2.setRawInputType(0x00000000);
        vodootvod_2.setRawInputType(0x00000000);
        svet_den_2.setRawInputType(0x00000000);
        svet_noch_2.setRawInputType(0x00000000);
        //card3
        TextView text_date3 = (TextView) findViewById(R.id.text_date3);
        TextView text_result3 = (TextView) findViewById(R.id.text_result3);
        EditText voda_hol_3 = (EditText)findViewById(R.id.voda_hol_3);
        EditText voda_gor_3 = (EditText)findViewById(R.id.voda_gor_3);
        EditText vodootvod_3 = (EditText)findViewById(R.id.vodootvod_3);
        EditText svet_den_3= (EditText)findViewById(R.id.svet_den_3);
        EditText svet_noch_3 = (EditText)findViewById(R.id.svet_noch_3);
        text_date3.setRawInputType(0x00000000);
        text_result3.setRawInputType(0x00000000);
        voda_gor_3.setRawInputType(0x00000000);
        voda_hol_3.setRawInputType(0x00000000);
        vodootvod_3.setRawInputType(0x00000000);
        svet_den_3.setRawInputType(0x00000000);
        svet_noch_3.setRawInputType(0x00000000);
        //card4
        TextView text_date4 = (TextView) findViewById(R.id.text_date4);
        TextView text_result4 = (TextView) findViewById(R.id.text_result4);
        EditText voda_hol_4 = (EditText)findViewById(R.id.voda_hol_4);
        EditText voda_gor_4 = (EditText)findViewById(R.id.voda_gor_4);
        EditText vodootvod_4 = (EditText)findViewById(R.id.vodootvod_4);
        EditText svet_den_4= (EditText)findViewById(R.id.svet_den_4);
        EditText svet_noch_4 = (EditText)findViewById(R.id.svet_noch_4);
        text_date4.setRawInputType(0x00000000);
        text_result4.setRawInputType(0x00000000);
        voda_gor_4.setRawInputType(0x00000000);
        voda_hol_4.setRawInputType(0x00000000);
        vodootvod_4.setRawInputType(0x00000000);
        svet_den_4.setRawInputType(0x00000000);
        svet_noch_4.setRawInputType(0x00000000);
        //card5
        TextView text_date5 = (TextView) findViewById(R.id.text_date5);
        TextView text_result5 = (TextView) findViewById(R.id.text_result5);
        EditText voda_hol_5 = (EditText)findViewById(R.id.voda_hol_5);
        EditText voda_gor_5 = (EditText)findViewById(R.id.voda_gor_5);
        EditText vodootvod_5 = (EditText)findViewById(R.id.vodootvod_5);
        EditText svet_den_5= (EditText)findViewById(R.id.svet_den_5);
        EditText svet_noch_5 = (EditText)findViewById(R.id.svet_noch_5);
        text_date5.setRawInputType(0x00000000);
        text_result5.setRawInputType(0x00000000);
        voda_gor_5.setRawInputType(0x00000000);
        voda_hol_5.setRawInputType(0x00000000);
        vodootvod_5.setRawInputType(0x00000000);
        svet_den_5.setRawInputType(0x00000000);
        svet_noch_5.setRawInputType(0x00000000);
        //card6
        TextView text_date6 = (TextView) findViewById(R.id.text_date6);
        TextView text_result6 = (TextView) findViewById(R.id.text_result6);
        EditText voda_hol_6 = (EditText)findViewById(R.id.voda_hol_6);
        EditText voda_gor_6 = (EditText)findViewById(R.id.voda_gor_6);
        EditText vodootvod_6 = (EditText)findViewById(R.id.vodootvod_6);
        EditText svet_den_6= (EditText)findViewById(R.id.svet_den_6);
        EditText svet_noch_6 = (EditText)findViewById(R.id.svet_noch_6);
        text_date6.setRawInputType(0x00000000);
        text_result6.setRawInputType(0x00000000);
        voda_gor_6.setRawInputType(0x00000000);
        voda_hol_6.setRawInputType(0x00000000);
        vodootvod_6.setRawInputType(0x00000000);
        svet_den_6.setRawInputType(0x00000000);
        svet_noch_6.setRawInputType(0x00000000);
        //card7
        TextView text_date7 = (TextView) findViewById(R.id.text_date7);
        TextView text_result7 = (TextView) findViewById(R.id.text_result7);
        EditText voda_hol_7 = (EditText)findViewById(R.id.voda_hol_7);
        EditText voda_gor_7 = (EditText)findViewById(R.id.voda_gor_7);
        EditText vodootvod_7 = (EditText)findViewById(R.id.vodootvod_7);
        EditText svet_den_7= (EditText)findViewById(R.id.svet_den_7);
        EditText svet_noch_7 = (EditText)findViewById(R.id.svet_noch_7);
        text_date7.setRawInputType(0x00000000);
        text_result7.setRawInputType(0x00000000);
        voda_gor_7.setRawInputType(0x00000000);
        voda_hol_7.setRawInputType(0x00000000);
        vodootvod_7.setRawInputType(0x00000000);
        svet_den_7.setRawInputType(0x00000000);
        svet_noch_7.setRawInputType(0x00000000);
        //card8
        TextView text_date8 = (TextView) findViewById(R.id.text_date8);
        TextView text_result8 = (TextView) findViewById(R.id.text_result8);
        EditText voda_hol_8 = (EditText)findViewById(R.id.voda_hol_8);
        EditText voda_gor_8 = (EditText)findViewById(R.id.voda_gor_8);
        EditText vodootvod_8 = (EditText)findViewById(R.id.vodootvod_8);
        EditText svet_den_8= (EditText)findViewById(R.id.svet_den_8);
        EditText svet_noch_8 = (EditText)findViewById(R.id.svet_noch_8);
        text_date8.setRawInputType(0x00000000);
        text_result8.setRawInputType(0x00000000);
        voda_gor_8.setRawInputType(0x00000000);
        voda_hol_8.setRawInputType(0x00000000);
        vodootvod_8.setRawInputType(0x00000000);
        svet_den_8.setRawInputType(0x00000000);
        svet_noch_8.setRawInputType(0x00000000);
        //card9
        TextView text_date9 = (TextView) findViewById(R.id.text_date9);
        TextView text_result9 = (TextView) findViewById(R.id.text_result9);
        EditText voda_hol_9 = (EditText)findViewById(R.id.voda_hol_9);
        EditText voda_gor_9 = (EditText)findViewById(R.id.voda_gor_9);
        EditText vodootvod_9 = (EditText)findViewById(R.id.vodootvod_9);
        EditText svet_den_9= (EditText)findViewById(R.id.svet_den_9);
        EditText svet_noch_9 = (EditText)findViewById(R.id.svet_noch_9);
        text_date9.setRawInputType(0x00000000);
        text_result9.setRawInputType(0x00000000);
        voda_gor_9.setRawInputType(0x00000000);
        voda_hol_9.setRawInputType(0x00000000);
        vodootvod_9.setRawInputType(0x00000000);
        svet_den_9.setRawInputType(0x00000000);
        svet_noch_9.setRawInputType(0x00000000);
        //card10
        TextView text_date0 = (TextView) findViewById(R.id.text_date0);
        TextView text_result0 = (TextView) findViewById(R.id.text_result0);
        EditText voda_hol_10 = (EditText)findViewById(R.id.voda_hol_10);
        EditText voda_gor_10 = (EditText)findViewById(R.id.voda_gor_10);
        EditText vodootvod_10 = (EditText)findViewById(R.id.vodootvod_10);
        EditText svet_den_10= (EditText)findViewById(R.id.svet_den_10);
        EditText svet_noch_10 = (EditText)findViewById(R.id.svet_noch_10);
        text_date0.setRawInputType(0x00000000);
        text_result0.setRawInputType(0x00000000);
        voda_gor_10.setRawInputType(0x00000000);
        voda_hol_10.setRawInputType(0x00000000);
        vodootvod_10.setRawInputType(0x00000000);
        svet_den_10.setRawInputType(0x00000000);
        svet_noch_10.setRawInputType(0x00000000);
        mDatabaseHelper = new DBHelper(this, "mydb.db", null, 1);
        mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();
        Cursor cursor = mSqLiteDatabase.query("jkh", new String[] {DBHelper.VODA_GOR_COLUMN, DBHelper.VODA_HOL_COLUMN, DBHelper.VODOOTVOD_COLUMN, DBHelper.SVET_DEN_COLUMN, DBHelper.SVET_NOCH_COLUMN, DBHelper.RESULT_COLUMN, DBHelper.DATE_COLUMN},
                null, null, null, null, null, null);
        cursor.moveToLast();
        String text_date_b1 = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        String text_result_b1 = cursor.getString(cursor.getColumnIndex(DBHelper.RESULT_COLUMN));
        String voda_hol_b1 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_HOL_COLUMN));
        String voda_gor_b1 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_GOR_COLUMN));
        String vodootvod_b1 = cursor.getString(cursor.getColumnIndex(DBHelper.VODOOTVOD_COLUMN));
        String svet_den_b1 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        String svet_noch_b1 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        cursor.moveToPrevious();
        String text_date_b2 = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        String text_result_b2 = cursor.getString(cursor.getColumnIndex(DBHelper.RESULT_COLUMN));
        String voda_hol_b2 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_HOL_COLUMN));
        String voda_gor_b2 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_GOR_COLUMN));
        String vodootvod_b2 = cursor.getString(cursor.getColumnIndex(DBHelper.VODOOTVOD_COLUMN));
        String svet_den_b2 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        String svet_noch_b2 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        cursor.moveToPrevious();
        String text_date_b3 = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        String text_result_b3 = cursor.getString(cursor.getColumnIndex(DBHelper.RESULT_COLUMN));
        String voda_hol_b3 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_HOL_COLUMN));
        String voda_gor_b3 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_GOR_COLUMN));
        String vodootvod_b3 = cursor.getString(cursor.getColumnIndex(DBHelper.VODOOTVOD_COLUMN));
        String svet_den_b3 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        String svet_noch_b3 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        cursor.moveToPrevious();
        String text_date_b4 = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        String text_result_b4 = cursor.getString(cursor.getColumnIndex(DBHelper.RESULT_COLUMN));
        String voda_hol_b4 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_HOL_COLUMN));
        String voda_gor_b4 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_GOR_COLUMN));
        String vodootvod_b4 = cursor.getString(cursor.getColumnIndex(DBHelper.VODOOTVOD_COLUMN));
        String svet_den_b4 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        String svet_noch_b4 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        cursor.moveToPrevious();
        String text_date_b5 = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        String text_result_b5 = cursor.getString(cursor.getColumnIndex(DBHelper.RESULT_COLUMN));
        String voda_hol_b5 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_HOL_COLUMN));
        String voda_gor_b5 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_GOR_COLUMN));
        String vodootvod_b5 = cursor.getString(cursor.getColumnIndex(DBHelper.VODOOTVOD_COLUMN));
        String svet_den_b5 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        String svet_noch_b5 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        cursor.moveToPrevious();
        String text_date_b6 = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        String text_result_b6 = cursor.getString(cursor.getColumnIndex(DBHelper.RESULT_COLUMN));
        String voda_hol_b6 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_HOL_COLUMN));
        String voda_gor_b6 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_GOR_COLUMN));
        String vodootvod_b6 = cursor.getString(cursor.getColumnIndex(DBHelper.VODOOTVOD_COLUMN));
        String svet_den_b6 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        String svet_noch_b6 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        cursor.moveToPrevious();
        String text_date_b7 = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        String text_result_b7 = cursor.getString(cursor.getColumnIndex(DBHelper.RESULT_COLUMN));
        String voda_hol_b7 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_HOL_COLUMN));
        String voda_gor_b7 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_GOR_COLUMN));
        String vodootvod_b7 = cursor.getString(cursor.getColumnIndex(DBHelper.VODOOTVOD_COLUMN));
        String svet_den_b7 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        String svet_noch_b7 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        cursor.moveToPrevious();
        String text_date_b8 = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        String text_result_b8 = cursor.getString(cursor.getColumnIndex(DBHelper.RESULT_COLUMN));
        String voda_hol_b8 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_HOL_COLUMN));
        String voda_gor_b8 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_GOR_COLUMN));
        String vodootvod_b8 = cursor.getString(cursor.getColumnIndex(DBHelper.VODOOTVOD_COLUMN));
        String svet_den_b8 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        String svet_noch_b8 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        cursor.moveToPrevious();
        String text_date_b9 = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        String text_result_b9 = cursor.getString(cursor.getColumnIndex(DBHelper.RESULT_COLUMN));
        String voda_hol_b9 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_HOL_COLUMN));
        String voda_gor_b9 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_GOR_COLUMN));
        String vodootvod_b9 = cursor.getString(cursor.getColumnIndex(DBHelper.VODOOTVOD_COLUMN));
        String svet_den_b9 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        String svet_noch_b9 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        cursor.moveToPrevious();
        String text_date_b10 = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        String text_result_b10 = cursor.getString(cursor.getColumnIndex(DBHelper.RESULT_COLUMN));
        String voda_hol_b10 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_HOL_COLUMN));
        String voda_gor_b10 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_GOR_COLUMN));
        String vodootvod_b10 = cursor.getString(cursor.getColumnIndex(DBHelper.VODOOTVOD_COLUMN));
        String svet_den_b10 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        String svet_noch_b10 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        cursor.close();
        text_date.setText(text_date_b1);
        text_date.setTextSize(20);
        text_result.setText(text_result_b1+" p.");
        text_result.setTextSize(20);
        voda_hol_1.setText(voda_hol_b1);
        voda_gor_1.setText(voda_gor_b1);
        vodootvod_1.setText(vodootvod_b1);
        svet_den_1.setText(svet_den_b1);
        svet_noch_1.setText(svet_noch_b1);
        text_date2.setText(text_date_b2);
        text_date2.setTextSize(20);
        text_result2.setText(text_result_b2+" p.");
        text_result2.setTextSize(20);
        voda_hol_2.setText(voda_hol_b2);
        voda_gor_2.setText(voda_gor_b2);
        vodootvod_2.setText(vodootvod_b2);
        svet_den_2.setText(svet_den_b2);
        svet_noch_2.setText(svet_noch_b2);
        text_date3.setText(text_date_b3);
        text_date3.setTextSize(20);
        text_result3.setText(text_result_b3+" p.");
        text_result3.setTextSize(20);
        voda_hol_3.setText(voda_hol_b3);
        voda_gor_3.setText(voda_gor_b3);
        vodootvod_3.setText(vodootvod_b3);
        svet_den_3.setText(svet_den_b3);
        svet_noch_3.setText(svet_noch_b3);
        text_date4.setText(text_date_b4);
        text_date4.setTextSize(20);
        text_result4.setText(text_result_b4+" p.");
        text_result4.setTextSize(20);
        voda_hol_4.setText(voda_hol_b4);
        voda_gor_4.setText(voda_gor_b4);
        vodootvod_4.setText(vodootvod_b4);
        svet_den_4.setText(svet_den_b4);
        svet_noch_4.setText(svet_noch_b4);
        text_date5.setText(text_date_b5);
        text_date5.setTextSize(20);
        text_result5.setText(text_result_b5+" p.");
        text_result5.setTextSize(20);
        voda_hol_5.setText(voda_hol_b5);
        voda_gor_5.setText(voda_gor_b5);
        vodootvod_5.setText(vodootvod_b5);
        svet_den_5.setText(svet_den_b5);
        svet_noch_5.setText(svet_noch_b5);
        text_date6.setText(text_date_b6);
        text_date6.setTextSize(20);
        text_result6.setText(text_result_b6+" p.");
        text_result6.setTextSize(20);
        voda_hol_6.setText(voda_hol_b6);
        voda_gor_6.setText(voda_gor_b6);
        vodootvod_6.setText(vodootvod_b6);
        svet_den_6.setText(svet_den_b6);
        svet_noch_6.setText(svet_noch_b6);
        text_date7.setText(text_date_b7);
        text_date7.setTextSize(20);
        text_result7.setText(text_result_b7+" p.");
        text_result7.setTextSize(20);
        voda_hol_7.setText(voda_hol_b7);
        voda_gor_7.setText(voda_gor_b7);
        vodootvod_7.setText(vodootvod_b7);
        svet_den_7.setText(svet_den_b7);
        svet_noch_7.setText(svet_noch_b7);
        text_date8.setText(text_date_b8);
        text_date8.setTextSize(20);
        text_result8.setText(text_result_b8+" p.");
        text_result8.setTextSize(20);
        voda_hol_8.setText(voda_hol_b8);
        voda_gor_8.setText(voda_gor_b8);
        vodootvod_8.setText(vodootvod_b8);
        svet_den_8.setText(svet_den_b8);
        svet_noch_8.setText(svet_noch_b8);
        text_date9.setText(text_date_b9);
        text_date9.setTextSize(20);
        text_result9.setText(text_result_b9+" p.");
        text_result9.setTextSize(20);
        voda_hol_9.setText(voda_hol_b9);
        voda_gor_9.setText(voda_gor_b9);
        vodootvod_9.setText(vodootvod_b9);
        svet_den_9.setText(svet_den_b9);
        svet_noch_9.setText(svet_noch_b9);
        text_date0.setText(text_date_b10);
        text_date0.setTextSize(20);
        text_result0.setText(text_result_b10+" p.");
        text_result0.setTextSize(20);
        voda_hol_10.setText(voda_hol_b10);
        voda_gor_10.setText(voda_gor_b10);
        vodootvod_10.setText(vodootvod_b10);
        svet_den_10.setText(svet_den_b10);
        svet_noch_10.setText(svet_noch_b10);
    }
}
