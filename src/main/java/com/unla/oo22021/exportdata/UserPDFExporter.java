package com.unla.oo22021.exportdata;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.unla.oo22021.entities.Persona;
import com.unla.oo22021.entities.UserRole;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class UserPDFExporter {

    private List<UserRole> listaUserRoles;
    private List<Persona> listaPersonas;

    public UserPDFExporter(List<Persona> listaPersonas, List<UserRole> listaUserRoles) {
        this.listaPersonas = listaPersonas;
        this.listaUserRoles = listaUserRoles;
    }

    private void headerUsuario(PdfPTable table) {

        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Username", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Nombre", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Apellido", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Roles", font));
        table.addCell(cell);
    }

    private void datosUsuario(PdfPTable table) {
        for (Persona persona : listaPersonas) {
            table.addCell(persona.getUser().getUsername());
            table.addCell(persona.getNombre());
            table.addCell(persona.getApellido());
            for (UserRole ur: persona.getUser().getUserRoles()) {
                table.addCell(ur.getRole());
            }
        }
    }

    public void exportarListadoUsuarios(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("Listado de Usuarios", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f});
        table.setSpacingBefore(10);

        headerUsuario(table);
        datosUsuario(table);

        document.add(table);

        document.close();
    }

    public void exportarListadoPerfiles(HttpServletResponse response) throws DocumentException, IOException {

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("Listado de Perfiles", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f});
        table.setSpacingBefore(10);

        headerPerfil(table);
        datosPerfil(table);

        document.add(table);

        document.add(new Paragraph("Listado filtrado de perfiles (sin duplicados)"));

        document.close();
    }

    private void datosPerfil(PdfPTable table) {
        for (UserRole userRole: listaUserRoles) {
            table.addCell(String.valueOf(userRole.getId()));
            table.addCell(userRole.getRole());
        }
    }

    private void headerPerfil(PdfPTable table) {

        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Roles", font));
        table.addCell(cell);
    }
}