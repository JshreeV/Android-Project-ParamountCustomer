package paramount.com.androidproject.models;

public class Sauces {


    private String sauce_id;
    private String title;

    public String getSauce_id() {
        return sauce_id;
    }

    public void setSauce_id(String sauce_id) {
        this.sauce_id = sauce_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getServes() {
        return serves;
    }

    public void setServes(String serves) {
        this.serves = serves;
    }

    public String getCals() {
        return cals;
    }

    public void setCals(String cals) {
        this.cals = cals;
    }

    private String Price;
    private String serves;
    private String cals;



}
