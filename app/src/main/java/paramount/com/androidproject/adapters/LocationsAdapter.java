package paramount.com.androidproject.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import paramount.com.androidproject.R;
import paramount.com.androidproject.fragments.ViewPackages;
import paramount.com.androidproject.models.LocationDetail;
import paramount.com.androidproject.utils.DominoBoldTextView;
import paramount.com.androidproject.utils.DominoRegularTextView;

public class LocationsAdapter extends RecyclerView.Adapter<LocationsAdapter.LocationViewHolder> {

    ArrayList<LocationDetail> locationDetails;
    Context mContext;


    public LocationsAdapter(Context mContext, ArrayList<LocationDetail> locationDetails) {
        this.locationDetails = locationDetails;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public LocationsAdapter.LocationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_location_layout, null);
        LocationsAdapter.LocationViewHolder locationViewHolder = new LocationsAdapter.LocationViewHolder(view);
        return locationViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final LocationsAdapter.LocationViewHolder locationViewHolder, int i) {

        final LocationDetail locationDetail = locationDetails.get(i);

        locationViewHolder.tv_loc_name.setText(locationDetail.getName());
//        locationViewHolder.tv_address.setText(locationDetail.getAddress());
//        locationViewHolder.tv_city.setText(locationDetail.getCity() + "," + locationDetail.getProvince());
//        locationViewHolder.tv_code.setText(locationDetail.getPostalcode());
//        locationViewHolder.tv_loc_phone.setText(locationDetail.getPhone());
//        locationViewHolder.tv_loc_email.setText(locationDetail.getEmail());

        Long mode = locationDetail.getMode();


        locationViewHolder.iv_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                locationViewHolder.iv_up.setVisibility(View.GONE);
                locationViewHolder.iv_expand.setVisibility(View.VISIBLE);
                locationViewHolder.iv_showView.setVisibility(View.GONE);

                /*locationViewHolder.tv_loc_phone.setText(locationDetail.getPhone());
                locationViewHolder.tv_loc_email.setText(locationDetail.getEmail());
                locationViewHolder.tv_code.setText(locationDetail.getPostalcode());
                locationViewHolder.tv_city.setText(locationDetail.getCity());
                locationViewHolder.tv_address.setText(locationDetail.getAddress());*/
            }
        });


        locationViewHolder.iv_expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                locationViewHolder.iv_expand.setVisibility(View.GONE);
                locationViewHolder.iv_up.setVisibility(View.VISIBLE);
                locationViewHolder.iv_showView.setVisibility(View.VISIBLE);
                locationViewHolder.tv_loc_phone.setText(locationDetail.getPhone());
                locationViewHolder.tv_loc_email.setText(locationDetail.getEmail());
                locationViewHolder.tv_code.setText(locationDetail.getPostalcode());
                locationViewHolder.tv_city.setText(locationDetail.getCity());
                locationViewHolder.tv_address.setText(locationDetail.getAddress());

            }
        });

        locationViewHolder.tv_loc_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // open fragment here and pass the location data to the View Package Fragment
                System.out.println("LocationDetsils_" + locationDetail);
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
                ViewPackages viwPackage = new ViewPackages();
                Bundle bundle = new Bundle();
                bundle.putParcelable("LocationData", locationDetail);
                viwPackage.setArguments(bundle);
                fragmentTransaction.replace(R.id.content_frame, viwPackage);
                fragmentTransaction.addToBackStack(viwPackage.getClass().getName());
                fragmentTransaction.commit();


//                Intent i = new Intent(mContext, ViewPackages.class);
//                i.putExtra("LocationData", locationDetail);
//                mContext.startActivity(i);
            }
        });


        if (mode == 1) {
            locationViewHolder.tv_locationMode.setText("Online");
            locationViewHolder.iv_loc_mode.setBackgroundColor(mContext.getResources().getColor(R.color.green));
        } else {

            locationViewHolder.iv_loc_mode.setBackgroundColor(mContext.getResources().getColor(R.color.red));
            locationViewHolder.tv_locationMode.setText("Offline");
        }


       /* locationViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, MenuPackagesActivity.class);
                i.putExtra("LocationData", locationDetail);
                mContext.startActivity(i);
            }
        });
*/
    }

    @Override
    public int getItemCount() {
        return locationDetails.size();
    }

    public static class LocationViewHolder extends RecyclerView.ViewHolder {


        LinearLayout iv_showView, iv_mainView;

        //        CardView cardView;
        ImageView iv_up, iv_expand;
        ImageView iv_loc_mode;
        DominoBoldTextView tv_locationMode;
        DominoBoldTextView tv_loc_name, tv_loc_phone, tv_loc_email;
        DominoRegularTextView tv_code, tv_address, tv_city;


        public LocationViewHolder(@NonNull View itemView) {
            super(itemView);


            tv_locationMode = (DominoBoldTextView) itemView.findViewById(R.id.location_mode);
            iv_mainView = (LinearLayout) itemView.findViewById(R.id.main_view);
            iv_showView = (LinearLayout) itemView.findViewById(R.id.show_view);
            iv_up = (ImageView) itemView.findViewById(R.id.iv_up);
            iv_expand = (ImageView) itemView.findViewById(R.id.iv_expand);
            //cardView = (CardView) itemView.findViewById(R.id.cardView);
            tv_loc_name = (DominoBoldTextView) itemView.findViewById(R.id.location_name);
            tv_address = (DominoRegularTextView) itemView.findViewById(R.id.location_address);
            tv_code = (DominoRegularTextView) itemView.findViewById(R.id.location_code);
            tv_loc_email = (DominoBoldTextView) itemView.findViewById(R.id.location_email);
            tv_loc_phone = (DominoBoldTextView) itemView.findViewById(R.id.location_number);
            tv_city = (DominoRegularTextView) itemView.findViewById(R.id.location_city);

            iv_loc_mode = (ImageView) itemView.findViewById(R.id.mode);
        }
    }
}
