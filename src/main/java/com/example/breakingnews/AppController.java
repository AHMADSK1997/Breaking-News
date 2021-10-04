package com.example.breakingnews;

import java.util.ArrayList;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    private ArrayList<Item> items = new ArrayList();

    public AppController() {
    }

    @PostConstruct
    private void loadData() {
        DataFromUrl data = new DataFromUrl("http://www.ynet.co.il/Integration/StoryRss2.xml");
        this.items = data.Readitems();
    }

    @GetMapping({"/"})
    public String hello(Model model) {
        model.addAttribute("items", this.items);
        return "table.html";
    }
}
