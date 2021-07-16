package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hey")
public class HelloController {

    // Handles request at path /hey
//    @GetMapping("hey")
//    @ResponseBody
//    public String hello() {
//        return "Hey There!";
//    }
    // lives at /hey/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Hasta la vista!";
    }

    // lives at /hey/(any name)
    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})

    public String helloWithQueryParam(@RequestParam String name) {
        return "Hey, " + name + "!";
    }

    // handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hey, " + name + "!";
    }

    // /hey/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hey' method='post'>" + // submit a request to /hey
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html";
    }
}
