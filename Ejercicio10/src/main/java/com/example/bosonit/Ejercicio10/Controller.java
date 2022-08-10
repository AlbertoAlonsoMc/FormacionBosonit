package com.example.bosonit.Ejercicio10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Ejercicio10Application.class);
    @GetMapping("info")
    public String infoLog() {
        logger.info("INFO LOG");
        return "Se ha creado log de info";
    }

    @GetMapping("warn")
    public String warnLog() {
        logger.warn("WARN LOG");
        return "Se ha creado log de warning";
    }

    @GetMapping("error")
    public String errorLog() {
        logger.error("ERROR LOG");
        return "Se ha creado log de error";
    }
}
