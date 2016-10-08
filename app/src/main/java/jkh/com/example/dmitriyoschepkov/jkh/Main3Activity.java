package jkh.com.example.dmitriyoschepkov.jkh;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.opengl.EGLDisplay;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {

    private EditText vgt;
    private EditText vht;
    private EditText sdt;
    private EditText snt;
    private EditText vot;
    private DBHelper mDatabaseHelper3;
    private SQLiteDatabase mSqLiteDatabase3;
    private Button update, view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
       mDatabaseHelper3 = new DBHelper(this, "mydb.db", null, 1);
        mSqLiteDatabase3 = mDatabaseHelper3.getWritableDatabase();
        /**EditText vgt = (EditText)findViewById(R.id.vgt);
        EditText vht = (EditText)findViewById(R.id.vht);
        EditText sdt = (EditText)findViewById(R.id.sdt);
        EditText snt = (EditText)findViewById(R.id.snt);
        Button update = (Button)findViewById(R.id.update);
        Button view = (Button)findViewById(R.id.view);**/
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabTarif);
        Cursor cursor;
        cursor = mSqLiteDatabase3.query("tarif", new String[] {DBHelper.VODA_GOR_TARIF_COLUMN, DBHelper.VODA_HOL_TARIF_COLUMN, DBHelper.SVET_DEN_TARIF_COLUMN, DBHelper.SVET_NOCH_TARIF_COLUMN, DBHelper.VODOOTVOD_TARIF_COLUMN},
                null, null, null, null, null);
        cursor.moveToPosition(0);

        double tarif_vh = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODA_HOL_TARIF_COLUMN));
        double tarif_vg = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODA_GOR_TARIF_COLUMN));
        double tarif_sd = cursor.getDouble(cursor.getColumnIndex(DBHelper.SVET_DEN_TARIF_COLUMN));
        double tarif_sn = cursor.getDouble(cursor.getColumnIndex(DBHelper.SVET_NOCH_TARIF_COLUMN));
        double tarif_vo = cursor.getDouble(cursor.getColumnIndex(DBHelper.VODOOTVOD_TARIF_COLUMN));
        cursor.close();
        EditText currentTarifGor = (EditText)findViewById(R.id.currentTarifGor);
        EditText currentTarifHol = (EditText)findViewById(R.id.currentTarifHol);
        EditText currentTarifVodootvod = (EditText)findViewById(R.id.currentTarifVodootvod);
        EditText currentTarifDen = (EditText)findViewById(R.id.currentTarifDen);
        EditText currentTarifNoch = (EditText)findViewById(R.id.currentTarifNoch);
        currentTarifDen.setText(""+tarif_sd);
        currentTarifGor.setText(""+tarif_vg);
        currentTarifHol.setText(""+tarif_vh);
        currentTarifNoch.setText(""+tarif_sn);
        currentTarifVodootvod.setText(""+tarif_vo);
    }
    public void onClickTarif (View view){
        EditText vgt = (EditText)findViewById(R.id.vgt);
        EditText vht = (EditText)findViewById(R.id.vht);
        EditText sdt = (EditText)findViewById(R.id.sdt);
        EditText snt = (EditText)findViewById(R.id.snt);
        EditText vot = (EditText)findViewById(R.id.vot);
        Double uvgt, uvht, usdt, usnt, uvot;
        String vgt1 = vgt.getText().toString();
        String vht1 = vht.getText().toString();
        String sdt1 = sdt.getText().toString();
        String snt1 = snt.getText().toString();
        String vot1 = vot.getText().toString();
        uvgt = Double.parseDouble(vgt1);
        uvht = Double.parseDouble(vht1);
        usdt = Double.parseDouble(sdt1);
        usnt = Double.parseDouble(snt1);
        uvot = Double.parseDouble(vot1);

        /**mDatabaseHelper3 = new DBHelper(this);
        mSqLiteDatabase3 = mDatabaseHelper3.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.VODA_GOR_TARIF_COLUMN, uvgt);
        values.put(DBHelper.VODA_HOL_TARIF_COLUMN, uvht);
        values.put(DBHelper.SVET_DEN_TARIF_COLUMN, usdt);
        values.put(DBHelper.SVET_NOCH_TARIF_COLUMN, usnt);
        mSqLiteDatabase3.insert("tarif", null, values);**/

       // mDatabaseHelper3 = new DBHelper(this);
        SQLiteDatabase sqdb = mDatabaseHelper3.getWritableDatabase();

        /**String insertQuery = "DELETE FROM " +
                DBHelper.DATABASE_TABLE2;
        sqdb.execSQL(insertQuery);
        ContentValues values = new ContentValues();
        values.put(DBHelper.VODA_GOR_TARIF_COLUMN, uvgt);
        values.put(DBHelper.VODA_HOL_TARIF_COLUMN, uvht);
        values.put(DBHelper.SVET_DEN_TARIF_COLUMN, usdt);
        values.put(DBHelper.SVET_NOCH_TARIF_COLUMN, usnt);
        values.put(DBHelper.VODOOTVOD_TARIF_COLUMN, uvot);
        mSqLiteDatabase3.insert("tarif", null, values);**/
        String iQuery = "INSERT INTO 'tarif' (tarif_vh, tarif_vg, tarif_vo, tarif_sd, tarif_sh) values ('1', '2', '3', '4', '5')";
        sqdb.execSQL(iQuery);
        String updateDb = "UPDATE 'tarif' SET tarif_vg = " + uvgt +
                ", tarif_vh = " + uvht +
                ", tarif_vo = " + uvot +
                ", tarif_sd = " + usdt +
                ", tarif_sh = " + usnt +
                ";";
        sqdb.execSQL(updateDb);
        AlertDialog.Builder complete = new AlertDialog.Builder(Main3Activity.this);
        complete.setTitle("Тарифы обновлены");
        complete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //finish();
                EditText currentTarifGor = (EditText)findViewById(R.id.currentTarifGor);
                EditText currentTarifHol = (EditText)findViewById(R.id.currentTarifHol);
                EditText currentTarifVodootvod = (EditText)findViewById(R.id.currentTarifVodootvod);
                EditText currentTarifDen = (EditText)findViewById(R.id.currentTarifDen);
                EditText currentTarifNoch = (EditText)findViewById(R.id.currentTarifNoch);
                currentTarifDen.setText("");
                currentTarifGor.setText("");
                currentTarifHol.setText("");
                currentTarifNoch.setText("");
                currentTarifVodootvod.setText("");
            }
        });
        complete.show();

    }
    public void view(View view){
        EditText vgt = (EditText)findViewById(R.id.vgt);
        EditText vht = (EditText)findViewById(R.id.vht);
        EditText sdt = (EditText)findViewById(R.id.sdt);
        EditText snt = (EditText)findViewById(R.id.snt);
        EditText vot = (EditText)findViewById(R.id.vot);
        Cursor cursor = mSqLiteDatabase3.query("tarif", new String[] {DBHelper.VODA_GOR_TARIF_COLUMN, DBHelper.VODA_HOL_TARIF_COLUMN, DBHelper.SVET_DEN_TARIF_COLUMN, DBHelper.SVET_NOCH_TARIF_COLUMN, DBHelper.VODOOTVOD_TARIF_COLUMN},
                null, null, null, null, null);
        cursor.moveToPosition(0);
        String bvgt = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_GOR_TARIF_COLUMN));
        String bvht = cursor.getString(cursor.getColumnIndex(DBHelper.VODA_HOL_TARIF_COLUMN));
        String bsdt = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_DEN_TARIF_COLUMN));
        String bsnt = cursor.getString(cursor.getColumnIndex(DBHelper.SVET_NOCH_TARIF_COLUMN));
        String bvot = cursor.getString(cursor.getColumnIndex(DBHelper.VODOOTVOD_TARIF_COLUMN));
        cursor.close();
        /**vgt.setText(""+bvgt);
        vht.setText(""+bvht);
        sdt.setText(""+bsdt);
        snt.setText(""+bsnt);**/
        vgt.setText(bvgt);
        vht.setText(bvht);
        sdt.setText(bsdt);
        snt.setText(bsnt);
        vot.setText(bvot);
    }
}
