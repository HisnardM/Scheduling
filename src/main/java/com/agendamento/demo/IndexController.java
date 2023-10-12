
package com.agendamento.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
    /**
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @Override
    public String toString() {
        return "IndexController []";
    }

}
