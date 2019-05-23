package paramount.com.androidproject.fragments;

import android.content.Context;
import android.content.Intent;
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
import android.widget.ExpandableListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import paramount.com.androidproject.R;
import paramount.com.androidproject.activities.AddToCartActivity;
import paramount.com.androidproject.activities.MainActivity;
import paramount.com.androidproject.adapters.SidesAdapter;

import paramount.com.androidproject.adapters.SidesExpandableAdapter;
import paramount.com.androidproject.models.Item;
import paramount.com.androidproject.models.Menu;
import paramount.com.androidproject.models.Sides;
import paramount.com.androidproject.utils.DominoBoldTextView;
import paramount.com.androidproject.utils.EqualSpacingItemDecoration;


public class SlidesPackage extends Fragment {

    LinearLayoutManager linearLayoutManager;
    ExpandableListView lv_sideList;
    /*SidesAdapter sidesAdapter;*/
    SidesExpandableAdapter sidesAdapter;
    public static DominoBoldTextView tv_add_cart;
    Context mContext;
    Button btn_chooseLocation;
    ArrayList<Sides> sideDetailArrayList;
    public static ArrayList<Item> selected_add_to_cart_items = new ArrayList<>();

    DatabaseReference databaseReference;

    Sides sideData;
    Menu menu;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_slides_package, container, false);

        View view = inflater.inflate(R.layout.fragment_slides_package, container, false);

        init(view);
        mContext = getActivity();


        return view;
    }


    private void init(View view) {


        lv_sideList = (ExpandableListView) view.findViewById(R.id.lv_sidesList);
        tv_add_cart = (DominoBoldTextView) view.findViewById(R.id.tv_add_cart);


//        tv_add_cart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i = new Intent(getActivity(), AddToCartActivity.class);
//                i.putExtra("selected_items",selected_add_to_cart_items);
//                startActivity(i);
//
//            }
//        });



        sideData = new Sides();
        sideDetailArrayList = new ArrayList<>();

        menu = new Menu();
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference users = rootRef.child("Menu");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    if (ds.getKey().equals("Sides")) {
//                        menu.setItems(ds.getValue(Item.class));
                        System.out.println("Sides found ---- ");
                        Iterable<DataSnapshot> threadDetails = ds.getChildren();
                        System.out.println("Sauce string value --- > "+threadDetails);
//
                        for (DataSnapshot snap : threadDetails) {

                            System.out.println("DataSnapshot Sauce string value --- > "+snap.toString());
                            //for (DataSnapshot locationItem : dataSnapshot.getChildren()) {
                            String side_id = snap.getKey();
                            sideData = snap.getValue(Sides.class);
                            System.out.println("Side Data --- > "+ sideData.toString());
                            sideData.setId(side_id);
                            sideDetailArrayList.add(sideData);

                            Log.d("list size-->", sideDetailArrayList.size() + "");
                        }


                        sidesAdapter = new SidesExpandableAdapter(mContext, sideDetailArrayList);
                        lv_sideList.setAdapter(sidesAdapter);


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
