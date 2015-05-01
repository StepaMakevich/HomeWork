package solitaire;

import java.awt.*;

/**
 * Created by Степан on 24.03.2015.
 */
class CardPile {//стопка карт

    // coordinates of the card pile
    protected int x;//координат карты на столе
    protected int y;

    private Card firstCard;//ссылка на верхнюю карту из стопки карт

    CardPile(final int xl, final int yl) {
        x = xl;
        y = yl;
        firstCard = null;
    }

    // the following are sometimes overridden

    public Card top() {//возвращает вершину стопки
        return firstCard;
    }

    public boolean empty() {
        return firstCard == null;
    }

    public Card pop() {
        Card result = null;
        if (firstCard != null) {
            result = firstCard;
            firstCard = firstCard.link;
        }
        return result;
    }

    public boolean includes(final int tx, final int ty) {//находятся ли эти координаты внутри нее
        return x <= tx && tx <= x + Card.width &&
                y <= ty && ty <= y + Card.height;
    }

    public int countOfCards(final CardPile aCard ) {
        int count = 0;
        Card temp = aCard.firstCard;
        while (temp != null) {
            temp = temp.link;
            count++;
        }
        return count;

    }

    public void select(final int tx, final int ty) {
        // do nothing
    }

    public void addCard(final Card aCard) {
        aCard.link = firstCard;
        firstCard = aCard;
    }

    public void display(final Graphics g) {//рисуем карту на холсте в зависимости от ситуации(этот методо переопределяется в некоторых наследниках)
        g.setColor(Color.black);
        if (firstCard == null) {
            g.drawRect(x, y, Card.width, Card.height);
        } else {
            firstCard.draw(g, x, y);//первая карта нарисует себя и мы увидим расположение стопки
        }
    }

    public boolean canTake(final Card aCard) {
        return false;
    }//это реализация по умолчанию в классе родителя
}
