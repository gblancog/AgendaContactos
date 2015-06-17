package almi.curso.agendacontactos;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.AsyncTask;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

/**
 * Created by android on 17/06/2015.
 */
public class SaveATask extends AsyncTask<Void, Integer, Void> {

    Context contexto;
    ProgressBar progreso;
    ImageView imagen;

    public SaveATask(Context c, ImageView iv, ProgressBar pb) {
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
                AnimatorSet anim1 = (AnimatorSet) AnimatorInflater.loadAnimator(contexto, R.animator.animacion1);
                anim1.setTarget(imagen);
                anim1.start();
                break;
            case 60:
                AnimatorSet anim2 = (AnimatorSet) AnimatorInflater.loadAnimator(contexto, R.animator.animacion2);
                anim2.setTarget(imagen);
                anim2.start();
                break;
            case 90:
                AnimatorSet anim3 = (AnimatorSet) AnimatorInflater.loadAnimator(contexto, R.animator.animacion3);
                anim3.setTarget(imagen);
                anim3.start();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        ((Save)contexto).finish();
    }
}
