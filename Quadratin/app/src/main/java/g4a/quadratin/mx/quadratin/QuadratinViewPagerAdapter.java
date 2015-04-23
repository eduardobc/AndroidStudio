package g4a.quadratin.mx.quadratin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by eduardo on 4/8/15.
 */
public class QuadratinViewPagerAdapter extends FragmentStatePagerAdapter {

    private CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    private int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created


    /*testing tab 1 data items*/
    public Object[] grid_items_data = new Object[] {
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Politica",R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Politica",R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Politica",R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Politica",R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Politica",R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Politica",R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Politica",R.drawable.q_test_img_politica),


            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Politica",R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Politica",R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Politica",R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Politica",R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Politica",R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Politica",R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Politica",R.drawable.q_test_img_politica),


            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Politica",R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Politica",R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Politica",R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Politica",R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Politica",R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Politica",R.drawable.q_test_img_politica),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Cultura",R.drawable.q_test_img_cultura),
            new Grid_item_data_source(0,0,"Economia",R.drawable.q_test_img_economia),
            new Grid_item_data_source(0,0,"Politica",R.drawable.q_test_img_politica),

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
            Tab_1 tab1 = new Tab_1();
            tab1.Tab_1_set_data(grid_items_data);
            tab1.tab_edit_content(Titles[position].toString());
            return tab1;
        }
        else if( position == 1 ) {
            Tab_2 tab2 = new Tab_2();
            tab2.Tab_2_set_data(grid_items_data);
            tab2.tab_edit_content(Titles[position].toString());
            return tab2;
        }
        else if( position == 3 ) {
            Tab_3 tab3 = new Tab_3();
            tab3.tab_edit_content(Titles[position].toString());
            return tab3;
        }
        else if( position == 3 ) {
            Tab_4 tab4 = new Tab_4();
            tab4.tab_edit_content(Titles[position].toString());
            return tab4;
        }
        else {
            Tab_5 tab5 = new Tab_5();
            tab5.tab_edit_content(Titles[position].toString());
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