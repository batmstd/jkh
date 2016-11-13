package jkh.com.example.dmitriyoschepkov.jkh;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends AppCompatActivity {
    public DBHelper db;
    public SQLiteDatabase sql;
    String deleteDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        db = new DBHelper(this);
        sql = db.getWritableDatabase();
        deleteDb = "DELETE FROM 'jkh';";

    }
    public void settingsTarif(View viw){
        Intent intent = new Intent(Settings.this, Main3Activity.class);
        startActivity(intent);
    }
    public void deleteDB(View view){
        sql.execSQL(deleteDb);
        Toast toast = Toast.makeText(getApplicationContext(),
                "БД Удалена)",
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
    public void clearDB(View view){


        sql.execSQL(deleteDb);
        String insertQuery = "INSERT INTO 'jkh' (voda_gor, voda_hol, vodootvod, svet_den, svet_noch, result, date) values " +
                "('13.48', '36.01', '8.65', '111.30', '387.37', '1962.18', '01.09.2015'), " +
                "('17.56', '43.02', '11.09', '153.66', '478.8', '1423.23', '01.10.2014'), " +
                "('21.91', '49.95', '11.28', '205.03', '568.93', '1463.96', '01.11.2014'), " +
                "('26.87', '56.83', '11.84', '253.6', '678.69', '1619.19', '01.12.2014'), " +
                "('33.41', '66.65', '16.36', '332.03', '841.13', '2257.95', '01.01.2015'), " +
                "('37.20', '72.45', '9.59', '392.58', '936.14', '1336.20', '01.02.2015'), " +
                "('42.20', '78.67', '11.22', '463.41', '1046.52', '1609.96', '01.03.2015'), " +
                "('46.63', '84.65', '10.41', '532.15', '1145.41', '1466.60', '01.04.2015'), " +
                "('50.95', '91.99', '11.66', '585.48', '1262.15', '1579.32', '01.05.2015'), " +
                "('54.47', '98.98', '10.51', '643.7', '1349.91', '1340.70', '01.06.2015'), " +
                "('58.31', '108.12', '12.98', '703.57', '1459.34', '1599.86', '01.07.2015'), " +
                "('59.68', '114.47', '7.73', '757.21', '1546.46', '966.36', '01.08.2015'), " +
                "('63.09', '122.45', '11.38', '814.28', '1652.34', '1445.65', '01.09.2015'), " +
                "('67.93', '131.04', '13.43', '898.04', '1763.25', '1749.85', '01.10.2015'), " +
                "('71.61', '137.49', '10.14', '970.25', '1888.25', '1476.16', '01.11.2015'), " +
                "('75.43', '144.02', '10.35', '1048', '2010.6', '1498.62', '01.12.2015'), " +
                "('79.45', '150.45', '10.45', '1117.38', '2134.74', '1519.89', '01.01.2016'), " +
                "('84.02', '156.94', '11.06', '1179.83', '2262.66', '1613.36', '01.02.2016'), " +
                "('89.01', '164.21', '12.25', '1272.06', '2398.25', '1783.78', '01.03.2016'), " +
                "('93.015', '170.823', '12', '1344.22', '2520.20', '1524.53', '01.04.2016'), " +
                "('96.765', '179.674', '12.601', '1431.66', '2628.88', '1596.31', '01.05.2016'), "+
                "('99.365', '188.003', '10.93', '1518.94', '2753.05', '1095.62', '01.06.2016'), " +
                "('102.196', '197.006', '11.894', '1600.05', '2855.96', '1540.31', '01.07.2016'), " +
                "('103.913', '203.667', '8.3179', '1657.20', '2957.79', '1657.20', '01.08.2016'), " +
                "('106.943', '210.212', '9.5795', '1712.87', '3050.41', '1280.61', '01.09.2016'), " +
                "('110.056', '217.553', '10.454', '1777.21', '3164.84', '1413.57', '01.10.2016'); "

                ;
        sql.execSQL(insertQuery);
        String deleteTarif = "INSERT INTO 'tarif' (tarif_vh, tarif_vg, tarif_vo, tarif_sd, tarif_sh) values ('32.22', '122.52', '30.20', '3.45', '1.1')";
        sql.execSQL(deleteTarif);

        AlertDialog.Builder complete = new AlertDialog.Builder(Settings.this);
        complete.setTitle("БД пересоздана");
        complete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //finish();
            }
        });
        complete.show();

    }
}
