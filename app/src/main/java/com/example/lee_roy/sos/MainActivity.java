package com.example.lee_roy.sos;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Geocoder geocoder;
    Button getLocation;

    List<Address> addresses;

    //Static latitude and longitude data
    Double latitude = 29.995502;
    Double longitude = -90.171908;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        geocoder = new Geocoder(this, Locale.getDefault());
        getLocation = (Button) findViewById(R.id.getLocation);

        getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayLocation();
            }
        });



        /*try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1);

            String address = addresses.get(0).getAddressLine(0);
            String area = addresses.get(0).getLocality();
            String city = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String postalCode = addresses.get(0).getPostalCode();

            String fullAddress = address+", "+area+", "+city+", "+country+", "+postalCode;
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    private void displayLocation(){
        /*textView = (TextView) findViewById(R.id.textView);

        geocoder = new Geocoder(this, Locale.getDefault());*/

        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1);

            String address = addresses.get(0).getAddressLine(0);
            String area = addresses.get(0).getLocality();
            String city = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String postalCode = addresses.get(0).getPostalCode();

            String fullAddress = address+", "+area+", "+city+", "+country+", "+postalCode;
            textView.setText(fullAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}





