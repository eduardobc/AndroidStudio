package g4a.quadratin.mx.quadratin;

import android.util.Log;

/**
 * Created by eduardo on 4/21/15.
 */
public class QuadratinMainDataGridGroupItems {
    int grid_layout;//number of items
    Object[] group_items;

    public QuadratinMainDataGridGroupItems(int grid_layout, Object[] group_items){
        this.grid_layout = grid_layout;
        this.group_items = group_items;
    }

    public void Grid_item_data_group_print() {

        for( int i=0; i<group_items.length; i++ ) {
            QuadratinMainDataGridItem item = ((QuadratinMainDataGridItem) group_items[i]);
            Log.i("QuadratinMainDataGridGroupItems",item.item_category_title);
        }
    }
}
