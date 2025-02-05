package Modele;

import java.awt.Color;

public class Piece implements Runnable {

    protected boolean [][] forme;
    private int x = 8;
    private int y = -5;
    private int dY = 1;
    private Couleur couleur;
    private GrilleJeu grille;

    public Piece(GrilleJeu _grid, boolean [][] _shape,Couleur _color) {
        grille= _grid;
        forme = _shape;
        couleur = _color;
    }



    public void run() {
        int nextY = this.y;
        int nextX = this.x;

        nextY += dY;

        if (grille.validationPosition(nextX, nextY)) {
            this.y = nextY;
            this.x = nextX;

        } else {
            grille.fige_piece();
            grille.ligne_complete();

        }

    }




    public void bougeAdroite() {

        int nextX = this.x;
        nextX += 1;
        if (grille.validationPosition(nextX, this.y)) {
            this.x = nextX;

        }
    }

    public void bougeAgauche() {

        int nextX = this.x;
        nextX -= 1;
        if (grille.validationPosition(nextX, y)) {

            this.x = nextX;

        }
    }


    public void move_down(){
        int nextY= this.y;
        nextY +=2;
        if(grille.validationPosition(this.x, nextY)){
            this.y=nextY;
        }


    }
    public void rotation() {
        boolean nouvelle_piece[][]= new boolean [4][4];
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                nouvelle_piece[i][j]=forme[4 - 1 -j][i];
            }
        }
        if (grille.validationPositionRotation(this.x, this.y, nouvelle_piece)) forme = nouvelle_piece;

    }




    public Couleur getCouleur() {
        return couleur;
    }


    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

    public void setX(int _x) {
       this.x = _x;
    }

    public void setY(int _y) {
        this.y = _y;
    }


    public boolean[][] getForme() {
        return forme;
    }

}
