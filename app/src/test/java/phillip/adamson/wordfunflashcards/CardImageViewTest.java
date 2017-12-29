package phillip.adamson.wordfunflashcards;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardImageViewTest {
    CardImageView testCardImageView;
    Drawable drawable;
    @Before
    public void setUp() throws Exception {
        this.drawable = new Drawable() {
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
        testCardImageView = new CardImageView(drawable, 2);
    }

    @Test
    public void getCardImage() throws Exception {
        testCardImageView.getCardImage();
        assertEquals(this.drawable, testCardImageView.getCardImage());
    }

    @Test
    public void getCardSoundResourceId() throws Exception {
        testCardImageView.getCardSoundResourceId();
        assertEquals(2, testCardImageView.getCardSoundResourceId());
    }

}