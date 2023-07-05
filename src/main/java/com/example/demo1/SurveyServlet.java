package com.example.demo1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class SurveyServlet extends HttpServlet {
    private final AtomicInteger maleCount = new AtomicInteger(0);
    private final AtomicInteger femaleCount = new AtomicInteger(0);
    private final AtomicInteger youthCount = new AtomicInteger(0);
    private final AtomicInteger adultCount = new AtomicInteger(0);


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");

        if ("male".equals(gender)) {
            maleCount.incrementAndGet();
        } else if ("female".equals(gender)) {
            femaleCount.incrementAndGet();
        }

        if ("youth".equals(age)) {
            youthCount.incrementAndGet();
        } else if ("adult".equals(age)) {
            adultCount.incrementAndGet();
        }

        doGet(request, response); // Вызываем метод doGet() для отображения результатов
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if ("reset".equals(action)) {
            // Сбрасываем значения счетчиков
            maleCount.set(0);
            femaleCount.set(0);
            youthCount.set(0);
            adultCount.set(0);

            response.sendRedirect("index.jsp"); // Перенаправляем обратно на страницу опроса
        } else {
            // Устанавливаем значения счетчиков в атрибуты запроса
            request.setAttribute("maleCount", maleCount.get());
            request.setAttribute("femaleCount", femaleCount.get());
            request.setAttribute("youthCount", youthCount.get());
            request.setAttribute("adultCount", adultCount.get());

            // Перенаправляем на страницу с результатами
            RequestDispatcher dispatcher = request.getRequestDispatcher("results.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                // Обработка исключений
                e.printStackTrace();
            }
        }
    }
}
