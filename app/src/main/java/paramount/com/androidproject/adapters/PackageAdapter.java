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
import paramount.com.androidproject.models.Packages;
import paramount.com.androidproject.utils.DominoBoldTextView;

public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.PackageViewHolder> {


    ArrayList<Packages> packagesDetails;
    Context mContext;


    public PackageAdapter(Context mContext, ArrayList<Packages> packagesDetails) {
        this.packagesDetails = packagesDetails;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public PackageAdapter.PackageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_packages_layout, null);
        PackageAdapter.PackageViewHolder packagesViewHolder = new PackageAdapter.PackageViewHolder(view);
        return packagesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PackageAdapter.PackageViewHolder packagesViewHolder, int i) {

        final Packages packageDetail = packagesDetails.get(i);

        packagesViewHolder.tv_package_name.setText(packageDetail.getTitle());


    }

    @Override
    public int getItemCount() {
        return packagesDetails.size();
    }


    public static class PackageViewHolder extends RecyclerView.ViewHolder {

        DominoBoldTextView tv_package_name;

        public PackageViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_package_name = (DominoBoldTextView) itemView.findViewById(R.id.packages_name);

        }
    }

}
