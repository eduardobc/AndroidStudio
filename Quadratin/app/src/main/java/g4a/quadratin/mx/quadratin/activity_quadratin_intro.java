package g4a.quadratin.mx.quadratin;



import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;


public class activity_quadratin_intro extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratin_intro);

        //set custom toolbar
        quadratin_custom_toolbar();

    }
    /* ========== start custom action bars ========== */
    /*quadratin custom toolbar*/
    public void quadratin_custom_toolbar() {
        Toolbar quadratin_custom_toolbar = (Toolbar)findViewById(R.id.quadratin_custom_toobar_intro);
        quadratin_custom_toolbar.setTitle("");
        setSupportActionBar(quadratin_custom_toolbar);
    }
    /* ========== start custom action bars ========== */

}
