
package paramount.com.androidproject.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Menu {

    @SerializedName("Own")
    @Expose
    private Own own;
    @SerializedName("Packages")
    @Expose
    private Packages Packages;
    @SerializedName("Sauces")
    @Expose

    private Sides Sides;

    public Item getItems() {
        return items;
    }

    public void setItems(Item items) {
        this.items = items;
    }

    private Item items;


    public Own getOwn() {
        return own;
    }

    public void setOwn(Own own) {
        this.own = own;
    }

    public Packages getPackages() {
        return Packages;
    }

    public void setPackages(Packages packages) {
        this.Packages = packages;
    }

    public paramount.com.androidproject.models.Sides getSides() {
        return Sides;
    }

    public void setSides(paramount.com.androidproject.models.Sides sides) {
        Sides = sides;
    }
}
