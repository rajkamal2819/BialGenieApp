package com.Hackathon.bialgenieapp.Fragments;

import static com.azure.android.maps.control.options.LineLayerOptions.strokeColor;
import static com.azure.android.maps.control.options.LineLayerOptions.strokeWidth;
import static com.azure.android.maps.control.options.PopupOptions.content;
import static com.azure.android.maps.control.options.PopupOptions.position;
import static com.azure.android.maps.control.options.SymbolLayerOptions.iconImage;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.FragmentMapsBinding;
import com.azure.android.maps.control.AzureMaps;
import com.azure.android.maps.control.MapControl;
import com.azure.android.maps.control.MapMath;
import com.azure.android.maps.control.Popup;
import com.azure.android.maps.control.data.Position;
import com.azure.android.maps.control.events.OnFeatureClick;
import com.azure.android.maps.control.layer.BubbleLayer;
import com.azure.android.maps.control.layer.SymbolLayer;
import com.azure.android.maps.control.options.AnchorType;
import com.azure.android.maps.control.options.CameraOptions;
import com.azure.android.maps.control.options.MapStyle;
import com.azure.android.maps.control.options.PopupOptions;
import com.azure.android.maps.control.options.StyleOptions;
import com.azure.android.maps.control.options.SymbolLayerOptions;
import com.azure.android.maps.control.source.DataSource;
import com.google.gson.JsonObject;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.Point;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

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
    String latitude, longitude;
    private static final int REQUEST_LOCATION = 1;
    private String LOG_TAG = MapsFragment.class.getSimpleName();

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
            source.importDataFromUrl("https://bialtable.file.core.windows.net/maps/POI_geoJson_bial_restaurants.json?sp=r&st=2022-01-02T23:37:15Z&se=2022-03-03T23:37:00Z&spr=https&sv=2020-08-04&sig=pxBth2PdiP%2FHe%2F9H%2BxufzmayNAAsaRovdSoRXS3TrLc%3D&sr=f");
            map.sources.add(source);

            DataSource sourceParking = new DataSource();
            sourceParking.importDataFromUrl("https://bialtable.file.core.windows.net/maps/POI_geoJson_bial_parking.json?sp=r&st=2022-01-02T23:36:36Z&se=2022-03-03T23:36:00Z&spr=https&sv=2020-08-04&sig=1z3U9y2Ag5RW5jyXJ3Pz8Cgbt0NQvoZwCje%2BV5G6t0Y%3D&sr=f");
            map.sources.add(sourceParking);

            DataSource sourceShopping = new DataSource();
            sourceShopping.importDataFromUrl("https://bialtable.file.core.windows.net/maps/POI_geoJson_bial_Shopping.json?sp=r&st=2022-01-02T23:37:54Z&se=2022-03-03T23:37:00Z&spr=https&sv=2020-08-04&sig=1EeSt2gGVjJRCuZsjSGrOJKhxpf7fivNetP1F%2BMosnk%3D&sr=f");
            map.sources.add(sourceShopping);

            DataSource sourceAtm = new DataSource();
            sourceAtm.importDataFromUrl("https://bialtable.file.core.windows.net/maps/POI_geoJson_bial_atms.json?sp=r&st=2022-01-02T23:35:52Z&se=2022-03-03T23:35:00Z&spr=https&sv=2020-08-04&sig=XpDCPvnmUNTLye9mN5uFkFWDGOfJblkNS74t3yM0zVk%3D&sr=f");
            map.sources.add(sourceAtm);

            DataSource sourceMedical = new DataSource();
            sourceMedical.importDataFromUrl("https://bialtable.file.core.windows.net/maps/POI_geoJson_bial_medical.json?sp=r&st=2022-01-02T23:38:35Z&se=2022-03-03T23:38:00Z&spr=https&sv=2020-08-04&sig=EKnIzXOTCvoBCoRXN0xz826XwCpOEfHrHrpO8O5TpEM%3D&sr=f");
            map.sources.add(sourceMedical);

            DataSource sourceSpecials = new DataSource();
            sourceSpecials.importDataFromUrl("https://bialtable.file.core.windows.net/maps/POI_geoJson_bial_specials.json?sp=r&st=2022-01-02T23:39:34Z&se=2022-03-03T23:39:00Z&spr=https&sv=2020-08-04&sig=%2B6r%2B1ipsW0GMJd0a6g2WzquLRoNA0R9kyEVrWzCNhCQ%3D&sr=f");
            map.sources.add(sourceSpecials);


            ArrayList<BubbleLayer> layersList = new ArrayList<>();
            BubbleLayer layer = new BubbleLayer(source);
            layersList.add(layer);
            BubbleLayer layerParking = new BubbleLayer(sourceParking);
            layersList.add(layerParking);
            BubbleLayer layerShopping = new BubbleLayer(sourceShopping);
            layersList.add(layerShopping);
            BubbleLayer layerAtms = new BubbleLayer(sourceAtm);
            layersList.add(layerAtms);
            BubbleLayer layerMedical = new BubbleLayer(sourceMedical);
            layersList.add(layerMedical);
            BubbleLayer layerSpecial = new BubbleLayer(sourceSpecials);
            layersList.add(layerSpecial);

            binding.restaurants.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    map.layers.remove(layersList.toArray(new BubbleLayer[layersList.size()]));
                    map.layers.add(layer);
                }
            });

            binding.parking.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    map.layers.remove(layersList.toArray(new BubbleLayer[layersList.size()]));
                    map.layers.add(layerParking);
                }
            });

            binding.shopping.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    map.layers.remove(layersList.toArray(new BubbleLayer[layersList.size()]));
                    map.layers.add(layerShopping);
                }
            });

            binding.atms.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    map.layers.remove(layersList.toArray(new BubbleLayer[layersList.size()]));
                    map.layers.add(layerAtms);
                }
            });

            binding.specials.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    map.layers.remove(layersList.toArray(new BubbleLayer[layersList.size()]));
                    map.layers.add(layerSpecial);
                }
            });

            binding.medical.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    map.layers.remove(layersList.toArray(new BubbleLayer[layersList.size()]));
                    map.layers.add(layerMedical);
                }
            });

            Popup popup = new Popup();
            map.popups.add(popup);
            popup.close();

            map.events.add((OnFeatureClick) (feature) -> {
                Feature f = feature.get(0);
                // Log.d(LOG_TAG,f.toString());
                JsonObject props = f.properties();
                View customView = LayoutInflater.from(getContext()).inflate(R.layout.popup_text, null);

                TextView tv1 = customView.findViewById(R.id.nameSpot);
                tv1.setText(f.getStringProperty("Name"));
                ImageView imageView = customView.findViewById(R.id.imageSpot);
                Picasso.get().load(f.getStringProperty("imageUrl")).into(imageView);
                Position pos = MapMath.getPosition((Point) f.geometry());

                popup.setOptions(
                        position(pos),
                        PopupOptions.anchor(AnchorType.BOTTOM),
                        content(customView)
                );
                popup.open();
                return false;
            }, layer, layerParking, layerShopping,layerAtms,layerMedical,layerSpecial);


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