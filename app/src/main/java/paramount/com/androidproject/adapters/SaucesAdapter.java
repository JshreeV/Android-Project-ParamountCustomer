package paramount.com.androidproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import paramount.com.androidproject.R;
import paramount.com.androidproject.activities.AddToCartActivity;
import paramount.com.androidproject.models.Item;
import paramount.com.androidproject.models.LocationDetail;
import paramount.com.androidproject.models.Sauces;
import paramount.com.androidproject.utils.DominoBoldTextView;
import paramount.com.androidproject.utils.DominoRegularTextView;

public class SaucesAdapter extends RecyclerView.Adapter<SaucesAdapter.SauceViewHolder> {


    public static ArrayList<Item> sauceDetails;
    Context mContext;

    int quantity_number = 0;
    Item sauceDetail;

    public SaucesAdapter(Context mContext, ArrayList<Item> sauceDetails) {
        this.sauceDetails = sauceDetails;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public SauceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_sauce_layout, null);
        SaucesAdapter.SauceViewHolder sauceViewHolder = new SaucesAdapter.SauceViewHolder(view);
        return sauceViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final SauceViewHolder sauceViewHolder, int i) {

         sauceDetail = sauceDetails.get(i);

         System.out.println("Sauces adapter title --> "+sauceDetail.getTitle());

        sauceViewHolder.tv_sauce_name.setText(sauceDetail.getTitle());


        sauceViewHolder.tv_sauce_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                sauceViewHolder.display_detailLayout.setVisibility(View.VISIBLE);

                sauceViewHolder.tv_name.setText(sauceDetail.getTitle());
                sauceViewHolder.tv_price.setText(sauceDetail.getPrice());

                sauceViewHolder.tv_cal.setText("Calories : " + sauceDetail.getCals() + " Cals");
                sauceViewHolder.tv_serves.setText("Serves : " + sauceDetail.getServes() + " People");


            }
        });

        sauceViewHolder.iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sauceViewHolder.display_detailLayout.setVisibility(View.GONE);
            }
        });

        sauceViewHolder.iv_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (quantity_number <= 0) {

                } else {

                    quantity_number = quantity_number - 1;
                    String number = String.valueOf(quantity_number);
                    sauceViewHolder.tv_quantity.setText(number);
                    sauceDetail.setQuantity(number);

                }

            }
        });

        sauceViewHolder.iv_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quantity_number = quantity_number + 1;
                String number = String.valueOf(quantity_number);
                sauceViewHolder.tv_quantity.setText(number);
                sauceDetail.setQuantity(number);
            }
        });

        sauceViewHolder.btn_addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "Data Added to Cart", Toast.LENGTH_LONG).show();
                Intent i = new Intent(mContext, AddToCartActivity.class);
                i.putExtra("selected_sauces",sauceDetail);
                mContext.startActivity(i);

            }
        });
    }


    @Override
    public int getItemCount() {
        return sauceDetails.size();
    }


    public static class SauceViewHolder extends RecyclerView.ViewHolder {


        LinearLayout display_detailLayout;
        ImageView iv_close, iv_plus, iv_minus;


        DominoBoldTextView tv_sauce_name, tv_name, tv_price, tv_quantity, tv_serves, tv_cal;

        Button btn_addtocart;


        public SauceViewHolder(@NonNull View itemView) {
            super(itemView);

            display_detailLayout = (LinearLayout) itemView.findViewById(R.id.display_detail);
            tv_sauce_name = (DominoBoldTextView) itemView.findViewById(R.id.sauce_name);

            tv_name = (DominoBoldTextView) itemView.findViewById(R.id.s_name);
            tv_price = (DominoBoldTextView) itemView.findViewById(R.id.s_price);
            tv_quantity = (DominoBoldTextView) itemView.findViewById(R.id.s_quantity);

            tv_cal = (DominoBoldTextView) itemView.findViewById(R.id.s_cal);
            tv_serves = (DominoBoldTextView) itemView.findViewById(R.id.s_serves);
            iv_close = (ImageView) itemView.findViewById(R.id.iv_close);
            iv_plus = (ImageView) itemView.findViewById(R.id.iv_plus);
            iv_minus = (ImageView) itemView.findViewById(R.id.iv_minus);

            btn_addtocart = (Button) itemView.findViewById(R.id.btn_addToCart);


        }
    }
}
