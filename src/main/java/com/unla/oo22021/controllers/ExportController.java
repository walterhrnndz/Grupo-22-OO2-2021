package com.unla.oo22021.controllers;

import com.lowagie.text.DocumentException;
import com.unla.oo22021.entities.User;
import com.unla.oo22021.exportdata.UserPDFExporter;
import com.unla.oo22021.services.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/pdfPerfiles")
    public void exportToPDFPerfiles(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=perfiles_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<User> listUsers = userService.listAll();

        UserPDFExporter exporter = new UserPDFExporter(listUsers);
        // TODO Corregir los métodos para exportar solo los perfiles
        exporter.exportarListadoUsuarios(response);
    }

    @GetMapping("/pdfUsuarios")
    public void exportToPDFUsuarios(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=usuarios_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<User> listUsers = userService.listAll();

        UserPDFExporter exporter = new UserPDFExporter(listUsers);
        exporter.exportarListadoUsuarios(response);
    }
}