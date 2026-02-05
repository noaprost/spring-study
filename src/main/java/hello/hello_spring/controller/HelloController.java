package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

  // /hello가 들어오면 이 메소드를 실행시켜줌
  @GetMapping("hello")
  public String hello(Model model) {
    model.addAttribute("data", "hello!!");

    // 컨트롤러에서 문자열을 반환하면 뷰 리졸버(viewResolver)가 화면을 찾아서 처리
    // 리턴값과 같은 이름의 templates에 있는 .html 파일을 찾아서 타임리프 템플릿 엔진처리를 해줌
    return "hello";
  }
}
