package jkh.com.example.dmitriyoschepkov.jkh;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    //=======================
    private EditText vg;
    private EditText vh;
    private EditText sd;
    private EditText sn;
    private TextView result1;
    public DBHelper mDatabaseHelper;
    public DBHelper mDBHelper;
    public SQLiteDatabase mSqLiteDatabase;
    private TextView currentDateGorVoda;
    private TextView lastDateGorVoda;
    private TextView currentGorVoda;
    private TextView lastGorVoda;
    private TextView resGorVoda;
    private TextView currentDateHolVoda;
    private TextView lastDateHolVoda;
    private TextView currentHolVoda;
    private TextView lastHolVoda;
    private TextView resHolVoda;
    private TextView currentDateSvetDen;
    private TextView lastDateSvetDen;
    private TextView currentSvetDen;
    private TextView lastSvetDen;
    private TextView resSvetDen;
    private TextView currentDateSvetNoch;
    private TextView lastDateSvetNoch;
    private TextView currentSvetNoch;
    private TextView lastSvetNoch;
    private TextView resSvetNoch;

    private TextView currentDateR;
    private TextView lastDateR;
    private TextView currentR;
    private TextView lastR;
    private TextView resR;

    private TextView plusGorVoda, plusHolVoda, plusSvetDen, plusSvetNoch, plusR;
    private ImageView imageGor, imageHol, imageDen, imageNoch, imageRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabaseHelper = new DBHelper(this, "mydb.db", null, 1);
        mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        currentDateGorVoda=(TextView) findViewById(R.id.currentDateGorVoda);
        lastDateGorVoda=(TextView)findViewById(R.id.lastDateGorVoda);
        currentGorVoda=(TextView)findViewById(R.id.currentGorVoda);
        lastGorVoda=(TextView)findViewById(R.id.lastGorVoda);
        resGorVoda=(TextView)findViewById(R.id.resGorVoda);

        currentDateHolVoda=(TextView) findViewById(R.id.currentDateHolVoda);
        lastDateHolVoda=(TextView)findViewById(R.id.lastDateHolVoda);
        currentHolVoda=(TextView)findViewById(R.id.currentHolVoda);
        lastHolVoda=(TextView)findViewById(R.id.lastHolVoda);
        resHolVoda=(TextView)findViewById(R.id.resHolVoda);

        currentDateSvetDen=(TextView) findViewById(R.id.currentDateSvetDen);
        lastDateSvetDen=(TextView)findViewById(R.id.lastDateSvetDen);
        currentSvetDen=(TextView)findViewById(R.id.currentSvetDen);
        lastSvetDen=(TextView)findViewById(R.id.lastSvetDen);
        resSvetDen=(TextView)findViewById(R.id.resSvetDen);

        currentDateSvetNoch=(TextView) findViewById(R.id.currentDateSvetNoch);
        lastDateSvetNoch=(TextView)findViewById(R.id.lastDateSvetNoch);
        currentSvetNoch=(TextView)findViewById(R.id.currentSvetNoch);
        lastSvetNoch=(TextView)findViewById(R.id.lastSvetNoch);
        resSvetNoch=(TextView)findViewById(R.id.resSvetNoch);

        currentDateR=(TextView) findViewById(R.id.currentDateR);
        lastDateR=(TextView)findViewById(R.id.lastDateR);
        currentR=(TextView)findViewById(R.id.currentR);
        lastR=(TextView)findViewById(R.id.lastR);
        resR=(TextView)findViewById(R.id.resR);

        plusGorVoda=(TextView)findViewById(R.id.plusGorVoda);
        plusHolVoda=(TextView)findViewById(R.id.plusHolVoda);
        plusSvetDen=(TextView)findViewById(R.id.plusSvetDen);
        plusSvetNoch=(TextView)findViewById(R.id.plusSvetNoch);
        plusR=(TextView)findViewById(R.id.plusR);

        imageGor = (ImageView)findViewById(R.id.imageGor);
        imageHol = (ImageView)findViewById(R.id.imageHol);
        imageDen = (ImageView)findViewById(R.id.imageDen);
        imageNoch = (ImageView)findViewById(R.id.imageNoch);
        imageRes = (ImageView)findViewById(R.id.imageRes);
        Cursor cursor;
        cursor = mSqLiteDatabase.query("jkh", new String[] {DBHelper.VODA_GOR_COLUMN, DBHelper.VODA_HOL_COLUMN, DBHelper.VODOOTVOD_COLUMN, DBHelper.SVET_DEN_COLUMN, DBHelper.SVET_NOCH_COLUMN, DBHelper.RESULT_COLUMN, DBHelper.DATE_COLUMN},
                null, null, null, null, null, null);
        cursor.moveToLast();
        double voda_gor = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODA_GOR_COLUMN));
        double voda_hol = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODA_HOL_COLUMN));
        double vodootvod = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODOOTVOD_COLUMN));
        double svet_noch = cursor.getDouble(cursor.getColumnIndex(DBHelper.SVET_NOCH_COLUMN));
        double svet_den = cursor.getDouble(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        double result = cursor.getDouble(cursor.getColumnIndex(DBHelper.RESULT_COLUMN));
        double date = cursor.getDouble(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        cursor.moveToPrevious();
        double last_voda_gor = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODA_GOR_COLUMN));
        double last_voda_hol = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODA_HOL_COLUMN));
        double last_vodootvod = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODOOTVOD_COLUMN));
        double last_svet_noch = cursor.getDouble(cursor.getColumnIndex(DBHelper.SVET_NOCH_COLUMN));
        double last_svet_den = cursor.getDouble(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        double last_result = cursor.getDouble(cursor.getColumnIndex(DBHelper.RESULT_COLUMN));
        double last_date = cursor.getDouble(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        cursor.moveToPrevious();
        double llast_voda_gor = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODA_GOR_COLUMN));
        double llast_voda_hol = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODA_HOL_COLUMN));
        double llast_vodootvod = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODOOTVOD_COLUMN));
        double llast_svet_noch = cursor.getDouble(cursor.getColumnIndex(DBHelper.SVET_NOCH_COLUMN));
        double llast_svet_den = cursor.getDouble(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
        double llast_result = cursor.getDouble(cursor.getColumnIndex(DBHelper.RESULT_COLUMN));
        double llast_date = cursor.getDouble(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
        cursor.close();
        currentDateGorVoda.setText(""+date);
        lastDateGorVoda.setText(""+last_date);
        currentGorVoda.setText(""+voda_gor);
        lastGorVoda.setText(""+last_voda_gor);
        Double gorVoda = voda_gor - last_voda_gor;
        BigDecimal gorVodax = new BigDecimal(gorVoda);
        gorVodax = gorVodax.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        resGorVoda.setText(""+gorVodax);

        currentDateHolVoda.setText(""+date);
        lastDateHolVoda.setText(""+last_date);
        currentHolVoda.setText(""+voda_hol);
        lastHolVoda.setText(""+last_voda_hol);
        Double HolVoda = voda_hol - last_voda_hol;
        BigDecimal holVodax = new BigDecimal(HolVoda);
        holVodax = holVodax.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        resHolVoda.setText(""+holVodax);

        currentDateSvetDen.setText(""+date);
        lastDateSvetDen.setText(""+last_date);
        currentSvetDen.setText(""+svet_den);
        lastSvetDen.setText(""+last_svet_den);
        Double SvetDen = svet_den - last_svet_den;
        BigDecimal SvetDenx = new BigDecimal(SvetDen);
        SvetDenx = SvetDenx.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        resSvetDen.setText(""+SvetDenx);

        currentDateSvetNoch.setText(""+date);
        lastDateSvetNoch.setText(""+last_date);
        currentSvetNoch.setText(""+svet_noch);
        lastSvetNoch.setText(""+last_svet_noch);
        Double SvetNoch = svet_noch - last_svet_noch;
        BigDecimal SvetNochx = new BigDecimal(SvetNoch);
        SvetNochx = SvetNochx.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        resSvetNoch.setText(""+SvetNochx);

        currentDateR.setText(""+date);
        lastDateR.setText(""+last_date);
        currentR.setText(""+result);
        lastR.setText(""+last_result);
        Double R = result - last_result;
        BigDecimal Rx = new BigDecimal(R);
        Rx = Rx.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        plusR.setText(""+Rx);
        if (result > last_result){imageRes.setImageResource(jkh.com.example.dmitriyoschepkov.jkh.R.drawable.ic_keyboard_arrow_up_red_900_36dp);}
        else {imageRes.setImageResource(jkh.com.example.dmitriyoschepkov.jkh.R.drawable.ic_keyboard_arrow_down_green_900_36dp);}

        Double lastResGorVoda, resultLastGorVoda;
        lastResGorVoda = last_voda_gor - llast_voda_gor;
        resultLastGorVoda = gorVoda - lastResGorVoda;
        BigDecimal resultLastGorVodax = new BigDecimal(resultLastGorVoda);
        resultLastGorVodax = resultLastGorVodax.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        plusGorVoda.setText(""+resultLastGorVodax);
        if (gorVoda > lastResGorVoda){
        imageGor.setImageResource(jkh.com.example.dmitriyoschepkov.jkh.R.drawable.ic_keyboard_arrow_up_red_900_36dp);}
        else  {
            imageGor.setImageResource(jkh.com.example.dmitriyoschepkov.jkh.R.drawable.ic_keyboard_arrow_down_green_900_36dp);}

        Double lastResHolVoda, resultLastHolVoda;
        lastResHolVoda = last_voda_hol - llast_voda_hol;
        resultLastHolVoda = HolVoda - lastResHolVoda;
        BigDecimal resultLastHolVodax = new BigDecimal(resultLastHolVoda);
        resultLastHolVodax = resultLastHolVodax.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        plusHolVoda.setText(""+resultLastHolVodax);
        if (HolVoda > lastResHolVoda){
            imageHol.setImageResource(jkh.com.example.dmitriyoschepkov.jkh.R.drawable.ic_keyboard_arrow_up_red_900_36dp);}
        else  {
            imageHol.setImageResource(jkh.com.example.dmitriyoschepkov.jkh.R.drawable.ic_keyboard_arrow_down_green_900_36dp);}

        Double lastResSvetDen, resultLastSvetDen;
        lastResSvetDen = last_svet_den - llast_svet_den;
        resultLastSvetDen = SvetDen - lastResSvetDen;
        BigDecimal resultLastSvetDenx = new BigDecimal(resultLastSvetDen);
        resultLastSvetDenx = resultLastSvetDenx.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        plusSvetDen.setText(""+resultLastSvetDenx);
        if (SvetDen > lastResSvetDen){
            imageDen.setImageResource(jkh.com.example.dmitriyoschepkov.jkh.R.drawable.ic_keyboard_arrow_up_red_900_36dp);}
        else  {
            imageDen.setImageResource(jkh.com.example.dmitriyoschepkov.jkh.R.drawable.ic_keyboard_arrow_down_green_900_36dp);}

        Double lastResSvetNoch, resultLastSvetNoch;
        lastResSvetNoch = last_svet_noch - llast_svet_noch;
        resultLastSvetNoch = SvetNoch - lastResSvetNoch;
        BigDecimal resultLastSvetNochx = new BigDecimal(resultLastSvetNoch);
        resultLastSvetNochx = resultLastSvetNochx.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        plusSvetNoch.setText(""+resultLastSvetNochx);
        if (SvetNoch > lastResSvetNoch){
            imageNoch.setImageResource(jkh.com.example.dmitriyoschepkov.jkh.R.drawable.ic_keyboard_arrow_up_red_900_36dp);}
        else  {
            imageNoch.setImageResource(jkh.com.example.dmitriyoschepkov.jkh.R.drawable.ic_keyboard_arrow_down_green_900_36dp);}




    }
    public void onClick2(View view){
        Intent intent = new Intent(MainActivity.this, add.class);
        startActivity(intent);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
        //настройки меню
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        if (id==R.id.mail){
            Cursor cursor;
            cursor = mSqLiteDatabase.query("jkh", new String[] {DBHelper.VODA_GOR_COLUMN, DBHelper.VODA_HOL_COLUMN, DBHelper.VODOOTVOD_COLUMN, DBHelper.SVET_DEN_COLUMN, DBHelper.SVET_NOCH_COLUMN, DBHelper.RESULT_COLUMN, DBHelper.DATE_COLUMN},
                    null, null, null, null, null, null);
            cursor.moveToLast();

            double voda_gor = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODA_GOR_COLUMN));
            double voda_hol = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODA_HOL_COLUMN));
            double vodootvod = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODOOTVOD_COLUMN));
            double svet_noch = cursor.getDouble(cursor.getColumnIndex(DBHelper.SVET_NOCH_COLUMN));
            double svet_den = cursor.getDouble(cursor.getColumnIndex(DBHelper.SVET_DEN_COLUMN));
            double result = cursor.getDouble(cursor.getColumnIndex(DBHelper.RESULT_COLUMN));
            double date = cursor.getDouble(cursor.getColumnIndex(DBHelper.DATE_COLUMN));
            cursor.close();
            cursor = mSqLiteDatabase.query("tarif", new String[] {DBHelper.VODA_GOR_TARIF_COLUMN, DBHelper.VODA_HOL_TARIF_COLUMN, DBHelper.SVET_DEN_TARIF_COLUMN, DBHelper.SVET_NOCH_TARIF_COLUMN, DBHelper.VODOOTVOD_TARIF_COLUMN},
                    null, null, null, null, null);
            cursor.moveToPosition(0);

            double tarif_vh = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODA_HOL_TARIF_COLUMN));
            double tarif_vg = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODA_GOR_TARIF_COLUMN));
            double tarif_sd = cursor.getDouble(cursor.getColumnIndex(DBHelper.SVET_DEN_TARIF_COLUMN));
            double tarif_sn = cursor.getDouble(cursor.getColumnIndex(DBHelper.SVET_NOCH_TARIF_COLUMN));
            double tarif_vo = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODOOTVOD_TARIF_COLUMN));
            cursor.close();
            BigDecimal resultx = new BigDecimal(result);
            resultx = resultx.setScale(2,BigDecimal.ROUND_HALF_DOWN);
            Intent mail = new Intent(Intent.ACTION_SEND);
            mail.putExtra(Intent.EXTRA_TEXT,
                    "Дата: "+date+
                            "\nВода Горячая: "+voda_gor+
                            "\nВода Холодная: "+voda_hol+
                            "\nВодоотвод: "+vodootvod+
                            "\n\nСвет за ночь: "+svet_noch+
                            "\nСвеь за день: "+svet_den+
                            "\n\nСумма к оплате: "+resultx+"rub."+
                            "\n\nПо тарифам: \nВода горячая "+tarif_vg+
                            "\nВода холодная: "+tarif_vh+
                            "\nВодоотвод: "+tarif_vo+
                            "\nСвет день: "+tarif_sd+
                            "\nСвет ночь: "+tarif_sn

            );
            mail.setType("text/plain");
            startActivity(mail);
        }



        else if (id==R.id.settings){
            Intent intent = new Intent(MainActivity.this, Settings.class);
            startActivity(intent);
        }
        else if (id==R.id.archive2){
            Intent intent = new Intent(MainActivity.this, archive.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        // super.onBackPressed();
        openQuitDialog();
    }

    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                MainActivity.this);
        quitDialog.setTitle("Вы уверены, что хотите выйти?");

        quitDialog.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                finish();
            }
        });

        quitDialog.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        });

        quitDialog.show();
    }
}
