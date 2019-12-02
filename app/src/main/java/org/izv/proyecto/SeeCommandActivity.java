package org.izv.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.izv.proyecto.model.data.Contenedor;
import org.izv.proyecto.model.data.Factura;
import org.izv.proyecto.view.adapter.SeeCommandAdapter;

public class SeeCommandActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Contenedor contenedor;
    SeeCommandAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_command);

        Intent intent = this.getIntent();
        contenedor = (Contenedor) intent.getSerializableExtra("contenedor");

        initComponents();
        initEvents();
    }

    private void initComponents() {
        recyclerView = findViewById(R.id.rvSeeCommand);
        initAdapter();
    }

    private void initAdapter() {
        adapter = new SeeCommandAdapter(contenedor.getCommandDetailList());
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }

    private void initEvents() {
        String nombre = contenedor.getCommandDetail().get(0).getProduct().getNombre();
    }
}
