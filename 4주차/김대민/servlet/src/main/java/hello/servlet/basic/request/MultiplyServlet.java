package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "multiplyServlet", urlPatterns = "/multiply")
public class MultiplyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Read request body
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        String requestBody = sb.toString();

        // Parse JSON
        JSONObject jsonObject = new JSONObject(requestBody);
        int num1 = jsonObject.getInt("num1");
        int num2 = jsonObject.getInt("num2");

        // Perform addition
        int result = num1 * num2;

        // Create JSON response
        JSONObject responseJson = new JSONObject();
        responseJson.put("result", result);

        // Set response content type and write JSON response
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write(responseJson.toString());
        out.flush();
    }
}