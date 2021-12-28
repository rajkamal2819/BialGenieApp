package com.Hackathon.bialgenieapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Hackathon.bialgenieapp.Actvities.ChatBotActivity;
import com.Hackathon.bialgenieapp.Actvities.FeedbackForm;
import com.Hackathon.bialgenieapp.databinding.FragmentMoreBinding;


public class MoreFragment extends Fragment {


    public MoreFragment() {
        // Required empty public constructor
    }

    FragmentMoreBinding binding;
    private static String LOG_TAG = MoreFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMoreBinding.inflate(getLayoutInflater());


        binding.chatBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ChatBotActivity.class));
            }
        });

        binding.feedbackForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), FeedbackForm.class));
            }
        });

       // Log.i(LOG_TAG,""+ result[0]);


        return  binding.getRoot();
    }


}