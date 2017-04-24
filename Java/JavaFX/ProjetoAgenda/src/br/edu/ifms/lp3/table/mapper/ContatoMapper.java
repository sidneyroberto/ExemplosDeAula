package br.edu.ifms.lp3.table.mapper;

import br.edu.ifms.lp3.model.Contato;
import br.edu.ifms.lp3.table.model.ContatoTM;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sidsu
 */
public class ContatoMapper {
    
    private ContatoMapper(){}
    
    public static List<ContatoTM> mapearLista(List<Contato> contatos) {
        List<ContatoTM> contatosTM = new ArrayList<>();
        if(contatos != null && contatos.size() > 0) {
            for(Contato contato : contatos) {
                ContatoTM contatoTM = new ContatoTM(contato);
                contatosTM.add(contatoTM);
            }
        }
        return contatosTM;
    }
}
