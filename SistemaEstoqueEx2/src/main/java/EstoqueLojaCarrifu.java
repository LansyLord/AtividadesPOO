import excecoes.produto.ProdutoJaCadastradoException;
import excecoes.produto.ProdutoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class EstoqueLojaCarrifu {
    private List<Produto> produtos;

    public EstoqueLojaCarrifu(List<Produto> p) {
        this.produtos = p;
    }

    public EstoqueLojaCarrifu() {
        this(new ArrayList<Produto>());
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void cadastraProduto(Produto p) throws ProdutoJaCadastradoException {
        if (produtos.isEmpty()) produtos.add(p);
        else {
            for (Produto produto : produtos) {
                if (produto.equals(p)) {
                    throw new ProdutoJaCadastradoException("Produto já cadastrado no sistema!");
                }
            }
            produtos.add(p);
        }
    }

    public Produto pesquisaProdutoPorId(int id) throws ProdutoNaoEncontradoException {
        if (produtos.isEmpty()) throw new ProdutoNaoEncontradoException("Não há nenhum produto cadastrado!");
        else {
            for (Produto p : produtos) {
                if (p.getId() == id) {
                    return p;
                }
            }
            throw new ProdutoNaoEncontradoException("O produto de id " + id + "não existe no sistema!");
        }
    }

    public List<Produto> exibeProdutos() {
        return this.produtos;
    }

    public void editaProdutoCadastrado(int id, Produto p) throws ProdutoNaoEncontradoException {

        for (Produto produto : produtos) {
            if (id == produto.getId()) {
                produto.setNome(p.getNome());
                produto.setTipo(p.getTipo());
                produto.setValor(p.getValor());
                return;
            }
        }
        throw new ProdutoNaoEncontradoException("Não foi possível editar o produto, produto não encontrado!");
    }

    public void excluiProdutoCadastrado(int id) throws ProdutoNaoEncontradoException {
        if (produtos.isEmpty()){
            throw new ProdutoNaoEncontradoException("Não há nenhum produto cadastrado!");
        }else {
            for (Produto p : produtos) {
                if (p.getId() == id) {
                    produtos.remove(p);
                    return;
                }
            }
            throw new ProdutoNaoEncontradoException("O produto de id " + id + " não existe no sistema!");
        }
    }
}