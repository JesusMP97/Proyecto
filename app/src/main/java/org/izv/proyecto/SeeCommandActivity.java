package org.izv.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.izv.circularfloatingbutton.FloatingActionButton;
import org.izv.circularfloatingbutton.FloatingActionMenu;
import org.izv.circularfloatingbutton.SubActionButton;
import org.izv.proyecto.model.data.Contenedor;
import org.izv.proyecto.model.data.Factura;
import org.izv.proyecto.view.adapter.SeeCommandAdapter;

public class SeeCommandActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Contenedor contenedor;
    SeeCommandAdapter adapter;
    TextView tvTotalPrice;
    Toolbar toolbar;
    private FloatingActionButton fab;
    private SubActionButton btLogOut, btProfile, btSettings;

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
        recyclerView = findViewById(R.id.rvSCItems);
        tvTotalPrice = findViewById(R.id.tvCommandTotal);
        toolbar = findViewById(R.id.tb);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initAdapter();
        initFabComponents();
    }

    private void initAdapter() {
        adapter = new SeeCommandAdapter(contenedor.getCommandDetailList());
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }

    private void initEvents() {

        float totalPrice = 0f;
        for (int i = 0; i < contenedor.getCommandDetailList().size(); i++) {
            totalPrice += contenedor.getCommandDetailList().get(i).getProduct().getPrecio() * contenedor.getCommandDetailList().get(i).getCommand().getUnidades();
        }
        tvTotalPrice.setText("Total: " + totalPrice + "€");
    }

    private void initFabComponents() {
        ImageView ivFab = new ImageView(this);
        ivFab.setImageDrawable(getDrawable(R.drawable.ic_done_black_36dp));
        ImageView ivLogOut = new ImageView(this);
        ivLogOut.setImageDrawable(getDrawable(R.drawable.ic_exit_to_app_black_24dp));
        ImageView ivProfile = new ImageView(this);
        ivProfile.setImageDrawable(getDrawable(R.drawable.ic_profile_black_24dp));
        ImageView ivSettings = new ImageView(this);
        ivSettings.setImageDrawable(getDrawable(R.drawable.ic_settings_black_24dp));
        fab = new FloatingActionButton.Builder(this)
                .setContentView(ivFab)
                .build();
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        btLogOut = itemBuilder.setContentView(ivLogOut).build();
        btProfile = itemBuilder.setContentView(ivProfile).build();
        btSettings = itemBuilder.setContentView(ivSettings).build();
        new FloatingActionMenu.Builder(this)
                .addSubActionView(btLogOut)
                .addSubActionView(btProfile)
                .addSubActionView(btSettings)
                .attachTo(fab)
                .build();
    }
}
