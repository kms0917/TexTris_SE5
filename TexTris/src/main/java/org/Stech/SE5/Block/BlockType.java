package org.Stech.SE5.Block;

public enum BlockType {
    J_BLOCK, L_BLOCK, Z_BLOCK, S_BLOCK, T_BLOCK, O_BLOCK, I_BLOCK;

    public static final int getTetrominoSize() {
        return 7;
    }

    public static final Block getBlockInstance(final BlockType blocktype) {
        return switch (blocktype) {
            case I_BLOCK -> new IBlock();
            case L_BLOCK -> new IBlock();
           //Block들 만들고 Case 추가필요
        };
    }
}