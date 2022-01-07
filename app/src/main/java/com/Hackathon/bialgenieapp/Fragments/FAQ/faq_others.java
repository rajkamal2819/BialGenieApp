package com.Hackathon.bialgenieapp.Fragments.FAQ;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Hackathon.bialgenieapp.Adapters.FAQ_Adapter;
import com.Hackathon.bialgenieapp.Models.FAQ_Model;
import com.Hackathon.bialgenieapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link faq_others#newInstance} factory method to
 * create an instance of this fragment.
 */
public class faq_others extends Fragment {


    View v;
    RecyclerView recyclerView;
    ArrayList<FAQ_Model> faqholder;
    public final String connectionString =
            "DefaultEndpointsProtocol=https;AccountName=bialtable;AccountKey=wRCVF2troxwyrE9pieQU0tjN84QSOwnq0ybCZBg+b76/EIUD3xFmM2p19Dn8hiIyKWGs1gPAm5cyKhHxh2y7oA==;EndpointSuffix=core.windows.net";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public faq_others() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment faq_others.
     */
    // TODO: Rename and change types and number of parameters
    public static faq_others newInstance(String param1, String param2) {
        faq_others fragment = new faq_others();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =  inflater.inflate(R.layout.fragment_faq_menu, container, false);

        recyclerView = v.findViewById(R.id.faq_ReView);

        faqholder = new ArrayList<>();

//        try
//        {
//            // Define constants for filters.
//            final String PARTITION_KEY = "PartitionKey";
//            final String tableName = "FAQ";
//
//            // Create a TableClient with a connection string and a table name.
//            TableClient tableClient = new TableClientBuilder()
//                    .connectionString(connectionString)
//                    .tableName(tableName)
//                    .buildClient();
//
//            // Create a filter condition where the partition key is "Other".
//            ListEntitiesOptions options = new ListEntitiesOptions().setFilter(PARTITION_KEY + " eq 'Other'");
//
//            // Loop through the results, displaying information about the entities.
//            tableClient.listEntities(options, null, null).forEach(tableEntity -> {
//
//                  faqholder.add(new FAQ_Model(tableEntity.getProperty("Question"),tableEntity.getProperty("Answer")));
//            });
//        }
//        catch (Exception e)
//        {
//            // Output the stack trace.
//            e.printStackTrace();
//        }





        FAQ_Adapter faq_adapter = new FAQ_Adapter(faqholder);
        recyclerView.setAdapter(faq_adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //recyclerView.setHasFixedSize(true);
        return v;
    }
}