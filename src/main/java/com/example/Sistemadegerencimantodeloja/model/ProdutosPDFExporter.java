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


public class ProdutosPDFExporter {
        private List<Produtos> listProdutos;

        public ProdutosPDFExporter(List<Produtos> listProdutos) {
            this.listProdutos = listProdutos;
        }

        private void writeTableHeader(PdfPTable table) {
            PdfPCell cell = new PdfPCell();
            cell.setBackgroundColor(Color.BLUE);
            cell.setPadding(5);

            com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA);
            font.setColor(Color.WHITE);

            cell.setPhrase(new Phrase("Produto ID", font));

            table.addCell(cell);

            cell.setPhrase(new Phrase("Descrição", font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Valor Custo", font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Valor Venda", font));
            table.addCell(cell);

        }

        private void writeTableData(PdfPTable table) {
            for (Produtos produtos : listProdutos) {
                table.addCell(String.valueOf(produtos.getId()));
                table.addCell(produtos.getDescricao());
                table.addCell(String.valueOf(produtos.getValorCusto()));
                table.addCell(String.valueOf(produtos.getValorVenda()));
            }
        }

        public void export(HttpServletResponse response) throws DocumentException, IOException {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, response.getOutputStream());

            document.open();
            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            font.setSize(18);
            font.setColor(Color.BLACK);

            Paragraph p = new Paragraph("Relatório dos produtos", font);
            p.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(p);

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100f);
            table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f});
            table.setSpacingBefore(10);

            writeTableHeader(table);
            writeTableData(table);

            document.add(table);

            document.close();

        }
    }

