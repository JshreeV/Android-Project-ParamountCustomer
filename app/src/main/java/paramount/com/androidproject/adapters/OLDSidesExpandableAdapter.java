package paramount.com.androidproject.adapters;/*
package paramount.com.androidproject.adapters;


import android.content.Context;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import paramount.com.androidproject.R;
import paramount.com.androidproject.models.Sides;
import paramount.com.androidproject.utils.DominoBoldTextView;


public class OLDSidesExpandableAdapter extends BaseExpandableListAdapter {

    private Context _context;
    ArrayList<Sides> sidesDetails;


    int quantity_number = 0;

    public OLDSidesExpandableAdapter(Context context, ArrayList<Sides> sidesDetails){
        this._context = context;
        this.sidesDetails = sidesDetails;


    }


    @Override
    public Object getChild(int groupPosition, int childPosititon) {


        return null;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }


    @Override
    public int getChildrenCount(int groupPosition) {


       // return sidesDetails.get(groupPosition).getItems().size();

        //inflate only one time and add dynamiccaly layout
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public int getGroupCount() {
        return sidesDetails.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }


    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {


        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_subitems_layout, null);
        }
        DominoBoldTextView tv_add_to_cart = convertView.findViewById(R.id.tv_add_to_cart);
        LinearLayout layout_container = convertView.findViewById(R.id.layout_container);
        //neeed to add dynamic layout in inflated layout


        //original layout
        */
/*DominoBoldTextView si_title = convertView.findViewById(R.id.si_title);
        DominoBoldTextView si_type = convertView.findViewById(R.id.si_type);
        DominoBoldTextView si_price = convertView.findViewById(R.id.si_price);
        DominoBoldTextView si_cals = convertView.findViewById(R.id.si_cals);
        DominoBoldTextView si_serves = convertView.findViewById(R.id.si_serves);*//*



        */
/*dynamic layout*//*


        DominoBoldTextView si_type = new DominoBoldTextView(_context);
        DominoBoldTextView si_price = new DominoBoldTextView(_context);
        DominoBoldTextView si_cals = new DominoBoldTextView(_context);
        DominoBoldTextView si_serves = new DominoBoldTextView(_context);



        LinearLayout layout = new LinearLayout(_context);
        LinearLayout.LayoutParams params =new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);



        float tenDp = 10f;
        DisplayMetrics metrics = _context.getResources().getDisplayMetrics();
        float fpixels = metrics.density * tenDp;
        int pixels = (int) (fpixels + 0.5f);
        params.setMargins(pixels,pixels,pixels,pixels);
        layout.setLayoutParams(params);
        layout.setGravity(Gravity.CENTER);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setWeightSum(2);


        LinearLayout innerLayout = new LinearLayout(_context);
        metrics = _context.getResources().getDisplayMetrics();
        float zeroDp = 0f;
        float zerofpixels = metrics.density * zeroDp;
        int zeropixels = (int) (zerofpixels + 0.5f);
        LinearLayout.LayoutParams inner_layout_params =new LinearLayout.LayoutParams(zeropixels,LinearLayout.LayoutParams.WRAP_CONTENT,1.4f);

        innerLayout.setLayoutParams(inner_layout_params);
        layout.setOrientation(LinearLayout.VERTICAL);



        DominoBoldTextView si_title = new DominoBoldTextView(_context);
        LinearLayout.LayoutParams si_title_params =new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.MATCH_PARENT);
        si_title.setLayoutParams(si_title_params);
        float fiveDp = 5f;
        DisplayMetrics fivemetrics = _context.getResources().getDisplayMetrics();
        float fFivepixels = fivemetrics.density * fiveDp;
        int five_pixels = (int) (fFivepixels + 0.5f);
        si_title_params.setMargins(five_pixels,five_pixels,five_pixels,five_pixels);
        si_title.setGravity(Gravity.LEFT);
        si_title.setTextSize(TypedValue.COMPLEX_UNIT_PX, _context.getResources().getDimension(R.dimen.twenty_sp));
        si_title.setTextColor(_context.getResources().getColor(R.color.bg_yellow_color));




        AppCompatRadioButton  appCompatRadioButton = new AppCompatRadioButton(_context);
        metrics = _context.getResources().getDisplayMetrics();
        float thirtyDp = 30f;
        float thirtyfpixels = metrics.density * thirtyDp;
        int thirtypixels = (int) (thirtyfpixels + 0.5f);
        LinearLayout.LayoutParams appCompatRadioButton_params =new LinearLayout.LayoutParams(thirtypixels,pixels,0.4f);
        appCompatRadioButton_params.gravity=Gravity.CENTER;
        appCompatRadioButton_params.setMargins(pixels,pixels,pixels,pixels);
        appCompatRadioButton.setLayoutParams(inner_layout_params);


        */
/*ADD LAYOUTS*//*

        innerLayout.addView(si_title);
        layout.addView(innerLayout);
        layout.addView(appCompatRadioButton);
        layout_container.addView(layout);












        //////////////////////////////////////////////////////////////////////












        final Sides sidesDetail = sidesDetails.get(groupPosition);

        String key= "item_"+(childPosition+1);
        si_title.setText(sidesDetail.getItems().get(key).getTitle());
  */
/*      si_type.setText(sidesDetail.getItems().get(key).getTitle());
        si_price.setText(sidesDetail.getItems().get(key).getPrice());
        si_cals.setText("Calories : "+sidesDetail.getItems().get(key).getCals()+" cals");
        si_price.setText("Serves : "+sidesDetail.getItems().get(key).getPrice()+" Pep");*//*



        tv_add_to_cart.setVisibility(View.VISIBLE);
        
        return convertView;
    }


    @Override
    public View getGroupView(final int groupPosition, final boolean isExpanded,
                             View itemView, ViewGroup parent) {



        if (itemView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = infalInflater.inflate(R.layout.item_side_layout, null);
        }

        LinearLayout display_detailLayout;
        ImageView iv_close, iv_plus, iv_minus;


        DominoBoldTextView tv_side_name, tv_name, tv_price, tv_quantity, tv_serves, tv_cal;

        Button btn_addtocart;
        display_detailLayout = itemView.findViewById(R.id.side_display_detail);
        tv_side_name =  itemView.findViewById(R.id.side_name);

        tv_name =  itemView.findViewById(R.id.si_name);
        tv_price = itemView.findViewById(R.id.si_price);
        tv_quantity =  itemView.findViewById(R.id.si_quantity);
        tv_cal =  itemView.findViewById(R.id.si_cal);
        tv_serves = itemView.findViewById(R.id.si_serves);
        iv_close =  itemView.findViewById(R.id.iv_side_close);
        iv_plus = itemView.findViewById(R.id.iv_side_plus);
        iv_minus =  itemView.findViewById(R.id.iv_side_minus);
        btn_addtocart =  itemView.findViewById(R.id.btn_side_addToCart);



        if (isExpanded) {

        } else {

        }



        final Sides sidesDetail = sidesDetails.get(groupPosition);


        tv_side_name.setText(sidesDetail.getTitle());


        */
/*tv_name.setText(sidesDetail.getItems().get("item_1").getTitle());*//*


        return itemView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}*/
