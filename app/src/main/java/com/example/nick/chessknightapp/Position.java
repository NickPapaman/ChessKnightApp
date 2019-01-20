package com.example.nick.chessknightapp;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Position)){
            return false;
        }
        return  ((((Position) obj).getX() == x)&&(((Position) obj).getY() == y));
    }

    public String getRealCells(){
        String result="";
        switch (x){
            case 0: result="A";
                break;
            case 1: result="B";
                break;
            case 2: result="C";
                break;
            case 3: result="D";
                break;
            case 4: result="E";
                break;
            case 5: result="F";
                break;
            case 6: result="G";
                break;
            case 7: result="H";
                break;

        }
        int resultY= y+1;
        result = result+resultY;
        return  result;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}