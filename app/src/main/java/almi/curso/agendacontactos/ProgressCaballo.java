package almi.curso.agendacontactos;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by android on 05/06/2015.
 */
public class ProgressCaballo extends AsyncTask<Void, Integer, Void> {

    Context contexto;
    TextView porcentaje;
    ProgressBar progreso;
    ImageView caballo;
    TypedArray animacion;

    int posicion = 1;

    // Opcion 1: Horizontal con texto
    public ProgressCaballo(Context c, TextView tv, ProgressBar pb) {
        contexto = c;
        porcentaje = tv;
        progreso = pb;

        caballo = null;
        animacion = null;
    }

    // Opcion 2: Horizontal con imagen
    public ProgressCaballo(Context c, ProgressBar pb, ImageView iv, TypedArray imgs) {
        contexto = c;
        progreso = pb;
        caballo = iv;
        animacion = imgs;

        porcentaje = null;
    }

    @Override
    protected Void doInBackground(Void... params) {
        publishProgress(0, posicion);
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
                posicion = posicion % 8 + 1;
                publishProgress(i + 1, posicion);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        if (porcentaje != null) {
            porcentaje.setText(values[0] + "%"); // Control del TextView
        }
        progreso.setProgress(values[0]); // Control del ProgressBar
        if (values[0] == 70) {
            Toast.makeText(contexto, "Adios", Toast.LENGTH_SHORT).show();
        }
        if (caballo != null) {
            caballo.setImageResource(animacion.getResourceId(values[1], 0)); // Control de la animacion
        }
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        ((NuevoATask) contexto).finish();
    }
}
