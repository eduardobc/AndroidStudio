package g4a.quadratin.mx.quadratin;

/**
 * Created by eduardo on 4/9/15.
 */
public class QuadratinMainMenuDataDrawerItem {
    private String name;
    private int iconId;
    private int TYPE_HEADER = 0;

    public QuadratinMainMenuDataDrawerItem(String name, int iconId, int type) {
        this.name = name;
        this.iconId = iconId;
        this.TYPE_HEADER = type;
    }

    public QuadratinMainMenuDataDrawerItem(int iconId) {
        this.iconId = iconId;
    }

    public String getName() {
        return name;
    }

    public int getIconId() {
        return iconId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public int getType() {
        return this.TYPE_HEADER;
    }

}
