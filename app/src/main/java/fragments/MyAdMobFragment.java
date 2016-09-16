package fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import clematix.com.poc_clematix.R;


public class MyAdMobFragment extends Fragment {

    private String TAG = MyAdMobFragment.class.getSimpleName();
    private AdView mAdViewTop, mAdViewBottom;
    private Context mContext;


    public static MyAdMobFragment newInstance(int columnCount, String title) {
        MyAdMobFragment fragment = new MyAdMobFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", columnCount);
        args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        Log.d(TAG, "onAttach");
        mContext = activity;
        super.onAttach(activity);

    }

    @Override
    public void onAttach(Context context) {
        mContext = context;
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
        View mView = inflater.inflate(R.layout.my_admob_fragment, container, false);
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
        if (mAdViewTop != null) {
            mAdViewTop.resume();
        }
        if (mAdViewBottom != null) {
            mAdViewBottom.resume();
        }
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        if (mAdViewTop != null) {
            mAdViewTop.pause();
        }
        if (mAdViewBottom != null) {
            mAdViewBottom.pause();
        }
        super.onPause();
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
        if (mAdViewTop != null) {
            mAdViewTop.destroy();
        }
        if (mAdViewBottom != null) {
            mAdViewBottom.destroy();
        }
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

            // Initialize the Mobile Ads SDK.
            MobileAds.initialize(mContext, getString(R.string.banner_ad_unit_id));

            // Gets the ad view defined in layout/ad_fragment.xml with ad unit ID set in
            // values/strings.xml.
            mAdViewTop = (AdView) oView.findViewById(R.id.ad_view_top);
            mAdViewBottom = (AdView) oView.findViewById(R.id.ad_view_bottom);

            // Create an ad request. Check your logcat output for the hashed device ID to
            // get test ads on a physical device. e.g.
            // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice("2C9B9F08B98B020647EB730484C27FA1").
                            addTestDevice("617BF717ACB3C7D4803651602E5502B1")
                    .build();

            // Start loading the ad in the background.
            mAdViewTop.loadAd(adRequest);
            mAdViewBottom.loadAd(adRequest);
        } catch (Exception exp) {
            exp.printStackTrace();
        }

    }


}
