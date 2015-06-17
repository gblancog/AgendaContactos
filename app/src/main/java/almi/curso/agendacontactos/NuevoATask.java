package almi.curso.agendacontactos;

import android.content.res.TypedArray;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class NuevoATask extends ActionBarActivity {
    public static final int CON_TEXTO = 1;
    public static final int CON_IMAGEN = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_atask);

        TextView tv = (TextView) findViewById(R.id.porcentaje);

        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
        pb.setMax(100);

        TypedArray imgs = getResources().obtainTypedArray(R.array.animacion);
        ImageView iv = (ImageView) findViewById(R.id.imagen);

        ProgressCaballo anima;
        int option = getIntent().getIntExtra("option", 0);

        if (option == CON_TEXTO) {
            anima = new ProgressCaballo(this, tv, pb);
        } else if (option == CON_IMAGEN) {
            anima = new ProgressCaballo(this, pb, iv, imgs);
        } else anima = null; // Imposible

        anima.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nuevo_atask, menu);
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
