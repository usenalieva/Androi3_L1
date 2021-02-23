package com.makhabatusen.lesson_1.ui.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makhabatusen.lesson_1.R;
import com.makhabatusen.lesson_1.domain.Card;
import com.makhabatusen.lesson_1.ui.EmojiGame;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiHolder> {

    private final EmojiGame emojiGame;
    private final Listener listener;

    public EmojiAdapter (Listener listener, EmojiGame emojiGame) {
        this.listener = listener;
        this.emojiGame = emojiGame;
    }

    @NonNull
    @Override
    public EmojiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new EmojiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiHolder holder, int position) {
        holder.onBind(emojiGame.getCards().get(position));
    }

    @Override
    public int getItemCount() {
        return emojiGame.getCards().size();
    }

    public class EmojiHolder extends RecyclerView.ViewHolder {
        private final TextView tvCardContent;


        public EmojiHolder(@NonNull View itemView) {
            super(itemView);
            tvCardContent = itemView.findViewById(R.id.tv_card_content);
        }

        public void onBind(Card<String> card) {
            if (card.isFaceUp())
            {
                itemView.setBackgroundColor(Color.WHITE);
                tvCardContent.setText(card.getContent());
            } else
            {
                itemView.setBackgroundColor(Color.BLUE);
                tvCardContent.setText("");
            }

            itemView.setOnClickListener(view -> {
                emojiGame.choose(card);
                listener.cardClick(card);
            });

        }
    }

    public interface Listener {
        void cardClick(Card<String> card);
    }
}
