package g4a.quadratin.mx.quadratin;

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
import android.widget.TextView;


/**
 * Created by eduardo on 4/8/15.
 */
public class Tab_global_grid extends Fragment {

    //start fragment vars
    private View root_view;
    private LinearLayout root_scroll_view;
    private final static int PADDING_LEFT_TIGHT = 10;
    //end fragment vars

    //start grid data vars
    private int grid_items_count = 0;
    private int grid_view_total_rows = 0;
    private boolean grid_iteration_finish = false;
    //end grid data vars

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
        //Log.i("GRID TOTAL ROWS",""+grid_view_total_rows);
        grid_item_data_groups = new Grid_item_data_group[grid_view_total_rows];
        grid_fill_items_rows();
    }






    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root_view = inflater.inflate(R.layout.tab_global_layout,container,false);
        root_scroll_view = (LinearLayout) root_view.findViewById(R.id.linear_layout);
        return root_view;
    }





    /*START THREAD in BACKGROUND*/

    public void inflate_rows() {
        new FillGridTask().execute();
    }

    private class FillGridTask extends AsyncTask<String, Integer, Integer> {

        protected Integer doInBackground(String... strings) {

            //Log.i("FillGridTask","doInBackground");
            return 1;
        }

        protected void onProgressUpdate(Integer... progress) {
            //Log.i("FillGridTask","onProgressUpdate");
        }

        protected void onPostExecute(Integer result) {
            //Log.i("FillGridTask","onPostExecute");
            fill_root_view();
        }
    }

    private class FillRowTask extends AsyncTask<Integer, Integer, Integer> {
        private Integer position;
        private View layout_grid = null;
        private Grid_item_data_group item_group = null;
        private LayoutInflater inflater;

        public FillRowTask() {
            inflater = (LayoutInflater) root_view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        protected Integer doInBackground(Integer... positions) {

            //Log.i("FillRowTask","doInBackground");
            position = positions[0];

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

            return 1;
        }

        protected void onProgressUpdate(Integer... progress) {
            //Log.i("FillRowTask","onProgressUpdate");
        }

        protected void onPostExecute(Integer result) {
            //Log.i("FillRowTask","onPostExecute");
            //append layout_grid to root_view
            root_scroll_view.addView(layout_grid);
        }
    }

    /*START THREAD in BACKGROUND*/









    private View fill_root_view() {
        for( int position=0; position<grid_item_data_groups.length; position++ ) {
            new FillRowTask().execute(position);
        }
        return root_view;
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

        if( position == 0 )
            layout_grid.setPadding(PADDING_LEFT_TIGHT,0,PADDING_LEFT_TIGHT,2);
        else if( position == grid_items_data.length -1 )
            layout_grid.setPadding(PADDING_LEFT_TIGHT,2,PADDING_LEFT_TIGHT,0);
        else
            layout_grid.setPadding(PADDING_LEFT_TIGHT,2,PADDING_LEFT_TIGHT,2);

        //get data from data source array
        Grid_item_data_source item_data_a = ((Grid_item_data_source) item_group.group_items[0]);
        Grid_item_data_source item_data_b = ((Grid_item_data_source) item_group.group_items[1]);
        Grid_item_data_source item_data_c = ((Grid_item_data_source) item_group.group_items[2]);

        //get child elements
        ViewGroup group_container = ((ViewGroup) layout_grid.findViewById(grid_layout_containers[item_group.grid_layout]));
        ViewGroup group_container_left = (ViewGroup) ((ViewGroup) group_container).getChildAt(0);
        ViewGroup group_container_right = (ViewGroup) ((ViewGroup) group_container).getChildAt(1);


        ViewGroup item_aa = (ViewGroup) group_container_left.getChildAt(0);
        ViewGroup item_bb = (ViewGroup) group_container_right.getChildAt(0);
        ViewGroup item_cc = (ViewGroup) group_container_right.getChildAt(1);
        //set data to items
        //images
        ((ImageView) item_aa.getChildAt(0)).setImageResource(item_data_a.item_image);
        ((ImageView) item_bb.getChildAt(0)).setImageResource(item_data_b.item_image);
        ((ImageView) item_cc.getChildAt(0)).setImageResource(item_data_c.item_image);

        //set cat titles
        //a
        ViewGroup group_category = (ViewGroup) item_aa.getChildAt(1);
        ((TextView) ((ViewGroup) group_category.getChildAt(0)).getChildAt(0) ).setText(item_data_a.item_category_title); //category name
        ((TextView) ((ViewGroup) group_category.getChildAt(0)).getChildAt(1) ).setText(position+":"+position); //post date
        ((TextView) group_category.getChildAt(1) ).setText("Post title - "+position); //post title
        //b
        group_category = (ViewGroup) item_bb.getChildAt(1);
        ((TextView) group_category.getChildAt(0) ).setText(item_data_b.item_category_title); //category
        ((TextView) group_category.getChildAt(1) ).setText("+"+position); //num posts
        //c
        group_category = (ViewGroup) item_cc.getChildAt(1);
        ((TextView) group_category.getChildAt(0) ).setText(item_data_c.item_category_title); //category
        ((TextView) group_category.getChildAt(1) ).setText("+"+position); //num posts


        //item click
        item_aa.setOnLongClickListener(new Item_long_click_listener());
        item_bb.setOnLongClickListener(new Item_long_click_listener());
        item_cc.setOnLongClickListener(new Item_long_click_listener());

        //DnD listener
        item_aa.setOnDragListener(new DragNDropListener());
        item_bb.setOnDragListener(new DragNDropListener());
        item_cc.setOnDragListener(new DragNDropListener());

        return layout_grid;
    }




    private View grid_layout_b_inflate(View layout_grid, LayoutInflater inflater, Grid_item_data_group item_group, int position) {
        //set layout for the item
        layout_grid = inflater.inflate(grid_layouts[item_group.grid_layout], null);

        if( position == 0 )
            layout_grid.setPadding(PADDING_LEFT_TIGHT,0,PADDING_LEFT_TIGHT,2);
        else if( position == grid_items_data.length -1 )
            layout_grid.setPadding(PADDING_LEFT_TIGHT,2,PADDING_LEFT_TIGHT,0);
        else
            layout_grid.setPadding(PADDING_LEFT_TIGHT,2,PADDING_LEFT_TIGHT,2);

        //get data from data source array
        Grid_item_data_source item_data_a = ((Grid_item_data_source) item_group.group_items[0]);
        Grid_item_data_source item_data_b = ((Grid_item_data_source) item_group.group_items[1]);
        Grid_item_data_source item_data_c = ((Grid_item_data_source) item_group.group_items[2]);

        //get child elements
        ViewGroup group_container = ((ViewGroup) layout_grid.findViewById(grid_layout_containers[item_group.grid_layout]));
        ViewGroup item_aa = (ViewGroup) group_container.getChildAt(0);
        ViewGroup item_bb = (ViewGroup) group_container.getChildAt(1);
        ViewGroup item_cc = (ViewGroup) group_container.getChildAt(2);
        //set data to items
        ((ImageView) item_aa.getChildAt(0)).setImageResource(item_data_a.item_image);
        ((ImageView) item_bb.getChildAt(0)).setImageResource(item_data_b.item_image);
        ((ImageView) item_cc.getChildAt(0)).setImageResource(item_data_c.item_image);

        //set cat titles
        //a
        ViewGroup group_category = (ViewGroup) item_aa.getChildAt(1);
        ((TextView) group_category.getChildAt(0) ).setText(item_data_a.item_category_title); //category
        ((TextView) group_category.getChildAt(1) ).setText("+"+position); //num posts
        //b
        group_category = (ViewGroup) item_bb.getChildAt(1);
        ((TextView) group_category.getChildAt(0) ).setText(item_data_b.item_category_title); //category
        ((TextView) group_category.getChildAt(1) ).setText("+"+position); //num posts
        //c
        group_category = (ViewGroup) item_cc.getChildAt(1);
        ((TextView) group_category.getChildAt(0) ).setText(item_data_c.item_category_title); //category
        ((TextView) group_category.getChildAt(1) ).setText("+"+position); //num posts


        //item click
        item_aa.setOnLongClickListener(new Item_long_click_listener());
        item_bb.setOnLongClickListener(new Item_long_click_listener());
        item_cc.setOnLongClickListener(new Item_long_click_listener());

        //DnD listener
        item_aa.setOnDragListener(new DragNDropListener());
        item_bb.setOnDragListener(new DragNDropListener());
        item_cc.setOnDragListener(new DragNDropListener());

        return layout_grid;
    }

    private View grid_layout_c_inflate(View layout_grid, LayoutInflater inflater, Grid_item_data_group item_group, int position) {
        //set layout for the item
        layout_grid = inflater.inflate(grid_layouts[item_group.grid_layout], null);

        if( position == 0 )
            layout_grid.setPadding(PADDING_LEFT_TIGHT,0,PADDING_LEFT_TIGHT,2);
        else if( position == grid_items_data.length -1 )
            layout_grid.setPadding(PADDING_LEFT_TIGHT,2,PADDING_LEFT_TIGHT,0);
        else
            layout_grid.setPadding(PADDING_LEFT_TIGHT,2,PADDING_LEFT_TIGHT,2);

        //get data from data source array
        Grid_item_data_source item_data_a = ((Grid_item_data_source) item_group.group_items[0]);
        Grid_item_data_source item_data_b = ((Grid_item_data_source) item_group.group_items[1]);
        //get child elements
        ViewGroup group_container = ((ViewGroup) layout_grid.findViewById(grid_layout_containers[item_group.grid_layout]));
        ViewGroup item_aa = (ViewGroup) group_container.getChildAt(0);
        ViewGroup item_bb = (ViewGroup) group_container.getChildAt(1);
        //set data to items
        ((ImageView) item_aa.getChildAt(0)).setImageResource(item_data_a.item_image);
        ((ImageView) item_bb.getChildAt(0)).setImageResource(item_data_b.item_image);
        //set cat titles
        //a
        ViewGroup group_category = (ViewGroup) item_aa.getChildAt(1);
        ((TextView) group_category.getChildAt(0) ).setText(item_data_a.item_category_title); //category
        ((TextView) group_category.getChildAt(1) ).setText("+"+position); //num posts
        //b
        group_category = (ViewGroup) item_bb.getChildAt(1);
        ((TextView) ((ViewGroup) group_category.getChildAt(0)).getChildAt(0) ).setText(item_data_b.item_category_title); //category
        ((TextView) ((ViewGroup) group_category.getChildAt(0)).getChildAt(1) ).setText(position+":"+position); //post date
        ((TextView) group_category.getChildAt(1) ).setText("Post title - "+position); //post date

        //item click
        item_aa.setOnLongClickListener(new Item_long_click_listener());
        item_bb.setOnLongClickListener(new Item_long_click_listener());

        //DnD listener
        item_aa.setOnDragListener(new DragNDropListener());
        item_bb.setOnDragListener(new DragNDropListener());

        return layout_grid;
    }

    private View grid_layout_d_inflate(View layout_grid, LayoutInflater inflater, Grid_item_data_group item_group, int position) {

        //set layout for the item
        layout_grid = inflater.inflate(grid_layouts[item_group.grid_layout], null);

        if( position == 0 )
            layout_grid.setPadding(PADDING_LEFT_TIGHT,0,PADDING_LEFT_TIGHT,2);
        else if( position == grid_items_data.length -1 )
            layout_grid.setPadding(PADDING_LEFT_TIGHT,2,PADDING_LEFT_TIGHT,0);
        else
            layout_grid.setPadding(PADDING_LEFT_TIGHT,2,PADDING_LEFT_TIGHT,2);

        //get data from data source array
        Grid_item_data_source item_data_a = ((Grid_item_data_source) item_group.group_items[0]);
        Grid_item_data_source item_data_b = ((Grid_item_data_source) item_group.group_items[1]);
        //get child elements
        ViewGroup group_container = ((ViewGroup) layout_grid.findViewById(grid_layout_containers[item_group.grid_layout]));
        ViewGroup item_aa = (ViewGroup) group_container.getChildAt(0);
        ViewGroup item_bb = (ViewGroup) group_container.getChildAt(1);
        //set data to items
        ((ImageView) item_aa.getChildAt(0)).setImageResource(item_data_a.item_image);
        ((ImageView) item_bb.getChildAt(0)).setImageResource(item_data_b.item_image);
        //set cat titles
        //a
        ViewGroup group_category = (ViewGroup) item_aa.getChildAt(1);
        ((TextView) ((ViewGroup) group_category.getChildAt(0)).getChildAt(0) ).setText(item_data_a.item_category_title); //category
        ((TextView) ((ViewGroup) group_category.getChildAt(0)).getChildAt(1) ).setText(position+":"+position); //post date
        ((TextView) group_category.getChildAt(1) ).setText("Post title - "+position); //post date
        //b
        group_category = (ViewGroup) item_bb.getChildAt(1);
        ((TextView) group_category.getChildAt(0) ).setText(item_data_b.item_category_title); //category
        ((TextView) group_category.getChildAt(1) ).setText("+"+position); //num posts

        //item click
        item_aa.setOnLongClickListener(new Item_long_click_listener());
        item_bb.setOnLongClickListener(new Item_long_click_listener());

        //DnD listener
        item_aa.setOnDragListener(new DragNDropListener());
        item_bb.setOnDragListener(new DragNDropListener());
        return layout_grid;
    }

    private View grid_layout_e_inflate(View layout_grid, LayoutInflater inflater, Grid_item_data_group item_group, int position) {
        //set layout for the item
        layout_grid = inflater.inflate(grid_layouts[item_group.grid_layout], null);

        Log.i("POSITION",grid_items_data.length+" == "+position);
        if( position == 0 )
            layout_grid.setPadding(PADDING_LEFT_TIGHT,0,PADDING_LEFT_TIGHT,2);
        else if( position == grid_items_data.length )
            layout_grid.setPadding(PADDING_LEFT_TIGHT,2,PADDING_LEFT_TIGHT,0);
        else
            layout_grid.setPadding(PADDING_LEFT_TIGHT,2,PADDING_LEFT_TIGHT,2);

        //get data from data source array
        Grid_item_data_source item_data_a = ((Grid_item_data_source) item_group.group_items[0]);
        //get child elements
        ViewGroup group_container = ((ViewGroup) layout_grid.findViewById(grid_layout_containers[item_group.grid_layout]));
        ViewGroup item_aa = (ViewGroup) group_container.getChildAt(0);
        //set data to items
        ((ImageView) item_aa.getChildAt(0)).setImageResource(item_data_a.item_image);
        //set cat titles
        //a
        ViewGroup group_category = (ViewGroup) item_aa.getChildAt(1);
        ((TextView) ((ViewGroup) group_category.getChildAt(0)).getChildAt(0) ).setText(item_data_a.item_category_title); //category
        ((TextView) ((ViewGroup) group_category.getChildAt(0)).getChildAt(1) ).setText(position+":"+position); //post date
        ((TextView) group_category.getChildAt(1) ).setText("Post title - "+position); //post date

        //item click
        item_aa.setOnLongClickListener(new Item_long_click_listener());
        //DnD listener
        item_aa.setOnDragListener(new DragNDropListener());

        return layout_grid;
    }
}
