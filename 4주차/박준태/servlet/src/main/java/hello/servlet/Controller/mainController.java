package hello.servlet.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller()
@RequestMapping("/calc")
public class mainController {

    @GetMapping("/main")
    public String mainPageCall(){
        return "main";
    }

    @GetMapping("/multiple")
    public String multiple(){
        return "multiple";
    }

    @PostMapping("/multiple")
    public String calcMultiple(@RequestParam String front, String back, Model model){
        model.addAttribute("mode","multiple");
        try {
            double a = Double.parseDouble((front));
            double b = Double.parseDouble((back));
            double result = a*b;
            model.addAttribute("data",result);
        }
        catch (NumberFormatException e){
            model.addAttribute("error","값이 비어있거나 잘못된 입력입니다.");
        }
        return "result";
    }

    @GetMapping("/divide")
    public String divide(){
        return "divide";
    }

    @PostMapping("/divide")
    public String divideCalc(@RequestParam String bunMo, String bunJa, Model model){
        model.addAttribute("mode","divide");
        try{
            double a = Double.parseDouble(bunMo);
            double b = Double.parseDouble(bunJa);
            double result=0;
            if(a!=0){
                result = b/a;
                model.addAttribute("data",result);
            }
            else{
                model.addAttribute("error","0은 분모로 올 수 없다.");
            }
        }
        catch (NumberFormatException numberFormatException){
            model.addAttribute("error","비어있거나 잘못된 입력입니다.");
        }

        return "result";
    }

    @GetMapping("/subtract")
    public String subtract(){
        return "subtract";
    }

    @PostMapping("/subtract")
    public String subtractCalc(@RequestParam String front, String back, Model model){
        model.addAttribute("mode","subtract");
        try{
            double a = Double.parseDouble(front);
            double b = Double.parseDouble(back);
            double result;
            result = a-b;
            model.addAttribute("data",result);
        }catch (NumberFormatException numberFormatException){
            model.addAttribute("error","비어있거나 잘못된 입력입니다.");
        }
        return "result";
    }

    @GetMapping("/plus")
    public String plus(){
        return "plus";
    }

    @PostMapping("/plus")
    public String plusCalc(@RequestParam String front, String back, Model model){
        model.addAttribute("mode","plus");
        try{
            double a = Double.parseDouble(front);
            double b = Double.parseDouble(back);
            double result;
            result = a+b;
            model.addAttribute("data",result);
        }catch (NumberFormatException numberFormatException){
            model.addAttribute("error","비어있거나 잘못된 입력입니다.");
        }
        return "result";
    }

}
