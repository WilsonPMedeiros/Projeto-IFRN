package com.example.Sistemadegerencimantodeloja.model;

import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;


public class VendaPDFExporter {
        private List<Vendas> listVendas;

        public VendaPDFExporter(List<Vendas> listVendas) {
            this.listVendas = listVendas;
        }

        private void writeTableHeader(PdfPTable table) {
            PdfPCell cell = new PdfPCell();
            cell.setBackgroundColor(Color.BLUE);
            cell.setPadding(4);

            Font font = FontFactory.getFont(FontFactory.HELVETICA);
            font.setColor(Color.WHITE);

            cell.setPhrase(new Phrase("venda ID", font));

            table.addCell(cell);

            cell.setPhrase(new Phrase("Data", font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Valor da venda", font));
            table.addCell(cell);


        }

        private void writeTableData(PdfPTable table) {
            for (Vendas vendas : listVendas) {
                table.addCell(String.valueOf(vendas.getId()));
                table.addCell(String.valueOf(vendas.getData_Venda()));
                table.addCell(String.valueOf(vendas.getPreco_total()));
            }
        }

        public void export(HttpServletResponse response) throws DocumentException, IOException {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, response.getOutputStream());

            document.open();
            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            font.setSize(18);
            font.setColor(Color.BLACK);

            Paragraph p = new Paragraph("Relatório das vendas", font);
            p.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(p);

            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100f);
            table.setWidths(new float[] {1.5f, 3.5f, 3.0f});
            table.setSpacingBefore(10);

            writeTableHeader(table);
            writeTableData(table);

            document.add(table);

            document.close();

        }
    }

