import excecoes.produto.ProdutoJaCadastradoException;
import excecoes.produto.ProdutoNaoEncontradoException;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class TestaEstoqueLojaCarrifu {
    public static void main(String[] args) {
        // Criando uma lista de produtos
        List<Produto> produtos = new ArrayList<>();

        // Criando o estoque
        EstoqueLojaCarrifu estoque = new EstoqueLojaCarrifu(produtos);

        // Criando produtos para teste
        Produto p1 = new Produto("Produto 1", "Tipo 1", 10.0);
        Produto p2 = new Produto("Produto 2", "Tipo 2", 20.0);
        Produto p3 = new Produto("Produto 3", "Tipo 3", 30.0);

        // Testando o método cadastraProduto
        try {
            estoque.cadastraProduto(p1);
            estoque.cadastraProduto(p2);
            estoque.cadastraProduto(p3);
        } catch (ProdutoJaCadastradoException e) {
            System.out.println(e.getMessage());
        }

        // Testando o método pesquisaProdutoPorId
        try {
            Produto produtoEncontrado = estoque.pesquisaProdutoPorId(1);
            System.out.println("Produto encontrado: " + produtoEncontrado);
        } catch (ProdutoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        // Testando o método exibeProdutos
        System.out.println("Produtos cadastrados:");
        List<Produto> produtosCadastrados = estoque.exibeProdutos();
        for (Produto produto : produtosCadastrados) {
            System.out.println(produto);
        }

        // Testando o método editaProdutoCadastrado
        Produto p4 = new Produto("Produto Editado", "Tipo Editado", 50.0);
        try {
            estoque.editaProdutoCadastrado(1, p4);
            System.out.println("-----------------------");
            System.out.println(estoque.pesquisaProdutoPorId(1));
            System.out.println("-----------------------");
        } catch (ProdutoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        // Testando o método excluiProdutoCadastrado
        try {
            estoque.excluiProdutoCadastrado(2);
            System.out.println("Produto Exluído com sucesso!");
        } catch (ProdutoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }
}
