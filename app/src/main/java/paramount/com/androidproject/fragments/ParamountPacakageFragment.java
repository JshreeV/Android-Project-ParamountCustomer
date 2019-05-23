package paramount.com.androidproject.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import paramount.com.androidproject.R;
import paramount.com.androidproject.adapters.PackageAdapter;

import paramount.com.androidproject.adapters.PackageExpandableAdapter;
import paramount.com.androidproject.adapters.SidesExpandableAdapter;
import paramount.com.androidproject.models.Item;
import paramount.com.androidproject.models.Menu;
import paramount.com.androidproject.models.Packages;
import paramount.com.androidproject.models.Sides;
import paramount.com.androidproject.utils.DiavloBoldTextView;
import paramount.com.androidproject.utils.DominoBoldTextView;
import paramount.com.androidproject.utils.EqualSpacingItemDecoration;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParamountPacakageFragment extends Fragment {



    LinearLayoutManager linearLayoutManager;
    ExpandableListView rv_packageList;
    //PackageAdapter packageAdapter;

    PackageExpandableAdapter  packageExpandableAdapter;
    Context mContext;
    Button btn_chooseLocation;
    ArrayList<Packages> packageDetailArrayList;

    DatabaseReference databaseReference;
    Packages packageData;
    Menu menu;

    // RecyclerView rv_packageList;
//    Context mContext;
//    Menu menu;

    DominoBoldTextView p1, p2, p3, p4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_paramount_pacakage, container, false);

        init(view);
        mContext = getActivity();


        return view;
    }

    private void init(View view) {


        rv_packageList = (ExpandableListView) view.findViewById(R.id.rv_packagesList);

        // DividerItemDecoration dividerItemDecoration = new DividerItemDecoration()

        packageData = new Packages();
        packageDetailArrayList = new ArrayList<>();

        menu = new Menu();
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference users = rootRef.child("Menu");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {


                    if (ds.getKey().equals("Packages")) {
//                        menu.setItems(ds.getValue(Item.class));
                        Iterable<DataSnapshot> threadDetails = ds.getChildren();

//
                        for (DataSnapshot snap : threadDetails) {

                            System.out.println("DataSnapshot Sauce string value --- > "+snap.toString());
                            //for (DataSnapshot locationItem : dataSnapshot.getChildren()) {
                            String package_id = snap.getKey();
                            packageData = snap.getValue(Packages.class);
                            packageData.setId(package_id);
                            packageDetailArrayList.add(packageData);
                            Log.d("list size-->", packageDetailArrayList.size() + "");
                        }

                        packageExpandableAdapter = new PackageExpandableAdapter(mContext, packageDetailArrayList);
                        rv_packageList.setAdapter(packageExpandableAdapter);


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
