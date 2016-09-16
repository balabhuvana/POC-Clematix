package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import clematix.com.poc_clematix.R;
import model.Fruits;


public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.FruitViewHolder> {

    private Context mContext;
    private List<Fruits> mArrayListFruits;

    public GroceryAdapter(Context oContext, List<Fruits> oArrayListFruits) {
        mContext = oContext;
        mArrayListFruits = oArrayListFruits;
    }

    public static class FruitViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivFruits, ivRightArrow;
        private TextView tvFruitName, tvFruitPrice, tvFruitWeight;

        public FruitViewHolder(View oView) {
            super(oView);
            ivFruits = (ImageView) oView.findViewById(R.id.ivFruit);
            ivRightArrow = (ImageView) oView.findViewById(R.id.iv_right_arrow);
            tvFruitName = (TextView) oView.findViewById(R.id.tvFruitName);
            tvFruitPrice = (TextView) oView.findViewById(R.id.tvFruitPrice);
            tvFruitWeight = (TextView) oView.findViewById(R.id.tvFruitWeight);
        }
    }

    @Override
    public FruitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.fruits_view, parent, false);
        return new FruitViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FruitViewHolder holder, int position) {
        Picasso.with(mContext).load(mArrayListFruits.get(position).getFruitUrl()).into(holder.ivFruits);
        holder.tvFruitName.setText(mArrayListFruits.get(position).getFruitName());
        holder.tvFruitPrice.setText(String.valueOf(mArrayListFruits.get(position).getFruitPrice()));
        holder.tvFruitWeight.setText(String.valueOf(mArrayListFruits.get(position).getFruitWeight()));
    }

    @Override
    public int getItemCount() {
        return mArrayListFruits.size();
    }
}
