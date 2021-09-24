package servicos;

import static utils.DataUtils.adicionarDias;

import entidades.Filme;
import entidades.Locacao;
import entidades.Usuario;

import java.util.Date;

public class LocacaoService {

    public String vPublica;
    protected String vProtected;
    private String vPrivate;
    String vDefault;

    public Locacao alugarFilme(Usuario usuario, Filme filme) {
        Locacao locacao = new Locacao();
        locacao.setFilme(filme);
        locacao.setUsuario(usuario);
        locacao.setDataLocacao(new Date());
        locacao.setValor(filme.getPrecoLocacao());

        //Entrega no dia seguinte
        Date dataEntrega = new Date();
        dataEntrega = adicionarDias(dataEntrega, 1);
        locacao.setDataRetorno(dataEntrega);

        //Salvando a locacao...
        //TODO adicionar método para salvar

        return locacao;
    }

    public static void main(String[] args) {

    }

}
