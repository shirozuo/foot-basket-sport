package com.shirozuo.footbasketsport;

import android.content.res.TypedArray;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgGallery;
    private RecyclerView rules, players, gallery;
    private RulesAdapter rulesAdapter;
    private PlayersAdapter playersAdapter;
    private String typeOfRules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rules = findViewById(R.id.rv_rules);
        players = findViewById(R.id.rv_players);
        imgGallery = findViewById(R.id.icon_gallery);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        rules.setLayoutManager(linearLayoutManager);
        players.setLayoutManager(linearLayoutManager2);

        playersAdapter = new PlayersAdapter(10, R.array.basketball_players, R.array.basketball_players_image);
        players.setAdapter(playersAdapter);
        rulesAdapter = new RulesAdapter(12, R.array.basketball_rules);
        rules.setAdapter(rulesAdapter);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_rules:
                    rules.setVisibility(View.VISIBLE);
                    players.setVisibility(View.GONE);
                    imgGallery.setVisibility(View.GONE);
                    break;
                case R.id.action_peoples:
                    rules.setVisibility(View.GONE);
                    players.setVisibility(View.VISIBLE);
                    imgGallery.setVisibility(View.GONE);
                    break;
                case R.id.action_gallery:
                    rules.setVisibility(View.GONE);
                    players.setVisibility(View.GONE);
                    imgGallery.setVisibility(View.VISIBLE);
            }
            return true;
        });
    }
}