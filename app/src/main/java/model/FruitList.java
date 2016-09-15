package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by balamurugan_se on 6/9/2016.
 */
public class FruitList {
    @SerializedName("fruits")
    private List<Fruits> fruitsList;

    public List<Fruits> getFruitsList() {
        return fruitsList;
    }

    public void setFruitsList(List<Fruits> fruitsList) {
        this.fruitsList = fruitsList;
    }
}
