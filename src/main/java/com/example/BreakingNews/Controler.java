package com.example.BreakingNews;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Controller
public class Controler {
    private ArrayList<Item> items = new ArrayList<>();
    @PostConstruct
    private void loadData(){
        DataFromUrl data = new DataFromUrl("http://www.ynet.co.il/Integration/StoryRss2.xml");
        items = data.Readitems();

    }
    @GetMapping(value = "/")
    public String hello(Model model){
        model.addAttribute("items",items);
        return "table.html";
    }
}
