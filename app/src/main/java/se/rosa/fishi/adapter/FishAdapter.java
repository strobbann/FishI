package se.rosa.fishi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import se.rosa.fishi.R;
import se.rosa.fishi.model.Fish;

public class FishAdapter extends RecyclerView.Adapter<FishAdapter.FishViewHolder> {

    private final List<Fish> fishes;

    public FishAdapter(List<Fish> fishes) {
        this.fishes = fishes;
    }

    @Override
    public FishViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View fishView = inflater.inflate(R.layout.fish_list_item, parent, false);
        return new FishViewHolder(fishView);
    }

    @Override
    public void onBindViewHolder(FishViewHolder holder, int position) {
        Fish fish = fishes.get(position);
        holder.bindView(fish);
    }

    @Override
    public int getItemCount() {
        return fishes.size();
    }

    class FishViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvfishType;
        private final TextView tvfishLength;
        private final TextView tvfishWeight;

        FishViewHolder(View itemView) {
            super(itemView);
            tvfishType = (TextView) itemView.findViewById(R.id.tv_fish_type);
            tvfishLength = (TextView) itemView.findViewById(R.id.tv_fish_length);
            tvfishWeight = (TextView) itemView.findViewById(R.id.tv_fish_weight);
        }

        void bindView(Fish fish) {
            tvfishType.setText(fish.getFishType().toString());
            tvfishLength.setText(fish.getLength());
            tvfishWeight.setText(fish.getWeight());
        }
    }
}
