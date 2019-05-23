package paramount.com.androidproject.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import paramount.com.androidproject.R;
import paramount.com.androidproject.activities.AddToCartActivity;
import paramount.com.androidproject.models.Item;
import paramount.com.androidproject.models.OrderDetail;
import paramount.com.androidproject.utils.DominoBoldTextView;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    List<Item> list_of_order;
    Context mContext;
    boolean isFromSauce = true;
    private static ArrayList<Item> arrayList;

    static {
        arrayList = new ArrayList<>();

    }

    public OrderAdapter(Context mContext, List<Item> list_of_order) {
        this.mContext = mContext;
        this.list_of_order = list_of_order;

    }

    @NonNull
    @Override
    public OrderAdapter.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_order_layout, null);
        OrderAdapter.OrderViewHolder orderViewHolder = new OrderAdapter.OrderViewHolder(view);
        return orderViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.OrderViewHolder orderViewHolder, int i) {

        Item item = list_of_order.get(i);
        String menu_title = item.getMenuTitle();
//        String item_title = item.getTitle();
        String price = item.getPrice();
        String quantity = item.getQuantity();

        System.out.println("Menu Title ---> "+menu_title);

//        System.out.println("Item Title ---> "+item_title);

        if(menu_title != null){
            orderViewHolder.tv_itemName.setText(menu_title);
        }else{
            System.out.println("enter inti if block -- title value: "+item.getTitle());
            orderViewHolder.tv_itemName.setText(item.getTitle());

        }


        orderViewHolder.tv_itemPrice.setText(price);
        orderViewHolder.tv_quantity.setText(quantity);

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder_item_name(orderViewHolder.tv_itemName.getText().toString());
        orderDetail.setOrder_price(price);
        orderDetail.setOrder_qty(quantity);
        arrayList.add(item);
        AddToCartActivity.setArrayOrderList(arrayList);
    }

    @Override
    public int getItemCount() {
        return list_of_order.size();
    }


    public static class OrderViewHolder extends RecyclerView.ViewHolder {

        DominoBoldTextView tv_itemName, tv_quantity, tv_itemPrice;
        ImageView iv_edit;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_itemName = itemView.findViewById(R.id.item_name);
            tv_quantity = itemView.findViewById(R.id.item_quantity);
            tv_itemPrice = itemView.findViewById(R.id.item_price);


        }
    }
}
