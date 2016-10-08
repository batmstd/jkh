package jkh.com.example.dmitriyoschepkov.jkh;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main2Activity extends AppCompatActivity {


    private EditText vg;
    private EditText vh;
    private EditText sd;
    private EditText sn;
    private TextView result1;
    private DBHelper mDatabaseHelper1;
    private DBHelper mDBHelper;
    private SQLiteDatabase mSqLiteDatabase1;
    private EditText pole;
    private EditText avg, avh, asd, asn, ar;
    private TextView a10, a9, a8, a7, a6, a5, a4, a3, a2, a1;
    private TextView c10;

    GridView gridView, gridView2;
    ArrayAdapter<String> adapter, adapterm1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText avg = (EditText)findViewById(R.id.avg);
        EditText avh = (EditText)findViewById(R.id.avh);
        EditText asn = (EditText)findViewById(R.id.asn);
        EditText asd = (EditText)findViewById(R.id.asd);
        EditText ar = (EditText)findViewById(R.id.ar);
        TextView a10 = (TextView)findViewById(R.id.a10);
        TextView a9 = (TextView)findViewById(R.id.a9);
        TextView a8 = (TextView)findViewById(R.id.a8);
        TextView a7 = (TextView)findViewById(R.id.a7);
        TextView a6 = (TextView)findViewById(R.id.a6);
        TextView a5 = (TextView)findViewById(R.id.a5);
        TextView a4 = (TextView)findViewById(R.id.a4);
        TextView a3 = (TextView)findViewById(R.id.a3);
        TextView a2 = (TextView)findViewById(R.id.a2);
        TextView a1 = (TextView)findViewById(R.id.a1);
        avg.setRawInputType(0x00000000);
        avh.setRawInputType(0x00000000);
        asn.setRawInputType(0x00000000);
        asd.setRawInputType(0x00000000);
        ar.setRawInputType(0x00000000);
        mDatabaseHelper1 = new DBHelper(this, "mydb.db", null, 1);
        mSqLiteDatabase1 = mDatabaseHelper1.getWritableDatabase();
        Cursor cursor = mSqLiteDatabase1.query("jkh", new String[] {DBHelper.VODA_GOR_COLUMN, DBHelper.VODA_HOL_COLUMN, DBHelper.VODOOTVOD_COLUMN, DBHelper.SVET_DEN_COLUMN, DBHelper.SVET_NOCH_COLUMN, DBHelper.RESULT_COLUMN, DBHelper.DATE_COLUMN},
                null, null, null, null, null, null);
        cursor.moveToLast();
        String date10 = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        cursor.moveToPrevious();
        String date9 = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        cursor.moveToPrevious();
        String date8 = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        cursor.moveToPrevious();
        String date7 = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
         cursor.moveToPrevious();
        String date6 = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        cursor.moveToPrevious();
        String date5 = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        cursor.moveToPrevious();
        String date4 = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        cursor.moveToPrevious();
        String date3 = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        cursor.moveToPrevious();
        String date2 = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        cursor.moveToPrevious();
        String date1 = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        cursor.close();
        a10.setText(date10);
        a9.setText(date9);
        a8.setText(date8);
        /**a7.setText(date7);
        a6.setText(date6);
        a5.setText(date5);
        a4.setText(date4);
        a3.setText(date3);
        a2.setText(date2);
        a1.setText(date1);**/




       /** mDatabaseHelper1 = new DBHelper(this, "mydb.db", null, 1);
        mSqLiteDatabase1 = mDatabaseHelper1.getWritableDatabase();
        Cursor cursor = mSqLiteDatabase1.query("jkh", new String[] {DBHelper.VODA_GOR_COLUMN, DBHelper.VODA_HOL_COLUMN, DBHelper.VODOOTVOD_COLUMN, DBHelper.SVET_DEN_COLUMN, DBHelper.SVET_NOCH_COLUMN, DBHelper.RESULT_COLUMN, DBHelper.DATE_COLUMN},
                null, null, null, null, null, null);
        cursor.moveToLast();
        String voda_gor = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_GOR_COLUMN));
        String voda_hol = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_HOL_COLUMN));
        double vodootvod = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODOOTVOD_COLUMN));
        double svet_noch = cursor.getDouble(cursor.getColumnIndex(DBHelper.SVET_NOCH_COLUMN));
        double svet_den = cursor.getDouble(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        String result = cursor.getString(cursor.getColumnIndex(DBHelper.RESULT_COLUMN));
        String date = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        cursor.moveToPrevious();
        String voda_gor_m1 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_GOR_COLUMN));
        String voda_hol_m1 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_HOL_COLUMN));
        cursor.close();
        String[] last = {date, result};
        String[] m1 = {voda_gor_m1, voda_hol_m1};
        adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.tvText, last);
        //gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(adapter);
        adapterm1 = new ArrayAdapter<String>(this, R.layout.item, R.id.tvText, m1);
       // gridView2 = (GridView)findViewById(R.id.gridView2);
        gridView2.setAdapter(adapterm1);
        adjustGridView();

    }
    private void adjustGridView() {
        gridView.setNumColumns(2);
        gridView2.setNumColumns(2);

**/


}
    public void c10(View view){
        TextView a10 = (TextView)findViewById(R.id.a10);
        TextView a9 = (TextView)findViewById(R.id.a9);
        TextView a8 = (TextView)findViewById(R.id.a8);
        EditText avg = (EditText)findViewById(R.id.avg);
        EditText avh = (EditText)findViewById(R.id.avh);
        EditText asn = (EditText)findViewById(R.id.asn);
        EditText asd = (EditText)findViewById(R.id.asd);
        EditText ar = (EditText)findViewById(R.id.ar);
        a10.setTextSize(35);
        a9.setTextSize(20);
        a8.setTextSize(20);
        Cursor cursor = mSqLiteDatabase1.query("jkh", new String[] {DBHelper.VODA_GOR_COLUMN, DBHelper.VODA_HOL_COLUMN, DBHelper.VODOOTVOD_COLUMN, DBHelper.SVET_DEN_COLUMN, DBHelper.SVET_NOCH_COLUMN, DBHelper.RESULT_COLUMN, DBHelper.DATE_COLUMN},
                null, null, null, null, null, null);
        cursor.moveToLast();

        String avg10 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_GOR_COLUMN));
        String avh10 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_HOL_COLUMN));
        String asn10 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_NOCH_COLUMN));
        String asd10 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        String ar10 = cursor.getString(cursor.getColumnIndex(DBHelper.RESULT_COLUMN));
        //cursor.close();
        BigDecimal arx = new BigDecimal(ar10);
       arx = arx.setScale(2,BigDecimal.ROUND_HALF_DOWN);
        avg.setText(""+avg10);
        avh.setText(""+avh10);
        asn.setText(""+asn10);
        asd.setText(""+asd10);
        ar.setText(""+arx+" p.");

    }

    public void c9(View view){
        TextView a10 = (TextView)findViewById(R.id.a10);
        TextView a9 = (TextView)findViewById(R.id.a9);
        TextView a8 = (TextView)findViewById(R.id.a8);
        EditText avg = (EditText)findViewById(R.id.avg);
        EditText avh = (EditText)findViewById(R.id.avh);
        EditText asn = (EditText)findViewById(R.id.asn);
        EditText asd = (EditText)findViewById(R.id.asd);
        EditText ar = (EditText)findViewById(R.id.ar);
        a10.setTextSize(20);
        a9.setTextSize(35);
        a8.setTextSize(20);
        Cursor cursor = mSqLiteDatabase1.query("jkh", new String[] {DBHelper.VODA_GOR_COLUMN, DBHelper.VODA_HOL_COLUMN, DBHelper.VODOOTVOD_COLUMN, DBHelper.SVET_DEN_COLUMN, DBHelper.SVET_NOCH_COLUMN, DBHelper.RESULT_COLUMN, DBHelper.DATE_COLUMN},
                null, null, null, null, null, null);
        cursor.moveToLast();
        cursor.moveToPrevious();

        String avg9 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_GOR_COLUMN));
        String avh9 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_HOL_COLUMN));
        String asn9 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_NOCH_COLUMN));
        String asd9 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        String ar9 = cursor.getString(cursor.getColumnIndex(DBHelper.RESULT_COLUMN));
        //cursor.close();
        BigDecimal arx = new BigDecimal(ar9);
        arx = arx.setScale(2,BigDecimal.ROUND_HALF_DOWN);
        avg.setText(""+avg9);
        avh.setText(""+avh9);
        asn.setText(""+asn9);
        asd.setText(""+asd9);
        ar.setText(""+arx+" p.");

    }
    public void c8(View view){
        TextView a10 = (TextView)findViewById(R.id.a10);
        TextView a9 = (TextView)findViewById(R.id.a9);
        TextView a8 = (TextView)findViewById(R.id.a8);
        EditText avg = (EditText)findViewById(R.id.avg);
        EditText avh = (EditText)findViewById(R.id.avh);
        EditText asn = (EditText)findViewById(R.id.asn);
        EditText asd = (EditText)findViewById(R.id.asd);
        EditText ar = (EditText)findViewById(R.id.ar);
        a10.setTextSize(20);
        a9.setTextSize(20);
        a8.setTextSize(35);
        Cursor cursor = mSqLiteDatabase1.query("jkh", new String[] {DBHelper.VODA_GOR_COLUMN, DBHelper.VODA_HOL_COLUMN, DBHelper.VODOOTVOD_COLUMN, DBHelper.SVET_DEN_COLUMN, DBHelper.SVET_NOCH_COLUMN, DBHelper.RESULT_COLUMN, DBHelper.DATE_COLUMN},
                null, null, null, null, null, null);
        cursor.moveToLast();
        cursor.moveToPrevious();
        cursor.moveToPrevious();

        String avg8 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_GOR_COLUMN));
        String avh8 = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_HOL_COLUMN));
        String asn8 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_NOCH_COLUMN));
        String asd8 = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        String ar8 = cursor.getString(cursor.getColumnIndex(DBHelper.RESULT_COLUMN));
        //cursor.close();
        BigDecimal arx = new BigDecimal(ar8);
        arx = arx.setScale(2,BigDecimal.ROUND_HALF_DOWN);
        avg.setText(""+avg8);
        avh.setText(""+avh8);
        asn.setText(""+asn8);
        asd.setText(""+asd8);
        ar.setText(""+arx+" p.");

    }
}
