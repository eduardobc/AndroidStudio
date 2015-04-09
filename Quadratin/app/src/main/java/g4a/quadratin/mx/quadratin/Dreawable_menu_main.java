package g4a.quadratin.mx.quadratin;

import android.app.FragmentManager;
import android.os.Bundle;
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

    Toolbar quadratin_custom_toolbar;
    DrawerLayout drawerLayout;
    ListView drawerList;
    String[] tagTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_drawable_menu);

        //custom toolbar
        quadratin_custom_toolbar_main();

        tagTitles = getResources().getStringArray(R.array.Tags);
        //get instances
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);

        //new list
        ArrayList<DrawerItem> items = new ArrayList<DrawerItem>();
        items.add(new DrawerItem("",R.drawable.quadratin_logo));
        for(int i = 0 ; i < tagTitles.length; i++) {
            items.add(new DrawerItem(tagTitles[i],R.mipmap.q_ic_launcher));
        }

        //relations listening
        drawerList.setAdapter(new DrawerListAdapter(this, items));


        //ListView click item listener
        drawerList.setOnItemClickListener(new ListView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("MENU Position", "pos=" + position);
                drawer_fragment fragment = new drawer_fragment();
                Bundle args = new Bundle();
                args.putInt(drawer_fragment.ARG_ARTICLES_NUMBER, position);
                fragment.setArguments(args);

                //change content fragment
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

                // update item selected and close drawer
                drawerList.setItemChecked(position, true);
                //quadratin_custom_toolbar.setTitle(tagTitles[position]);
                drawerLayout.closeDrawer(drawerList);
            }
        });
    }

    /* ========== start custom action bars ========== */
    /*quadratin custom toolbar*/
    public void quadratin_custom_toolbar_main() {
        quadratin_custom_toolbar = (Toolbar)findViewById(R.id.quadratin_custom_toobar_main);
        quadratin_custom_toolbar.setTitle("");
        setSupportActionBar(quadratin_custom_toolbar);
    }
    /* ========== start custom action bars ========== */

}