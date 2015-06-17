package almi.curso.agendacontactos;

import android.content.Context;
import android.os.AsyncTask;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

/**
 * Created by android on 16/06/2015.
 */
public class UsersATask extends AsyncTask<Void, Integer, Void> {

    Context contexto;
    ProgressBar progreso;
    ImageView imagen;

    public UsersATask(Context c, ImageView iv, ProgressBar pb) {
        contexto = c;
        progreso = pb;
        imagen = iv;
    }

    @Override
    protected Void doInBackground(Void... params) {
        publishProgress(0);
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
                publishProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        progreso.setProgress(values[0]);
        switch (values[0]) {
            case 20:
                Animation animacion1 = AnimationUtils.loadAnimation(contexto, R.anim.movimiento1);
                imagen.startAnimation(animacion1);
                break;
            case 60:
                Animation animacion2 = AnimationUtils.loadAnimation(contexto, R.anim.movimiento2);
                imagen.startAnimation(animacion2);
                break;
            case 90:
                Animation animacion3 = AnimationUtils.loadAnimation(contexto, R.anim.movimiento3);
                imagen.startAnimation(animacion3);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        ((Users)contexto).finish();
    }
}
