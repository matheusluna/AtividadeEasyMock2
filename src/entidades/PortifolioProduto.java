/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import interfaces.IPrecoProdutoServico;
import java.util.List;

/**
 *
 * @author mathe
 */
public class PortifolioProduto {
    private IPrecoProdutoServico iPrecoProdutoService;
    private List<Produto> produtos;

    public PortifolioProduto(IPrecoProdutoServico iPrecoProdutoService, List<Produto> produtos) {
        this.iPrecoProdutoService = iPrecoProdutoService;
        this.produtos = produtos;
    }

    public IPrecoProdutoServico getiPrecoProdutoService() {
        return iPrecoProdutoService;
    }

    public void setiPrecoProdutoService(IPrecoProdutoServico iPrecoProdutoService) {
        this.iPrecoProdutoService = iPrecoProdutoService;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public double getValorPortfolio(){
        double soma = 0;
        for(Produto p : produtos){
            soma+= iPrecoProdutoService.getPrecoProduto(p)*p.getQuantidade();
        }
        return soma;
    }
    
}
