package paramount.com.androidproject.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class OrderDetail implements Parcelable {

    private String order_id;
    private String order_item_name;
    private String order_iten_description;
    private String order_qty;
    private String order_price;
    private String order_item_price;
    private String order_type;
//    private static ArrayList<OrderDetail> arrayOrderList;

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;


    public OrderDetail(){


    }



    protected OrderDetail(Parcel in) {
        order_id = in.readString();
        order_item_name = in.readString();
        order_iten_description = in.readString();
        order_qty = in.readString();
        order_price = in.readString();
        order_item_price = in.readString();
    }

    public static final Creator<OrderDetail> CREATOR = new Creator<OrderDetail>() {
        @Override
        public OrderDetail createFromParcel(Parcel in) {
            return new OrderDetail(in);
        }

        @Override
        public OrderDetail[] newArray(int size) {
            return new OrderDetail[size];
        }
    };

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_item_name() {
        return order_item_name;
    }

    public void setOrder_item_name(String order_item_name) {
        this.order_item_name = order_item_name;
    }

    public String getOrder_iten_description() {
        return order_iten_description;
    }

    public void setOrder_iten_description(String order_iten_description) {
        this.order_iten_description = order_iten_description;
    }

    public String getOrder_qty() {
        return order_qty;
    }

    public void setOrder_qty(String order_qty) {
        this.order_qty = order_qty;
    }

    public String getOrder_price() {
        return order_price;
    }

    public void setOrder_price(String order_price) {
        this.order_price = order_price;
    }

    public String getOrder_item_price() {
        return order_item_price;
    }

    public void setOrder_item_price(String order_item_price) {
        this.order_item_price = order_item_price;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(order_id);
        dest.writeString(order_item_name);
        dest.writeString(order_iten_description);
        dest.writeString(order_qty);
        dest.writeString(order_price);
        dest.writeString(order_item_price);
    }
}
