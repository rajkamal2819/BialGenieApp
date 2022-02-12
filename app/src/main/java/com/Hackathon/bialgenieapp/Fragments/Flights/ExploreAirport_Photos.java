package com.Hackathon.bialgenieapp.Fragments.Flights;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Hackathon.bialgenieapp.Adapters.AirportPhotosAdapter;
import com.Hackathon.bialgenieapp.Adapters.RestaurantShoppingAdapter;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.FragmentExploreAirportPhotosBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExploreAirport_Photos extends Fragment {

    public ExploreAirport_Photos() {
        // Required empty public constructor
    }

    FragmentExploreAirportPhotosBinding binding;
    ArrayList<String> cafeList, csrList, loungeList, terminalList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentExploreAirportPhotosBinding.inflate(getLayoutInflater());

        cafeList = new ArrayList<>();
        csrList = new ArrayList<>();
        loungeList = new ArrayList<>();
        terminalList = new ArrayList<>();

        String linkStart = "https://bialtable.blob.core.windows.net/exploreairportimages/";
        for (int i = 0;i<5;i++){
            cafeList.add(linkStart+"cafe"+(i+1)+".jpg");
            csrList.add(linkStart+"csr"+(i+1)+".jpg");
            terminalList.add(linkStart+"terminal"+(i+1)+".jpg");
            loungeList.add(linkStart+"lounge"+(i+1)+".jpg");
        }
        loungeList.add(linkStart+"lounge"+6+".jpg");

        updateUi();

        return binding.getRoot();
    }

    public void updateUi() {

        binding.textCafe.setVisibility(View.VISIBLE);
        AirportPhotosAdapter adapterCafe = new AirportPhotosAdapter(cafeList, binding.recyclerViewCafe, getContext());
        binding.recyclerViewCafe.setAdapter(adapterCafe);
        binding.recyclerViewCafe.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        adapterCafe.notifyDataSetChanged();

        binding.textLounges.setVisibility(View.VISIBLE);
        AirportPhotosAdapter adapterLounges = new AirportPhotosAdapter(loungeList, binding.recyclerViewLounges, getContext());
        binding.recyclerViewLounges.setAdapter(adapterLounges);
        binding.recyclerViewLounges.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        adapterLounges.notifyDataSetChanged();

        binding.textCsr.setVisibility(View.VISIBLE);
        AirportPhotosAdapter adapterCsr = new AirportPhotosAdapter(csrList, binding.recyclerViewCsr, getContext());
        binding.recyclerViewCsr.setAdapter(adapterCsr);
        binding.recyclerViewCsr.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        adapterCsr.notifyDataSetChanged();

        binding.textTerminal.setVisibility(View.VISIBLE);
        AirportPhotosAdapter adapterTerminal = new AirportPhotosAdapter(terminalList, binding.recyclerViewTerminal, getContext());
        binding.recyclerViewTerminal.setAdapter(adapterTerminal);
        binding.recyclerViewTerminal.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        adapterTerminal.notifyDataSetChanged();

        binding.progressBar1.setVisibility(View.GONE);

    }

}