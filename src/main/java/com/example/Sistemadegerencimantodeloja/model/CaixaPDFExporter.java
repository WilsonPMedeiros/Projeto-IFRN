package com.example.Sistemadegerencimantodeloja.model;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class CaixaPDFExporter {
    private List<Caixa> listCaixa;

    public CaixaPDFExporter(List<Caixa> listCaixa) {
        this.listCaixa = listCaixa;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Caixa ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Data", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Entrada", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Saída", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Saldo", font));
        table.addCell(cell);


    }

    private void writeTableData(PdfPTable table) {
        for (Caixa caixas : listCaixa) {
            table.addCell(String.valueOf(caixas.getId()));
            table.addCell(String.valueOf(caixas.getData()));
            table.addCell(String.valueOf(caixas.getEntrada()));
            table.addCell(String.valueOf(caixas.getSaida()));
            table.addCell(String.valueOf(caixas.getSaldo()));
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLACK);

        Paragraph p = new Paragraph("Relatório de fechamento de caixa", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 1.5f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }
}
