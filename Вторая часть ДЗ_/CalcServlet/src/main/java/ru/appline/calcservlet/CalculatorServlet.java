package ru.appline.calcservlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = "/calc")
public class CalculatorServlet extends HttpServlet {

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter pw = response.getWriter();

        StringBuilder buffer = new StringBuilder();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        String jsonString = buffer.toString();


        Gson gson = new Gson();
        JsonObject jobj = gson.fromJson(jsonString, JsonObject.class);
        double a = jobj.get("a").getAsDouble();
        double b = jobj.get("b").getAsDouble();
        String math = jobj.get("math").getAsString();

        double result = 0;
        switch (math) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b != 0) {
                    result = a / b;
                } else {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    pw.print("{\"error\": \"На ноль делить нельзя\"}");
                    return;
                }
                break;
        }

        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("result", result);

        pw.print(jsonResponse.toString());
        pw.flush();
    }
}