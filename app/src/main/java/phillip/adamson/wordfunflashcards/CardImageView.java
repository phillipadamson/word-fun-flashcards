package phillip.adamson.wordfunflashcards;

import android.graphics.drawable.Drawable;

public class CardImageView {
    private Drawable cardImage;
    private int cardSoundResourceId;

    CardImageView(Drawable cardImage, int cardSoundResourceId) {
        this.cardImage = cardImage;
        this.cardSoundResourceId = cardSoundResourceId;
    }

    public Drawable getCardImage() {
        return cardImage;
    }

    public int getCardSoundResourceId() {
        return cardSoundResourceId;
    }
}
