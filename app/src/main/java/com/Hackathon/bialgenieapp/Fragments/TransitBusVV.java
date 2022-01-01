package com.Hackathon.bialgenieapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.Hackathon.bialgenieapp.Database.CreateBusTable;
import com.Hackathon.bialgenieapp.Database.Route_Model;
import com.Hackathon.bialgenieapp.Fragments.Transit.BusRoute;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.Route;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class TransitBusVV extends Fragment implements AdapterView.OnItemClickListener{
    //arrivals in list and in textview
    Spinner spn;
    Button btn,btn1;
    View v;
    String routeselected,routeselected2;

    ArrayList<Route_Model> banashankari_ttmc,billekahali,central_silk_board,chandapura,dlf,domalur,electronic,hal,halasur,hebbal,hope,hsr,indirangar,jayanagar,jp,kadugodi,kempegowda,marthahalli,marthahalli_bridge,mekri,mg,mctc,shanthinagar,shivajinagar,sony,shivananda,taj,tin,vijaynagar,west,white,white_ttmc,yeshavanthapura;


    public TransitBusVV() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_transit_bus_v_v, container, false);

        banashankari_ttmc = new ArrayList<>();
        banashankari_ttmc.add(new Route_Model("KIAB-5"));

        billekahali = new ArrayList<>();
        billekahali.add(new Route_Model("KIAB-14"));


        central_silk_board = new ArrayList<>();
        central_silk_board.add(new Route_Model("KIAB-8"));
        central_silk_board.add(new Route_Model("KIAB-8C"));

        chandapura = new ArrayList<>();
        chandapura.add(new Route_Model("KIAB-8C"));

        dlf = new ArrayList<>();
        dlf.add(new Route_Model("KIAB-14"));

        domalur = new ArrayList<>();
        domalur.add(new Route_Model("KIAB-6"));
        domalur.add(new Route_Model("KIAB-7A"));

        electronic = new ArrayList<>();
        electronic.add(new Route_Model("KIAB-8C"));
        electronic.add(new Route_Model("KIAB-8"));

        hal = new ArrayList<>();
        hal.add(new Route_Model("KIAB-4"));

        halasur = new ArrayList<>();
        halasur.add(new Route_Model("KIAB-4A"));
        halasur.add(new Route_Model("KIAB-4"));

        hebbal = new ArrayList<>();
        hebbal.add(new Route_Model("KIAB-4A"));
        hebbal.add(new Route_Model("KIAB-4"));
        hebbal.add(new Route_Model("KIAB-14"));
        hebbal.add(new Route_Model("KIAB-5"));
        hebbal.add(new Route_Model("KIAB-8C"));
        hebbal.add(new Route_Model("KIAB-6"));
        hebbal.add(new Route_Model("KIAB-8"));
        hebbal.add(new Route_Model("KIAB-7A"));
        hebbal.add(new Route_Model("KIAB-9"));
        hebbal.add(new Route_Model("KIAB-10"));

        hope = new ArrayList<>();
        hope.add(new Route_Model("KIAB-6"));

        hsr = new ArrayList<>();
        hsr.add(new Route_Model("KIAB-7A"));

        indirangar = new ArrayList<>();
        indirangar.add(new Route_Model("KIAB-4A"));
        indirangar.add(new Route_Model("KIAB-4"));

        jayanagar = new ArrayList<>();
        jayanagar.add(new Route_Model("KIAB-5"));

        jp = new ArrayList<>();
        jp.add(new Route_Model("KIAB-5"));

        kadugodi = new ArrayList<>();
        kadugodi.add(new Route_Model("KIAB-6"));

        kempegowda = new ArrayList<>();
        kempegowda.add(new Route_Model("KIAB-9"));

        marthahalli = new ArrayList<>();
        marthahalli.add(new Route_Model("KIAB-6"));

        marthahalli_bridge = new ArrayList<>();
        marthahalli_bridge.add(new Route_Model("KIAB-8"));
        marthahalli_bridge.add(new Route_Model("KIAB-8C"));

        mekri = new ArrayList<>();
        mekri.add(new Route_Model("KIAB-14"));
        mekri.add(new Route_Model("KIAB-4A"));
        mekri.add(new Route_Model("KIAB-4"));
        mekri.add(new Route_Model("KIAB-5"));
        mekri.add(new Route_Model("KIAB-9"));

        mg = new ArrayList<>();
        mg.add(new Route_Model("KIAB-5"));
        mg.add(new Route_Model("KIAB-7A"));
        mg.add(new Route_Model("KIAB-6"));

        mctc = new ArrayList<>();
        mctc.add(new Route_Model("KIAB-10"));

        shanthinagar = new ArrayList<>();
        shanthinagar.add(new Route_Model("KIAB-5"));
        shanthinagar.add(new Route_Model("KIAB-14"));

        shivajinagar = new ArrayList<>();
        shivajinagar.add(new Route_Model("KIAB-7A"));

        shivananda = new ArrayList<>();
        shivananda.add(new Route_Model("KIAB-9"));

        sony = new ArrayList<>();
        sony.add(new Route_Model("KIAB-7A"));

        taj = new ArrayList<>();
        taj.add(new Route_Model("KIAB-4A"));
        taj.add(new Route_Model("KIAB-4"));

        tin = new ArrayList<>();
        tin.add(new Route_Model("KIAB-8C"));
        tin.add(new Route_Model("KIAB-8"));

        vijaynagar = new ArrayList<>();
        vijaynagar.add(new Route_Model("KIAB-10"));

        west = new ArrayList<>();
        west.add(new Route_Model("KIAB-10"));

        white = new ArrayList<>();
        white.add(new Route_Model("KIAB-6"));

        white_ttmc= new ArrayList<>();
        white_ttmc.add(new Route_Model("KIAB-4A"));

        yeshavanthapura= new ArrayList<>();
        yeshavanthapura.add(new Route_Model("KIAB-10"));


/*  CreateBusTable c = new CreateBusTable();
  c.create();*/

      /*  spn = v.findViewById(R.id.spinner2);*/
        btn = v.findViewById(R.id.btn);
      String[] routes = getResources().getStringArray(R.array.routes);
     ArrayAdapter<String> routeadapter = new ArrayAdapter<String>(getContext(),R.layout.bus_selector_item,routes);
        AutoCompleteTextView autocompletetextview = v.findViewById(R.id.autoCompleteTextView);
       autocompletetextview.setAdapter(routeadapter);
       autocompletetextview.setOnItemClickListener(this::onItemClick);
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(getContext(), BusRoute.class);
               i.putExtra("route",routeselected);
               startActivity(i);
           }
       });
        btn1 = v.findViewById(R.id.btn2);
        String[] routes1 = getResources().getStringArray(R.array.Routes);
        ArrayAdapter<String> routeadapter1 = new ArrayAdapter<String>(getContext(),R.layout.bus_selector_item,routes1);
        AutoCompleteTextView autocompletetextview1 = v.findViewById(R.id.autoCompleteTextView2);
        autocompletetextview1.setAdapter(routeadapter1);
        autocompletetextview1.setOnItemClickListener(this::onItemClick);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), Route.class);
                Bundle args = new Bundle();
                switch(routeselected)
                {
                    case "Banashankari TTMC":

                        args.putSerializable("ARRAYLIST",(Serializable)banashankari_ttmc);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Billekahalli"   :

                        args.putSerializable("ARRAYLIST",(Serializable)billekahali);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Central Silk Board"   :

                        args.putSerializable("ARRAYLIST",(Serializable)central_silk_board);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Chandapura"   :
                        args.putSerializable("ARRAYLIST",(Serializable)chandapura);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "DLF Apartment"   :

                        args.putSerializable("ARRAYLIST",(Serializable)dlf);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Domalur"   :
                        args.putSerializable("ARRAYLIST",(Serializable)domalur);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Electronic City"   :
                        args.putSerializable("ARRAYLIST",(Serializable)electronic);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "HAL"   :
                        args.putSerializable("ARRAYLIST",(Serializable)hal);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Halasur Lake"   :
                        args.putSerializable("ARRAYLIST",(Serializable)halasur);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Hebbal"   :
                        args.putSerializable("ARRAYLIST",(Serializable)hebbal);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Hope Farm"   :
                        args.putSerializable("ARRAYLIST",(Serializable)hope);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "HSR Layout BDA Complex"   :
                        args.putSerializable("ARRAYLIST",(Serializable)hsr);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Indiranagar KFC"   :
                        args.putSerializable("ARRAYLIST",(Serializable)indirangar);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Jayanagar 4th Block"   :
                        args.putSerializable("ARRAYLIST",(Serializable)jayanagar);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "JP Nagar 6th Phase"   :
                        args.putSerializable("ARRAYLIST",(Serializable)jp);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Kadugodi Bus Station"   :
                        args.putSerializable("ARRAYLIST",(Serializable)kadugodi);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Kempegowda Bus Station"   :
                        args.putSerializable("ARRAYLIST",(Serializable)kempegowda);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Marthahalli"   :
                        args.putSerializable("ARRAYLIST",(Serializable)marthahalli);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Marthahalli Bridge"   :
                        args.putSerializable("ARRAYLIST",(Serializable)marthahalli_bridge);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Mekri Cicle"   :
                        args.putSerializable("ARRAYLIST",(Serializable)mekri);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "MG Road"   :
                        args.putSerializable("ARRAYLIST",(Serializable)mg);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Mysuru Road Bus Station (MCTC)"   :
                        args.putSerializable("ARRAYLIST",(Serializable)mctc);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Shanthinagar TTMC"   :
                        args.putSerializable("ARRAYLIST",(Serializable)shanthinagar);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Shivajinagar Bus Station"   :
                        args.putSerializable("ARRAYLIST",(Serializable)shivajinagar);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Shivananda Circle"   :
                        args.putSerializable("ARRAYLIST",(Serializable)shivananda);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Sony World signal"   :
                        args.putSerializable("ARRAYLIST",(Serializable)sony);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Taj Residency"   :
                        args.putSerializable("ARRAYLIST",(Serializable)taj);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Tinfactory"   :
                        args.putSerializable("ARRAYLIST",(Serializable)tin);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Vijaynagar"   :
                        args.putSerializable("ARRAYLIST",(Serializable)vijaynagar);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "West of Chord Road"   :
                        args.putSerializable("ARRAYLIST",(Serializable)west);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "White Field"   :
                        args.putSerializable("ARRAYLIST",(Serializable)white);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "White Field TTMC"   :
                        args.putSerializable("ARRAYLIST",(Serializable)white_ttmc);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    case "Yeshavanthapura"   :
                        args.putSerializable("ARRAYLIST",(Serializable)yeshavanthapura);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                        break;
                    default :
                        Toast.makeText(getContext(),"Invalid Option",Toast.LENGTH_LONG).show();


                }

            }
        });

        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
         routeselected = adapterView.getItemAtPosition(i).toString();


    }
}