package com.shirozuo.footbasketsport;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shirozuo.footbasketsport.adapters.GalleryAdapter;
import com.shirozuo.footbasketsport.adapters.PlayersAdapter;
import com.shirozuo.footbasketsport.adapters.RulesAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rules, players, gallery;
    private PlayersAdapter playersAdapter;
    private RulesAdapter rulesAdapter;
    private GalleryAdapter galleryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) throws RuntimeException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rules = findViewById(R.id.rv_rules);
        players = findViewById(R.id.rv_players);
        gallery = findViewById(R.id.rv_gallery);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);

        rules.setLayoutManager(linearLayoutManager);
        players.setLayoutManager(linearLayoutManager2);
        gallery.setLayoutManager(linearLayoutManager3);

        players.setHasFixedSize(true);
        rules.setHasFixedSize(true);
        gallery.setHasFixedSize(true);

        if (HomeActivity.isFootball()) {
            playersAdapter = new PlayersAdapter(10, R.array.football_players, R.array.football_players_image);
            rulesAdapter = new RulesAdapter(12, R.array.football_rules);
            galleryAdapter = new GalleryAdapter(10, R.array.football_image);
        } else {
            playersAdapter = new PlayersAdapter(10, R.array.basketball_players, R.array.basketball_players_image);
            rulesAdapter = new RulesAdapter(12, R.array.basketball_rules);
            galleryAdapter = new GalleryAdapter(10, R.array.basketball_image);
        }

        players.setAdapter(playersAdapter);
        rules.setAdapter(rulesAdapter);
        gallery.setAdapter(galleryAdapter);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_rules:
                    rules.setVisibility(View.VISIBLE);
                    players.setVisibility(View.GONE);
                    gallery.setVisibility(View.GONE);
                    break;
                case R.id.action_peoples:
                    rules.setVisibility(View.GONE);
                    players.setVisibility(View.VISIBLE);
                    gallery.setVisibility(View.GONE);
                    break;
                case R.id.action_gallery:
                    rules.setVisibility(View.GONE);
                    players.setVisibility(View.GONE);
                    gallery.setVisibility(View.VISIBLE);
            }
            return true;
        });
    }
}