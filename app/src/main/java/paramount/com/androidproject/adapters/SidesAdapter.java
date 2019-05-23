package paramount.com.androidproject.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import paramount.com.androidproject.R;
import paramount.com.androidproject.models.Item;
import paramount.com.androidproject.models.Sides;
import paramount.com.androidproject.utils.DominoBoldTextView;

public class SidesAdapter extends RecyclerView.Adapter<SidesAdapter.SidesViewHolder> {

    ArrayList<Sides> sidesDetails;
    Context mContext;

    int quantity_number = 0;

    public SidesAdapter(Context mContext, ArrayList<Sides> sidesDetails) {
        this.sidesDetails = sidesDetails;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public SidesAdapter.SidesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_side_layout, null);
        SidesAdapter.SidesViewHolder sidesViewHolder = new SidesAdapter.SidesViewHolder(view);
        return sidesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final SidesAdapter.SidesViewHolder sidesViewHolder,final int i) {


        final Sides sidesDetail = sidesDetails.get(i);


        sidesViewHolder.tv_side_name.setText(sidesDetail.getTitle());


        sidesViewHolder.tv_name.setText(sidesDetail.getItems().get("item_1").getTitle());

        sidesViewHolder.tv_side_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            // sidesViewHolder.display_detailLayout.setVisibility(View.VISIBLE);

                // sidesViewHolder.tv_name.setText(sidesDetail.getItems().get("item_1").getTitle());





            }
        });






    }

    @Override
    public int getItemCount() {
        return sidesDetails.size();
    }


    public static class SidesViewHolder extends RecyclerView.ViewHolder {

        LinearLayout display_detailLayout;
        ImageView iv_close, iv_plus, iv_minus;


        DominoBoldTextView tv_side_name, tv_name, tv_price, tv_quantity, tv_serves, tv_cal;

        Button btn_addtocart;


        public SidesViewHolder(@NonNull View itemView) {
            super(itemView);

            display_detailLayout = (LinearLayout) itemView.findViewById(R.id.side_display_detail);
            tv_side_name = (DominoBoldTextView) itemView.findViewById(R.id.side_name);

            tv_name = (DominoBoldTextView) itemView.findViewById(R.id.si_name);
            tv_price = (DominoBoldTextView) itemView.findViewById(R.id.si_price);
            tv_quantity = (DominoBoldTextView) itemView.findViewById(R.id.si_quantity);
            tv_cal = (DominoBoldTextView) itemView.findViewById(R.id.si_cal);
            tv_serves = (DominoBoldTextView) itemView.findViewById(R.id.si_serves);
            iv_close = (ImageView) itemView.findViewById(R.id.iv_side_close);
            iv_plus = (ImageView) itemView.findViewById(R.id.iv_side_plus);
            iv_minus = (ImageView) itemView.findViewById(R.id.iv_side_minus);
            btn_addtocart = (Button) itemView.findViewById(R.id.btn_side_addToCart);


        }
    }

}
