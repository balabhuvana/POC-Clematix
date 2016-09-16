package fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import adapter.GroceryAdapter;
import clematix.com.poc_clematix.R;
import model.FruitList;
import model.Fruits;
import network.BaseNetworkApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GroceryFragment extends Fragment {

    private String TAG = GroceryFragment.class.getSimpleName();
    private static RecyclerView mRecyclerView;
    private static RecyclerView.LayoutManager mLayoutManager;
    private static GroceryAdapter mGroceryAdapter;


    public static GroceryFragment newInstance(int columnCount, String title) {
        GroceryFragment fragment = new GroceryFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", columnCount);
        args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        Log.d(TAG, "onAttach");
        super.onAttach(activity);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.grocery_fragment, container, false);
        Log.d(TAG, "onCreateView");
        return mView;
    }

    @Override
    public void onViewCreated(View oView, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated");
        super.onViewCreated(oView, savedInstanceState);

        try {
            initViews(oView);
        } catch (Exception exp) {
            exp.printStackTrace();
        }

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");

    }

    public void initViews(View oView) {
        try {
            mRecyclerView = (RecyclerView) oView.findViewById(R.id.mRecyclerView);
            intiRecyclerView();
        } catch (Exception exp) {
            exp.printStackTrace();
        }

    }

    public void intiRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        hitFruits();
    }

    private void setRecyclerViewAdapterValue(List<Fruits> mFruitsList) {
        try {
            mGroceryAdapter = new GroceryAdapter(getContext(), mFruitsList);
            mRecyclerView.setAdapter(mGroceryAdapter);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public void hitFruits() {
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://demo0214632.mockable.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            BaseNetworkApi mBaseNetworkApi = retrofit.create(BaseNetworkApi.class);

            Call<FruitList> call = mBaseNetworkApi.getFruits();
            call.enqueue(new Callback<FruitList>() {
                @Override
                public void onResponse(Call<FruitList> call, Response<FruitList> response) {
                    Log.d(TAG, "onResponse");
                    if (response.body().getFruitsList() != null && response.body().getFruitsList().size() > 0) {
                        setRecyclerViewAdapterValue(response.body().getFruitsList());
                    } else {
                        Log.d(TAG, "null or size zero");
                    }
                }

                @Override
                public void onFailure(Call<FruitList> call, Throwable t) {
                    Log.d(TAG, "onFailure " + t.getMessage());
                }
            });

        } catch (Exception exp) {
            exp.printStackTrace();
        }

    }


}
