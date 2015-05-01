package solitaire;

/**
 * Created by Степан on 26.03.2015.
 */
public class TableAndDiscard extends CardPile {
    public TableAndDiscard(int xl, int yl) {
        super(xl, yl);
    }

    public void select(final Card topCard, int tx, int ty) {
        //tx,ty добавить код проверки карты по координатам



        for (int i = 0; i < 4; i++) {
            if (Solitaire.suitPile[i].canTake(topCard)) {
                topCard.clicked=false;
                Solitaire.suitPile[i].addCard(topCard);
                return;
            }
        }
        // else see if any other table pile can take card
        for (int i = 0; i < 7; i++) {
            if (Solitaire.tableau[i].canTake(topCard)) {
                topCard.clicked=false;
                Solitaire.tableau[i].addCard(topCard);
                return;
            }
        }
        // else put it back on our pile


        addCard(topCard);

    }

}
