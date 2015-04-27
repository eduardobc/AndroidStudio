package g4a.quadratin.mx.quadratin;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by eduardo on 4/8/15.
 */
public class Tab_global_grid extends Fragment {

    private MyAsyncTask myTask;
    private View root_view;
    private LinearLayout root_scroll_view;

    private String tab_title = "-";
    private int grid_items_count = 0;
    private int grid_view_total_rows = 0;
    private boolean grid_iteration_finish = false;


    /*Start grid data*/
    //Grid Layouts
    private Integer grid_layouts[] = new Integer[]{
            R.layout.grid_type_a,
            R.layout.grid_type_b,
            R.layout.grid_type_c,
            R.layout.grid_type_d,
            R.layout.grid_type_e,
    };
    //Grid Layouts -> Containers
    private Integer grid_layout_containers[] = new Integer[]{
            R.id.grid_container_a,
            R.id.grid_container_b,
            R.id.grid_container_c,
            R.id.grid_container_d,
            R.id.grid_container_e,
    };
    private Object[] grid_items_data,grid_data_items_original;
    private Grid_item_data_group[] grid_item_data_groups;
    private View item_vh_dragged;//current item dragging
    private View item_vh_dropped;//current item dropping
    /*End grid data*/

    private void grid_total_row_items() {
        //A=3
        if( (grid_data_items_original.length-grid_items_count) > 2 ) {
            grid_view_total_rows = grid_view_total_rows + 1;
            grid_items_count = grid_items_count + 3;
            //Log.i("GRID ITEMS","A=3");
        }
        //B=3
        if( (grid_data_items_original.length-grid_items_count) > 2 ) {
            grid_view_total_rows = grid_view_total_rows + 1;
            grid_items_count = grid_items_count + 3;
            //Log.i("GRID ITEMS","B=3");
        }
        //C=2
        if( (grid_data_items_original.length-grid_items_count) > 1 ) {
            grid_view_total_rows = grid_view_total_rows + 1;
            grid_items_count = grid_items_count + 2;
            //Log.i("GRID ITEMS","C=2");
        }
        //D=2
        if( (grid_data_items_original.length-grid_items_count) > 1 ) {
            grid_view_total_rows = grid_view_total_rows + 1;
            grid_items_count = grid_items_count + 2;
            //Log.i("GRID ITEMS","D=2");
        } else if( (grid_data_items_original.length-grid_items_count) > 0 ) {
            //E=1
            grid_view_total_rows = grid_view_total_rows + 1;
            grid_items_count = grid_items_count + 1;
            //Log.i("GRID ITEMS","E=1");
        } else {
            grid_iteration_finish = true;
        }
        if( grid_iteration_finish == false )
            grid_total_row_items();

    }

    private int grid_fill_rows_count = 0;
    private void grid_fill_items_rows() {
        //A=3
        if( (grid_data_items_original.length-grid_items_count) > 2 ) {

            Object group[] = new Object[3];
            group[0] = grid_items_data[grid_items_count++];
            group[1] = grid_items_data[grid_items_count++];
            group[2] = grid_items_data[grid_items_count++];
            grid_item_data_groups[grid_fill_rows_count++] = new Grid_item_data_group(0,group);
            //Log.i("GRID ITEMS", "A=3");
        }
        //B=3
        if( (grid_data_items_original.length-grid_items_count) > 2 ) {
            Object group[] = new Object[3];
            group[0] = grid_items_data[grid_items_count++];
            group[1] = grid_items_data[grid_items_count++];
            group[2] = grid_items_data[grid_items_count++];
            grid_item_data_groups[grid_fill_rows_count++] = new Grid_item_data_group(1,group);
            //Log.i("GRID ITEMS","B=3");
        }
        //C=2
        if( (grid_data_items_original.length-grid_items_count) > 1 ) {
            Object group[] = new Object[2];
            group[0] = grid_items_data[grid_items_count++];
            group[1] = grid_items_data[grid_items_count++];
            grid_item_data_groups[grid_fill_rows_count++] = new Grid_item_data_group(2,group);
            //Log.i("GRID ITEMS","C=2");
        }
        //D=2
        if( (grid_data_items_original.length-grid_items_count) > 1 ) {
            Object group[] = new Object[2];
            group[0] = grid_items_data[grid_items_count++];
            group[1] = grid_items_data[grid_items_count++];
            grid_item_data_groups[grid_fill_rows_count++] = new Grid_item_data_group(3,group);
            //Log.i("GRID ITEMS","D=2");
        } else if( (grid_data_items_original.length-grid_items_count) > 0 ) {
            //E=1
            Object group[] = new Object[1];
            group[0] = grid_items_data[grid_items_count++];
            grid_item_data_groups[grid_fill_rows_count++] = new Grid_item_data_group(4,group);
            //Log.i("GRID ITEMS","E=1");
        } else {
            grid_iteration_finish = true;
        }
        if( grid_iteration_finish == false )
            grid_fill_items_rows();
    }

    //Start prepare data source to be used
    public void tab_set_data(Object[] data_source) {
        grid_items_data = data_source;
        grid_data_items_original = data_source;
        grid_total_row_items();
        grid_iteration_finish = false;
        grid_items_count = 0;
        Log.i("GRID TOTAL ROWS",""+grid_view_total_rows);
        grid_item_data_groups = new Grid_item_data_group[grid_view_total_rows];
        grid_fill_items_rows();
    }

    public void tab_set_title(String title) {
        tab_title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root_view = inflater.inflate(R.layout.tab_global_layout,container,false);
        root_scroll_view = (LinearLayout) root_view.findViewById(R.id.linear_layout);
        //fill
        root_view = fill_root_view(root_view);


        /*
        setRetainInstance(true);
        myTask = new MyAsyncTask(getActivity(),root_view);
        myTask.execute();
        */
        return root_view;
    }








    private View fill_root_view(View root_view) {


        for( int position=0; position<26; position++ ) {
            View layout_grid = null;
            Grid_item_data_group item_group = null;
            LayoutInflater inflater = (LayoutInflater) root_scroll_view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            item_group = (Grid_item_data_group) grid_item_data_groups[position];
            if (item_group.grid_layout == 0)
                layout_grid = grid_layout_a_inflate(layout_grid, inflater, item_group, position);
            else if (item_group.grid_layout == 1)
                layout_grid = grid_layout_b_inflate(layout_grid, inflater, item_group, position);
            else if (item_group.grid_layout == 2)
                layout_grid = grid_layout_c_inflate(layout_grid, inflater, item_group, position);
            else if (item_group.grid_layout == 3)
                layout_grid = grid_layout_d_inflate(layout_grid, inflater, item_group, position);
            else
                layout_grid = grid_layout_e_inflate(layout_grid, inflater, item_group, position);

            //append layout_grid to root_view
            root_scroll_view.addView(layout_grid);
        }
        return root_view;
    }



    private void populate_result_task() {
        Log.i("THREAD","FINISH");
        setRetainInstance(false);
    }
    private class MyAsyncTask extends AsyncTask<String, Void, String>{
        Activity context;
        View root_view;

        public  MyAsyncTask(Activity context,View root_view) {
            this.context = context;
            this.root_view = root_view;
        }



        @Override
        protected String doInBackground(String... params) {

            View layout_grid = null;
            Grid_item_data_group item_group = null;
            LayoutInflater inflater = (LayoutInflater) root_scroll_view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            for( int position=0; position<grid_item_data_groups.length; position++ ) {

                item_group = (Grid_item_data_group) grid_item_data_groups[position];
                if (item_group.grid_layout == 0)
                    layout_grid = grid_layout_a_inflate(layout_grid, inflater, item_group, position);
                else if (item_group.grid_layout == 1)
                    layout_grid = grid_layout_b_inflate(layout_grid, inflater, item_group, position);
                else if (item_group.grid_layout == 2)
                    layout_grid = grid_layout_c_inflate(layout_grid, inflater, item_group, position);
                else if (item_group.grid_layout == 3)
                    layout_grid = grid_layout_d_inflate(layout_grid, inflater, item_group, position);
                else
                    layout_grid = grid_layout_e_inflate(layout_grid, inflater, item_group, position);
                //append layout_grid to root_view
                root_scroll_view.addView(layout_grid);

            }

            populate_result_task();
            return null;
        }

    }



    /*Start items functions*/
    private final class Item_long_click_listener implements View.OnLongClickListener {

        @Override
        public boolean onLongClick(View view) {
            item_vh_dragged = view;
            ClipData data = ClipData.newPlainText("clip_data", "A-1");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            // start dragging the item touched
            view.startDrag(data, shadowBuilder, view, 0);
            item_vh_dragged.setVisibility(View.INVISIBLE);

            return false;
        }
    }

    private class DragNDropListener implements AdapterView.OnDragListener {

        @Override
        public boolean onDrag(View view, DragEvent event) {

            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    //String title = (String)((TextView) v.findViewById(R.id.grid_text)).getText();
                    //Log.i("DRAG Started", "ACTION_DRAG_STARTED = "+title);
                    if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                        view.setBackgroundColor(Color.WHITE);
                        view.invalidate();
                        //dragged element
                        //Log.i("DRAG Started", "ACTION_DRAG_STARTED");
                        return true;
                    }
                    return false;
                case DragEvent.ACTION_DRAG_ENTERED:
                    //item it is dropper
                    view.setBackgroundColor(Color.GREEN);
                    view.invalidate();
                    return true;
                case DragEvent.ACTION_DRAG_EXITED:
                    //Log.i("DRAG Exited", "ACTION_DRAG_EXITED");
                    view.setBackgroundColor(Color.WHITE);
                    view.invalidate();
                    return true;
                case DragEvent.ACTION_DROP:

                    // Gets the item containing the dragged data
                    ClipData.Item item = event.getClipData().getItemAt(0);
                    // Gets the text data from the item.
                    String clip_data = (String) item.getText();

                    //droppped item
                    item_vh_dropped = view;
                    //Log.i("DRAG Dropped", "ACTION_DROP Item Tag DROP");
                    //iterchange_items_data();

                    // Turns off any color tints
                    view.setBackgroundColor(Color.BLUE);
                    // Invalidates the view to force a redraw
                    view.invalidate();

                    // Returns true. DragEvent.getResult() will return true.
                    return true;
                case DragEvent.ACTION_DRAG_ENDED:
                    view.setBackgroundColor(Color.WHITE);
                    view.invalidate();
                    if (event.getResult()) {
                        //Log.i("DRAG Ended", "The drop was handled.");
                    } else {
                        //Log.i("DRAG Ended", "The drop didn't work.");
                    }
                    return true;
                // An unknown action type was received.
                default:
                    item_vh_dragged.setVisibility(View.VISIBLE);
                    //Log.i("DragDrop Example","Unknown action type received by OnDragListener.");
                    break;
            }
            return false;
        }
    }
    /*End items functions*/






    private View grid_layout_a_inflate(View layout_grid, LayoutInflater inflater, Grid_item_data_group item_group, int position) {

        //for Layout grid_type_a.xml
        //set layout for the item
        layout_grid = inflater.inflate(grid_layouts[item_group.grid_layout], null);
        //get data from data source array
        /*Grid_item_data_source item_data_a = ((Grid_item_data_source) item_group.group_items[0]);
        Grid_item_data_source item_data_b = ((Grid_item_data_source) item_group.group_items[1]);
        Grid_item_data_source item_data_c = ((Grid_item_data_source) item_group.group_items[2]);

        //get child elements
        ViewGroup group_container = ((ViewGroup) layout_grid.findViewById(grid_layout_containers[item_group.grid_layout]));
        ViewGroup group_container_left = (ViewGroup) ((ViewGroup) group_container).getChildAt(0);
        ViewGroup group_container_right = (ViewGroup) ((ViewGroup) group_container).getChildAt(1);


        RelativeLayout item_aa = (RelativeLayout) group_container_left.getChildAt(0);
        RelativeLayout item_bb = (RelativeLayout) group_container_right.getChildAt(0);
        RelativeLayout item_cc = (RelativeLayout) group_container_right.getChildAt(1);
        //set data to items

        ((ImageView) ((ViewGroup) item_aa).getChildAt(0)).setImageResource(item_data_a.item_image);
        ((ImageView) ((ViewGroup) item_bb).getChildAt(0)).setImageResource(item_data_b.item_image);
        ((ImageView) ((ViewGroup) item_cc).getChildAt(0)).setImageResource(item_data_c.item_image);
        //set cat titles
        ((TextView) ((ViewGroup) ((ViewGroup) ((ViewGroup) group_container_left.getChildAt(0)).getChildAt(1)).getChildAt(0)).getChildAt(0) ).setText(item_data_a.item_category_title);
        ((TextView) ((ViewGroup) ((ViewGroup) ((ViewGroup) group_container_right.getChildAt(0)).getChildAt(1)).getChildAt(0)).getChildAt(0) ).setText(item_data_b.item_category_title);
        ((TextView) ((ViewGroup) ((ViewGroup) ((ViewGroup) group_container_right.getChildAt(1)).getChildAt(1)).getChildAt(0)).getChildAt(0) ).setText(item_data_c.item_category_title);

        //item click
        item_aa.setOnLongClickListener(new Item_long_click_listener());
        item_bb.setOnLongClickListener(new Item_long_click_listener());
        item_cc.setOnLongClickListener(new Item_long_click_listener());

        //DnD listener
        item_aa.setOnDragListener(new DragNDropListener());
        item_bb.setOnDragListener(new DragNDropListener());
        item_cc.setOnDragListener(new DragNDropListener());
        */

        return layout_grid;
    }




    private View grid_layout_b_inflate(View layout_grid, LayoutInflater inflater, Grid_item_data_group item_group, int position) {
        //set layout for the item
        layout_grid = inflater.inflate(grid_layouts[item_group.grid_layout], null);
        /*
        //get data from data source array
        Grid_item_data_source item_data_a = ((Grid_item_data_source) item_group.group_items[0]);
        Grid_item_data_source item_data_b = ((Grid_item_data_source) item_group.group_items[1]);
        Grid_item_data_source item_data_c = ((Grid_item_data_source) item_group.group_items[2]);

        //get child elements
        ViewGroup group_container = ((ViewGroup) layout_grid.findViewById(grid_layout_containers[item_group.grid_layout]));
        RelativeLayout item_aa = (RelativeLayout) group_container.getChildAt(0);
        RelativeLayout item_bb = (RelativeLayout) group_container.getChildAt(1);
        RelativeLayout item_cc = (RelativeLayout) group_container.getChildAt(2);
        //set data to items
        ((ImageView) ((ViewGroup) item_aa).getChildAt(0)).setImageResource(item_data_a.item_image);
        ((ImageView) ((ViewGroup) item_bb).getChildAt(0)).setImageResource(item_data_b.item_image);
        ((ImageView) ((ViewGroup) item_cc).getChildAt(0)).setImageResource(item_data_c.item_image);
        //set cat titles
        ((TextView) ((ViewGroup) ((ViewGroup) item_aa.getChildAt(1)).getChildAt(0)).getChildAt(0) ).setText(item_data_a.item_category_title);
        ((TextView) ((ViewGroup) ((ViewGroup) item_bb.getChildAt(1)).getChildAt(0)).getChildAt(0) ).setText(item_data_b.item_category_title);
        ((TextView) ((ViewGroup) ((ViewGroup) item_cc.getChildAt(1)).getChildAt(0)).getChildAt(0) ).setText(item_data_c.item_category_title);

        //item click
        item_aa.setOnLongClickListener(new Item_long_click_listener());
        item_bb.setOnLongClickListener(new Item_long_click_listener());
        item_cc.setOnLongClickListener(new Item_long_click_listener());

        //DnD listener
        item_aa.setOnDragListener(new DragNDropListener());
        item_bb.setOnDragListener(new DragNDropListener());
        item_cc.setOnDragListener(new DragNDropListener());
        */
        return layout_grid;
    }

    private View grid_layout_c_inflate(View layout_grid, LayoutInflater inflater, Grid_item_data_group item_group, int position) {
        //set layout for the item
        layout_grid = inflater.inflate(grid_layouts[item_group.grid_layout], null);
        /*
        //get data from data source array
        Grid_item_data_source item_data_a = ((Grid_item_data_source) item_group.group_items[0]);
        Grid_item_data_source item_data_b = ((Grid_item_data_source) item_group.group_items[1]);
        //get child elements
        ViewGroup group_container = ((ViewGroup) layout_grid.findViewById(grid_layout_containers[item_group.grid_layout]));
        RelativeLayout item_aa = (RelativeLayout) group_container.getChildAt(0);
        RelativeLayout item_bb = (RelativeLayout) group_container.getChildAt(1);
        //set data to items
        ((ImageView) ((ViewGroup) item_aa).getChildAt(0)).setImageResource(item_data_a.item_image);
        ((ImageView) ((ViewGroup) item_bb).getChildAt(0)).setImageResource(item_data_b.item_image);
        //set cat titles
        ((TextView) ((ViewGroup) ((ViewGroup) item_aa.getChildAt(1)).getChildAt(0)).getChildAt(0) ).setText(item_data_a.item_category_title);
        ((TextView) ((ViewGroup) ((ViewGroup) item_bb.getChildAt(1)).getChildAt(0)).getChildAt(0) ).setText(item_data_b.item_category_title);

        //item click
        item_aa.setOnLongClickListener(new Item_long_click_listener());
        item_bb.setOnLongClickListener(new Item_long_click_listener());

        //DnD listener
        item_aa.setOnDragListener(new DragNDropListener());
        item_bb.setOnDragListener(new DragNDropListener());
        */
        return layout_grid;
    }

    private View grid_layout_d_inflate(View layout_grid, LayoutInflater inflater, Grid_item_data_group item_group, int position) {
        //set layout for the item
        layout_grid = inflater.inflate(grid_layouts[item_group.grid_layout], null);
        /*
        //get data from data source array
        Grid_item_data_source item_data_a = ((Grid_item_data_source) item_group.group_items[0]);
        Grid_item_data_source item_data_b = ((Grid_item_data_source) item_group.group_items[1]);
        //get child elements
        ViewGroup group_container = ((ViewGroup) layout_grid.findViewById(grid_layout_containers[item_group.grid_layout]));
        RelativeLayout item_aa = (RelativeLayout) group_container.getChildAt(0);
        RelativeLayout item_bb = (RelativeLayout) group_container.getChildAt(1);
        //set data to items
        ((ImageView) ((ViewGroup) item_aa).getChildAt(0)).setImageResource(item_data_a.item_image);
        ((ImageView) ((ViewGroup) item_bb).getChildAt(0)).setImageResource(item_data_b.item_image);
        //set cat titles
        ((TextView) ((ViewGroup) ((ViewGroup) item_aa.getChildAt(1)).getChildAt(0)).getChildAt(0) ).setText(item_data_a.item_category_title);
        ((TextView) ((ViewGroup) ((ViewGroup) item_bb.getChildAt(1)).getChildAt(0)).getChildAt(0) ).setText(item_data_b.item_category_title);


        //item click
        item_aa.setOnLongClickListener(new Item_long_click_listener());
        item_bb.setOnLongClickListener(new Item_long_click_listener());

        //DnD listener
        item_aa.setOnDragListener(new DragNDropListener());
        item_bb.setOnDragListener(new DragNDropListener());
        */
        return layout_grid;
    }

    private View grid_layout_e_inflate(View layout_grid, LayoutInflater inflater, Grid_item_data_group item_group, int position) {
        //set layout for the item
        layout_grid = inflater.inflate(grid_layouts[item_group.grid_layout], null);
        /*
        //get data from data source array
        Grid_item_data_source item_data_a = ((Grid_item_data_source) item_group.group_items[0]);
        //get child elements
        ViewGroup group_container = ((ViewGroup) layout_grid.findViewById(grid_layout_containers[item_group.grid_layout]));
        RelativeLayout item_aa = (RelativeLayout) group_container.getChildAt(0);
        //set data to items
        ((ImageView) ((ViewGroup) item_aa).getChildAt(0)).setImageResource(item_data_a.item_image);
        //set cat titles
        ((TextView) ((ViewGroup) ((ViewGroup) item_aa.getChildAt(1)).getChildAt(0)).getChildAt(0) ).setText(item_data_a.item_category_title);

        //item click
        item_aa.setOnLongClickListener(new Item_long_click_listener());
        //DnD listener
        item_aa.setOnDragListener(new DragNDropListener());
        */
        return layout_grid;
    }
}