package g4a.quadratin.mx.quadratin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by eduardo on 4/8/15.
 */
public class QuadratinViewPagerAdapter extends FragmentStatePagerAdapter {

    private CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    private int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created
    private int Current_tab_position = 0;


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

    };


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public QuadratinViewPagerAdapter(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);
        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if( position == 0 ) {
            tab0 = new Tab_global_grid();
            tab0.tab_set_data(grid_items_data);
            return tab0;
        }
        else if( position == 1 ) {
            tab1 = new Tab_global_grid();
            tab1.tab_set_data(grid_items_data);
            return tab1;
        }
        else if( position == 2 ) {
            tab2 = new Tab_global_grid();
            tab2.tab_set_data(grid_items_data);
            return tab2;
        }
        else if( position == 3 ) {
            tab3 = new Tab_global_grid();
            tab3.tab_set_data(grid_items_data);
            return tab3;
        }
        else if( position == 4 ) {
            tab4 = new Tab_global_grid();
            tab4.tab_set_data(grid_items_data);
            return tab4;
        }
        else {
            tab5 = new Tab_global_grid();
            tab5.tab_set_data(grid_items_data);
            return tab5;
        }

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