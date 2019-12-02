package org.izv.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.izv.proyecto.model.data.Factura;

public class SeeCommandActivity extends AppCompatActivity {

    TextView tvTable;
    Factura factura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_command);

        initComponents();
        initEvents();
    }

    private void initComponents() {
        tvTable = findViewById(R.id.tvTableSeeCommand);

    }

    private void initEvents() {
        //factura = getIntent().getExtras("selectedFactura");
    }
}
