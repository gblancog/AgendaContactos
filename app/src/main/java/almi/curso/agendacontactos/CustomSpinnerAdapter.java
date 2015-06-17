package almi.curso.agendacontactos;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by android on 11/06/2015.
 */
public class CustomSpinnerAdapter extends ArrayAdapter<Object> {

    Context contexto;
    String[] lista;
    TypedArray imagenes;


    public CustomSpinnerAdapter(Context c, int resource, String[] datos, TypedArray imgs) {
        super(c, resource, datos);
        contexto = c;
        lista = datos;
        imagenes = imgs;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    // Esta vista es la que vamos a cambiar
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li = ((Activity)this.contexto).getLayoutInflater();
        View fila = li.inflate(R.layout.horse_spinner, parent, false);
        TextView txt = (TextView) fila.findViewById(R.id.cTexto);
        ImageView im1 = (ImageView) fila.findViewById(R.id.cImagen1);
        ImageView im2 = (ImageView) fila.findViewById(R.id.cImagen2);

        txt.setText(lista[position]);
        im1.setImageResource(imagenes.getResourceId(position, 0));
        im2.setImageResource(imagenes.getResourceId(position, 0));

        return fila;
    }


}
