package com.shirozuo.footbasketsport.adapters;

import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.shirozuo.footbasketsport.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder> {

    private final int playerItems;
    private List<String> playersName = new ArrayList<>();
    private TypedArray playersImage;
    private final int typeOfPlayersName;
    private final int typeOfPlayersImage;


    public PlayersAdapter(int playerItems, int typeOfPlayersName, int typeOfPlayersImage) {
        this.playerItems = playerItems;
        this.typeOfPlayersName = typeOfPlayersName;
        this.typeOfPlayersImage = typeOfPlayersImage;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_players, parent, false);

        playersName = Arrays.asList(parent.getContext().getResources().getStringArray(typeOfPlayersName));
        playersImage = parent.getContext().getResources().obtainTypedArray(typeOfPlayersImage);

        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return playerItems;
    }

    class PlayerViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPlayerImage;
        TextView tvPlayerName;


        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);

            ivPlayerImage = itemView.findViewById(R.id.iv_player_item);
            tvPlayerName = itemView.findViewById(R.id.tv_view_holder_player);
        }
        void bind(int position){
            ivPlayerImage.setImageResource(playersImage.getResourceId(position, -1));
            tvPlayerName.setText(playersName.get(position));
        }
    }
}
