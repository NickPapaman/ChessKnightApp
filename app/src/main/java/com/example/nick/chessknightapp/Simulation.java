package com.example.nick.chessknightapp;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private List<ArrayList> completedPaths;
    private int maxNumberOfMoves;
    private Position initialPosition;
    private Position finalPosition;
    private int[][] knightMoves={{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};

    public Simulation(int maxNumberOfMoves,int initialX,int initialY,int finalX,int finalY){
        completedPaths=new ArrayList();
        this.maxNumberOfMoves=maxNumberOfMoves;
        initialPosition=new Position(initialX,initialY);
        finalPosition=new Position(finalX,finalY);
    }

    public void start(){
        ArrayList<Position> possibleMoves=getPossibleMoves(initialPosition);
        int move=0;
        for(Position p:possibleMoves){
            ArrayList<Position> path= new ArrayList<Position>();
            path.add(new Position(initialPosition.getX(),initialPosition.getY()));
            path.add( new Position(p.getX(),p.getY()));
            recursiveMove(path,move);
        }
        for(ArrayList<Position> arrayList:completedPaths){
            String s=" Path Starts ";
            for(Position p:arrayList){
                s=s+"->"+ p.getRealCells();
            }
            Log.i("result",s);
        }
    }

    private void recursiveMove(ArrayList<Position> path,int move){
        move++;
        int positionInPath= path.size()-1;
        if(path.get(positionInPath).equals(finalPosition)){
            ArrayList<Position> fullPath= new ArrayList<Position>(path);
            completedPaths.add(fullPath);
        }else if(move<maxNumberOfMoves){
            ArrayList<Position> possibleMoves=getPossibleMoves(path.get(positionInPath));
            for(Position p:possibleMoves){
                if(!path.contains(p)){
                    ArrayList<Position> extraPath = new ArrayList<Position>(path);
                    extraPath.add(new Position(p.getX(),p.getY()));
                    recursiveMove(extraPath,move);
                }
            }
        }
    }


    public ArrayList<Position> getPossibleMoves(Position currentPosition){
        ArrayList<Position> possibleMoves= new ArrayList();
        int x=currentPosition.getX();
        int y=currentPosition.getY();
        for(int i=0;i<8;i++){
            if(isValidPosition(x+knightMoves[i][0],y+knightMoves[i][1])){
                possibleMoves.add(new Position(x+knightMoves[i][0],y+knightMoves[i][1]));
            }
        }
        return possibleMoves;
    }

    public boolean isValidPosition(int x,int y){
        return !((x<0)||(x>7)||(y<0)||(y>7));
    }

}