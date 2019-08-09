package com.lee.poi.demo.service;

import java.util.regex.Pattern;

public class RegexMatch {

    static String projectName = "项目名称:";

    public static void main(String[] args) {
        String file = "C:\\Users\\User\\Desktop\\WXWork\\1688852494422079\\Cache\\File\\2019-07\\10.1\\10.1 国网北京信通公司2019年“网上国网”服务提升工程（电子发票推广及调价改造）-资本性委托开发合同.doc";

    }

    public static void match(String filePath, Pattern pattern) {
        String s = Word2Html.DocxToHtml(filePath);

    }
}
