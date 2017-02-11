package bu.chanhom.mananya.helpmeplease;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private Button button;
    private ListView listView;
    private String[] titleStrings, rangeStrings, soundStrings,
            latStrings, lngStrings, actionStrings;
    private LocationManager locationManager;
    private Criteria criteria;
    private double latADouble, lngADouble;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setup
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);

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

        //My Loop
        myLoop();

    } //Main Method

    private void myLoop() {
        //My To do
        Location networkLocation = myFindLocation(LocationManager.NETWORK_PROVIDER);
        if (networkLocation != null) {
            latADouble = networkLocation.getLatitude();
            lngADouble = networkLocation.getLongitude();
        }

        Location gpsLocation = myFindLocation(LocationManager.GPS_PROVIDER);
        if (gpsLocation != null) {
            latADouble = gpsLocation.getLatitude();
            lngADouble = gpsLocation.getLongitude();
        }

        Log.d("7decV4", "lat ==> " + latADouble);
        Log.d("7decV4", "lng ==> " + lngADouble);

        //Calculate All Point Where action = 0
        calculateAllPoint(latADouble, lngADouble);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                myLoop();
            }
        }, 5000);


    }   // myLoop

    private void calculateAllPoint(double latADouble, double lngADouble) {

        try {

            String tag = "11febV1";

            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                    MODE_PRIVATE, null);
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM helpTABLE WHERE Action = 0", null);
            cursor.moveToFirst();
            Log.d("11febV1", "cursor.getCount ==> " + cursor.getCount());

            for (int i=0;i<cursor.getCount();i++) {

                double lat2 = Double.parseDouble(cursor.getString(cursor.getColumnIndex(MyManage.column_Lat)));
                double lng2 = Double.parseDouble(cursor.getString(cursor.getColumnIndex(MyManage.column_Lng)));
                Log.d(tag, "lat2 ==> " + lat2);
                Log.d(tag, "lng2 ==> " + lng2);
                double douDistance = distance(latADouble, lngADouble,
                        Double.parseDouble(cursor.getString(5)), Double.parseDouble(cursor.getString(6)));
                Log.d(tag, "Distance ==> " + douDistance);
                cursor.moveToNext();

            }   // for


            cursor.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }   // calculate


    //นี่คือ เมทอด ที่หาระยะ ระหว่างจุด
    private static double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515 * 1609.344;


        return (dist);
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }



    @Override
    protected void onStop() {
        super.onStop();
        locationManager.removeUpdates(locationListener);
    }

    @Override
    protected void onResume() {
        super.onResume();

        latADouble = 13.711390;
        lngADouble = 100.581730;



    }   // onResume

    public Location myFindLocation(String strProvider) {

        Location location = null;
        if (locationManager.isProviderEnabled(strProvider)) {
            locationManager.requestLocationUpdates(strProvider, 1000, 10, locationListener);
            location = locationManager.getLastKnownLocation(strProvider);
        }

        return location;
    }

    public LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            latADouble = location.getLatitude();
            lngADouble = location.getLongitude();
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };

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

            String[] titleStrings = new String[cursor.getCount()];

            for (int i = 0; i < cursor.getCount(); i++) {
                titleStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Title));
                cursor.moveToNext();
            }   //for

            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(MainActivity.this,
                    android.R.layout.simple_list_item_1, titleStrings);
            listView.setAdapter(stringArrayAdapter);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }   // createListView

} // Main Class

