package com.unla.oo22021.exportdata;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.unla.oo22021.entities.User;
import com.unla.oo22021.entities.UserRole;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class UserPDFExporter {

    private List<User> listUsers;

    public UserPDFExporter(List<User> listUsers) {
        this.listUsers = listUsers;
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
        for (User user : listUsers) {
            table.addCell(user.getUsername());
            table.addCell(user.getPersona().getNombre());
            table.addCell(user.getPersona().getApellido());
            for (UserRole ur: user.getUserRoles()) {
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
}