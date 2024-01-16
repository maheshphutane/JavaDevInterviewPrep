package org.example.MachineCoding.TicTacToe.stratergies.Bot;

import org.example.MachineCoding.TicTacToe.models.BotDifficultyLevel;

public class BotPlayingStratergyFactory {
    public static BotPlayingStratergy getBotPlayingStratergy(BotDifficultyLevel botDifficultyLevel){
        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)){
            return new EasyBotPlayingStratergy();
        }
        return null;
    }
}
