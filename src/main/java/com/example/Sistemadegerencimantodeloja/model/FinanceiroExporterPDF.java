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

public class FinanceiroExporterPDF {
    private List<Vender> listVendas;
    private List<Despesas> despesas;
    private List<Investimento> investimentos;
    private double despesa;
    private double investimento;
    private double venda;


    public FinanceiroExporterPDF(List<Vender> listVendas,
                                 List<Despesas> despesas,
                                 List<Investimento> investimentos) {
        this.listVendas = listVendas;
        this.despesas = despesas;
        this.investimentos = investimentos;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(4);

        com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Total de Vendas", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Total Investimento", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Total Despesas", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Rendimento", font));
        table.addCell(cell);


    }

    private void writeTableData(PdfPTable table) {
        this.venda = 0;
        for (Vender vendas : listVendas) {
            this.venda = this.venda + vendas.getPreco_total();
        }
        this.despesa = 0;
        for (Despesas despesas : despesas) {
            this.despesa = this.despesa + despesas.getValor();
        }
        this.investimento = 0;
        for (Investimento investimento : investimentos) {
            this.investimento = this.investimento + investimento.getValor();
        }

        Double Rendimento = this.venda -(this.despesa+this.investimento);

        String auxV = Double.toString(this.venda);
        String auxI = Double.toString(this.investimento);
        String auxD = Double.toString(this.despesa);
        String rend = Double.toString(Rendimento);

        table.addCell(String.valueOf(auxV));
        table.addCell(String.valueOf(auxI));
        table.addCell(String.valueOf(auxD));
        table.addCell(String.valueOf(rend));
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLACK);

        Paragraph p = new Paragraph("Relatório Financeiro", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[]{1.5f, 3.5f, 3.0f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }
}
