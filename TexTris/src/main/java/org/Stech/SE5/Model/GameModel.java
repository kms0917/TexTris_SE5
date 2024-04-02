package org.Stech.SE5.Model;

import  org.Stech.SE5.Controller.GameController;
import  org.Stech.SE5.Block.*;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Random;

public class GameModel {
    private GameController gamecontroller;
    private ArrayList<Element[]> board;
    private Block currentBlock;
    private Block nextBlock;
    private double score = 0;
    private int deletedRowCount = 0;

    private final int DEFAULT_POS_X = 3;
    private final int DEFAULT_POS_Y = 0;
    private double gameSpeed = 1;

    private int posX;
    private int posY;

    public GameModel(final GameController controller) {
        this.gamecontroller = controller;
        initBoard(10, 20);  //나중에 설정쪽에서 받아올 수 있게 변경 필요
        this.setRandomBlock();
        posX = DEFAULT_POS_X;
        posY = DEFAULT_POS_Y;
    }

    public final ArrayList<Element[]> getBoard() {
        return board;
    }

    public double getScore() {
        return score;
    }

    public Block getCurrentBlock() {
        return currentBlock;
    }

    public Block getNextBlock() {
        return nextBlock;
    }

    public int getDeletedRaw() {
        return deletedRowCount;
    }

    public final void initBoard(final int width, final int height) {
        board = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            Element[] row = new Element[width];
            for (int j = 0; j < width; j++) {
                row[j] = Element.EMPTY;
            }
            board.add(row);
        }
    }

    public final void setRandomBlock() {
        Random rnd = new Random(System.currentTimeMillis());
        BlockType blocktype;
        int rndNum = 0;

        if(nextBlock == null) {
            rndNum = rnd.nextInt(BlockType.getTetrominoSize());
            blocktype = BlockType.values()[rndNum];
            currentBlock = BlockType.getBlockInstance(blocktype);
        } else {
            currentBlock = nextBlock;
        }
       /* switch (설정에서 가져온 난이도 값) {
            case EASY -> {
                rndNum = rnd.nextInt(72) / 10; // I_BLOCK 60 ~ 71, weight 12
                if(rndNum > 6) rndNum = 6;
            }
            case NORMAL -> rndNum = rnd.nextInt(70) / 10; // I_BLOCK 60 ~ 69, weight 10
            case HARD -> rndNum = rnd.nextInt(68) / 10; // I_BLOCK 60 ~ 67, weight 8
        }*/
        rndNum = rnd.nextInt(70) / 10;  //일단 노말로 설정

        blocktype = BlockType.values()[rndNum];
        nextBlock = BlockType.getBlockInstance(blocktype);

        posX = DEFAULT_POS_X;
        posY = DEFAULT_POS_Y;
        //생성이 불가한 상황이면 게임오버되는 기능 구현 필요
    }
}