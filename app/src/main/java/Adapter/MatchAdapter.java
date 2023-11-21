package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mgetestat.R;

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
                R.layout.match_custom_layout,
                parent,
                false);

        TextView Player1 = view.findViewById(R.id.p1_name);
        TextView Player2 = view.findViewById(R.id.p2_name);
        TextView ScoreP1 = view.findViewById(R.id.p1_score);
        TextView ScoreP2 = view.findViewById(R.id.p2_score);

        return new MatchViewHolder(view, Player1, Player2, ScoreP1, ScoreP2);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        MatchesWithSets match = this.matches.get(position);
        holder.Player1.setText(match.getPlayer1());
        holder.Player2.setText(match.getPlayer2());
        holder.ScoreP1.setText(match.setsToString(1));
        holder.ScoreP2.setText(match.setsToString(2));
    }

    @Override
    public int getItemCount() {
        return this.matches.size();
    }

}
