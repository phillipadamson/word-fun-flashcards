package phillip.adamson.wordfunflashcards;

public class CardTextView {
    public String cardText;
    private int cardSoundResourceId;

    CardTextView(String cardText, int cardSoundResourceId) {
        this.cardText = cardText;
        this.cardSoundResourceId = cardSoundResourceId;
    }

    public int getCardSoundResourceId() {
        return cardSoundResourceId;
    }

    public String getCardText() {
        return cardText;
    }
}
