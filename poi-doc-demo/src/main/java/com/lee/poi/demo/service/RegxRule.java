package com.lee.poi.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum RegxRule {

    A("工程规模","工程规模：([\\s\\S]*?)元"),
     B("工程名称","工程名称：([\\s\\S]*?)\\r"),
    C("项目名称", "项目名称：([\\s\\S]*?)<"),
    D("服务", "鉴于甲方拟委托乙方提供([\\s\\S]*?)信息系统"),
    E("委托方甲方", "委托方（甲方）：([\\s\\S]*?)</p>"),
    F("受托方乙方", "受托方（乙方）：([\\s\\S]*?)</p>"),
    G("合同项下服务费大写", "合同项下的服务费用为人民币([\\s\\S]*?)（大写）"),
    //     H("合同项下服务费小写","（大写）\\([\\s\\S]*?&yen;([\\s\\S]*?)\\)（含税）"),
    I("不含税人民币大写", "不含税价人民币([\\s\\S]*?)（大写）"),
    J("不含税人民币小写", "（大写）\\([\\s\\S]*?&yen;([\\s\\S]*?)\\)"),//与合同项下服务费小写一样有问题
    K("增值税税率", "增值税税率([\\s\\S]*?)%"),
    L("增值税税额", "增值税税额([\\s\\S]*?)元"),
    M("服务费用的支付时间和方式", "服务费用的支付时间和方式：([\\s\\S]*?)[1-9].工作条件"),
    N("法定代表人签字", "法定代表人[\\s\\S]*?授权代表（签字）：([\\s\\S]*?)</td>"),  //甲乙方规则相同，左边为甲方右边为乙方
    O("签署页签订日期", "<td[\\s\\S]*?签订日期：([\\s\\S]*?)</td>"),//甲乙方规则相同，左边为甲方右边为乙方
    P("签署页甲乙方开户银行", "<td[\\s\\S]*?开户银行：([\\s\\S]*?)</td>"),
    Q("签署页甲乙方账户", "<td[\\s\\S]*?开户行联行号：([\\s\\S]*?)</td>"),
    R("签署页甲乙方统一社会信用代码", "<td[\\s\\S]*?统一社会信用代码：([\\s\\S]*?)</td>"),
    S("签署页甲乙方盖章", "<td[\\s\\S]*?甲方：[\\s\\S]*?（盖章）([\\s\\S]*?)</td>"),
    T("争议解决方式", "经协商仍无法达成一致的，按以下第([\\s\\S]*?)种方式处理："),
    U("仲裁机构", "仲裁：提交([\\s\\S]*?)仲裁委员会"),
    V("诉讼地方", "诉讼：向([\\s\\S]*?)所在地人民法院"),
    W("合同份数", "本合同一式([\\s\\S]*?)份"),
    X("甲方份数", "甲方执([\\s\\S]*?)份"),
    XX("乙方份数", "乙方执([\\s\\S]*?)份"),
    Y("特别约定", "其他条款的修改或补充，如有不一致，以特别约定为准。</span>([\\s\\S]*?)（以下无正文）"),
    Z("日期", "服务期限为从([\\s\\S]*?)日。");
    private String regxName;
    private String regx;

    private RegxRule(String regxName, String regx) {
        this.regxName = regxName;
        this.regx = regx;
    }

    public static String takeRegx(String regxName) {
        for (RegxRule regxRule : RegxRule.values()) {
            if (regxRule.regxName.equals(regxName)) {
                return regxRule.regx;
            }
        }
        return null;
    }

    public static List<String> listRegxValue() {
        List<String> values = new ArrayList<>();
        for (RegxRule regxRule : RegxRule.values()) {
            values.add(regxRule.regx);
        }
        return values;
    }


    public static void main(String[] args) {
        String content = Word2Html.DocxToHtml("C:\\Users\\User\\Desktop\\WXWork\\1688852494422079\\Cache\\File\\2019-07\\9.4\\9.4国网北京市电力公司二级系统等级保护测评项目技术服务合同.doc").replaceAll("HYPERLINK([\\s\\S]*?)[1-9]\\.", "").replaceAll("TOC \\\\o([\\s\\S]*?)\\\\u", "");
//        System.out.println(content);
        Matcher matcher = Pattern.compile("13\\.6其他：([\\s\\S]*?)14\\.").matcher(content);
        int aa = 1;
        while (matcher.find()) {
            System.out.println(aa++);
            String group = matcher.group();
            System.out.println(group);
            Pattern p = Pattern.compile("<[^>]+>", Pattern.CASE_INSENSITIVE);
            String trim = matcher.group(1).trim();
            System.out.println(trim);
            Matcher ma = p.matcher(trim);
            String s = ma.replaceAll("");
            System.out.println("con:" + s.trim().replaceAll("\n\r", ""));
        }
    }
}
