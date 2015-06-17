package almi.curso.agendacontactos;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;


public class Users extends ActionBarActivity {

    ProgressBar progreso;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        progreso = (ProgressBar) findViewById(R.id.progessMonigote);
        imagen = (ImageView) findViewById(R.id.imagenMonigote);

        progreso.setMax(100);

        // Inicia animacion frame by frame
        imagen.setBackgroundResource(R.drawable.frame_monigote);
        AnimationDrawable frame = (AnimationDrawable) imagen.getBackground();
        frame.start();

        UsersATask animacion = new UsersATask(this, imagen, progreso);
        animacion.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_users, menu);
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
