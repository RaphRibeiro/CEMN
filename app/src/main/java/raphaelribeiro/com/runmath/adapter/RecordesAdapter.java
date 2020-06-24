package raphaelribeiro.com.runmath.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import raphaelribeiro.com.runmath.R;
import raphaelribeiro.com.runmath.RecordesActivity;
import raphaelribeiro.com.runmath.modelo.Recordes;

public class RecordesAdapter extends BaseAdapter {
    private final List<Recordes> recordes;
    private final Context context;

    public RecordesAdapter(Context context, List<Recordes> recordes) {
        this.context = context;
        this.recordes = recordes;
    }

    @Override
    public int getCount() {
        return recordes.size();
    }

    @Override
    public Object getItem(int position) {
        return recordes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return recordes.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Recordes recorde = recordes.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);


        View view = convertView;
        if (view == null){
            view = inflater.inflate(R.layout.list_item,parent, false);
        }

        TextView campoNome = (TextView) view.findViewById(R.id.item_nome);
        campoNome.setText(recorde.getNome());

        TextView campoPlacar = (TextView) view.findViewById(R.id.item_pontos);
        campoPlacar.setText(": "+recorde.getPontos()+" Pontos");

//        TextView campoPonto = (TextView) view.findViewById(R.id.item_pontos);
//        campoPonto.setText(recorde.getPontos());
        return view;
    }
}
