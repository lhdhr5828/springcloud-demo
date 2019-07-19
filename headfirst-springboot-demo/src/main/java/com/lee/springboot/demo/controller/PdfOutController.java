package com.lee.springboot.demo.controller;

import com.lee.springboot.demo.pdfconfig.PdfOutService;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


public class PdfOutController extends AbstractPdfView {

    private PdfOutService pdfOutService = null;

    public PdfOutController(PdfOutService pdfOutService) {
        this.pdfOutService = pdfOutService;
    }

    @Override
    protected void buildPdfDocument(Map<String, Object> model, com.lowagie.text.Document document, com.lowagie.text.pdf.PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {

    }
}
