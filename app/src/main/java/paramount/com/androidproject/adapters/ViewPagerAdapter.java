package paramount.com.androidproject.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import paramount.com.androidproject.fragments.BuildYourOwnFragment;
import paramount.com.androidproject.fragments.ParamountPacakageFragment;
import paramount.com.androidproject.fragments.SlidesPackage;
import paramount.com.androidproject.fragments.SuacesFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private int numOfTabs;


    public ViewPagerAdapter(FragmentManager fm,int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new ParamountPacakageFragment();
            case 1:
                return new BuildYourOwnFragment();
            case 2:
                return new SlidesPackage();
            case 3:
                return new SuacesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
