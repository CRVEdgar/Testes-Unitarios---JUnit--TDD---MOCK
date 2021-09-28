package explicativos;

import entidades.Filme;
import entidades.Usuario;
import exceptions.FilmeSemEstoqueException;
import exceptions.LocadoraException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import servicos.LocacaoService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TratamentoDeExceptionsTest {

    /*
    * TESTES COM LANÇAMENTOS DE EXCEPTIONS
    * */

    @Test
    public void testLocacao_filmeSemEstoque() throws Exception{

        assertThrows(FilmeSemEstoqueException.class, () -> {
            //cenario
            LocacaoService service = new LocacaoService();
            Usuario usuario = new Usuario("Usuario 1");
            Filme filme = new Filme("Filme 2", 0, 4.0);

            //acao
            service.alugarFilme(usuario, filme);
        });
    }

    @Test
    public void testLocacao_usuarioVazio() throws FilmeSemEstoqueException{ //AQUI-> se aparecer uma exceção que eu n ao quero trabalhar, lanço ela pro Junit Tratar. NO CASO AQUI NAO QUERO TRABALHAR COM [FilmeSemEstoqueException]
        //cenario
        LocacaoService service = new LocacaoService();
        Filme filme = new Filme("Filme2", 1, 4.0);

        try{
            service.alugarFilme(null, filme);
            Assertions.fail("FALHA AO ENCONTRAR A EXCEPTION");
        }catch(LocadoraException e){
            assertEquals(e.getMessage(), "Usuario vazio"); //assertiva vrf se as excpitons sao iguais
        }
    }

    @Test

    void testarLocacao_usuarioVazioMet2() throws FilmeSemEstoqueException{
        assertThrows(LocadoraException.class, () -> {
            //cenario
            LocacaoService service = new LocacaoService();
            Filme filme = new Filme("Filme2", 1, 4.0);
//            Usuario usuario = new Usuario("Usuario 1");

            service.alugarFilme(null, filme); //desse jeito, com o usuario sendo nulo, a exception será lançada
//            service.alugarFilme(usuario, filme); //desse jeito o usuario nao é nulo, logo a exception nao será lançada

        });
    }

    @Test
    @DisplayName("deve lançar uma exception quando tentar alugar um filme que nao tem estoque")
    void testarLocacao_FilmeVazio() throws LocadoraException{

        assertThrows(FilmeSemEstoqueException.class, () -> {
            //cenario
            LocacaoService service = new LocacaoService();

            Usuario usuario = new Usuario("Usuario 1");
            Filme filme = new Filme("Filme2", 0, 4.0);

            service.alugarFilme(usuario, filme);
        });
    }

    @Test
    void testLocacao_FilmeVazio() throws  FilmeSemEstoqueException, LocadoraException {
        LocadoraException locadoraException = new LocadoraException("Filme vazio");
        assertThrows(locadoraException.getClass(), () -> {
            //cenario
            LocacaoService service = new LocacaoService();
            Usuario usuario = new Usuario("Usuario 1");

            //Assertativas - nesse caso vem primeiro explicacao VD-10, min 13min00
            assertEquals(locadoraException.getMessage(), "Filme vazio");

            //acao
            service.alugarFilme(usuario, null);

        });

    }

//    @Test
//    public void testLocacao_filmeSemEstoque_2() {
//        //cenario
//        LocacaoService service = new LocacaoService();
//        Usuario usuario = new Usuario("Usuario 1");
//        Filme filme = new Filme("Filme 2", 0, 4.0);
//
//        //acao
//        try {
//            service.alugarFilme(usuario, filme);
////            Assert.fail("Deveria ter lancado uma excecao");
//        } catch (Exception e) {
//            assertEquals(e.getMessage(), "Filme sem estoque");
//        }
//    }

//    @Test
//    public void testLocacao_filmeSemEstoque_3() throws Exception {
//        //cenario
//        LocacaoService service = new LocacaoService();
//        Usuario usuario = new Usuario("Usuario 1");
//        Filme filme = new Filme("Filme 2", 1, 4.0);
//
//        exception.expect(Exception.class);
//        exception.expectMessage("Filme sem estoque");
//
//        //acao
//        service.alugarFilme(usuario, filme);
//    }
}
