package solitaire;

/**
 * Created by Степан on 26.03.2015.
 */
public class TableAndDiscard extends CardPile {
    public TableAndDiscard(int xl, int yl) {
        super(xl, yl);
    }

    public void select(Card topCard) {
        //tx,ty добавить код проверки карты по координатам

        //все работает, но осталось решить проблему с nulpointer в случае, трогается первая стопка, в ней образуется 0 карт или в discardPile только 1 карта
        for (int i = 0; i < 4; i++) {
            if (Solitaire.suitPile[i].canTake(topCard)) {
                Solitaire.suitPile[i].addCard(topCard);
                return;
            }
        }

        boolean flag = false;
        topCard.clicked = true;

        if (Solitaire.discardPile.top().clicked) {
            System.out.println("discardPile is green");
            flag = true;
            int number = topCard.returnNumberCardPile();
            this.addCard(topCard);
            Card temp = Solitaire.discardPile.top();
            if (Solitaire.tableau[number].canTake(temp)) {
                System.out.println("it can");
                Solitaire.discardPile.pop();
                topCard.clicked = false;
                temp.clicked = false;
                Solitaire.tableau[number].addCard(temp);
                return;
            } else {
                temp.clicked = false;
                topCard.clicked = false;
                System.out.println("it can't");
            }
        } else {


            for (int i = 0; i < 7; i++) {

                Card tempCard = Solitaire.tableau[i].top();

                if ((tempCard.clicked) && (!tempCard.equals(topCard))) {
                    flag = true;
                    int number = topCard.returnNumberCardPile();
                    this.addCard(topCard);


                    if (Solitaire.tableau[number].canTake(tempCard)) {
                        System.out.println("it can");
                        Solitaire.tableau[i].pop();
                        topCard.clicked = false;
                        tempCard.clicked = false;
                        Solitaire.tableau[number].addCard(tempCard);
                        return;
                    } else {
                        topCard.clicked = false;
                        System.out.println("it can't");
                    }
                    tempCard.clicked = false;
                }


            }
        }

//
//        for (int i = 0; i < 4; i++) {
//            if (Solitaire.suitPile[i].canTake(topCard)) {
//                Solitaire.suitPile[i].addCard(topCard);
//                return;
//            }
//        }
//        // else see if any other table pile can take card
//        for (int i = 0; i < 7; i++) {
//            if (Solitaire.tableau[i].canTake(topCard)) {
//                Solitaire.tableau[i].addCard(topCard);
//                return;
//            }
//        }
        // else put it back on our pile


        if (!flag) {
            addCard(topCard);
        }

    }

}
