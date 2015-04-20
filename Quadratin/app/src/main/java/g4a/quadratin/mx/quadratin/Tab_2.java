package g4a.quadratin.mx.quadratin;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by eduardo on 4/8/15.
 */
public class Tab_2 extends Fragment {

    private String tab_title = "-";


    /*start grid layout*/
    private GridLayout grid_layout;
    private RelativeLayout item;
    private Object[] grid_items_data = new Object[] {
            new Grid_item_data_source("Cat 0",R.drawable.q_test_img_economia,R.layout.tab_2_grid_left),
            new Grid_item_data_source("Cat 1",R.drawable.q_test_img_cultura,R.layout.tab_2_grid_top),
            new Grid_item_data_source("Cat 2",R.drawable.q_test_img_politica,R.layout.tab_2_grid_top),
            new Grid_item_data_source("Cat 3",R.drawable.q_test_img_economia,R.layout.tab_2_grid_left),
            new Grid_item_data_source("Cat 4",R.drawable.q_test_img_cultura,R.layout.tab_2_grid_top),
            new Grid_item_data_source("Cat 5",R.drawable.q_test_img_politica,R.layout.tab_2_grid_top),
    };
    /*end grid layout*/

    public void tab_edit_content(String title) {
        tab_title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_2,container,false);



        return view;
    }




}
