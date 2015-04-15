package g4a.quadratin.mx.quadratin;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
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

    public void tab_edit_content(String title) {
        tab_title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_1,container,false);

        grid_view = (GridView) view.findViewById(R.id.gridview);
        grid_view.setAdapter(new Tab_1_grid_adapter(view.getContext()));

        //events
        //grid_view.setOnItemClickListener(new Click_listener());
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


            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            // start dragging the item touched
            view.startDrag(data, shadowBuilder, view, 0);

            //view.setOnDragListener(new DragNDropListener());


            return false;
        }
    }

    //DragNDrop listener
    private class DragNDropListener implements AdapterView.OnDragListener {
        @Override
        public boolean onDrag(View v, DragEvent event) {

            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    Log.i("DRAG Started", "ACTION_DRAG_STARTED");
                    Toast.makeText(v.getContext(),"ACTION_DRAG_STARTED",Toast.LENGTH_SHORT).show();
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.i("DRAG Entered", "ACTION_DRAG_ENTERED" );

                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.i("DRAG Exited", "ACTION_DRAG_EXITED");

                    break;
                case DragEvent.ACTION_DROP:
                    Log.i("DRAG Dropped", "ACTION_DROP");
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    Log.i("DRAG Ended", "ACTION_DRAG_ENDED");
                    Toast.makeText(v.getContext(),"ACTION_DRAG_ENDED",Toast.LENGTH_SHORT).show();
                default:
                    break;
            }
            return true;
        }
    }

}
