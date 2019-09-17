package com.lee.poi.demo.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class IndexController {

    @RequestMapping(value = "/getHtml")
    public Map<String, String> getHtml() {
        String filePath = "D:\\6.2（检修技术改造）施工合同（2018版）.doc";

        String s = Word2Html.DocxToHtml(filePath);

        HashMap<String, String> map = new HashMap<>();
        map.put("result", s);
        return map;

    }

    @RequestMapping(value = "/genHtml")
    public Map<String, String> genHtml() {
        String filePath = "D:\\6.2（检修技术改造）施工合同（2018版）.doc";
        String docFile = "C:\\ideaProject\\demo\\poi-doc-demo\\src\\main\\resources\\static\\doc.html";

        Word2Html.doc2Html(filePath, docFile);
        HashMap<String, String> map = new HashMap<>();
        map.put("result", "");
        return map;
    }
}
