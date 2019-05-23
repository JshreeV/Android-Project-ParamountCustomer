
package paramount.com.androidproject.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Map;

public class Sides implements Serializable {

    private String id;
    private String title;

    private boolean isSelected = false;



    public Map<String, Item> getItems() {
        return items;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void setItems(Map<String, Item> items) {
        this.items = items;
    }

    public Map<String, Item> items;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }






}
