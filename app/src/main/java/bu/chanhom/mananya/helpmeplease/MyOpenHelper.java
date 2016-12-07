package bu.chanhom.mananya.helpmeplease;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by masterUNG on 12/7/2016 AD.
 */

public class MyOpenHelper extends SQLiteOpenHelper{

    //Explicit
    private Context context;
    public static final String database_name = "helpMe.db";
    private static final int database_version = 1;
    private static final String create_help_table = "create table helpTABLE (" +
            "_id integer primary key, " +
            "Title text," +
            "Range text," +
            "Sound text," +
            "Favorite text," +
            "Lat text," +
            "Lng text," +
            "Action text);";

    public MyOpenHelper(Context context) {
        super(context, database_name, null, database_version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_help_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}   // Main Class
