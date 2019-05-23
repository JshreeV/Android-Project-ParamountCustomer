package paramount.com.androidproject.models;

import android.os.Parcel;
import android.os.Parcelable;

public class LocationDetail implements Parcelable {

    private String id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String postalcode;
    private Long latitude;
    private Long longitude;
    private Long mode;


    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }


    protected LocationDetail(Parcel in) {
        name = in.readString();
        address = in.readString();
        phone = in.readString();
        email = in.readString();
        postalcode = in.readString();
        if (in.readByte() == 0) {
            latitude = null;
        } else {
            latitude = in.readLong();
        }
        if (in.readByte() == 0) {
            longitude = null;
        } else {
            longitude = in.readLong();
        }
        if (in.readByte() == 0) {
            mode = null;
        } else {
            mode = in.readLong();
        }
        city = in.readString();
        province = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(phone);
        dest.writeString(email);
        dest.writeString(postalcode);
        if (latitude == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(latitude);
        }
        if (longitude == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(longitude);
        }
        if (mode == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mode);
        }
        dest.writeString(city);
        dest.writeString(province);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LocationDetail> CREATOR = new Creator<LocationDetail>() {
        @Override
        public LocationDetail createFromParcel(Parcel in) {
            return new LocationDetail(in);
        }

        @Override
        public LocationDetail[] newArray(int size) {
            return new LocationDetail[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }



    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Long getMode() {
        return mode;
    }

    public void setMode(Long mode) {
        this.mode = mode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    private String city;
    private String province;

    public LocationDetail() {
    }


}
