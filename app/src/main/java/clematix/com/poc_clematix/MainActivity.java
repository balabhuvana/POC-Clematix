package clematix.com.poc_clematix;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import fragments.GroceryFragment;
import fragments.MyAdMobFragment;
import fragments.MyMapFragment;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName();
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private Fragment mGroceryFragment, mSampleFragment, mMyAdMobFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    public void initViews() {
        try {

            transactionProcess(2, "");

        } catch (Exception exp) {
            exp.printStackTrace();
        }

    }

    public void transactionProcess(int position, String selectedTitle) {
        try {
            mFragmentManager = getSupportFragmentManager();
            mFragmentTransaction = mFragmentManager.beginTransaction();

            if (position == 0) {
                mGroceryFragment = GroceryFragment.newInstance(1);
                startFragment(mGroceryFragment);
            } else if (position == 1) {
                mSampleFragment = MyMapFragment.newInstance(1);
                startFragment(mSampleFragment);
            } else if (position == 2) {
                mMyAdMobFragment = MyAdMobFragment.newInstance(1);
                startFragment(mMyAdMobFragment);
            }

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    private void startFragment(Fragment mFragment) {
        try {
            mFragmentTransaction.replace(R.id.detailsContainer, mFragment);
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }


}
