


package paramount.com.androidproject.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatRadioButton;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import paramount.com.androidproject.R;

import java.util.ArrayList;
import java.util.HashMap;

import paramount.com.androidproject.activities.AddToCartActivity;
import paramount.com.androidproject.fragments.SlidesPackage;
import paramount.com.androidproject.models.Item;
import paramount.com.androidproject.models.Sides;
import paramount.com.androidproject.utils.DominoBoldTextView;


public class SidesExpandableAdapter extends BaseExpandableListAdapter {

    private Context context;
    ArrayList<Sides> sidesDetails;
    HashMap<Integer, ArrayList<Boolean>> selection;
    ArrayList<Boolean> selected;
    int quantity_number = 0;
    String number;
    Item item;

    public SidesExpandableAdapter(Context context, ArrayList<Sides> sidesDetails) {
        this.context = context;
        this.sidesDetails = sidesDetails;
        selection = new HashMap<>();
        selected = new ArrayList<>();
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
    public int getChildType(int groupPosition, int childPosition) {
        return super.getChildType(groupPosition, childPosition);
    }

    @Override
    public int getGroupType(int groupPosition) {
        return super.getGroupType(groupPosition);
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return sidesDetails.get(groupPosition).getItems().size();
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
    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final int grp_position = groupPosition;
        final int ch_position = childPosition;


        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_subitems_layout, null);
        }

        DominoBoldTextView si_title = convertView.findViewById(R.id.si_title);
        DominoBoldTextView si_type = convertView.findViewById(R.id.si_type);
        final DominoBoldTextView si_price = convertView.findViewById(R.id.si_price);
        DominoBoldTextView si_cals = convertView.findViewById(R.id.si_cals);
        DominoBoldTextView si_serves = convertView.findViewById(R.id.si_serves);
        final DominoBoldTextView si_quanrity = convertView.findViewById(R.id.s_quantity);
        ImageView iv_plus = convertView.findViewById(R.id.iv_plus);
        ImageView iv_minus = convertView.findViewById(R.id.iv_minus);
        final AppCompatRadioButton rb_select = convertView.findViewById(R.id.rb_select);
        Button btn = convertView.findViewById(R.id.btn_addToCart);


        final Sides sidesDetail = sidesDetails.get(groupPosition);

        String key = "item_" + (childPosition + 1);

        si_title.setText(sidesDetail.getTitle());
        si_type.setText(sidesDetail.getItems().get(key).getTitle());
        si_price.setText(sidesDetail.getItems().get(key).getPrice());
        si_cals.setText("Calories : " + sidesDetail.getItems().get(key).getCals() + " cals");
        si_price.setText("Serves : " + sidesDetail.getItems().get(key).getPrice() + " Pep");


        /*ADD TO CART AND RADIO BUTTON LOGIC*/

        if (selected.size() <= 0) {
            for (int i = 0; i < sidesDetails.get(grp_position).getItems().size(); i++) {
                selected.add(false);
            }
            selection.put(groupPosition, selected);
        }


        iv_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity_number <= 0) {


                } else {
                    quantity_number = quantity_number - 1;
                    number = String.valueOf(quantity_number);
                    si_quanrity.setText(number);
                    item.setQuantity(number);

                }
            }
        });

        iv_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quantity_number = quantity_number + 1;
                number = String.valueOf(quantity_number);
                si_quanrity.setText(number);
                item.setQuantity(number);

            }
        });



        rb_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = new ArrayList<>();

                for (int i = 0; i < sidesDetails.get(grp_position).getItems().size(); i++) {
                    selected.add(false);
                }
                selection.put(groupPosition, selected);

                if (rb_select.isChecked()) {
                    selection.get(grp_position).set(ch_position, true);
                    String key = "item_" + (ch_position + 1);
                    item = sidesDetail.getItems().get(key);
                    item.setQuantity(number);
                    item.setMenuTitle(sidesDetail.getTitle());
//                    sidesDetail.getItems().get(key).setQuantity(si_quanrity.getText().toString());
//                    SlidesPackage.selected_add_to_cart_items.add(sidesDetail.getItems().get(key));
                   // SlidesPackage.selected_add_to_cart_items.add(item);
//

                  //  SlidesPackage.tv_add_cart.setVisibility(View.VISIBLE);

                } else {
                    selection.get(grp_position).set(ch_position, false);
                }

                notifyDataSetChanged();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(context, AddToCartActivity.class);
                i.putExtra("selected_items",item);
                context.startActivity(i);
            }
        });
        try {
            rb_select.setChecked(selection.get(grp_position).get(ch_position));
        } catch (Exception e) {

        }


        return convertView;
    }


    @Override
    public View getGroupView(final int groupPosition, final boolean isExpanded,
                             View itemView, ViewGroup parent) {


        if (itemView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = infalInflater.inflate(R.layout.item_side_layout, null);
        }


        DominoBoldTextView tv_side_name;

        tv_side_name = itemView.findViewById(R.id.side_name);
        final Sides sidesDetail = sidesDetails.get(groupPosition);
        tv_side_name.setText(sidesDetail.getTitle());

        //SlidesPackage.selected_add_to_cart_items.add(sidesDetail);
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

}
