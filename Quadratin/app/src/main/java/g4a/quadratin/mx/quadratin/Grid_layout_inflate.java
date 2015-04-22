package g4a.quadratin.mx.quadratin;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by eduardo on 4/22/15. NOT USED
 */
public class Grid_layout_inflate {

    private View item_vh_dragged;
    private View item_vh_dropped;

    private Integer grid_layouts[] = new Integer[]{
            R.layout.grid_type_a,
            R.layout.grid_type_b,
            R.layout.grid_type_c,
            R.layout.grid_type_d,
            R.layout.grid_type_e,
    };
    private Integer grid_layout_containers[] = new Integer[]{
            R.id.grid_container_a,
            R.id.grid_container_b,
            R.id.grid_container_c,
            R.id.grid_container_d,
            R.id.grid_container_e,
    };

    public Grid_layout_inflate() {

    }



    public View grid_layout_a_inflate(View layout_grid, LayoutInflater inflater, Grid_item_data_group item_group, int position) {
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

    public View grid_layout_b_inflate(View layout_grid, LayoutInflater inflater, Grid_item_data_group item_group, int position) {
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

    public View grid_layout_c_inflate(View layout_grid, LayoutInflater inflater, Grid_item_data_group item_group, int position) {
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

    public View grid_layout_d_inflate(View layout_grid, LayoutInflater inflater, Grid_item_data_group item_group, int position) {
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

    public View grid_layout_e_inflate(View layout_grid, LayoutInflater inflater, Grid_item_data_group item_group, int position) {
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
        public boolean onDrag(View v, DragEvent event) {

            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    //String title = (String)((TextView) v.findViewById(R.id.grid_text)).getText();
                    //Log.i("DRAG Started", "ACTION_DRAG_STARTED = "+title);
                    if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                        v.setBackgroundColor(Color.WHITE);
                        v.invalidate();
                        //dragged element
                        //Log.i("DRAG Started", "ACTION_DRAG_STARTED");
                        return true;
                    }
                    return false;
                case DragEvent.ACTION_DRAG_ENTERED:
                    //item it is dropper
                    v.setBackgroundColor(Color.GREEN);
                    v.invalidate();
                    return true;
                case DragEvent.ACTION_DRAG_EXITED:
                    //Log.i("DRAG Exited", "ACTION_DRAG_EXITED");
                    v.setBackgroundColor(Color.WHITE);
                    v.invalidate();
                    return true;
                case DragEvent.ACTION_DROP:

                    // Gets the item containing the dragged data
                    ClipData.Item item = event.getClipData().getItemAt(0);
                    // Gets the text data from the item.
                    String clip_data = (String) item.getText();

                    //droppped item
                    item_vh_dropped = v;
                    //Log.i("DRAG Dropped", "ACTION_DROP Item Tag DROP");
                    //iterchange_items_data();

                    // Turns off any color tints
                    v.setBackgroundColor(Color.BLUE);
                    // Invalidates the view to force a redraw
                    v.invalidate();

                    // Returns true. DragEvent.getResult() will return true.
                    return true;
                case DragEvent.ACTION_DRAG_ENDED:
                    v.setBackgroundColor(Color.WHITE);
                    v.invalidate();
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
