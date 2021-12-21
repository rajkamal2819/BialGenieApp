package com.Hackathon.bialgenieapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Hackathon.bialgenieapp.databinding.FragmentMapsBinding;
import com.azure.android.maps.control.AzureMaps;
import com.azure.android.maps.control.MapControl;
import com.azure.android.maps.control.options.CameraOptions;
import com.azure.android.maps.control.options.MapStyle;
import com.azure.android.maps.control.options.StyleOptions;
import com.mapbox.geojson.Point;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMapsBinding.inflate(getLayoutInflater());

        mapControl = binding.mapcontrol;

        mapControl.onCreate(savedInstanceState);

        //Wait until the map resources are ready.
        mapControl.onReady(map -> {

            //   map.setCamera(CameraOptions.center(Point.fromLngLat(77.710228, 13.200771)), CameraOptions.zoom(15));
              map.setStyle(StyleOptions.style(MapStyle.SATELLITE_ROAD_LABELS));

           /* map.setCamera(
                    //The area to focus the map on.
                    CameraBoundsOptions.bounds(BoundingBox.fromLngLats(
                            //West
                            77.710228,

                            //South
                            13.200771,

                            //East
                            77.710228,

                            //North
                            13.200771
                    )),

                    //Amount of pixel buffer around the bounding box to provide extra space around the bounding box.
                    CameraBoundsOptions.padding(20),

                    //The maximum zoom level the map will zoom-in to when animating from one location to another on the map.
                    CameraBoundsOptions.maxZoom(14)
            );*/

            map.setCamera(CameraOptions.center(Point.fromLngLat(77.7081072,13.1990036)),

                    //The zoom level. Typically a value between 0 and 22.
                    CameraOptions.zoom(15),

                    //The amount of tilt in degrees the map where 0 is looking straight down.
                    CameraOptions.pitch(45),

                    //Direction the top of the map is pointing in degrees. 0 = North, 90 = East, 180 = South, 270 = West
                   // CameraOptions.pitch(90),

                    //The minimum zoom level the map will zoom-out to when animating from one location to another on the map.
                    CameraOptions.minZoom(10),

                    //The maximum zoom level the map will zoom-in to when animating from one location to another on the map.
                    CameraOptions.maxZoom(20));

            /*map.setCamera(
                    CameraOptions.center(Point.fromLngLat(77.710228, 13.200771)),
                    CameraOptions.zoom(16),
                    AnimationOptions.animationType(AnimationType.FLY),
                    AnimationOptions.animationDuration(3000)
            );*/

            //Create a data source and add it to the map.
            /*DataSource source = new DataSource();
            map.sources.add(source);

            Feature feature = Feature.fromGeometry(Point.fromLngLat(77.7081072,13.1990036));

            feature.addStringProperty("title", "Duty Free");

            source.add(feature);

            SymbolLayer layer = new SymbolLayer(source,
                    SymbolLayerOptions.textField(Expression.get("title"))
            );

            map.layers.add(layer);*/

            //Load a custom icon image into the image sprite of the map.
           /* map.images.add("my-custom-icon", R.drawable.food_img);

            DataSource source = new DataSource();
            map.sources.add(source);

            Feature feature = Feature.fromGeometry(Point.fromLngLat(77.710228, 13.200771));

            feature.addNumberProperty("temperature", 64);

            source.add(feature);

            SymbolLayer layer = new SymbolLayer(source,
                    SymbolLayerOptions.iconImage("my-custom-icon"),
                    SymbolLayerOptions.iconSize(0.1f),

                    //Get the title property of the feature and display it on the map.
                    SymbolLayerOptions.textField(Expression.concat(Expression.toString(Expression.get("temperature")), Expression.literal("°F"))),
                    SymbolLayerOptions.textOffset(new Float[]{0f, -1.5f})
            );

            map.layers.add(layer);*/


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