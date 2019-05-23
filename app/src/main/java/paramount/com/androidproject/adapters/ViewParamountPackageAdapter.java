package paramount.com.androidproject.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import paramount.com.androidproject.R;
import paramount.com.androidproject.utils.DiavloBoldTextView;

public class ViewParamountPackageAdapter extends RecyclerView.Adapter<ViewParamountPackageAdapter.PackageViewHolder> {


    ArrayList<MenuDetails>  menuDetails;
    Context mContext;



    public ViewParamountPackageAdapter(ArrayList<MenuDetails> menuDetails, Context mContext) {

        this.mContext = mContext;
        this.menuDetails = menuDetails;

    }

    @NonNull
    @Override
    public ViewParamountPackageAdapter.PackageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_paramountpackages_layout, null);
        ViewParamountPackageAdapter.PackageViewHolder orderViewHolder = new ViewParamountPackageAdapter.PackageViewHolder(view);
        return orderViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewParamountPackageAdapter.PackageViewHolder packageViewHolder, int i) {

        final MenuDetails menuDetail = menuDetails.get(i);

        packageViewHolder.tv_pacakage_title.setText("Pagal SAHEB");

    }

    @Override
    public int getItemCount() {
        return menuDetails.size();
    }


    public class PackageViewHolder extends RecyclerView.ViewHolder{

     private DiavloBoldTextView tv_pacakage_title;

        public PackageViewHolder(@NonNull View itemView) {
            super(itemView);


            tv_pacakage_title = (DiavloBoldTextView) itemView.findViewById(R.id.tv_pacakage_title);
        }
    }
}
