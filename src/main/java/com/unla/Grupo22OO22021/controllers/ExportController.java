package com.unla.Grupo22OO22021.controllers;

import com.lowagie.text.DocumentException;
import com.unla.Grupo22OO22021.entities.Persona;
import com.unla.Grupo22OO22021.entities.UserRole;
import com.unla.Grupo22OO22021.exportdata.UserPDFExporter;
import com.unla.Grupo22OO22021.servicies.implementations.PersonaService;
import com.unla.Grupo22OO22021.servicies.implementations.UserRoleService;
import com.unla.Grupo22OO22021.servicies.implementations.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ExportController {

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("personaService")
    private PersonaService personaService;

    @Autowired
    @Qualifier("userRoleService")
    private UserRoleService userRoleService;

    @GetMapping("/pdfPerfiles")
    public void exportToPDFPerfiles(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=perfiles_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<UserRole> listaUserRoles = userRoleService.getAll();

        UserPDFExporter exporter = new UserPDFExporter(null, listaUserRoles);

        exporter.exportarListadoPerfiles(response);
    }

    @GetMapping("/pdfUsuarios")
    public void exportToPDFUsuarios(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=usuarios_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Persona> listaPersonas = personaService.getAll();

        UserPDFExporter exporter = new UserPDFExporter(listaPersonas, null);
        exporter.exportarListadoUsuarios(response);
    }
}