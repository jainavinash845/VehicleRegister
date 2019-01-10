package com.example.avinash.vehicleregister;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;


public class BlankFragment extends DialogFragment {
    SearchView sv;
    ListView lv;
    String str;
    String [] year ,make,model,colour,seatbalts,door;
    private MComplete mComplete;
    public MainActivity.VehicleDetails vehicleDetails;

    public ArrayAdapter<String> adapter_year,adapter_make,adapter_model,adColour,adSeatbalts,adDoor;

    public  BlankFragment() {
        // Required empty public constructor
    }
    public static BlankFragment newInstance(String[] s,MainActivity.VehicleDetails vehicleDetails) {

        Bundle args = new Bundle();
        args.putStringArray("file_name", s);
        args.putSerializable("vehicle_detail", vehicleDetails);

       BlankFragment b = new BlankFragment();
        b.setArguments(args);

        return b;
    }


    public void onAttach(Activity activity){
        super.onAttach(activity);
        try {
            this.mComplete=(MComplete)activity;
        }
        catch (Exception e){
            System.err.println(e);
        }
    }
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        year = getArguments().getStringArray("file_name");
        make=getArguments().getStringArray("file_name");
        model  =getArguments().getStringArray("file_name");
        colour = getArguments().getStringArray("file_name");
        seatbalts = getArguments().getStringArray("file_name");
        door = getArguments().getStringArray("file_name");

        vehicleDetails =  (MainActivity.VehicleDetails) getArguments().getSerializable("vehicle_detail");
    }
    public static interface MComplete {

        public  void onComplete(String s, MainActivity.VehicleDetails vehicleDetails);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getDialog().setTitle("Choose Your Car");
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_blank, container, false);

        lv=view.findViewById(R.id.lv);
        sv=view.findViewById(R.id.sv);


       adapter_year =  new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,year);
        lv.setAdapter(adapter_year);

       adapter_make = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,make);
        lv.setAdapter(adapter_make);

        adapter_model = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,model);
        lv.setAdapter(adapter_model);

        adColour = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,colour);
        lv.setAdapter(adColour);

        adSeatbalts = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,seatbalts);
        lv.setAdapter(adSeatbalts);

        adDoor = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,door);
        lv.setAdapter(adDoor);

        //Searching list....
        sv.setQueryHint("search");
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String txt) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String txt) {
                adapter_year.getFilter().filter(txt);
                adapter_make.getFilter().filter(txt);
                adapter_model.getFilter().filter(txt);
                adColour.getFilter().filter(txt);
                adSeatbalts.getFilter().filter(txt);
                adDoor.getFilter().filter(txt);
                return true;
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                str =(String) lv.getItemAtPosition(position);
                mComplete.onComplete(str, vehicleDetails);
                dismiss();
            }
        });
        return view;
    }

}
