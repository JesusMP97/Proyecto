package org.izv.proyecto.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.izv.proyecto.R;
import org.izv.proyecto.model.data.Comanda;
import org.izv.proyecto.model.data.Contenedor;
import org.izv.proyecto.model.data.Producto;

import java.util.List;

public class SeeCommandAdapter extends RecyclerView.Adapter<SeeCommandAdapter.SeeCommandViewHolder> {

    private List<Contenedor.CommandDetail> comandas;
    View v;

    public SeeCommandAdapter(List<Contenedor.CommandDetail> comandas) {
        this.comandas = comandas;
    }

    @NonNull
    @Override
    public SeeCommandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.seecommand_item, parent, false);
        return new SeeCommandViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SeeCommandViewHolder holder, int position) {
        holder.tvCommandNumber.setText("Comanda " + comandas.get(position).getCommand().getId());
        holder.tvProducto.setText(comandasToString());
    }

    public String comandasToString(){
        String str = "";
        for (int i = 0; i < comandas.size(); i++) {
            str += comandas.get(i).getCommand().getUnidades() + "x " + comandas.get(i).getProduct().getNombre() + "\n";
        }
        return str;
    }

    /*public Producto findProductoById(long idNumber){
        Producto productoError = new Producto(-1, "Error", "Error", "Error", "Error", 0);
        for (int i = 0; i < productos.size(); i++) {
            if(productos.get(i).getId() == idNumber){
                return productos.get(i);
            }
        }

        return productoError;
    }*/

    @Override
    public int getItemCount() {
        return comandas.size();
    }

    class SeeCommandViewHolder extends RecyclerView.ViewHolder {

        TextView tvCommandNumber, tvProducto;

        public SeeCommandViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvCommandNumber = itemView.findViewById(R.id.tvSCNumeroComanda);
            this.tvProducto = itemView.findViewById(R.id.tvSCProductos);
        }

    }
}
