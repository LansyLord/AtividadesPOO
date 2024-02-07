import excecoes.produto.NaoHaProdutosException;
import excecoes.produto.ProdutoJaCadastradoException;
import excecoes.produto.ProdutoNaoEncontradoException;

import java.util.List;

public interface SistemaEstoque {

    void cadastraProduto(Produto p) throws ProdutoJaCadastradoException;
    Produto pesquisaProdutoPorId(int id) throws ProdutoNaoEncontradoException;
    List<Produto> exibeProdutosCadastrados() throws NaoHaProdutosException;
    void editaProdutoCadastrado(int id) throws ProdutoNaoEncontradoException;
}
