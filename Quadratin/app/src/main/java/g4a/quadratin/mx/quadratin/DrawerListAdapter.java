package g4a.quadratin.mx.quadratin;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by eduardo on 4/9/15.
 */
public class DrawerListAdapter extends ArrayAdapter {

    public DrawerListAdapter(Context context, List objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*if( convertView == null ) {
            Log.d("MENU","NULLL"+position);
        } else {
            Log.d("MENU","No - NULLL"+position);
        }*/

        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        DrawerItem item = (DrawerItem) getItem(position);


            if (item.getType() == 0) {

                convertView = inflater.inflate(R.layout.test_drawable_listview, null);
                ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
                TextView name = (TextView) convertView.findViewById(R.id.name);

                icon.setImageResource(item.getIconId());
                name.setText(item.getName());

            } else {
                //type header
                convertView = inflater.inflate(R.layout.header, null);
                ImageView icon = (ImageView) convertView.findViewById(R.id.icon);

                icon.setImageResource(item.getIconId());

            }


        return convertView;
    }

}
