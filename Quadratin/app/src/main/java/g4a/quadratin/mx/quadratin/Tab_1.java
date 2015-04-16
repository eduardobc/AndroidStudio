package g4a.quadratin.mx.quadratin;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
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
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by eduardo on 4/8/15.
 */
public class Tab_1 extends Fragment {

    private String tab_title = "-";

    /*start gridview*/
    private GridView grid_view;

    /*end gridview*/

    /*start DnD*/
    private View item_vh_dragged;
    private View item_vh_dropped;
    /*end DnD*/

    public void tab_edit_content(String title) {
        tab_title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_1,container,false);

        grid_view = (GridView) view.findViewById(R.id.gridview);
        grid_view.setAdapter(new Grid_adapter(view.getContext()));

        //events
        grid_view.setOnItemClickListener(new Click_listener());
        grid_view.setOnItemLongClickListener(new Long_click_listener());

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
            //Toast.makeText(view.getContext(),"Long Click - "+position,Toast.LENGTH_SHORT).show();

            item_vh_dragged = view;
            ClipData data = ClipData.newPlainText("clip_data",""+position);
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            // start dragging the item touched
            view.startDrag(data, shadowBuilder, view, 0);

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
                        Log.i("DRAG Started", "ACTION_DRAG_STARTED");
                        return true;
                    }
                    return false;
                case DragEvent.ACTION_DRAG_ENTERED:
                    //item it is dropper
                    v.setBackgroundColor(Color.GREEN);
                    v.invalidate();
                    return true;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.i("DRAG Exited", "ACTION_DRAG_EXITED");
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
                    Log.i("DRAG Dropped", "ACTION_DROP Item Tag DROP");

                    print_items();


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
                        Log.i("DRAG Ended", "The drop was handled.");
                    } else {
                        Log.i("DRAG Ended", "The drop didn't work.");
                    }
                    return true;
                // An unknown action type was received.
                default:
                    Log.i("DragDrop Example","Unknown action type received by OnDragListener.");
                break;

            }
            return false;
        }
    }

    private void print_items() {
        ViewHolder item_vh_dragged_data = new ViewHolder();
        item_vh_dragged_data = (ViewHolder) item_vh_dragged.getTag();

        ((ImageView) item_vh_dropped.findViewById(R.id.grid_image)).setImageResource(item_vh_dragged_data.ivImage);
        Log.i("DnD", "DnD Tags DROP = "+item_vh_dropped+" DRAG = "+item_vh_dragged);
    }

    //Grid Adapter
    private class Grid_adapter extends BaseAdapter {
        private Context mContext;
        private Integer[] mThumbIds = {
                R.drawable.quadratin_logo_dark, R.mipmap.q_ic_launcher,
                R.drawable.quadratin_logo_dark, R.mipmap.q_ic_launcher,
                R.drawable.quadratin_logo_dark, R.mipmap.q_ic_launcher,
                R.drawable.quadratin_logo_dark, R.mipmap.q_ic_launcher,
                R.drawable.quadratin_logo_dark, R.mipmap.q_ic_launcher,
                R.drawable.quadratin_logo_dark, R.mipmap.q_ic_launcher,
                R.drawable.quadratin_logo_dark, R.mipmap.q_ic_launcher,
                R.drawable.quadratin_logo_dark, R.mipmap.q_ic_launcher,
                R.drawable.quadratin_logo_dark, R.mipmap.q_ic_launcher,
        };

        public Grid_adapter(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {
            return mThumbIds.length;
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


                grid = new View(mContext);
                grid = inflater.inflate(R.layout.tab_1_grid_adapter_layout, null);
                ((TextView) grid.findViewById(R.id.grid_text)).setText("P="+position);
                ((ImageView) grid.findViewById(R.id.grid_image)).setImageResource(mThumbIds[position]);

                //data tag
                ViewHolder vh = new ViewHolder();
                vh.tvTitle = "P="+position;
                vh.ivImage = R.id.grid_image;
                grid.setTag(vh);

                //DnD Listener
                grid.setOnDragListener(new DragNDropListener());
            } else {
                grid = (View) convertView;

            }

            return grid;
        }

    }

    static class ViewHolder {
        String tvTitle;
        int ivImage;
    }

}
