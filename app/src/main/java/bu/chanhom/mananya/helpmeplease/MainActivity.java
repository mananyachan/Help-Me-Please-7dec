package bu.chanhom.mananya.helpmeplease;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private Button button;
    private ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        button = (Button) findViewById(R.id.button);
        listView = (ListView) findViewById(R.id.livFavorite);

        //Button Controller
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddValue.class));
            }
        });

        //Create ListView
        createListview();


    } //Main Method

    @Override
    protected void onRestart() {
        super.onRestart();
        createListview();
    }

    private void createListview() {

        try {

            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                    MODE_PRIVATE, null);
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM helpTABLE WHERE Favorite = 1", null);
            cursor.moveToFirst();
            Log.d("7decV3", "cursor.count ==> " + cursor.getCount());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }   // createListView

} // Main Class

