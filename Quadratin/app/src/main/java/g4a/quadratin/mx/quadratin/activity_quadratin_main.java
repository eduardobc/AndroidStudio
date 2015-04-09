package g4a.quadratin.mx.quadratin;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by eduardo on 4/8/15.
 */
public class activity_quadratin_main extends ActionBarActivity {

    /*start sliding tabs*/

    Toolbar toolbar;
    ViewPager pager;
    QuadratinViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[] = {"MICHOACAN","OAXACA","CHIAPAS","GUANAJUATO","MORELOS","VERACRUZ","HIDALGO"};
    int Numboftabs = Titles.length;

    /*end sliding tabs*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratin_main);


        /* ========== start sliding tabs ========== */

        // Creating The Toolbar and setting it as the Toolbar for the activity
        //set custom toolbar
        quadratin_custom_toolbar_main();

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter =  new QuadratinViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
            return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);


        /* ========== end sliding tabs ========== */

    }


    /* ========== start custom action bars ========== */
    /*quadratin custom toolbar*/
    public void quadratin_custom_toolbar_main() {
        Toolbar quadratin_custom_toolbar = (Toolbar)findViewById(R.id.quadratin_custom_toobar_main);
        quadratin_custom_toolbar.setTitle("");
        setSupportActionBar(quadratin_custom_toolbar);
    }
    /* ========== start custom action bars ========== */




    /* ========== start menu settings ========== */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quadratin_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /* ========== end menu settings ========== */
}
