package paramount.com.androidproject.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

import paramount.com.androidproject.activities.GooglemapActivity;
import paramount.com.androidproject.R;
import paramount.com.androidproject.adapters.LocationsAdapter;
import paramount.com.androidproject.models.LocationDetail;
import paramount.com.androidproject.utils.EqualSpacingItemDecoration;

import static android.support.v7.widget.DividerItemDecoration.HORIZONTAL;
import static android.support.v7.widget.DividerItemDecoration.VERTICAL;


public class ChangeLocationFragment extends Fragment {


    LinearLayoutManager linearLayoutManager;
    RecyclerView rv_location;
    LocationsAdapter locationsAdapter;
    Context mContext;
    Button btn_chooseLocation;
    ArrayList<LocationDetail> locationDetailArrayList;

    DatabaseReference databaseReference;

    LocationDetail locationData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_change_location, container, false);


        mContext = getActivity();

        init(view);
        return view;

    }

    private void init(View view) {



        rv_location = (RecyclerView) view.findViewById(R.id.rv_locationList);

       // DividerItemDecoration dividerItemDecoration = new DividerItemDecoration()

        locationData = new LocationDetail();
        locationDetailArrayList = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                DataSnapshot threadSnap = dataSnapshot.child("Location");


                Iterable<DataSnapshot> threadDetails = threadSnap.getChildren();


                for (DataSnapshot snap : threadDetails) {
                    //for (DataSnapshot locationItem : dataSnapshot.getChildren()) {
                    String loc_id  = snap.getKey();
                    locationData = snap.getValue(LocationDetail.class);
//                    lolocationData.getLocation_id();
                    locationData.setId(loc_id);
                    locationDetailArrayList.add(locationData);
                    Log.d("list size-->"  ,locationDetailArrayList.size()+"");
                }

                locationsAdapter = new LocationsAdapter(mContext, locationDetailArrayList);
                linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
                rv_location.setLayoutManager(linearLayoutManager);
                rv_location.setAdapter(locationsAdapter);


                rv_location.addItemDecoration(new EqualSpacingItemDecoration(20,EqualSpacingItemDecoration.VERTICAL));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

}

