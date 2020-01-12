//package com.quizapp.springREST.services;
//
//import com.quizapp.springREST.Model.Game;
//import com.quizapp.springREST.Model.GameState;
//import com.quizapp.springREST.Model.Lobby;
//import com.quizapp.springREST.Model.PlayerAnswers;
//import com.quizapp.springREST.Repositories.GameRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class GameService {
//
//    private Lobby lobby;
//
//    @Autowired
//    GameLobbyService gameLobbyService;
//
//    @Autowired
//    GameRepository gameRepository;
//
//    @Autowired
//   // SimpMessagingTemplate template;
//
//
////    public Game startNewGame(String lobbyID)
////    {
////     //  return gameRepository.AddNewGame(new Game(gameLobbyService.getLobbyById(lobbyID).getPlayers()));
////    }
//
//
//    public Game proceedAnserws(String game_id, PlayerAnswers answers) {
//       return gameRepository.getActiveGameByID(game_id).proceedAnserws(answers);
//    }
//
//    public Game GetGameByGameID(String game_id)
//    {
//       return gameRepository.getActiveGameByID(game_id);
//    }
//
//    public void sendMessage(String s, GameState startNextRound) {
//      //  template.convertAndSend("/games/{game_id}",startNextRound);
//    }
//}
