package hello.servlet.basic;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.Data;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;

@Slf4j
@WebServlet(name = "dividerServlet", urlPatterns = "/divider")
public class divider extends HttpServlet {
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
            int bunJa = Integer.parseInt(req.getParameter("bunJa"));
            int bunMo = Integer.parseInt(req.getParameter("bunMo"));
            int result = 0;
            if(bunMo!=0){
                result = bunJa/bunMo;
                resp.setContentType("application/json");
                resp.setCharacterEncoding("utf-8");
                Data data = new Data(bunMo,bunJa,result);
                String answer = objectMapper.writeValueAsString(data);
                resp.getWriter().write(answer);
            }
            else {
                log.error("나누는 분모가 0이면 안됩니다.");
                String errorMessage ="분모 0은 안됩니다.";
                resp.setContentType("plain/text");
                resp.setCharacterEncoding("utf-8");
                resp.getWriter().write(errorMessage);
            }
        }
        catch (NumberFormatException numberFormatException){
            log.error("숫자 넣어주세요.");
        }
    }
}
