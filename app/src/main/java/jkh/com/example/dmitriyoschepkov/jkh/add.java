package jkh.com.example.dmitriyoschepkov.jkh;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class add extends AppCompatActivity {
    private EditText voda_gor_new;
    private EditText voda_hol_new;
    private EditText svet_den_new;
    private EditText svet_noch_new;
    private EditText voda_gor_old;
    private EditText voda_hol_old;
    private EditText svet_den_old;
    private EditText svet_noch_old;
    public DBHelper mDatabaseHelper;
    public DBHelper mDBHelper;
    public SQLiteDatabase mSqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAdd);
        mDatabaseHelper = new DBHelper(this, "mydb.db", null, 1);
        mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();
        voda_gor_new = (EditText)findViewById(R.id.voda_gor_new);
        voda_hol_new = (EditText)findViewById(R.id.voda_hol_new);
        svet_den_new = (EditText)findViewById(R.id.svet_den_new);
        svet_noch_new = (EditText)findViewById(R.id.svet_noch_new);
        voda_gor_old = (EditText)findViewById(R.id.voda_gor_old);
        voda_hol_old = (EditText)findViewById(R.id.voda_hol_old);
        svet_den_old = (EditText)findViewById(R.id.svet_den_old);
        svet_noch_old = (EditText)findViewById(R.id.svet_noch_old);
        voda_gor_old.setRawInputType(0x00000000);
        voda_hol_old.setRawInputType(0x00000000);
        svet_den_old.setRawInputType(0x00000000);
        svet_noch_old.setRawInputType(0x00000000);
        Cursor cursor;
        cursor = mSqLiteDatabase.query("jkh", new String[]{DBHelper.VODA_GOR_COLUMN, DBHelper.VODA_HOL_COLUMN, DBHelper.VODOOTVOD_COLUMN, DBHelper.SVET_DEN_COLUMN, DBHelper.SVET_NOCH_COLUMN, DBHelper.RESULT_COLUMN, DBHelper.DATE_COLUMN},
                null, null, null, null, null, null);
        cursor.moveToLast();
        double voda_gor = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODA_GOR_COLUMN));
        double voda_hol = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODA_HOL_COLUMN));
        double svet_noch = cursor.getDouble(cursor.getColumnIndex(DBHelper.SVET_NOCH_COLUMN));
        double svet_den = cursor.getDouble(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        cursor.close();
        voda_hol_old.setText(""+voda_hol);

        voda_gor_old.setText(""+voda_gor);
        svet_den_old.setText(""+svet_den);
        svet_noch_old.setText(""+svet_noch);
    }
    public void onClickAdd(View view){
         //читаем с таблицы последние значения с БД
         Cursor cursor;
         cursor = mSqLiteDatabase.query("jkh", new String[]{DBHelper.VODA_GOR_COLUMN, DBHelper.VODA_HOL_COLUMN, DBHelper.VODOOTVOD_COLUMN, DBHelper.SVET_DEN_COLUMN, DBHelper.SVET_NOCH_COLUMN, DBHelper.RESULT_COLUMN, DBHelper.DATE_COLUMN},
         null, null, null, null, null, null);
         cursor.moveToLast();
         double voda_gor = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODA_GOR_COLUMN));
         double voda_hol = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODA_HOL_COLUMN));
         double svet_noch = cursor.getDouble(cursor.getColumnIndex(DBHelper.SVET_NOCH_COLUMN));
         double svet_den = cursor.getDouble(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        int strok = cursor.getCount();
        System.out.println(strok);
         cursor.close();
         //Вводим новые переменные, считываем данные с полей
         double nvg, nvh, nsn, nsd, x;
         String voda_gor_new1 = voda_gor_new.getText().toString();
         String voda_hol_new1 = voda_hol_new.getText().toString();
         String svet_noch_new1 = svet_noch_new.getText().toString();
         String svet_den_new1 = svet_den_new.getText().toString();

         nvg = Double.parseDouble(voda_gor_new1);
         nvh = Double.parseDouble(voda_hol_new1);
         nsn = Double.parseDouble(svet_noch_new1);
         nsd = Double.parseDouble(svet_den_new1);
         //тарифы

         cursor = mSqLiteDatabase.query("tarif", new String[] {DBHelper.VODA_GOR_TARIF_COLUMN, DBHelper.VODA_HOL_TARIF_COLUMN, DBHelper.SVET_DEN_TARIF_COLUMN, DBHelper.SVET_NOCH_TARIF_COLUMN, DBHelper.VODOOTVOD_TARIF_COLUMN},
         null, null, null, null, null);
         cursor.moveToPosition(0);

         double tarif_vh = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODA_HOL_TARIF_COLUMN));
         double tarif_vg = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODA_GOR_TARIF_COLUMN));
         double tarif_sd = cursor.getDouble(cursor.getColumnIndex(DBHelper.SVET_DEN_TARIF_COLUMN));
         double tarif_sn = cursor.getDouble(cursor.getColumnIndex(DBHelper.SVET_NOCH_TARIF_COLUMN));
         double tarif_vo = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODOOTVOD_TARIF_COLUMN));
         cursor.close();
         //подсчеты
         double rvo = ((nvg-voda_gor)+(nvh-voda_hol));
         double voda = ((nvg-voda_gor)*tarif_vg)+((nvh-voda_hol)*tarif_vh)+(rvo*tarif_vo);
         double svet = ((nsn-svet_noch)*tarif_sn)+((nsd-svet_den)*tarif_sd);
         x = (voda+svet);
         BigDecimal z = new BigDecimal(x);
         z = z.setScale(2,BigDecimal.ROUND_HALF_DOWN);
         //String S = Double.toString(z);
         //result1.setText(z+" р.");

         Date currentDate = new Date();
         SimpleDateFormat dateFormat = null;
         dateFormat = new SimpleDateFormat("MM.yyyy");




        // mDatabaseHelper = new DBHelper(this);
        mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();
        /**String insertNew = "INSERT INTO 'jkh' (voda_gor, voda_hol, vodootvod, svet_den, svet_noch, result, date) values " +
                "(" +
                nvg +
                ", " +
                nvh +
                ", " +
                rvo +
                ", " +
                nsd +
                ", " +
                nsn +
                ", " +
                x +
                ", " +
                dateFormat.format(currentDate) +
                ");";
        mSqLiteDatabase.execSQL(insertNew);**/
        String insertQuery = "INSERT INTO 'jkh' (voda_gor, voda_hol, vodootvod, svet_den, svet_noch, result, date) values " +
                "("+nvg+", "+nvh+", "+rvo+", "+nsd+", "+nsn+", "+x+", "+dateFormat.format(currentDate)+");";
        mSqLiteDatabase.execSQL(insertQuery);


        /** ContentValues values = new ContentValues();
         values.put(DBHelper.VODA_GOR_COLUMN, nvg);
         values.put(DBHelper.VODA_HOL_COLUMN, nvh);
         values.put(DBHelper.VODOOTVOD_COLUMN, rvo);
         values.put(DBHelper.SVET_NOCH_COLUMN, nsn);
         values.put(DBHelper.SVET_DEN_COLUMN, nsd);
         values.put(DBHelper.RESULT_COLUMN, x);
         values.put(DBHelper.DATE_COLUMN,dateFormat.format(currentDate));
         mSqLiteDatabase.insert("jkh", null, values);**/

        BigDecimal resultx = new BigDecimal(x);
        resultx = resultx.setScale(2, BigDecimal.ROUND_HALF_DOWN);

         //TextView complete = (TextView)findViewById(R.id.textView9);
         //complete.setText("Запись добавлена.");
        AlertDialog.Builder complete = new AlertDialog.Builder(add.this);
        complete.setTitle("Запись добавлена\nСумма к оплате: "+resultx+" p.");
        complete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        complete.show();

         Intent mail = new Intent(Intent.ACTION_SEND);
         mail.putExtra(Intent.EXTRA_TEXT, "Дата: "+currentDate+"\nВода Горячая: "+nvg+"\nВода Холодная: "+nvh+"\nВодоотвод: "+rvo+"\n\nСвет за ночь: "+nsn+"\nСвеь за день: "+nsd+
         "\n\nСумма к оплате: "+resultx+"rub."+
         "\n\nПо тарифам: \nВода горячая "+tarif_vg+
         "\nВода холодная: "+tarif_vh+
         "\nВодоотвод: "+tarif_vo+
         "\nСвет день: "+tarif_sd+
         "\nСвет ночь: "+tarif_sn

         );
         mail.setType("text/plain");
         startActivity(mail);

        Log.d("SQLite", "Database initialized!"); // обычное отладочное сообщение
        Log.e("SQLite", "Database initialized!"); // сообщение-ошибка
        Log.i("SQLite", "Database initialized!"); // информационное сообщение
        Log.v("SQLite", "Database initialized!"); // verbose-сообщение
        Log.w("SQLite", "Database initialized!"); // warning-сообщение а-ля внимание

        cursor.close();


    }

}
