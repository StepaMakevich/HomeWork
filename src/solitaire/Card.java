package solitaire;

import java.awt.*;

/**
 * Created by Степан on 24.03.2015.
 */
class Card {
    // data fields for colors and suits
    final static int red = 0;
    final static int black = 1;

    final static int heart = 0;
    final static int spade = 1;
    final static int diamond = 2;
    final static int club = 3;

    final static int width = 50;
    final static int height = 70;

    //private static String names[] = {"A", "2", "3", "4", "5", "6",
    //	"7", "8", "9", "10", "J", "Q", "K"};
    // data fields
    private boolean faceup;//рубашка карты, изначально  false то есть рубашкой вверх
    private int rank;
    private int suit;

    public Card link;//в этом поле ссылка на следующую карту(карты в стопке закончились, когда link = null)
    public boolean clicked;

    // constructor
    Card(final int suitValue, final int rankValue) {
        suit = suitValue;
        rank = rankValue;
        faceup = false;//лицом вниз
    }

    // access attributes of card
    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public boolean isFaceUp() {
        return faceup;
    }

    //метод меняет состояние
    public void flip() {
        faceup = !faceup;
    }

    public int color() {
        if (getSuit() == heart || getSuit() == diamond) {
            return red;
        }
        return black;
    }

    public void draw(final Graphics g, final int x, final int y) {//метод рисует карту
        String names[] = {"A", "2", "3", "4", "5", "6",
                "7", "8", "9", "10", "J", "Q", "K"};
        // clear rectangle, draw border
        g.clearRect(x, y, width, height);
        if (isClicked()) {
            g.setColor(Color.green);
        } else {
            g.setColor(Color.black);
        }
        g.drawRect(x, y, width, height);//рисуем черный прямоугольник
        // draw body of card
        if (isFaceUp()) {
            if (color() == red) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.blue);
            }
            g.drawString(names[getRank()], x + 3, y + 15);
            if (getSuit() == heart) {//линиями рисуется масть
                g.drawLine(x + 25, y + 30, x + 35, y + 20);
                g.drawLine(x + 35, y + 20, x + 45, y + 30);
                g.drawLine(x + 45, y + 30, x + 25, y + 60);
                g.drawLine(x + 25, y + 60, x + 5, y + 30);
                g.drawLine(x + 5, y + 30, x + 15, y + 20);
                g.drawLine(x + 15, y + 20, x + 25, y + 30);
            } else if (getSuit() == spade) {
                g.drawLine(x + 25, y + 20, x + 40, y + 50);
                g.drawLine(x + 40, y + 50, x + 10, y + 50);
                g.drawLine(x + 10, y + 50, x + 25, y + 20);
                g.drawLine(x + 23, y + 45, x + 20, y + 60);
                g.drawLine(x + 20, y + 60, x + 30, y + 60);
                g.drawLine(x + 30, y + 60, x + 27, y + 45);
            } else if (getSuit() == diamond) {
                g.drawLine(x + 25, y + 20, x + 40, y + 40);
                g.drawLine(x + 40, y + 40, x + 25, y + 60);
                g.drawLine(x + 25, y + 60, x + 10, y + 40);
                g.drawLine(x + 10, y + 40, x + 25, y + 20);
            } else if (getSuit() == club) {
                g.drawOval(x + 20, y + 25, 10, 10);
                g.drawOval(x + 25, y + 35, 10, 10);
                g.drawOval(x + 15, y + 35, 10, 10);
                g.drawLine(x + 23, y + 45, x + 20, y + 55);
                g.drawLine(x + 20, y + 55, x + 30, y + 55);
                g.drawLine(x + 30, y + 55, x + 27, y + 45);
            }
        } else { // face down
            g.setColor(Color.yellow);
            g.drawLine(x + 15, y + 5, x + 15, y + 65);
            g.drawLine(x + 35, y + 5, x + 35, y + 65);
            g.drawLine(x + 5, y + 20, x + 45, y + 20);
            g.drawLine(x + 5, y + 35, x + 45, y + 35);
            g.drawLine(x + 5, y + 50, x + 45, y + 50);
        }
    }

    public int returnNumberCardPile() {
        for (int i = 0; i < 7; i++) {
            if (Solitaire.tableau[i].countOfCards() != i + 1) {
                System.out.println("number of pile =" + (i + 1));
                return i;
            }
        }
        System.out.println("return 10");
        return 10;
    }

    public boolean isClicked() {
        return clicked;
    }

    final boolean isAce() {//превратили метод в вопрос - туз ли это?
        return getRank() == 0;
    }

    final boolean isKing() {//добавили final для запрта переопределния этого метода в классах наследниках
        return getRank() == 12;
    }

    public CardPile returnCardPile() {
        for (int i = 0; i < 7; i++) {
            if (Solitaire.tableau[i].countOfCards() != i + 1) {
                System.out.println("number of pile =" + (i + 1));
                return Solitaire.tableau[i];
            }
        }
        return null;
    }
}
