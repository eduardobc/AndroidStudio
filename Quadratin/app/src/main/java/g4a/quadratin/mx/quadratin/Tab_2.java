package g4a.quadratin.mx.quadratin;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;


/**
 * Created by eduardo on 4/8/15.
 */
public class Tab_2 extends Fragment {
    /* start Tab data */
    private String tab_title = "-";
    /* end Tab data */

    /* start gridview */

    private GridView grid_view;
    private Object[] grid_items_data,grid_data_items_original;
    private Grid_item_data_group[] grid_item_data_groups;


    /* end gridview */



    public Tab_2() {}



    private int grid_items_count = 0;
    private int grid_view_total_rows = 0;
    private boolean grid_iteration_finish = false;

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
            Log.i("GRID ITEMS","A=3");
        }
        //B=3
        if( (grid_data_items_original.length-grid_items_count) > 2 ) {
            Object group[] = new Object[3];
            group[0] = grid_items_data[grid_items_count++];
            group[1] = grid_items_data[grid_items_count++];
            group[2] = grid_items_data[grid_items_count++];
            grid_item_data_groups[grid_fill_rows_count++] = new Grid_item_data_group(1,group);
            Log.i("GRID ITEMS","B=3");
        }
        //C=2
        if( (grid_data_items_original.length-grid_items_count) > 1 ) {
            Object group[] = new Object[2];
            group[0] = grid_items_data[grid_items_count++];
            group[1] = grid_items_data[grid_items_count++];
            grid_item_data_groups[grid_fill_rows_count++] = new Grid_item_data_group(2,group);
            Log.i("GRID ITEMS","C=2");
        }
        //D=2
        if( (grid_data_items_original.length-grid_items_count) > 1 ) {
            Object group[] = new Object[2];
            group[0] = grid_items_data[grid_items_count++];
            group[1] = grid_items_data[grid_items_count++];
            grid_item_data_groups[grid_fill_rows_count++] = new Grid_item_data_group(3,group);
            Log.i("GRID ITEMS","D=2");
        } else if( (grid_data_items_original.length-grid_items_count) > 0 ) {
            //E=1
            Object group[] = new Object[1];
            group[0] = grid_items_data[grid_items_count++];
            grid_item_data_groups[grid_fill_rows_count++] = new Grid_item_data_group(4,group);
            Log.i("GRID ITEMS","E=1");
        } else {
            grid_iteration_finish = true;
        }
        if( grid_iteration_finish == false )
            grid_fill_items_rows();

    }

    //Start prepare data source to be used
    public void Tab_2_set_data(Object[] data_source) {
        grid_items_data = data_source;
        grid_data_items_original = data_source;
        grid_total_row_items();
        grid_iteration_finish = false;
        grid_items_count = 0;
        Log.i("GRID TOTAL ROWS",""+grid_view_total_rows);
        grid_item_data_groups = new Grid_item_data_group[grid_view_total_rows];
        grid_fill_items_rows();


        /*
        int items_count = 0;
        int grid_item_data_group_count = 0;

        //set total items to show
        grid_item_data_groups = new Grid_item_data_group[4];

        //group A or B. 3 items
        int type_layout = 0;
        int total_group_a = (grid_items_data.length/3);
        if( total_group_a > 0 ) {

            for(int i=0; i<total_group_a; i++ ) {//iterate rows of 3 items each one
                Object group[] = new Object[3];
                group[0] = grid_items_data[items_count++];
                group[1] = grid_items_data[items_count++];
                group[2] = grid_items_data[items_count++];
                grid_item_data_groups[grid_item_data_group_count++] = new Grid_item_data_group(type_layout,group);
                if( type_layout == 0 )
                    type_layout = 1;
                else
                    type_layout = 0;
            }
        }
        //group C or D. 2 items
        type_layout = 2;
        if( items_count < grid_items_data.length ) {
            int total_group_b = ((grid_items_data.length-items_count)/2);
            if( total_group_b > 0 ) {

                //grid_item_data_groups = new Grid_item_data_group[total_group_b];
                for(int i=0; i<total_group_b; i++ ) {//iterate rows of 3 items each one
                    Object group[] = new Object[2];
                    group[0] = grid_items_data[items_count++];
                    group[1] = grid_items_data[items_count++];
                    grid_item_data_groups[grid_item_data_group_count++] = new Grid_item_data_group(type_layout,group);
                    if( type_layout == 2 )
                        type_layout = 3;
                    else
                        type_layout = 2;
                }
            }
        }*/

    }

    public void tab_edit_content(String title) {
        tab_title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Set Layout to this tab
        View view = inflater.inflate(R.layout.tab_2,container,false);
        //set gridview to the layout Tab
        grid_view = (GridView) view.findViewById(R.id.gridview);
        //set data to the gridView
        grid_view.setAdapter(new Grid_adapter(view.getContext()));

        return view;
    }


    private void iterchange_items_data() {
        /*
        //item dragged
        ViewHolder item_dragged_vh_data;
        item_dragged_vh_data = (ViewHolder) item_vh_dragged.getTag();
        Grid_item_data_source item_dragged_data = (Grid_item_data_source) grid_items_data[item_dragged_vh_data.item_position];

        //item dropped
        ViewHolder item_dropped_vh_data;
        item_dropped_vh_data = (ViewHolder) item_vh_dropped.getTag();
        Grid_item_data_source item_dropped_data = (Grid_item_data_source) grid_items_data[item_dropped_vh_data.item_position];

        //set Dragged title into Dropped title
        ( (TextView) grid_view.getChildAt(item_dropped_data.item_index).findViewById(R.id.grid_text) ).setText(item_dragged_data.item_title);
        ( (ImageView) grid_view.getChildAt(item_dropped_data.item_index).findViewById(R.id.grid_image) ).setImageResource(item_dragged_data.item_image);
        //set Dropped title into Dragged title
        ( (TextView) grid_view.getChildAt(item_dragged_data.item_index).findViewById(R.id.grid_text) ).setText(item_dropped_data.item_title);
        ( (ImageView) grid_view.getChildAt(item_dragged_data.item_index).findViewById(R.id.grid_image) ).setImageResource(item_dropped_data.item_image);

        //change data from the items
        Log.i("grid_items_data antes","-----");
        print_grid_items_data();

        //dragged data = dropped data
        String dragged_title = item_dragged_data.item_title;
        Integer dragged_image = item_dragged_data.item_image;

        ((Grid_item_data_source) grid_items_data[item_dragged_vh_data.item_position]).item_title = item_dropped_data.item_title;
        ((Grid_item_data_source) grid_items_data[item_dragged_vh_data.item_position]).item_image = item_dropped_data.item_image;

        //dropped data = dragged data
        ((Grid_item_data_source) grid_items_data[item_dropped_vh_data.item_position]).item_title = dragged_title;
        ((Grid_item_data_source) grid_items_data[item_dropped_vh_data.item_position]).item_image = dragged_image;

        Log.i("grid_items_data despues","-----");
        print_grid_items_data();
        //set visible view item
        */


    }


    static class ViewHolder {
        int item_position_parent;
        int item_position;

        public ViewHolder(int item_position_parent, int item_position) {
            this.item_position_parent = item_position_parent;
            this.item_position = item_position;
        }
    }


    private class Grid_adapter extends BaseAdapter {

        private Context mContext; //current context
        private View item_vh_dragged;//current item dragging
        private View item_vh_dropped;//current item dropping
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


        public Grid_adapter(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {
            return grid_item_data_groups.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Creates a new drag event listener
            View layout_grid = null;
            Grid_item_data_group item_group = null;
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (convertView == null) {
                //just creating the view if not already present

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

            } else {
                //re-using if already here

                layout_grid = convertView;
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
            }

            return layout_grid;
        }

        private View grid_layout_a_inflate(View layout_grid, LayoutInflater inflater, Grid_item_data_group item_group, int position) {
            //for Layout grid_type_a.xml
            //set layout for the item
            layout_grid = inflater.inflate(grid_layouts[item_group.grid_layout], null);
            //get data from data source array
            Grid_item_data_source item_data_a = ((Grid_item_data_source) item_group.group_items[0]);
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
            //get data from data source array
            Grid_item_data_source item_data_a = ((Grid_item_data_source) item_group.group_items[0]);
            //get child elements
            ViewGroup group_container = ((ViewGroup) layout_grid.findViewById(grid_layout_containers[item_group.grid_layout]));
            RelativeLayout item_aa = (RelativeLayout) group_container.getChildAt(0);
            //set data to items
            ((ImageView) ((ViewGroup) item_aa).getChildAt(0)).setImageResource(item_data_a.item_image);
            //item click
            item_aa.setOnLongClickListener(new Item_long_click_listener());
            //DnD listener
            item_aa.setOnDragListener(new DragNDropListener());

            return layout_grid;
        }

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

        //Start DragNDrop listener
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
        //End DragNDrop listener


    }
    /* End GridView Adapter */

}
