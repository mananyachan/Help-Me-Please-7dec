package bu.chanhom.mananya.helpmeplease;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 12/7/2016 AD.
 */

public class MyManage {

    //Explicit
    private Context context;
    public static final String table_name = "helpTABLE";
    public static final String column_id = "_id";
    public static final String column_Title = "Title";
    public static final String column_Range = "Range";
    public static final String column_Sound = "Sound";
    public static final String column_Favorite = "Favorite";
    public static final String column_Lat = "Lat";
    public static final String column_Lng = "Lng";
    public static final String column_Action = "Action";
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public MyManage(Context context) {
        this.context = context;
        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();
    }

    public long addValue(String strTitle, String strRange, String strSound,
                         String strFavorite, String strLat, String strLng) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_Title, strTitle);
        contentValues.put(column_Range, strRange);
        contentValues.put(column_Sound, strSound);
        contentValues.put(column_Favorite, strFavorite);
        contentValues.put(column_Lat, strLat);
        contentValues.put(column_Lng, strLng);
        contentValues.put(column_Action, "0");

        return sqLiteDatabase.insert(table_name, null, contentValues);
    }

}   // Main Class
