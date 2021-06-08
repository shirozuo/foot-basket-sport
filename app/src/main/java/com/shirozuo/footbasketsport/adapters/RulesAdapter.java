package com.shirozuo.footbasketsport.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.shirozuo.footbasketsport.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RulesAdapter extends RecyclerView.Adapter<RulesAdapter.RuleViewHolder>{

    private final int ruleItems;
    private List<String> rules = new ArrayList<>();
    private final int typeOfRules;


    public RulesAdapter(int ruleItems, int typeOfRules) {
        this.ruleItems = ruleItems;
        this.typeOfRules = typeOfRules;
    }

    @NonNull
    @Override
    public RuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_rules, parent, false);

        rules = Arrays.asList(parent.getContext().getResources().getStringArray(typeOfRules));

        return new RuleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RuleViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return ruleItems;
    }

    class RuleViewHolder extends RecyclerView.ViewHolder {

        TextView tvIndexOfRule;
        TextView tvTextOfRule;

        public RuleViewHolder(@NonNull View itemView) {
            super(itemView);

            tvIndexOfRule = itemView.findViewById(R.id.tv_rule_item);
            tvTextOfRule = itemView.findViewById(R.id.tv_view_holder_rule);
        }
        void bind(int position){
            tvIndexOfRule.setText(String.valueOf(position + 1));
            tvTextOfRule.setText(rules.get(position));
        }
    }
}
