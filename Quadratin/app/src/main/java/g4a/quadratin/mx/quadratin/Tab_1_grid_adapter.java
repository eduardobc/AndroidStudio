package g4a.quadratin.mx.quadratin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by eduardo on 4/15/15.
 */
public class Tab_1_grid_adapter extends BaseAdapter {
    private Context mContext;
    private Integer[] mThumbIds = {
            R.drawable.quadratin_logo_dark, R.drawable.quadratin_logo_dark,
            R.drawable.quadratin_logo_dark, R.drawable.quadratin_logo_dark,
            R.drawable.quadratin_logo_dark, R.drawable.quadratin_logo_dark,
            R.drawable.quadratin_logo_dark, R.drawable.quadratin_logo_dark,
            R.drawable.quadratin_logo_dark, R.drawable.quadratin_logo_dark,
            R.drawable.quadratin_logo_dark, R.drawable.quadratin_logo_dark,
            R.drawable.quadratin_logo_dark, R.drawable.quadratin_logo_dark,
            R.drawable.quadratin_logo_dark, R.drawable.quadratin_logo_dark,
            R.drawable.quadratin_logo_dark, R.drawable.quadratin_logo_dark,
    };

    public Tab_1_grid_adapter(Context c) {
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
            ((TextView) grid.findViewById(R.id.grid_text)).setText("Titulo");
            ((ImageView) grid.findViewById(R.id.grid_image)).setImageResource(mThumbIds[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }

}


