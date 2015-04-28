package g4a.quadratin.mx.quadratin;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;

/**
 * Created by eduardo on 4/8/15.
 */
public class QuadratinViewPagerAdapter extends FragmentStatePagerAdapter {

    private CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    private int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created

    private Tab_global_grid fragment_tabs[];


    private Tab_global_grid tab0 = null;
    private Tab_global_grid tab1 = null;
    private Tab_global_grid tab2 = null;
    private Tab_global_grid tab3 = null;
    private Tab_global_grid tab4 = null;
    private Tab_global_grid tab5 = null;

    private int count_items = 0;

    /*testing tab 1 data items*/
    public Object[] grid_items_data = new Object[] {
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_politica),

            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_politica),

            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_politica),

            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,String.valueOf(count_items++),R.drawable.q_test_img_politica),
    };


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public QuadratinViewPagerAdapter(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);
        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
        this.fragment_tabs = new Tab_global_grid[NumbOfTabs];
    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if( fragment_tabs[position] == null ) {
            fragment_tabs[position] = new Tab_global_grid();
            fragment_tabs[position].tab_set_data(grid_items_data);
        }
        return fragment_tabs[position];
    }


    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}