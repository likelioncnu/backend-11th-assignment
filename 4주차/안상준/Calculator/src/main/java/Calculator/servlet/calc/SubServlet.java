package Calculator.servlet.calc;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "SubServlet",urlPatterns = "/sub")
public class SubServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        NumData numData = objectMapper.readValue(messageBody, NumData.class);

        int sum = numData.getNum1() - numData.getNum2();
        numData.setNum1(numData.getNum1());
        numData.setNum2(numData.getNum2());
        numData.setAns(sum);

        String result = objectMapper.writeValueAsString(numData);
        response.getWriter().write(result);
    }

}
