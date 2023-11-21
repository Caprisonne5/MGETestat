package Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MatchViewHolder extends RecyclerView.ViewHolder {
    public TextView Player1;
    public TextView Player2;
    public TextView ScoreP1;
    public TextView ScoreP2;

    public MatchViewHolder(View parent, TextView Player1, TextView Player2, TextView ScoreP1, TextView ScoreP2) {
        super(parent);
        this.Player1 = Player1;
        this.Player2 = Player2;
        this.ScoreP1 = ScoreP1;
        this.ScoreP2 = ScoreP2;
    }
}
