package com.sg.hangmanspringmvc;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HangmanGame {

    String word = "word";
    char guess;
    String hiddenWord;
    int guessCount = 6;
    int lettersFound = 0;
    boolean correctGuess = false;
    boolean lostGame = false;
    boolean wonGame = false;

    @GetMapping("/game")
    public String game(HttpServletRequest request, Model model) {
        StringBuilder sb = new StringBuilder(word);
        if (guessCount == 6 && lettersFound == 0) {
            for (int i = 0; i < word.length(); i++) {
                sb.setCharAt(i, '-');
            }
            hiddenWord = sb.toString();
        }

        model.addAttribute("hiddenWord", hiddenWord);
        model.addAttribute("guessCount", guessCount);

        return "result";
    }

    @PostMapping("/game")
    public String game(HttpServletRequest request) {

        StringBuilder sb = new StringBuilder(word);

        guess = request.getParameter("guess").charAt(0);

        for (int i = 0; i < word.length(); i++) {
            sb.setCharAt(i, '-');
        }

        for (int i = 0; i < word.length() - 1; i++) {
            if (sb.charAt(i) == guess) {
                sb.setCharAt(i, guess);
                correctGuess = true;
                lettersFound++;
            }
        }

        if (guessCount == 0) {
            lostGame = true;
        }

        if (lettersFound == word.length()) {
            wonGame = true;
        }

        if (correctGuess == false) {
            guessCount--;
        }

        hiddenWord = sb.toString();

        return "redirect:game";
    }

}
