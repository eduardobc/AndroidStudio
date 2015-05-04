package g4a.quadratin.mx.quadratin;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.widget.ProgressBar;

/**
 * Created by eduardo on 4/7/15.
 */
public class QuadratinSplashScreen extends ActionBarActivity {
    public static final int secconds = 2;
    public static final int milsecconds = secconds*1000;
    private ProgressBar q_sc_progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quadratin_splash_screen);

        q_sc_progressbar = (ProgressBar)findViewById(R.id.q_sc_progressbar);
        quadratin_start_progressbar();
    }


    /* ========== start progressbar ========== */
    public void quadratin_start_progressbar() {
        new CountDownTimer(milsecconds,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //Log.d("onTick", "millisUntilFinished = "+millisUntilFinished);
                q_sc_progressbar.setProgress(set_progress(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                /*
                Intent quadratin_activity_intent_intro = new Intent(QuadratinSplashScreen.this,QuadratinIntro.class);
                startActivity(quadratin_activity_intent_intro);
                finish();
                */
                Intent dreawable_menu_main = new Intent(QuadratinSplashScreen.this,QuadratinMain.class);
                startActivity(dreawable_menu_main);
                finish();

            }
        }.start();
    }

    public int set_progress(long milisecconds) {
        return (int)((milsecconds-milisecconds)/1000);
    }
    /* ========== end progressbar ========== */
}
