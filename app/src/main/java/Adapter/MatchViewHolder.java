package Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MatchViewHolder extends RecyclerView.ViewHolder {
    public TextView Player1;
    public TextView Player2;

    public MatchViewHolder(View parent, TextView Player1, TextView Player2) {
        super(parent);
        this.Player1 = Player1;
        this.Player2 = Player2;
    }
}
