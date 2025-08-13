package com.example.soap.client.controller;

import com.example.soap.client.controller.request.ElegibilidadeRequest;
import com.example.soap.client.controller.response.ElegibilidadeResponse;
import com.example.soap.client.service.ElegibilidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("elegibilidade")
public class VerificarElibilidadeController {

    @Autowired
    private ElegibilidadeService service;

    @PostMapping
    @ResponseBody
    public ElegibilidadeResponse verificar(@RequestBody ElegibilidadeRequest request) {
        return service.verificar(request);
    }
}