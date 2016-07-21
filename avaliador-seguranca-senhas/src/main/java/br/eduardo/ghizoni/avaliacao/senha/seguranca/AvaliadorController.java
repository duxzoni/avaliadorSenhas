package br.eduardo.ghizoni.avaliacao.senha.seguranca;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvaliadorController {

    @RequestMapping(name = "/avaliador", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    Response avaliador(@RequestBody Request request) {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.calculaSegurancaDaSenha(request.getSenha());
		
        return avaliadorSegurancaSenha.getResultadoAvaliacao();
    }
    
    
}