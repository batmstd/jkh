package jkh.com.example.dmitriyoschepkov.jkh;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.opengl.EGLDisplay;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class archive extends AppCompatActivity {
 private DBHelper db;
    private SQLiteDatabase sql;
    ListView listViewArchive;
    Cursor cursor;
    SimpleCursorAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive);
        listViewArchive = (ListView)findViewById(R.id.listViewArchive);
        db = new DBHelper(this, "mydb.db", null, DBHelper.DATABASE_VERSION);
        sql = db.getReadableDatabase();
        String select = "select * from jkh order by _ID desc;";
        System.out.print(select);
        cursor = sql.rawQuery(select, null);
        final String[] headers = new String[] {DBHelper.DATE_COLUMN, DBHelper.RESULT_COLUMN,
                DBHelper.VODA_GOR_COLUMN, DBHelper.VODA_HOL_COLUMN, DBHelper.VODOOTVOD_COLUMN,
                DBHelper.SVET_DEN_COLUMN, DBHelper.SVET_NOCH_COLUMN};
        adapter = new SimpleCursorAdapter(this, R.layout.archive_list_view, cursor,
                headers, new int[] {R.id.archiveDate, R.id.archiveResult,
        R.id.archiveVodaGor, R.id.archiveVodaHol, R.id.archiveVodaVodootvod,
        R.id.archiveDay, R.id.archiveNight},0);
        listViewArchive.setAdapter(adapter);
        listViewArchive.setDivider(null);
        setTitle("Архив");
        //cursor.close();
        //db.close();

    }
}
