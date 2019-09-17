package com.lee.poi.demo.service;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.w3c.dom.Document;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word2Html {

    static String hyperlinkRegex = "<span class=\"s2\"> </span><span>HYPERLINK \\\\l \"_Toc\\d{9}\"</span>";
    static Pattern hyperlinkPattern = Pattern.compile(hyperlinkRegex);
    static String tocRegex = "<span.{0,12}>\\sTOC\\s\\\\o.{0,30}</span>";
    static Pattern tocPattern = Pattern.compile(tocRegex);
    static String catelogMore = "<span>\t</span>";
    static Pattern catelogMorePattern = Pattern.compile(catelogMore);

    public static void main(String[] args) {

//        String hi = "hi";
        String doc = "1. 委托事项......................................... 1";
        String filePath = "D:\\国网北京信通公司2019年省级客户服务中心座席功能完善（95598优质服务全量数据分析及智能监测）-资本性合同.doc";
//        String outPath = "D:\\无法4.html";
//        doc2Html(filePath, outPath);
        String a = "<span.{0,15}>\\s\\d{0,2}\\.\\s.{0,20}</span>";
        Pattern compile = Pattern.compile(a);
        String s = DocxToHtml(filePath);
        Matcher matcher = compile.matcher(s);
        while (matcher.find()) {
            System.out.println(matcher.group());

        }
    }


    public static String removeCateLogStr(String resource) {
        Matcher hyper = hyperlinkPattern.matcher(resource);
        System.out.println(resource.length());
        while (hyper.find()) {
            // 去除显示hyper的多于字符
            String group = hyper.group();
            System.out.println(group);
            resource = resource.replace(group, "");
        }
        System.out.println(resource.length());
        Matcher toc = tocPattern.matcher(resource);
        if (toc.find()) {
            // 去除多于的TOC字符串
            String group = toc.group();
            resource = resource.replace(group, "");
        }
        return resource;
    }

    public static String DocxToHtml(String fileAllName) {
        HWPFDocument wordDocument;
        try {
            //根据输入文件路径与名称读取文件流
            InputStream in = new FileInputStream(fileAllName);
            //把文件流转化为输入wordDom对象
            wordDocument = new HWPFDocument(in);
            //通过反射构建dom创建者工厂
            DocumentBuilderFactory domBuilderFactory = DocumentBuilderFactory.newInstance();
            //生成dom创建者
            DocumentBuilder domBuilder = domBuilderFactory.newDocumentBuilder();
            //生成dom对象
            Document dom = domBuilder.newDocument();
            //生成针对Dom对象的转化器
            WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(dom);
            //转化器重写内部方法
            wordToHtmlConverter.setPicturesManager(new PicturesManager() {
                @Override
                public String savePicture(byte[] content,
                                          PictureType pictureType, String suggestedName,
                                          float widthInches, float heightInches) {
                    return suggestedName;
                }
            });
            //转化器开始转化接收到的dom对象
            wordToHtmlConverter.processDocument(wordDocument);
            //保存文档中的图片
        /*    List<?> pics=wordDocument.getPicturesTable().getAllPictures();
            if(pics!=null){
                for(int i=0;i<pics.size();i++){
                    Picture pic = (Picture)pics.get(i);
                    try {
                        pic.writeImageContent(new FileOutputStream("E:/test/"+ pic.suggestFullFileName()));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } */
            //从加载了输入文件中的转换器中提取DOM节点
            Document htmlDocument = wordToHtmlConverter.getDocument();
            //从提取的DOM节点中获得内容
            DOMSource domSource = new DOMSource(htmlDocument);

            //字节码输出流
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            //输出流的源头
            StreamResult streamResult = new StreamResult(out);
            //转化工厂生成序列转化器
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer serializer = tf.newTransformer();
            //设置序列化内容格式
            serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            serializer.setOutputProperty(OutputKeys.INDENT, "no");
            serializer.setOutputProperty(OutputKeys.METHOD, "html");

            serializer.transform(domSource, streamResult);
            //生成文件方法
            String content = new String(out.toByteArray());
            out.close();
            return content;

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void doc2Html(String fileAllName, String outPutFile) {
        String content = DocxToHtml(fileAllName);

        System.out.println(content);
        writeFile(content, outPutFile);

    }

    public static void writeFile(String content, String path) {
        FileOutputStream fos = null;
        BufferedWriter bw = null;
        try {
            File file = new File(path);
            fos = new FileOutputStream(file);
            bw = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
            bw.write(content);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ie) {
            }
        }
    }
}
