package g4a.apptest_e;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        app_custom_toolbar();

        ((Button)findViewById(R.id.app_btn_start)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ((EditText)findViewById(R.id.app_txt_user)).getText().toString();
                String userpass = ((EditText)findViewById(R.id.app_txt_pass)).getText().toString();

                if( username.equals("admin") && userpass.equals("admin") ) {
                    /*start new Activity*/
                    Intent app_activity_started = new Intent(MainActivity.this,session_started.class);
                    startActivity(app_activity_started);

                } else {
                    /*Start Toast Message to show in error case*/
                    (Toast.makeText(getApplicationContext(), "Error!",Toast.LENGTH_LONG)).show();
                }
            }
        });
    }

    public void app_custom_toolbar(){
        Toolbar app_toolbar = (Toolbar) findViewById(R.id.activity_custom_toobar);
        app_toolbar.setTitle("G4A - Quadratin");
        setSupportActionBar(app_toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
