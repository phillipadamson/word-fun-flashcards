package phillip.adamson.wordfunflashcards;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Resources resources;
    private FragmentManager fragmentManager;
    private List<Card> appCards = new ArrayList<>();
    private static final int WORD_IMAGE = 0;
    private static final int WORD_ENGLISH = 1;
    private static final int WORD_THAI = 2;
    private static final int WORD_SOUND = 3;
    private static final int WORD_SOUND_ENGLISH = 4;
    private static final int WORD_SOUND_THAI = 5;
    private int currentCard = 0;
    private CardFragment wordFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resources = getResources();
        fragmentManager = getFragmentManager();
        this.getCardsFromResources();
        this.createCardFragment();
    }

    private void createCardFragment() {
        this.wordFragment = new CardFragment();
        this.wordFragment.setCard(this.appCards.get(this.currentCard));
        FragmentTransaction fragmentTransaction = this.fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, this.wordFragment, "fragment");
        fragmentTransaction.commit();
    }

    private void getCardsFromResources() {
        TypedArray loadedWords = resources.obtainTypedArray(R.array.word_items);
        TypedArray itemDef;

        for (int i = 0; i < loadedWords.length(); i++) {
            int resourceId = loadedWords.getResourceId(i, -1);
            itemDef = resources.obtainTypedArray(resourceId);

            Drawable wordImage = itemDef.getDrawable(WORD_IMAGE);
            String wordEnglish = itemDef.getString(WORD_ENGLISH);
            String wordThai = itemDef.getString(WORD_THAI);
            String imageSound = itemDef.getString(WORD_SOUND);
            String wordEnglishSound = itemDef.getString(WORD_SOUND_ENGLISH);
            String wordThaiSound = itemDef.getString(WORD_SOUND_THAI);
            int wordImageSoundId = resources.getIdentifier(imageSound, "raw", getPackageName());
            int wordEnglishSoundId = resources.getIdentifier(wordEnglishSound, "raw", getPackageName());
            int wordThaiSoundId = resources.getIdentifier(wordThaiSound, "raw", getPackageName());
            CardImageView[] cardImageViews = {new CardImageView(wordImage, wordImageSoundId)};

            CardTextView cardTextView = new CardTextView(wordEnglish, wordEnglishSoundId);
            CardTextView cardTextView2 = new CardTextView(wordThai, wordThaiSoundId);
            CardTextView[] cardTextViews = {cardTextView, cardTextView2};
            Card theCard = new Card(cardTextViews, cardImageViews);
            this.appCards.add(theCard);
            Collections.shuffle(this.appCards);
        }
    }

    public void generateNextCard(View view) {
        this.increaseCurrentCard();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(this.wordFragment);
        this.wordFragment = new CardFragment();
        this.wordFragment.setCard(this.appCards.get(this.currentCard));
        fragmentTransaction.replace(R.id.container, this.wordFragment, "fragment");
        fragmentTransaction.commit();
    }

    private void increaseCurrentCard() {
        this.currentCard++;
        if (this.currentCard == this.appCards.size()) {
            Collections.shuffle(this.appCards);
            this.currentCard = 0;
        }
    }
}
