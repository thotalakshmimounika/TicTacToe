package controller;

import constants.GameStatus;
import model.Board;
import model.Game;
import model.Move;
import model.Player;
import service.winningStrategy.WinningStrategy;
import service.winningStrategy.WinningStrategyFactory;
import service.winningStrategy.WinningStrategyName;

import java.util.List;

public class GameController {

    //create game will automatically start the game
    public Game createGame(int dimension, List<Player> players, WinningStrategyName name){
        return Game.builder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategy(WinningStrategyFactory.getWinningStrategy(name, dimension))
                .build();
    }

    public void displayBoard(Game game){
        game.getCurrentBoard().displayBoard();
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    public Move executeMove(Game game, Player player){
        return player.makeMove(game.getCurrentBoard());
    }

    public Player checkWinner(Game game, Move lastMovePlayed){
        return game.getWinningStrategy().checkWinner(game.getCurrentBoard(), lastMovePlayed);
    }

    public Board undoMove(Game game, Move lastPlayedMove){
        return null;
    }

    public void replayGame(Game game){

    }
}