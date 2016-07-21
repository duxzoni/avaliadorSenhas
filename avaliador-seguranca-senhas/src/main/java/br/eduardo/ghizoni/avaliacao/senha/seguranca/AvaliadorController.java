package br.eduardo.ghizoni.avaliacao.senha.seguranca;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("avaliador")
public class AvaliadorController {

    @RequestMapping(method = RequestMethod.POST)
    Response avaliador(@RequestBody Request request) {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.calculaSegurancaDaSenha(request.getSenha());
		
        return avaliadorSegurancaSenha.getResultadoAvaliacao();
    }
    
    
//    @RequestMapping(name = "/")
//    public String index(){
//    	return "avaliador";
//    }
}