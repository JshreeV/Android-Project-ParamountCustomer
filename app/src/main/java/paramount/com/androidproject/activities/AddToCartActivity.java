package paramount.com.androidproject.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import paramount.com.androidproject.R;
import paramount.com.androidproject.adapters.OrderAdapter;
import paramount.com.androidproject.models.Item;
import paramount.com.androidproject.models.OrderDetail;
import paramount.com.androidproject.utils.DiavloBoldTextView;
import paramount.com.androidproject.utils.DominoBoldTextView;
import paramount.com.androidproject.utils.EqualSpacingItemDecoration;

public class AddToCartActivity extends AppCompatActivity {


    LinearLayoutManager linearLayoutManager;
    OrderAdapter orderAdapter;
    RecyclerView rv_orderList;
    Context mContext;
    DiavloBoldTextView tv_placeOrder;

    boolean isFromSauce = true;

    private static ArrayList<Item> arrayOrderList;


    public static ArrayList<Item> getArrayOrderList() {
        return arrayOrderList;
    }

    public static void setArrayOrderList(ArrayList<Item> arrayOrderList) {
        AddToCartActivity.arrayOrderList = arrayOrderList;
    }



    static {
        arrayOrderList = new ArrayList<>();
    }

    Item itemObject;
    static List<Item> listItems;
    List<Item> order_list_of_items;

//    AddToCartActivity(){
//        listItems = new ArrayList<>();
//    }

    static {
        listItems = new ArrayList<>();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);

        mContext = this;
        rv_orderList = (RecyclerView) findViewById(R.id.rv_orderList);
        tv_placeOrder = (DiavloBoldTextView) findViewById(R.id.tv_placeOrder);

        order_list_of_items = new ArrayList<>();
        Intent intent = getIntent();
        if (intent != null) {

            if (intent.hasExtra("selected_items")) {
                itemObject = (Item)
                        intent.getSerializableExtra("selected_items");
                listItems.add(itemObject);
                orderAdapter = new OrderAdapter(mContext, listItems);
            } else if (intent.hasExtra("selected_sauces")){
                itemObject = (Item) intent.getSerializableExtra("selected_sauces");
                listItems.add(itemObject);
                orderAdapter = new OrderAdapter(mContext, listItems);
            } else if (intent.hasExtra("order_list")){
                order_list_of_items = (List<Item>) intent.getSerializableExtra("order_list");
                orderAdapter = new OrderAdapter(mContext, order_list_of_items);
//                listItems.add(itemObject);
            }
            else
            {
                itemObject = (Item) intent.getSerializableExtra("selected_pacakgeItmes");
                listItems.add(itemObject);
                orderAdapter = new OrderAdapter(mContext, listItems);
            }

        }

//        orderAdapter = new OrderAdapter(mContext, listItems);


        linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        rv_orderList.setLayoutManager(linearLayoutManager);
        rv_orderList.setAdapter(orderAdapter);
        rv_orderList.addItemDecoration(new EqualSpacingItemDecoration(20, EqualSpacingItemDecoration.VERTICAL));

        tv_placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
