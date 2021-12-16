package com.Hackathon.bialgenieapp.Fragments.Transit;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.Hackathon.bialgenieapp.R;
import com.uber.sdk.android.core.Deeplink;
import com.uber.sdk.android.rides.RideParameters;
import com.uber.sdk.android.rides.RideRequestButton;
import com.uber.sdk.android.rides.RideRequestButtonCallback;
import com.uber.sdk.rides.client.SessionConfiguration;
import com.uber.sdk.android.core.UberSdk;
import com.uber.sdk.core.auth.Scope;;
import com.uber.sdk.rides.client.ServerTokenSession;
import com.uber.sdk.rides.client.SessionConfiguration;
import com.uber.sdk.rides.client.error.ApiError;
import com.uber.sdk.rides.client.model.RideReceipt;

import java.util.ArrayList;
import java.util.Arrays;


public class Transit_Cab_Uber extends Fragment {
    View v;
Button b ;



    public Transit_Cab_Uber() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_transit__cab__uber, container, false);

        b = v.findViewById(R.id.ridebutton);
        /*SessionConfiguration config = new SessionConfiguration.Builder()
                .setClientId("eRgXgAjIK0fE4nxe6L7dA_9LIdws89R4")
                .setServerToken("IA.VUNmGAAAAAAAEgASAAAABwAIAAwAAAAAAAAAEgAAAAAAAAGgAAAAFAAAAAAADgAQAAQAAAAIAAwAAAAOAAAAdAAAABwAAAAEAAAAEAAAACSkdvsWv7xBRq13guh8uhxOAAAAlyIaBC0nOUA3Ww-mtEkqAlOAvIv9Yn3fAKvQ6KRb6uQ9qRUqZXW-co23oOL_cm2lq5w1uWTLdiQ-CI0wg3T78DAMueagU8Iiil8tvEThAAAMAAAA_mx6ij8lvqsCuh5eJAAAAGIwZDg1ODAzLTM4YTAtNDJiMy04MDZlLTdhNGNmOGUxOTZlZQ")
                .setScopes(Arrays.asList(Scope.PROFILE, Scope.RIDE_WIDGETS))
                .setEnvironment(SessionConfiguration.Environment.SANDBOX)
                .build();
        UberSdk.initialize(config);*/



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PackageManager pm = getActivity().getPackageManager();
                try {
                    pm.getPackageInfo("com.ubercab", PackageManager.GET_ACTIVITIES);
                    String uri = "uber://?action=setPickup&pickup=my_location&dropoff[latitude]=13.19864&dropoff[longitude]=77.7066&dropoff[nickname]=Kempegowda%20International%20Airport%20Bengaluru";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(uri));
                    startActivity(intent);
                } catch (PackageManager.NameNotFoundException e) {
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=com.ubercab")));

                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.ubercab")));
                    }
                }
            }
        });
        // Text view number 1 to add hyperlink
        TextView linkTextView = v.findViewById(R.id.text2);

        // method to redirect to provided link
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());

        // method to change color of link
        linkTextView.setLinkTextColor(Color.YELLOW);



      /*  SessionConfiguration config = new SessionConfiguration.Builder()
                .setClientId("eRgXgAjIK0fE4nxe6L7dA_9LIdws89R4")
                .setServerToken("IA.VUNmGAAAAAAAEgASAAAABwAIAAwAAAAAAAAAEgAAAAAAAAGgAAAAFAAAAAAADgAQAAQAAAAIAAwAAAAOAAAAdAAAABwAAAAEAAAAEAAAACSkdvsWv7xBRq13guh8uhxOAAAAlyIaBC0nOUA3Ww-mtEkqAlOAvIv9Yn3fAKvQ6KRb6uQ9qRUqZXW-co23oOL_cm2lq5w1uWTLdiQ-CI0wg3T78DAMueagU8Iiil8tvEThAAAMAAAA_mx6ij8lvqsCuh5eJAAAAGIwZDg1ODAzLTM4YTAtNDJiMy04MDZlLTdhNGNmOGUxOTZlZQ")
                .setScopes(Arrays.asList(Scope.PROFILE, Scope.RIDE_WIDGETS))
                .setEnvironment(SessionConfiguration.Environment.SANDBOX)
                .build();
        UberSdk.initialize(config);
         r.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 PackageManager pm = getActivity().getPackageManager();
                 try {
                     pm.getPackageInfo("com.ubercab", PackageManager.GET_ACTIVITIES);
                     String uri = "uber://?action=setPickup&pickup=my_location&dropoff[latitude]=13.19864&dropoff[longitude]=77.7066&dropoff[nickname]=Kempegowda%20International%20Airport%20Bengaluru";
                     Intent intent = new Intent(Intent.ACTION_VIEW);
                     intent.setData(Uri.parse(uri));
                     startActivity(intent);
                 } catch (PackageManager.NameNotFoundException e) {
                     try {
                         startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=com.ubercab")));

                     } catch (android.content.ActivityNotFoundException anfe) {
                         startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.ubercab")));
                     }
                 }
             }
         });
*/


        return v;
    }
}