package hello.servlet.basic.Cal;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.CalData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestSubServlet", urlPatterns = "/subtraction")
public class Sub extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");

        int value = Integer.parseInt(num1)-Integer.parseInt(num2);
        CalData calData = new CalData();
        calData.setNum1(num1);
        calData.setNum2(num2);
        calData.setResult( String.valueOf(value));
        String result = objectMapper.writeValueAsString(calData); //객체를 JSON문자로 변경

        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(result);

    }

}
