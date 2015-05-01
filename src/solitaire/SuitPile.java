package solitaire;

/**
 * Created by Степан on 24.03.2015.
 */
class SuitPile extends CardPile {//это стопка, в которую мы складываем открытые карты(таких 4 стопки)

    SuitPile(final int x, final int y) {
        super(x, y);
    }

    public boolean canTake(final Card aCard) {//это метод замещение
        if (empty()) {//специальная проверка для туза
            return aCard.isAce();//возвращается выражение туз ли это
        }
        Card topCard = top();
        return (aCard.getSuit() == topCard.getSuit()) &&//проверка на совпадение мастей и ранг новой = ранг старой+1?
                (aCard.getRank() == 1 + topCard.getRank());
    }

}
