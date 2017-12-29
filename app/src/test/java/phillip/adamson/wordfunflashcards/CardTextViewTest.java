package phillip.adamson.wordfunflashcards;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTextViewTest {
    private CardTextView testCardView;

    @Before
    public void setUp() {
        this.testCardView = new CardTextView("test", 2);
    }

    @Test
    public void getCardSoundResourceId() throws Exception {
        this.testCardView.getCardText();
        assertEquals("test", this.testCardView.getCardText());
    }

    @Test
    public void getCardText() throws Exception {
        this.testCardView.getCardSoundResourceId();
        assertEquals(2, this.testCardView.getCardSoundResourceId());
    }

}