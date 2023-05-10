package hello.servlet.hw01;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.Operator;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name="request_plusServlet", urlPatterns="/plus")
public class PlusServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + messageBody);

        Operator operator = objectMapper.readValue(messageBody, Operator.class);

        System.out.println("operator.num1 = " + operator.getNum1());
        System.out.println("operator.num2 = " + operator.getNum2());
        System.out.println("add = " + (operator.getNum1() + operator.getNum2()));
        System.out.println();

        response.getWriter().write("ok");
    }
}

