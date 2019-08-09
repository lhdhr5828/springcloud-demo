package com.lee.poi.demo.service;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception{
//        InputStream is = new FileInputStream("D:\\songjunbao\\4.27ht.doc");

//        InputStream is = new FileInputStream("C:\\Users\\User\\Desktop\\合同审核-北京电力\\归档\\6.2\\6.2国网北京信通公司220kV北寺站等12个变电站光缆线路双路由治理施工合同.doc");
        InputStream is = new FileInputStream("C:\\Users\\User\\Desktop\\合同审核-北京电力\\归档\\9.4\\9.4国网北京市电力公司三级系统等级保护测评项目技术服务合同.doc");


        POIFSFileSystem fs=new POIFSFileSystem(is);

        HWPFDocument doc=new HWPFDocument(fs);
        WordExtractor we=new WordExtractor(doc);
        String origText=we.getText();
        System.out.println(origText);
    }
}
