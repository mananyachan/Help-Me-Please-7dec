package bu.chanhom.mananya.helpmeplease;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Blind extends AppCompatActivity {

    private ListView listView;
    private String[] blindStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blind);

        listView = (ListView) findViewById(R.id.livBlind);

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM helpTABLE", null);
        cursor.moveToFirst();

        blindStrings = new String[cursor.getCount()];
        for (int i=0;i<cursor.getCount();i++) {
            blindStrings[i] = cursor.getString(1);
            cursor.moveToNext();
        }

        BlindAdapter blindAdapter = new BlindAdapter(Blind.this, blindStrings);
        listView.setAdapter(blindAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);

                ContentValues contentValues = new ContentValues();
                contentValues.put(MyManage.column_Action, "0");

                sqLiteDatabase.update(MyManage.table_name, contentValues,
                        "_id=" + (i+1), null);



            }   // onItemClick
        });


    }   // Main Method

}   // Main Class
