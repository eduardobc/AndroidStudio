package g4a.quadratin.mx.quadratin;

/**
 * Created by eduardo on 4/17/15.
 */
public class Grid_item_data_source {
    int item_position_parent;
    int item_position;
    String item_category_title;
    String item_post_title;
    Integer item_image;
    String item_date;
    String item_total_posts;

    public Grid_item_data_source(int item_position_parent, int item_position, String item_category_title, Integer item_image) {
        this.item_position_parent = item_position_parent;
        this.item_position = item_position;
        this.item_category_title = item_category_title;
        this.item_image = item_image;
        this.item_post_title = "The post title";
        this.item_date = "09:35";
        this.item_total_posts = "+99";
    }
}
