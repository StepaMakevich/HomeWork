package solitaire;

import java.awt.*;

/**
 * Created by Степан on 24.03.2015.
 */
class TablePile extends TableAndDiscard {
    private int Oldx;//это перевернутые стопки раздвинутые как стек - 7 стопок
    private int Oldy;


    TablePile(final int x, final int y, final int c) {
        // initialize the parent class
        super(x, y);

        // then initialize our pile of cards
        for (int i = 0; i < c; i++) {
            addCard(Solitaire.deckPile.pop());
        }
        // flip topmost card face up
        top().flip();
    }

    public boolean canTake(final Card aCard) {
        if (empty()) {
            return aCard.isKing();//сделали более наглядные эти методы
        }
        Card topCard = top();
        return (aCard.color() != topCard.color()) && //если цвета не совпадают и ранг нижней на 1-цу меньше ранга верхней, то можно положить карту
                (aCard.getRank() == topCard.getRank() - 1);
    }

    //домашнее задание учитывать в методе includes расположение карты, а не стопки в целом
    public boolean includes(final int tx, final int ty) {
        // don't createObject bottom of card
        return x <= tx && tx <= x + Card.width &&
                (y+(countOfCards()-1)* Card.height/2) <= ty && ty<= (y+(countOfCards()-1)* Card.height/2 + Card.height);
        // y <= ty && ty <= y + Card.height;

    }

    public void select(final int tx, final int ty) {
        if (empty()) {
            return;
        }

        // if face down, then flip
        Card topCard = top();
        if (!topCard.isFaceUp()) {//если карта лицом вниз, то переворачиваем
            topCard.flip();
            return;
        }

        // else see if any suit pile can take card
        //тут мы забираем верхнюю карту и последовательно прикладываем ко всем стопкам с вопросом можешь ли взять?
        //сначала проверяем 4 стопки "бито"
        topCard = pop();
        super.select(topCard);
    }

    private int stackDisplay(final Graphics g, final Card aCard) {//рисуем стопку в виде раздвинутого стека
        int localy;
        if (aCard == null) {
            return y;
        }
        localy = stackDisplay(g, aCard.link);
        aCard.draw(g, x, localy);
        return localy + 35;
    }

    public void display(final Graphics g) {
        stackDisplay(g, top());
    }

}
