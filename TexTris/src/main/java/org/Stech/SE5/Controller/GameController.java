package org.Stech.SE5.Controller;

import org.Stech.SE5.View.GameView;
import org.Stech.SE5.Model.GameModel;

public class GameController implements Controller {

    private GameView gameView;
    private GameModel gameModel;

    @Override
    public void setVisible(boolean visible) {

    }

    @Override
    public void initController() {
        this.gameModel = new GameModel(this);
        this.gameView = new GameView();
        this.gameView.drawBoard(this.gameModel.getBoard());
    }
}