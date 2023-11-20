package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Model.Match;
import Model.storage.MatchesWithSets;

public class MatchAdapter extends RecyclerView.Adapter<MatchViewHolder> {

    private List<MatchesWithSets> matches;
    public MatchAdapter(){ this.matches = new ArrayList<>(); }

    public void updateMatches(List<MatchesWithSets> matches) {
        this.matches = matches;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(
                android.R.layout.simple_list_item_2,
                parent,
                false);

        TextView Player1 = view.findViewById(android.R.id.text1);
        TextView Player2 = view.findViewById(android.R.id.text2);


        return new MatchViewHolder(view, Player1, Player2);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        MatchesWithSets match = this.matches.get(position);
        holder.Player1.setText(match.match.P1);
        holder.Player2.setText(match.match.P2);
    }

    @Override
    public int getItemCount() {
        return this.matches.size();
    }
}
