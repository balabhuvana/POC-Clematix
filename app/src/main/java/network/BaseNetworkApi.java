package network;



import model.FruitList;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by balamurugan_se on 6/9/2016.
 */
public interface BaseNetworkApi {

    @GET("/fruits")
    Call<FruitList> getFruits();
}
