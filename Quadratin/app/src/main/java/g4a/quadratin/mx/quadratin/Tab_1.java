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
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by eduardo on 4/8/15.
 */
public class Tab_1 extends Fragment {
    /* start Tab data */
    private String tab_title = "-";
    /* end Tab data */

    /* start gridview */
    private GridView grid_view;
    private Object[] grid_items_data = new Object[] {
            new Grid_item_data_source("Cat 0",R.drawable.quadratin_logo_dark,0),
            new Grid_item_data_source("Cat 1",R.mipmap.q_ic_launcher,0),
            new Grid_item_data_source("Cat 2",R.drawable.quadratin_logo_dark,0),
            new Grid_item_data_source("Cat 3",R.mipmap.q_ic_launcher,0),
    };
    /* end gridview */

    /* start DnD */
    private View item_vh_dragged;
    private View item_vh_dropped;
    /* end DnD */


    public Tab_1(Object[] data_source) {
        grid_items_data = data_source;
    }

    public void tab_edit_content(String title) {
        tab_title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Set Layout to this tab
        View view = inflater.inflate(R.layout.tab_1,container,false);
        //set gridview to the layout Tab
        grid_view = (GridView) view.findViewById(R.id.gridview);
        //set data to the gridView
        grid_view.setAdapter(new Grid_adapter(view.getContext()));

        //events for each items of gridView
        //grid_view.setOnItemClickListener(new Click_listener());
        //grid_view.setOnItemLongClickListener(new Long_click_listener());

        return view;
    }



    //lick listener
    private final class Click_listener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(view.getContext(),"Click - "+position,Toast.LENGTH_SHORT).show();
        }
    }

    //long click listener
    private final class Long_click_listener implements AdapterView.OnItemLongClickListener {

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

            item_vh_dragged = view;
            ClipData data = ClipData.newPlainText("clip_data",""+position);
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            // start dragging the item touched
            view.startDrag(data, shadowBuilder, view, 0);
            item_vh_dragged.setVisibility(View.INVISIBLE);
            return false;
        }
    }

    //DragNDrop listener
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
                    iterchange_items_data();

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
                    //Log.i("DragDrop Example","Unknown action type received by OnDragListener.");
                break;
            }
            return false;
        }
    }

    private void print_grid_items_data() {

        for(int i=0; i<grid_items_data.length; i++ ) {
            Log.i("item", "i="+i+" = "+((Grid_item_data_source)grid_items_data[i]).item_title);
        }
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
        item_vh_dragged.setVisibility(View.VISIBLE);

    }


    /* Start GridView Adapter */
    /*static class Grid_item_data_source {
        String item_title;
        Integer item_image;
        int item_index;

        public Grid_item_data_source(String item_title, Integer item_image,int item_index) {
            this.item_title = item_title;
            this.item_image = item_image;
            this.item_index = item_index;
        }
    }*/
    static class ViewHolder {
        int item_position;
        int item_sub_position;

        public ViewHolder(int item_position, int item_sub_position) {
            this.item_position = item_position;
            this.item_sub_position = item_sub_position;
        }
    }


    private class Grid_adapter extends BaseAdapter {
        private Context mContext;


        public Grid_adapter(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {
            return grid_items_data.length;
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
            View grid;
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if( convertView == null ) {
                //set layout for the item
                grid = inflater.inflate(R.layout.tab_1_grid_adapter_layout, null);

                //set item data from grid_items_data
                //((Grid_item_data_source) grid_items_data[position]).item_index = position;
                //((TextView) grid.findViewById(R.id.grid_text)).setText( ((Grid_item_data_source) grid_items_data[position]).item_title );
                //((ImageView) grid.findViewById(R.id.grid_image)).setImageResource( ((Grid_item_data_source) grid_items_data[position]).item_image );


                //get child elements
                RelativeLayout item_a = (RelativeLayout) grid.findViewById(R.id.grid_a_item);
                RelativeLayout item_b = (RelativeLayout) grid.findViewById(R.id.grid_b_item);
                RelativeLayout item_c = (RelativeLayout) grid.findViewById(R.id.grid_c_item);
                //set Tag data
                ViewHolder vh_a = new ViewHolder(position,1);
                ViewHolder vh_b = new ViewHolder(position,2);
                ViewHolder vh_c = new ViewHolder(position,3);
                item_a.setTag(vh_a);
                item_b.setTag(vh_b);
                item_b.setTag(vh_c);


                //item click
                item_a.setOnLongClickListener(new Item_long_click_listener());
                item_b.setOnLongClickListener(new Item_long_click_listener());
                item_c.setOnLongClickListener(new Item_long_click_listener());





                //DnD listener
                item_a.setOnDragListener(new DragNDropListener());
                item_b.setOnDragListener(new DragNDropListener());
                item_c.setOnDragListener(new DragNDropListener());



                //set data tag for the item
                //ViewHolder vh = new ViewHolder(position);
                //grid.setTag(vh);

                //DnD Listener
                //grid.setOnDragListener(new DragNDropListener());
            } else {
                grid = (View) convertView;
            }
            return grid;
        }



        private final class Item_long_click_listener implements View.OnLongClickListener {

            @Override
            public boolean onLongClick(View view) {
                item_vh_dragged = view;
                ClipData data = ClipData.newPlainText("clip_data","A-1");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                // start dragging the item touched
                view.startDrag(data, shadowBuilder, view, 0);
                item_vh_dragged.setVisibility(View.INVISIBLE);

                return false;
            }
        }
    }
    /* End GridView Adapter */




}
