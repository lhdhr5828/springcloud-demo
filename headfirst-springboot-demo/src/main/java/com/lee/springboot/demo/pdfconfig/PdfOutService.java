package com.lee.springboot.demo.pdfconfig;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface PdfOutService {

    /**
     * 输出pdf文件
     *
     * @param model
     * @param document
     * @param writer
     * @param request
     */
    public void make(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request);
}
