package g4a.quadratin.mx.quadratin;

/**
 * Created by eduardo on 4/17/15.
 */
public class Grid_item_data_source {
    int item_position_parent;
    int item_position;
    String item_title;
    Integer item_image;

    public Grid_item_data_source(int item_position_parent, int item_position, String item_title, Integer item_image) {
        this.item_position_parent = item_position_parent;
        this.item_position = item_position;
        this.item_title = item_title;
        this.item_image = item_image;
    }
}
