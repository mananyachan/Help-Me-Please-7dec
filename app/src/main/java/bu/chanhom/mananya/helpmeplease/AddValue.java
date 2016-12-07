package bu.chanhom.mananya.helpmeplease;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class AddValue extends FragmentActivity implements OnMapReadyCallback {

    //Explicit
    private GoogleMap mMap;
    private EditText editText;
    private Button rangeButton, soundButton, favoriteButton, saveButton;
    private int rangeAnInt, soundAnInt, favoriteAnInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_addvalue_layout);

        //Bind Widget
        editText = (EditText) findViewById(R.id.editText);
        rangeButton = (Button) findViewById(R.id.button2);
        soundButton = (Button) findViewById(R.id.button3);
        favoriteButton = (Button) findViewById(R.id.button4);
        saveButton = (Button) findViewById(R.id.button5);

        //rangButton Controller
        rangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final CharSequence[] charSequences = new  CharSequence[]{"200 เมตร","400 เมตร","600 เมตร","800 เมตร"};
                AlertDialog.Builder builder = new AlertDialog.Builder(AddValue.this);
                builder.setCancelable(false);
                builder.setIcon(R.drawable.doremon48);
                builder.setTitle(getResources().getString(R.string.range));
                builder.setSingleChoiceItems(charSequences, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        rangeAnInt = ((i + 1) *2) * 100;
                        Log.d("17novV1", "range ==> " + rangeAnInt);
                        rangeButton.setText(charSequences[i].toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.show();


            } //onClick
        });

        //soundButton Controller
        soundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final CharSequence[] charSequences = new CharSequence[]{"Bird","Cat","Cow","Dog","Elephant"};
                final int[] ints = new int[]{R.raw.bird, R.raw.cat, R.raw.cow, R.raw.dog, R.raw.elephant};
                AlertDialog.Builder builder = new AlertDialog.Builder(AddValue.this);
                builder.setCancelable(false);
                builder.setIcon(R.drawable.nobita48);
                builder.setTitle(getResources().getString(R.string.sound));
                builder.setSingleChoiceItems(charSequences, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        soundAnInt = i;

                        playSound(ints[i]);

                        soundButton.setText(charSequences[i].toString());

                        dialogInterface.dismiss();

                    } //Dialog
                });
                builder.show();


            } //onClick
        });


        //FavoriteButton Controller
        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                favoriteAnInt = 1;
                Toast.makeText(AddValue.this, getResources().getString(R.string.favorite) + " แล้ว !! ",Toast.LENGTH_SHORT).show();

            }//onClick
        });

        //saveButton Controller
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }//onClick
        });




        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    } // Main Method

    private void playSound(int anInt) {

        MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), anInt);
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    } // onMap
}// Main Class
