package phillip.adamson.wordfunflashcards;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CardFragment extends Fragment {
    private Card card;
    private TextView textView;
    private ImageView imageView;
    private MediaPlayer cardSound;
    private View fragmentView;
    private int currentView = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle fragmentBundle) {
        this.fragmentView = inflater.inflate(R.layout.fragment_container, container, false);
        this.textView = fragmentView.findViewById(R.id.textView);
        this.imageView = this.fragmentView.findViewById(R.id.imageView);

        this.displayNextView();
        this.fragmentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNextView();
            }
        });

        return this.fragmentView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.cardSound.stop();
        this.cardSound.release();
    }

    public void setCard(Card card) {
        this.card = card;

    }

    public void displayNextView() {
        this.textView = this.fragmentView.findViewById(R.id.textView);
        this.textView.setVisibility(View.GONE);
        this.imageView.setVisibility(View.GONE);
        if (this.cardSound != null) {
            this.cardSound.stop();
            this.cardSound.release();
            this.cardSound = null;
        }
        if (this.currentView < this.card.getCardImageViews().length) {
            this.imageView.setImageDrawable(this.card.getCardImageViews()[0].getCardImage());
            this.imageView.setVisibility(View.VISIBLE);
            this.cardSound = MediaPlayer.create(getActivity().getBaseContext(), this.card.getCardImageViews()[0].getCardSoundResourceId());
            this.cardSound.start();
        } else {
            this.textView.setText(this.card.getCardTextViews()[this.currentView - this.card.getCardImageViews().length].getCardText());
            this.textView.setVisibility(View.VISIBLE);
            this.cardSound = MediaPlayer.create(getActivity().getBaseContext(), this.card.getCardTextViews()[this.currentView - this.card.getCardImageViews().length].getCardSoundResourceId());
            this.cardSound.start();
        }
        if (this.currentView >= ((this.card.getCardImageViews().length + this.card.getCardTextViews().length) - 1)) {
            this.currentView = 0;
        } else {
            this.currentView++;
        }

    }
}
