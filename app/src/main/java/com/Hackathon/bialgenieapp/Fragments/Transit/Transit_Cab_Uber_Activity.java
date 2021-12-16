package com.Hackathon.bialgenieapp.Fragments.Transit;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.Hackathon.bialgenieapp.Fragments.HomeFragment;
import com.Hackathon.bialgenieapp.R;
import com.uber.sdk.android.core.UberSdk;
import com.uber.sdk.android.rides.RideRequestButton;
import com.uber.sdk.core.auth.Scope;
import com.uber.sdk.rides.client.SessionConfiguration;

import java.util.Arrays;

public class Transit_Cab_Uber_Activity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transit_cab_uber);
        RideRequestButton r = new RideRequestButton(this);
        RelativeLayout layout = new RelativeLayout(this);
        layout.addView(r);
        SessionConfiguration config = new SessionConfiguration.Builder()
                .setClientId("eRgXgAjIK0fE4nxe6L7dA_9LIdws89R4")
                .setServerToken("IA.VUNmGAAAAAAAEgASAAAABwAIAAwAAAAAAAAAEgAAAAAAAAGgAAAAFAAAAAAADgAQAAQAAAAIAAwAAAAOAAAAdAAAABwAAAAEAAAAEAAAACSkdvsWv7xBRq13guh8uhxOAAAAlyIaBC0nOUA3Ww-mtEkqAlOAvIv9Yn3fAKvQ6KRb6uQ9qRUqZXW-co23oOL_cm2lq5w1uWTLdiQ-CI0wg3T78DAMueagU8Iiil8tvEThAAAMAAAA_mx6ij8lvqsCuh5eJAAAAGIwZDg1ODAzLTM4YTAtNDJiMy04MDZlLTdhNGNmOGUxOTZlZQ")
                .setScopes(Arrays.asList(Scope.PROFILE, Scope.RIDE_WIDGETS))
                .setEnvironment(SessionConfiguration.Environment.SANDBOX)
                .build();
        UberSdk.initialize(config);
        PackageManager pm = getPackageManager();
        try {
            pm.getPackageInfo("com.ubercab", PackageManager.GET_ACTIVITIES);
            String uri = "uber://?action=setPickup&pickup=my_location&dropoff[latitude]=13.19864&dropoff[longitude]=77.7066&dropoff[nickname]=Kempegowda%20International%20Airport%20Bengaluru";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(uri));
            startActivity(intent);
        } catch (PackageManager.NameNotFoundException e) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.ubercab")));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=com.ubercab")));
            }
        }

  onDestroy();

    }



}
