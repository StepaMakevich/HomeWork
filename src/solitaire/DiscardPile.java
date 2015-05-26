package solitaire;

/**
 * Created by Степан on 24.03.2015.
 */
class DiscardPile extends TableAndDiscard {//стопка, в которую сбрасывается карта(тут карты переворачиваются)

    DiscardPile(final int x, final int y) {
        super(x, y);
    }

    public void addCard(final Card aCard) {
        if (!aCard.isFaceUp()) {
            aCard.flip();
        }
        super.addCard(aCard);
    }

    public void select(final int tx, final int ty) {
        if (empty()) {
            return;
        }
        Card topCard = pop();
        super.select(topCard);
        //сюда можно добавить код переворота карт в новую стопку
        if (Solitaire.deckPile.empty()) {
            while (topCard != null) {
                    topCard = pop();
                if (topCard!=null){
                    topCard.flip();
                    Solitaire.deckPile.addCard(topCard);
                }

            }
        }


    }
}
