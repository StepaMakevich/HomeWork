package solitaire;

/*
    Simple Solitaire Card Game in Java
	Written by Tim Budd, Oregon State University, 1996
*/

import java.applet.Applet;
import java.awt.*;

public class Solitaire extends Applet {
    static DeckPile deckPile;
    static DiscardPile discardPile;
    static TablePile tableau[];
    static SuitPile suitPile[];
    static CardPile allPiles[];

    int xOld;
    int yOld;

    public void init() {//вместо метода main() запускает апплет
        // first allocate the arrays
        allPiles = new CardPile[13];//содержит ссылки на все 13 стопок
        suitPile = new SuitPile[4];
        tableau = new TablePile[7];
        // then fill them in
        allPiles[0] = deckPile = new DeckPile(335, 5);//инициализация deckpile с координатами карты и тут же присваивания новой переменной другой переменной
        allPiles[1] = discardPile = new DiscardPile(268, 5);
        for (int i = 0; i < 4; i++) {
            allPiles[2 + i] = suitPile[i] =
                    new SuitPile(15 + 60 * i, 5);//тут в конструкторе стопки специально немного сдвигаются
        }
        for (int i = 0; i < 7; i++) {
            allPiles[6 + i] = tableau[i] =
                    new TablePile(5 + 55 * i, 80, i + 1);
        }
    }

    public void paint(final Graphics g) { //этот метод тоже не надо явно вызывать, как и init()
        for (int i = 0; i < 13; i++) {
            allPiles[i].display(g);
        }
    }

    public boolean mouseDown(final Event evt, final int x, final int y) {
        for (int i = 0; i < 13; i++) {
//            if (allPiles[i].includes(x, y)) {
//                //ждем второго нажатия мыши, то есть надо запомнить координаты предыдущего нажатия
//                xOld = x;
//                yOld = y;
//            }
            if (allPiles[i].includes(x, y)) {
                //тут код прорисовки карты в другой цвет при выборе ее
                allPiles[i].select(x, y);//если координаты (x,y) в какой-то стопке, то выполняем select()
                repaint();//метод для перерисовки страницы
                return true;
            }
        }
        return true;
    }
}
