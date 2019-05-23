package paramount.com.androidproject.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import paramount.com.androidproject.activities.AddToCartActivity;
import paramount.com.androidproject.adapters.LocationsAdapter;
import paramount.com.androidproject.adapters.SaucesAdapter;
import paramount.com.androidproject.models.Item;
import paramount.com.androidproject.models.LocationDetail;
import paramount.com.androidproject.models.Menu;
import paramount.com.androidproject.models.Sauces;
import paramount.com.androidproject.models.Sides;
import paramount.com.androidproject.utils.DominoBoldTextView;
import paramount.com.androidproject.utils.EqualSpacingItemDecoration;


public class SuacesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    LinearLayoutManager linearLayoutManager;
    RecyclerView rv_sauceList;
    SaucesAdapter sauceAdapter;
    Context mContext;
    Button btn_chooseLocation;
    ArrayList<Item> sauceDetailArrayList;

    public static DominoBoldTextView tv_add_cart;
    DatabaseReference databaseReference;
    Item sauceData;
    Menu menu;
    public static ArrayList<Item> selected_add_to_cart_items = new ArrayList<>();

    DominoBoldTextView sa1, sa2, sa3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_suaces, container, false);

        View view = inflater.inflate(R.layout.fragment_suaces, container, false);

        init(view);
        mContext = getActivity();


        return view;
    }

    private void init(View view) {


        rv_sauceList = (RecyclerView) view.findViewById(R.id.rv_sauceList);


        // DividerItemDecoration dividerItemDecoration = new DividerItemDecoration()

        sauceData = new Item();
        sauceDetailArrayList = new ArrayList<>();

        menu = new Menu();


        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference users = rootRef.child("Menu");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    if (ds.getKey().equals("Sauces")) {
//                        menu.setItems(ds.getValue(Item.class));
                        System.out.println("Sauces found ---- ");
                        Iterable<DataSnapshot> threadDetails = ds.getChildren();
                        System.out.println("Sauce string value --- > " + threadDetails);
//
                        for (DataSnapshot snap : threadDetails) {

                            System.out.println("DataSnapshot Sauce string value --- > " + snap.toString());
                            //for (DataSnapshot locationItem : dataSnapshot.getChildren()) {
                            String sauce_id = snap.getKey();
                            sauceData = snap.getValue(Item.class);
//                    lolocationData.getLocation_id();
                            // sauceData.setItem_id(sauce_id);
                            sauceDetailArrayList.add(sauceData);
                            Log.d("list size-->", sauceDetailArrayList.size() + "");
                        }

                        sauceAdapter = new SaucesAdapter(mContext, sauceDetailArrayList);
                        linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
                        rv_sauceList.setLayoutManager(linearLayoutManager);
                        rv_sauceList.setAdapter(sauceAdapter);


                        rv_sauceList.addItemDecoration(new EqualSpacingItemDecoration(20, EqualSpacingItemDecoration.VERTICAL));

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
