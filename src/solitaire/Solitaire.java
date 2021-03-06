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

    public void init() {//������ ������ main() ��������� ������
        // first allocate the arrays
        allPiles = new CardPile[13];//�������� ������ �� ��� 13 ������
        suitPile = new SuitPile[4];
        tableau = new TablePile[7];
        // then fill them in
        allPiles[0] = deckPile = new DeckPile(335, 5);//������������� deckpile � ������������ ����� � ��� �� ������������ ����� ���������� ������ ����������
        allPiles[1] = discardPile = new DiscardPile(268, 5);
        for (int i = 0; i < 4; i++) {
            allPiles[2 + i] = suitPile[i] =
                    new SuitPile(15 + 60 * i, 5);//��� � ������������ ������ ���������� ������� ����������
        }
        for (int i = 0; i < 7; i++) {
            allPiles[6 + i] = tableau[i] =
                    new TablePile(5 + 55 * i, 80, i + 1);
        }
    }

    public void paint(final Graphics g) { //���� ����� ���� �� ���� ���� ��������, ��� � init()
        for (int i = 0; i < 13; i++) {
            allPiles[i].display(g);
        }
    }

    public boolean mouseDown(final Event evt, final int x, final int y) {
        for (int i = 0; i < 13; i++) {
//            if (allPiles[i].includes(x, y)) {
//                //���� ������� ������� ����, �� ���� ���� ��������� ���������� ����������� �������
//                xOld = x;
//                yOld = y;
//            }
            if (allPiles[i].includes(x, y)) {
                //��� ��� ���������� ����� � ������ ���� ��� ������ ��
                allPiles[i].select(x, y);//���� ���������� (x,y) � �����-�� ������, �� ��������� select()
                repaint();//����� ��� ����������� ��������
                return true;
            }
        }
        return true;
    }
}
