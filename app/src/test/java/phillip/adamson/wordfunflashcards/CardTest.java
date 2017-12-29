package phillip.adamson.wordfunflashcards;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {
    private Card testCard;
    private CardImageView[] cardImageViews;
    private CardTextView[] cardTextViews;

    @Before
    public void setUp() throws Exception {
        Drawable drawable = new Drawable() {
            @Override
            public void draw(Canvas canvas) {

            }

            @Override
            public void setAlpha(int alpha) {

            }

            @Override
            public void setColorFilter(ColorFilter colorFilter) {

            }

            @Override
            public int getOpacity() {
                return 0;
            }
        };
        this.cardImageViews = new CardImageView[]{new CardImageView(drawable, 2)};
        this.cardTextViews = new CardTextView[]{new CardTextView("cardText", 2)};
        this.testCard = new Card(this.cardTextViews, this.cardImageViews);
    }

    @Test
    public void getCardImageViews() throws Exception {
        this.testCard.getCardImageViews();
        assertArrayEquals(this.cardImageViews, this.testCard.getCardImageViews());
    }

    @Test
    public void getCardTextViews() throws Exception {
        this.testCard.getCardTextViews();
        assertArrayEquals(this.cardTextViews, this.testCard.getCardTextViews());
    }

}