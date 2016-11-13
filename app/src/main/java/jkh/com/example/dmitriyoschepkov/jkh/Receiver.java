package jkh.com.example.dmitriyoschepkov.jkh;

/**
 * Created by Dmitriy.Oschepkov on 13.11.2016.
 */
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.text.format.DateUtils;
import android.util.Log;
import java.util.Calendar;
import java.util.Date;

public class Receiver extends BroadcastReceiver {
    private static final int NOTIFY_ID = 1;
    final String LOG = "myLogs";
    Calendar dateAndTime=Calendar.getInstance();
    public DBHelper mDatabaseHelper;
    public SQLiteDatabase mSqLiteDatabase;

    @Override
    public void onReceive(Context context, Intent intent)
    {
            Log.d(LOG, "выполняется: " + intent.getAction());

        Calendar c = Calendar.getInstance();
        Date now = new Date();
        c.setTime(now);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));

            Intent notificationIntent = new Intent(context, MainActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(context,
                    0, notificationIntent,
                    PendingIntent.FLAG_CANCEL_CURRENT);
            Resources res = context.getResources();
            Notification.Builder builder = new Notification.Builder(context);
            builder.setContentIntent(contentIntent)
                    .setSmallIcon(R.drawable.ic_announcement_white_18dp)
                    .setPriority(Notification.PRIORITY_HIGH)// большая картинка
                    .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.ic_business_blue_900_48dp))
                    .setWhen(System.currentTimeMillis())
                    .setAutoCancel(true)
                    .setStyle(new Notification.InboxStyle()
                            .addLine("3")
                            .setBigContentTitle("Нужно снять счетчики"))
                    //.setSummaryText("хз"))
                    //.setContentText(select_date+" - "+select_type)
                    .setContentTitle("Нужно снять счетчики");
            Notification notification = builder.build();
            notification.defaults = Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE;
            NotificationManager notificationManager = (NotificationManager) context
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(NOTIFY_ID, notification);


    }



}
