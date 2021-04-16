package com.example.Sistemadegerencimantodeloja.model;

import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Funcionario;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class FuncionarioPDFExporter {

    private List<Funcionario> listfuncionarios;

    public FuncionarioPDFExporter(List<Funcionario> listfuncionarios) {
        this.listfuncionarios = listfuncionarios;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(6);

        com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Nome", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("CPF", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Email", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Telefone", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Função", font));
        table.addCell(cell);

    }

    private void writeTableData(PdfPTable table) {
        for (Funcionario funcionario : listfuncionarios) {
            table.addCell(String.valueOf(funcionario.getId()));
            table.addCell(funcionario.getNome());
            table.addCell(String.valueOf(funcionario.getCpf()));
            table.addCell(String.valueOf(funcionario.getLogin()));
            table.addCell(String.valueOf(funcionario.getTelefone()));
            table.addCell(String.valueOf(funcionario.getFuncao()));
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLACK);

        Paragraph p = new Paragraph("Relatório de clientes", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }
}
