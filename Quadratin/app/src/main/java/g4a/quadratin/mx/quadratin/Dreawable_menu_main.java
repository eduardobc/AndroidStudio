package g4a.quadratin.mx.quadratin;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by eduardo on 4/9/15.
 */
public class Dreawable_menu_main extends ActionBarActivity {

    /*start sliding tabs*/

    ViewPager pager;
    QuadratinViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[] = {
            "Aguascalientes",
            "Baja California Norte",
            "Baja California Sur",
            "Campeche",
            "Chiapas",
            "Chihuahua",
            "Coahuila",
            "Colima",
            "Distrito Federal",
            "Durango",
            "Guanajuato",
            "Guerrero",
            "Hidalgo",
            "Jalisco",
            "México",
            "Michoacán",
            "Morelos",
            "Nayarit",
            "Nuevo León",
            "Oaxaca",
            "Puebla",
            "Querétaro",
            "Quintana Roo",
            "San Luis Potos",
            "Sinaloa",
            "Sonora",
            "Tabasco",
            "Tamaulipas",
            "Tlaxcala",
            "Veracruz",
            "Yucatán",
            "Zacatecas",
    };
    int Numboftabs = Titles.length;



    /*end sliding tabs*/

    /*start drawer menu*/
    Toolbar quadratin_custom_toolbar;
    DrawerLayout drawerLayout;
    ListView drawerList;
    String[] tagTitles;
    /*end drawer menu*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_drawable_menu);

        //start custom toolbar
        quadratin_custom_toolbar_main();
        //start drawer tabs
        start_drawertabs();
        //start drawer menu
        start_drawermenu();

    }


    public void start_drawermenu() {
        /*start menu drawer*/
        tagTitles = getResources().getStringArray(R.array.Tags);
        //get instances
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);

        //new list
        ArrayList<DrawerItem> items = new ArrayList<DrawerItem>();
        items.add(new DrawerItem("",R.drawable.quadratin_logo_dark,1));
        for(int i = 0 ; i < tagTitles.length; i++) {
            items.add(new DrawerItem(tagTitles[i],R.drawable.quadratin_arrow_right_icon,0));
        }

        //relations listening
        drawerList.setAdapter(new DrawerListAdapter(this, items));

        //((ImageView)drawerList.getChildAt(0)).setMaxHeight(10);

        //show drawer
        drawerLayout.openDrawer(drawerList);

        //ListView click item listener
        drawerList.setOnItemClickListener(new ListView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("MENU Position", "pos=" + position);
                //this update a fragment, but it is not in use

                //get fragment and show
                /*DrawerMenuFragment fragment = new DrawerMenuFragment();
                Bundle args = new Bundle();
                args.putInt(DrawerMenuFragment.ARG_ARTICLES_NUMBER, position);
                fragment.setArguments(args);

                //change content fragment
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                */
                // update item selected and close drawer
                drawerList.setItemChecked(position, true);
                //quadratin_custom_toolbar.setTitle(tagTitles[position]);
                drawerLayout.closeDrawer(drawerList);
            }
        });
        /*end menu drawer*/
    }



    public void start_drawertabs() {
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
            //Log.d("TAB","Pos = "+position);
            return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        tabs.setCustomTabView(R.layout.tab_layout, android.R.id.text1);

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);
        /* ========== end sliding tabs ========== */
    }



    /* ========== start custom action bars ========== */
    /*quadratin custom toolbar*/
    public void quadratin_custom_toolbar_main() {
        quadratin_custom_toolbar = (Toolbar)findViewById(R.id.quadratin_custom_toobar_main);
        quadratin_custom_toolbar.setTitle("");
        setSupportActionBar(quadratin_custom_toolbar);
    }
    /* ========== start custom action bars ========== */



    /* ========== start menu settings ========== */
    /*@Override
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
    }*/
    /* ========== end menu settings ========== */

}