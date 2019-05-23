package paramount.com.androidproject.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import paramount.com.androidproject.R;
import paramount.com.androidproject.adapters.BuildYourOwnAdapter;
import paramount.com.androidproject.adapters.PackageAdapter;
import paramount.com.androidproject.models.Item;
import paramount.com.androidproject.models.Menu;
import paramount.com.androidproject.models.Own;
import paramount.com.androidproject.models.Packages;
import paramount.com.androidproject.utils.DominoBoldTextView;
import paramount.com.androidproject.utils.EqualSpacingItemDecoration;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuildYourOwnFragment extends Fragment {

    LinearLayoutManager linearLayoutManager;
    RecyclerView rv_build_your_ownList;
    BuildYourOwnAdapter buildYourOwnAdapter;
    Context mContext;
    Button btn_chooseLocation;
    ArrayList<Item> buildYourOwnDetailArrayList;

    DatabaseReference databaseReference;
    Item buildYourOwnData;
    Menu menu;

//    Context mContext;
//    Menu menu;

    DominoBoldTextView s1, s2, s3, s4, s5, s6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_build_your_own, container, false);

        init(view);
        mContext = getActivity();

        return view;
    }

    private void init(View view) {


        rv_build_your_ownList = (RecyclerView) view.findViewById(R.id.rv_ownList);

        // DividerItemDecoration dividerItemDecoration = new DividerItemDecoration()

        buildYourOwnData = new Item();
        buildYourOwnDetailArrayList = new ArrayList<>();

        menu = new Menu();
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference users = rootRef.child("Menu");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    if (ds.getKey().equals("Own")) {
//                        menu.setItems(ds.getValue(Item.class));
                        Iterable<DataSnapshot> threadDetails = ds.getChildren();

//
                        for (DataSnapshot snap : threadDetails) {

                            System.out.println("DataSnapshot Sauce string value --- > "+snap.toString());
                            //for (DataSnapshot locationItem : dataSnapshot.getChildren()) {
                            String package_id = snap.getKey();
                            buildYourOwnData = snap.getValue(Item.class);
//                    lolocationData.getLocation_id();
                           // buildYourOwnData.setItem_id(package_id);
                            buildYourOwnDetailArrayList.add(buildYourOwnData);
                            Log.d("list size-->", buildYourOwnDetailArrayList.size() + "");
                        }

                        buildYourOwnAdapter = new BuildYourOwnAdapter(mContext, buildYourOwnDetailArrayList);
                        linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
                        rv_build_your_ownList.setLayoutManager(linearLayoutManager);
                        rv_build_your_ownList.setAdapter(buildYourOwnAdapter);
                        rv_build_your_ownList.addItemDecoration(new EqualSpacingItemDecoration(20, EqualSpacingItemDecoration.VERTICAL));

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        };

        users.addListenerForSingleValueEvent(eventListener);
    }

}
