package paramount.com.androidproject.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import paramount.com.androidproject.R;
import paramount.com.androidproject.models.Item;
import paramount.com.androidproject.utils.DominoBoldTextView;

public class BuildYourOwnAdapter extends RecyclerView.Adapter<BuildYourOwnAdapter.BuildYourOwnViewHolder> {

    ArrayList<Item> buildyourownDetails;
    Context mContext;


    public BuildYourOwnAdapter(Context mContext, ArrayList<Item> buildyourownDetails) {
        this.buildyourownDetails = buildyourownDetails;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public BuildYourOwnAdapter.BuildYourOwnViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_buildown_layout, null);
        BuildYourOwnAdapter.BuildYourOwnViewHolder buildYourOwnViewHolder = new BuildYourOwnAdapter.BuildYourOwnViewHolder(view);
        return buildYourOwnViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BuildYourOwnAdapter.BuildYourOwnViewHolder buildYourOwnViewHolder, int i) {

        final Item buildyourownDetail = buildyourownDetails.get(i);

        buildYourOwnViewHolder.tv_build_your_own_name.setText(buildyourownDetail.getTitle());
//        locationViewHolder.tv_address.setText(locationDetail.getAddress());
//        locationViewHolder.tv_city.setText(locationDetail.getCity() + "," + locationDetail.getProvince());
//        locationViewHolder.tv_code.setText(locationDetail.getPostalcode());
//        locationViewHolder.tv_loc_phone.setText(locationDetail.getPhone());
//        locationViewHolder.tv_loc_email.setText(locationDetail.getEmail());


    }

    @Override
    public int getItemCount() {
        return buildyourownDetails.size();
    }


    public static class BuildYourOwnViewHolder extends RecyclerView.ViewHolder {

        DominoBoldTextView tv_build_your_own_name;

        public BuildYourOwnViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_build_your_own_name = (DominoBoldTextView) itemView.findViewById(R.id.buildown_name);

        }
    }
}
