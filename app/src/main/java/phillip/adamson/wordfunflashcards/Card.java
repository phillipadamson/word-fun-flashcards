package phillip.adamson.wordfunflashcards;

public class Card {
    private CardTextView[] cardTextViews;
    private CardImageView[] cardImageViews;

    Card(CardTextView[] cardTextViews, CardImageView[] cardImageView) {
        this.cardTextViews = cardTextViews;
        this.cardImageViews = cardImageView;
    }

    public CardImageView[] getCardImageViews() {
        return cardImageViews;
    }

    public CardTextView[] getCardTextViews() {
        return cardTextViews;
    }
}
