package paramount.com.androidproject.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import paramount.com.androidproject.R;
import paramount.com.androidproject.adapters.ViewPagerAdapter;
import paramount.com.androidproject.models.LocationDetail;
import paramount.com.androidproject.utils.DominoBoldTextView;


public class ViewPackages extends Fragment {


    Context mContext;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter pageAdapter;
    TabItem tabPacakges;
    TabItem tabBuildOwn;
    TabItem tabSlides, tabSauces;

    DominoBoldTextView tv_locatioName;

    LocationDetail locationDetail;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_view_packages, container, false);
        mContext = getActivity();

        Bundle extras = getArguments();
        locationDetail = (LocationDetail) extras.getParcelable("LocationData");
        System.out.println("Viewpack_" + locationDetail.getName());


      //  tv_locatioName = view.findViewById(R.id.location_name);
        tabLayout = view.findViewById(R.id.tablayout);
        tabPacakges = view.findViewById(R.id.tabpackages);
        tabBuildOwn = view.findViewById(R.id.tabbuildOwn);
        tabSauces = view.findViewById(R.id.tabSauces);
        tabSlides = view.findViewById(R.id.tabSlides);
        viewPager = view.findViewById(R.id.viewPager);


       // tv_locatioName.setText(locationDetail.getName());

        pageAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 1) {

                    tabLayout.setBackgroundColor(ContextCompat.getColor(mContext,
                            android.R.color.transparent));

                } else if (tab.getPosition() == 2) {

                    tabLayout.setBackgroundColor(ContextCompat.getColor(mContext,
                            android.R.color.transparent));
                }

               else {

                    tabLayout.setBackgroundColor(ContextCompat.getColor(mContext,
                            android.R.color.transparent));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        return view;

    }
}
