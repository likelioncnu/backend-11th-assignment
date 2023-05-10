package hello.servlet.basic;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")  // /hello로 오면 실행 (URL 매핑)
public class HelloServlet extends HttpServlet {

    @Override  //서블릿이 호출되면 서비스 메서드 호출
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("HelloServlet.service");

        System.out.println("req = " + req);
        System.out.println("resp = " + resp);

        //서블릿 요청
        String username = req.getParameter("username"); //쿼리파라미터 조회
        System.out.println("username = " + username);
        //서블릿 응답
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("hello " + username); //http메시지 바디에 들어감

    }
}


//ctrl+o
//soutm
//soutv