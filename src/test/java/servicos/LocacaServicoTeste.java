package servicos;

import entidades.Filme;
import entidades.Locacao;
import entidades.Usuario;
import exceptions.FilmeSemEstoqueException;
import org.junit.jupiter.api.Test;
import utils.DataUtils;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class LocacaServicoTeste {
    @Test
    public void teste() throws Exception {
        //CENÁRIO
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("filme 1", 2, 5.0);

        //AÇÃO
        Locacao locacao = service.alugarFilme(usuario, filme);

        //quando as classes de testes estiverem no mesmo pacote de serviço, será possivel ter acesso às varaveis da [default, public, protected] classe
        service.vPublica = "publica";
        service.vDefault = "default";
        service.vProtected = "protected";
//        service.vPrivate = "private"; não é possivel ter acesso a var/metodo/class private

        //VERIFICAÇÃO
        assertTrue(locacao.getValor() == 5.0);
        assertEquals(5.0, locacao.getValor(), 0.01);
        assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));

    }



}
