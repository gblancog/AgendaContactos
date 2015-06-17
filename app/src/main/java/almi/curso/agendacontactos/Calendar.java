package almi.curso.agendacontactos;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Calendar extends ActionBarActivity {

    private Spinner sp;
    private String[] datos;
    private TypedArray imagenes;
    private boolean ver = false;

    private ImageView caballo;
    private TextView texto;

    // Toast
    private LayoutInflater li;
    private View pantalla;
    private Toast toasty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        // Para coger los datos de los arrays
        Resources recursos = getResources();
        datos = recursos.getStringArray(R.array.caballos);
        imagenes = recursos.obtainTypedArray(R.array.animacion);

        // Instanciar el spinner
        sp = (Spinner) findViewById(R.id.spCaballo);

        // Asignamos el adaptador
        sp.setAdapter(new CustomSpinnerAdapter(this, R.layout.horse_spinner, datos, imagenes));

        // Toast personalizados
        toasty = new Toast(this);
        li = getLayoutInflater(); // inflador
        pantalla = li.inflate(R.layout.horse_spinner, (ViewGroup) findViewById(R.id.linearHorse));

        // Enlazar elementos del diseño con elementos en el codigo
        caballo = (ImageView) findViewById(R.id.imgCaballo);

        // Animacion frame by frame
        caballo.setBackgroundResource(R.drawable.frame);
        AnimationDrawable frameByFrame = (AnimationDrawable) caballo.getBackground();
        frameByFrame.start();

        // Spinner item selected listener
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Declaramos la variable vista para cargar nuestro XML
                texto = (TextView) pantalla.findViewById(R.id.cTexto);
                texto.setText(datos[position]);

                caballo = (ImageView) pantalla.findViewById(R.id.cImagen1);
                caballo.setImageResource(imagenes.getResourceId(position, -1));
                caballo = (ImageView) pantalla.findViewById(R.id.cImagen2);
                caballo.setImageResource(imagenes.getResourceId(position, -1));

                //caballo = (ImageView) findViewById(R.id.imgCaballo);
               // caballo.setImageResource(imagenes.getResourceId(position, -1));

                // La primera vez no saldra toast
                if(ver) {
                    toasty.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toasty.setView(pantalla);
                    toasty.show();
                } else ver = !ver;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // ImageView on click listener
        caballo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calendar, menu);
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
