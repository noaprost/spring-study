package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

  @GetMapping("hello-mvc")
  public String helloMvc(@RequestParam("name") String name, Model model) {
    model.addAttribute("name", name);
    return "hello-template";
  }

  @GetMapping("hello-string")
  // http의 통신 프로토콜 body 구에 return 한 데이터를 직접 넣어주겠다는 의미
  // template 과의 차이점 : view 없이도 이 문자가 그대로 내려감
  @ResponseBody
  public String helloString(@RequestParam("name") String name) {
    return "hello " + name;
  }

  @GetMapping("hello-api")
  // json으로 반환하는게 기본
  @ResponseBody
  public Hello helloApi(@RequestParam("name") String name) {
    Hello hello = new Hello();
    hello.setName(name);

    // ResponseBody를 사용하면 ViewResolver 대신에 HttpMessageConverter가 동작
    // 단순 String일 경우 StringConverter가 동작하고 json 객체일 경우 JsonConverter가 동작함
    return hello;
  }

  static class Hello {
    private String name;

    // getter, setter를 Java Bean 규약이라고 함
    // 프로퍼티 방식이라고도 함
    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
}

