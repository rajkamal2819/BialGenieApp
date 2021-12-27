package com.Hackathon.bialgenieapp.Fragments;

import static com.azure.android.maps.control.options.LineLayerOptions.strokeColor;
import static com.azure.android.maps.control.options.LineLayerOptions.strokeWidth;
import static com.azure.android.maps.control.options.SymbolLayerOptions.iconImage;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.Hackathon.bialgenieapp.MainActivity;
import com.Hackathon.bialgenieapp.databinding.FragmentMapsBinding;
import com.azure.android.maps.control.AzureMaps;
import com.azure.android.maps.control.MapControl;
import com.azure.android.maps.control.layer.LineLayer;
import com.azure.android.maps.control.layer.SymbolLayer;
import com.azure.android.maps.control.options.CameraOptions;
import com.azure.android.maps.control.options.Expression;
import com.azure.android.maps.control.options.MapStyle;
import com.azure.android.maps.control.options.StyleOptions;
import com.azure.android.maps.control.options.SymbolLayerOptions;
import com.azure.android.maps.control.source.DataSource;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.LineString;
import com.mapbox.geojson.Point;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapsFragment extends Fragment {

    public MapsFragment() {
        // Required empty public constructor
    }

    static {
        AzureMaps.setSubscriptionKey("97YsFp1Xl5NCA41HpbHGz3w04Raw3O-PSQSLHxqA4v4");
        // AzureMaps.setDomain("atlas.azure.us");
        AzureMaps.setView("Auto");

        //Alternatively use Azure Active Directory authenticate.
        // AzureMaps.setAadProperties("");
        //AzureMaps.setAadProperties("<Your aad clientId>", "<Your aad AppId>", "<Your aad Tenant>");
    }

    FragmentMapsBinding binding;
    MapControl mapControl;
    int count = 0;
    LocationManager locationManager;
    String latitude,longitude;
    private static  final int REQUEST_LOCATION=1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMapsBinding.inflate(getLayoutInflater());

        mapControl = binding.mapcontrol;
        mapControl.onCreate(savedInstanceState);

        //Wait until the map resources are ready.
        mapControl.onReady(map -> {

            //   map.setCamera(CameraOptions.center(Point.fromLngLat(77.710228, 13.200771)), CameraOptions.zoom(15));
            //  map.setStyle(StyleOptions.style(MapStyle.SATELLITE_ROAD_LABELS));

            map.setCamera(CameraOptions.center(Point.fromLngLat(77.710228, 13.200771)),
                    CameraOptions.zoom(15),
                    CameraOptions.pitch(45),
                    CameraOptions.minZoom(10),
                    CameraOptions.maxZoom(20));

            DataSource source = new DataSource();
            map.sources.add(source);

            Feature feature = Feature.fromGeometry(Point.fromLngLat(77.7087188,13.1988221));
            source.add(feature);

            SymbolLayer layer0 = new SymbolLayer(source, iconImage("marker-yellow"),SymbolLayerOptions.textField("KIAL Parking 3"));


            DataSource source1 = new DataSource();
            map.sources.add(source1);
            Feature feature1 = Feature.fromGeometry(Point.fromLngLat(77.7079768,13.1986348,461));
            source1.add(feature1);
            SymbolLayer layer1 = new SymbolLayer(source1,iconImage("marker-yellow"),SymbolLayerOptions.textField("Uber Parking"));

            DataSource source2 = new DataSource();
            map.sources.add(source2);
            Feature feature2 = Feature.fromGeometry(Point.fromLngLat(77.7071251,13.1971207));
            source2.add(feature2);
            SymbolLayer layer2 = new SymbolLayer(source2,iconImage("marker-yellow"),SymbolLayerOptions.textField("OLA Parking"));

            DataSource source3 = new DataSource();
            map.sources.add(source3);
            Feature feature3 = Feature.fromGeometry(Point.fromLngLat(77.7077248,13.1970668));
            source3.add(feature3);
            SymbolLayer layer3 = new SymbolLayer(source3,iconImage("marker-yellow"),SymbolLayerOptions.textField("KIAL Parking 4"));

            DataSource source4 = new DataSource();
            map.sources.add(source4);
            Feature feature4 = Feature.fromGeometry(Point.fromLngLat(77.7076666,13.1979509));
            source4.add(feature4);
            SymbolLayer layer4 = new SymbolLayer(source4,iconImage("marker-yellow"),SymbolLayerOptions.textField("KIAL Parking 3"));

            DataSource source5 = new DataSource();
            map.sources.add(source5);
            Feature feature5 = Feature.fromGeometry(Point.fromLngLat(77.6955975,13.192843));
            source5.add(feature5);
            SymbolLayer layer5 = new SymbolLayer(source5,iconImage("marker-yellow"),SymbolLayerOptions.textField("P-6 Parking"));

            ArrayList<SymbolLayer> layerList = new ArrayList<>();
            layerList.add(layer0);
            layerList.add(layer1);
            layerList.add(layer2);
            layerList.add(layer3);
            layerList.add(layer4);
            layerList.add(layer5);

            // LAYER 0 to 5 for Parking




            DataSource source6 = new DataSource();
            map.sources.add(source6);
            Feature feature6 = Feature.fromGeometry(Point.fromLngLat(77.7085711,13.1999847,1067));
            source6.add(feature6);
            SymbolLayer layer6 = new SymbolLayer(source6,SymbolLayerOptions.textField("Sakkare / Smoor"));
            layerList.add(layer6);

            DataSource source7 = new DataSource();
            map.sources.add(source7);
            Feature feature7 = Feature.fromGeometry(Point.fromLngLat(77.7105965,13.2009514,839));
            source7.add(feature7);
            SymbolLayer layer7 = new SymbolLayer(source7,SymbolLayerOptions.textField("La Tapenade Mediterranean Café"));
            layerList.add(layer7);

            DataSource source8 = new DataSource();
            map.sources.add(source8);
            Feature feature8 = Feature.fromGeometry(Point.fromLngLat(77.708881,13.1977371,1316));
            source8.add(feature8);
            SymbolLayer layer8 = new SymbolLayer(source8,SymbolLayerOptions.textField("GOPIZZA"));
            layerList.add(layer8);

            DataSource source9 = new DataSource();
            map.sources.add(source9);
            Feature feature9 = Feature.fromGeometry(Point.fromLngLat(77.7100426,13.1994581,658));
            source9.add(feature9);
            SymbolLayer layer9 = new SymbolLayer(source9,SymbolLayerOptions.textField("Noodle"));
            layerList.add(layer9);

            DataSource source10 = new DataSource();
            map.sources.add(source10);
            Feature feature10 = Feature.fromGeometry(Point.fromLngLat(77.709366,13.1970989,839));
            source10.add(feature10);
            SymbolLayer layer10 = new SymbolLayer(source10,SymbolLayerOptions.textField("Lounge Bar"));
            layerList.add(layer10);

            DataSource source11 = new DataSource();
            map.sources.add(source11);
            Feature feature11 = Feature.fromGeometry(Point.fromLngLat(77.7063947,13.199459,1031));
            source11.add(feature11);
            SymbolLayer layer11 = new SymbolLayer(source11,SymbolLayerOptions.textField("Tiffin Center"));
            layerList.add(layer11);

            DataSource source12 = new DataSource();
            map.sources.add(source12);
            Feature feature12 = Feature.fromGeometry(Point.fromLngLat(77.7083733,13.1998314,516));
            source12.add(feature12);
            SymbolLayer layer12 = new SymbolLayer(source12,SymbolLayerOptions.textField("Street Food by Punjab Grill"));
            layerList.add(layer12);

            DataSource source13 = new DataSource();
            map.sources.add(source13);
            Feature feature13 = Feature.fromGeometry(Point.fromLngLat(77.7051889,13.1992026,839));
            source13.add(feature13);
            SymbolLayer layer13 = new SymbolLayer(source13,SymbolLayerOptions.textField("Nandi Upachar @ KIAL"));
            layerList.add(layer13);

            DataSource source14 = new DataSource();
            map.sources.add(source14);
            Feature feature14 = Feature.fromGeometry(Point.fromLngLat(77.7044041,13.1986348,839));
            source14.add(feature14);
            SymbolLayer layer14 = new SymbolLayer(source14,SymbolLayerOptions.textField("Ooru Canteen"));
            layerList.add(layer14);

            // RESTAURANTS LAYERS 6 to  14



            DataSource source15 = new DataSource();
            map.sources.add(source15);
            Feature feature15 = Feature.fromGeometry(Point.fromLngLat(77.7063339,13.1991188,839));
            source15.add(feature15);
            SymbolLayer layer15 = new SymbolLayer(source15,SymbolLayerOptions.textField("SBI ATM"));
            layerList.add(layer15);

            DataSource source16 = new DataSource();
            map.sources.add(source16);
            Feature feature16 = Feature.fromGeometry(Point.fromLngLat(77.7072788,13.2002139,839));
            source16.add(feature16);
            SymbolLayer layer16 = new SymbolLayer(source16,SymbolLayerOptions.textField("Kotak Mahindra Bank ATM"));
            layerList.add(layer16);

            DataSource source17 = new DataSource();
            map.sources.add(source17);
            Feature feature17 = Feature.fromGeometry(Point.fromLngLat(77.705724,13.1978411,839));
            source17.add(feature17);
            SymbolLayer layer17 = new SymbolLayer(source17,SymbolLayerOptions.textField("ICICI BANK ATM"));
            layerList.add(layer17);

            DataSource source18 = new DataSource();
            map.sources.add(source18);
            Feature feature18 = Feature.fromGeometry(Point.fromLngLat(77.7047201,13.1986348,839));
            source18.add(feature18);
            SymbolLayer layer18 = new SymbolLayer(source18,SymbolLayerOptions.textField("Bank of Baroda ATM"));
            layerList.add(layer18);

            // ATMs LAYERS 15 to 18




            DataSource source19 = new DataSource();
            map.sources.add(source19);
            Feature feature19 = Feature.fromGeometry(Point.fromLngLat(77.7071985,13.198969,839));
            source19.add(feature19);
            SymbolLayer layer19 = new SymbolLayer(source19,iconImage("marker-red"),SymbolLayerOptions.textField("Aster Airport Medical Centre"));
            layerList.add(layer19);

            DataSource source20 = new DataSource();
            map.sources.add(source20);
            Feature feature20 = Feature.fromGeometry(Point.fromLngLat(77.7088481,13.2002695,210));
            source20.add(feature20);
            SymbolLayer layer20 = new SymbolLayer(source20,iconImage("marker-red"),SymbolLayerOptions.textField("Aster Pharmacy & Clinic"));
            layerList.add(layer20);

            // MEDICAL LAYER 19 to 20




            DataSource source21 = new DataSource();
            map.sources.add(source21);
            Feature feature21 = Feature.fromGeometry(Point.fromLngLat(77.708817,13.2002175,248));
            source21.add(feature21);
            SymbolLayer layer21 = new SymbolLayer(source21,iconImage("marker-blue"),SymbolLayerOptions.textField("Swarovski"));
            layerList.add(layer21);

            DataSource source22 = new DataSource();
            map.sources.add(source22);
            Feature feature22 = Feature.fromGeometry(Point.fromLngLat(77.7083217,13.1993354,517));
            source22.add(feature22);
            SymbolLayer layer22 = new SymbolLayer(source22,iconImage("marker-blue"),SymbolLayerOptions.textField("Duty Free"));
            layerList.add(layer22);

            DataSource source23 = new DataSource();
            map.sources.add(source23);
            Feature feature23 = Feature.fromGeometry(Point.fromLngLat(77.708449,13.1995019,447));
            source23.add(feature23);
            SymbolLayer layer23 = new SymbolLayer(source23,iconImage("marker-blue"),SymbolLayerOptions.textField("FSTR"));
            layerList.add(layer23);

            DataSource source24 = new DataSource();
            map.sources.add(source24);
            Feature feature24 = Feature.fromGeometry(Point.fromLngLat(77.7085024,13.2000034,266));
            source24.add(feature24);
            SymbolLayer layer24 = new SymbolLayer(source24,iconImage("marker-blue"),SymbolLayerOptions.textField("Fossil and skagen store at airport"));
            layerList.add(layer24);

            DataSource source25 = new DataSource();
            map.sources.add(source25);
            Feature feature25 = Feature.fromGeometry(Point.fromLngLat(77.7082659,13.1998623,328));
            source25.add(feature25);
            SymbolLayer layer25 = new SymbolLayer(source25,iconImage("marker-blue"),SymbolLayerOptions.textField("Hidesign"));
            layerList.add(layer25);

            DataSource source26 = new DataSource();
            map.sources.add(source26);
            Feature feature26 = Feature.fromGeometry(Point.fromLngLat(77.7082885,13.199763,360));
            source26.add(feature26);
            SymbolLayer layer26 = new SymbolLayer(source26,iconImage("marker-blue"),SymbolLayerOptions.textField("Mithastop"));
            layerList.add(layer26);

            DataSource source27 = new DataSource();
            map.sources.add(source27);
            Feature feature27 = Feature.fromGeometry(Point.fromLngLat(77.7081766,13.199696,451));
            source27.add(feature27);
            SymbolLayer layer27 = new SymbolLayer(source27,iconImage("marker-blue"),SymbolLayerOptions.textField("Relay"));
            layerList.add(layer27);

            DataSource source28 = new DataSource();
            map.sources.add(source28);
            Feature feature28 = Feature.fromGeometry(Point.fromLngLat(77.7097926,13.2001642,414));
            source28.add(feature28);
            SymbolLayer layer28 = new SymbolLayer(source28,iconImage("marker-blue"),SymbolLayerOptions.textField("WHSmith"));
            layerList.add(layer28);

            DataSource source29 = new DataSource();
            map.sources.add(source29);
            Feature feature29 = Feature.fromGeometry(Point.fromLngLat(77.7077882,13.1993455,491));
            source29.add(feature29);
            SymbolLayer layer29 = new SymbolLayer(source29,iconImage("marker-blue"),SymbolLayerOptions.textField("Buzz"));
            layerList.add(layer29);

            DataSource source30 = new DataSource();
            map.sources.add(source30);
            Feature feature30 = Feature.fromGeometry(Point.fromLngLat(77.7081292,13.2001311,360));
            source30.add(feature30);
            SymbolLayer layer30 = new SymbolLayer(source30,iconImage("marker-blue"),SymbolLayerOptions.textField("The Lotus House"));
            layerList.add(layer30);

            // SHOPS LAYERS 21 to 30




            DataSource source31 = new DataSource();
            map.sources.add(source31);
            Feature feature31 = Feature.fromGeometry(Point.fromLngLat(77.6791899,13.1878196,4840));
            source31.add(feature31);
            SymbolLayer layer31 = new SymbolLayer(source31,iconImage("marker-black"),SymbolLayerOptions.textField("Taj Bangalore"));
            layerList.add(layer31);

            DataSource source32 = new DataSource();
            map.sources.add(source32);
            Feature feature32 = Feature.fromGeometry(Point.fromLngLat(77.6340573,13.1924542,4848));
            source32.add(feature32);
            SymbolLayer layer32 = new SymbolLayer(source32,iconImage("marker-black"),SymbolLayerOptions.textField("Regenta Inn Bangalore"));
            layerList.add(layer32);

            DataSource source33 = new DataSource();
            map.sources.add(source33);
            Feature feature33 = Feature.fromGeometry(Point.fromLngLat(77.6340573,13.1924542,4848));
            source33.add(feature32);
            SymbolLayer layer33 = new SymbolLayer(source33,iconImage("marker-black"),SymbolLayerOptions.textField("Regenta Inn Bangalore"));
            layerList.add(layer33);



            binding.restaurants.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    map.layers.remove(layerList.toArray(new SymbolLayer[layerList.size()]));
                    map.setCamera(CameraOptions.zoom(17));

                    map.layers.add(layer6);
                    map.layers.add(layer7);
                    map.layers.add(layer8);
                    map.layers.add(layer9);
                    map.layers.add(layer10);
                    map.layers.add(layer11);
                    map.layers.add(layer12);
                    map.layers.add(layer13);
                    map.layers.add(layer14);

                }
            });

            binding.parking.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    map.layers.remove(layerList.toArray(new SymbolLayer[layerList.size()]));
                    map.setCamera(CameraOptions.zoom(16));

                    map.layers.add(layer0);
                    map.layers.add(layer1);
                    map.layers.add(layer2);
                    map.layers.add(layer3);
                    map.layers.add(layer4);
                    map.layers.add(layer5);

                }
            });

            binding.atms.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    map.layers.remove(layerList.toArray(new SymbolLayer[layerList.size()]));
                    map.setCamera(CameraOptions.zoom(16));

                    map.layers.add(layer15);
                    map.layers.add(layer16);
                    map.layers.add(layer17);
                    map.layers.add(layer18);

                }
            });

            binding.medical.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    map.layers.remove(layerList.toArray(new SymbolLayer[layerList.size()]));
                    map.setCamera(CameraOptions.zoom(16));

                    map.layers.add(layer19);
                    map.layers.add(layer20);

                }
            });

            binding.shopping.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    map.layers.remove(layerList.toArray(new SymbolLayer[layerList.size()]));
                    map.setCamera(CameraOptions.zoom(17));

                    map.layers.add(layer21);
                    map.layers.add(layer22);
                    map.layers.add(layer23);
                    map.layers.add(layer24);
                    map.layers.add(layer25);
                    map.layers.add(layer26);
                    map.layers.add(layer27);
                    map.layers.add(layer28);
                    map.layers.add(layer29);
                    map.layers.add(layer30);

                }
            });

            binding.lounges.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    map.layers.remove(layerList.toArray(new SymbolLayer[layerList.size()]));
                    map.setCamera(CameraOptions.zoom(12));

                    map.layers.add(layer31);
                    map.layers.add(layer32);

                }
            });

            binding.preview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (count % 2 == 0) {
                        map.setStyle(StyleOptions.style(MapStyle.SATELLITE_ROAD_LABELS));
                        Toast.makeText(getContext(), "Loading Satellite View", Toast.LENGTH_SHORT).show();
                    } else {
                        map.setStyle(StyleOptions.style(MapStyle.ROAD));
                        Toast.makeText(getContext(), "Loading Normal View", Toast.LENGTH_SHORT).show();
                    }
                    count++;

                    Log.i("MapsFragment", "Count: " + count);

                }
            });

        });

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapControl.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        mapControl.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapControl.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapControl.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapControl.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapControl.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapControl.onSaveInstanceState(outState);
    }

}