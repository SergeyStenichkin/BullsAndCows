package ru.frostcode.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static ru.frostcode.servlet.CalculateBullsAndCows.*;


@WebServlet("/")
public class Game extends HttpServlet {


    private String a = randomNumber();
    private ArrayList<String> mas = new ArrayList<>();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userVar = request.getParameter("userVar");

        if(userVar != null && !userVar.equals("") && a.length() == userVar.length()) {
            if (a.equals(userVar)) {
                String win = userVar + " - Number guessed";
                request.setAttribute("win", win);
                a = randomNumber();
            }else {
                Pair<Integer, Integer> calc = calcBullsCows(a, userVar);
                mas.add(userVar + " - " + calc.first + "B" + calc.second + "C");
            }
        }
        request.setAttribute("result", mas);
        request.setAttribute("hid", a); // Отправляем загаданное число компьютером для отладки
        request.getServletContext().getRequestDispatcher("/jsp/Game.jsp").forward(request, response);

    }

}
