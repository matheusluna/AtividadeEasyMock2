/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import entidades.PortifolioProduto;
import entidades.Produto;
import interfaces.IPrecoProdutoServico;
import java.util.ArrayList;
import java.util.List;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mathe
 */
public class TestPortifolio {
    IPrecoProdutoServico iPrecoProdutoService;
    public TestPortifolio() {
    }
    
    
    
    @Before
    public void setUp() {
        iPrecoProdutoService = EasyMock.createMock(IPrecoProdutoServico.class);
    }
    
    @Test
    public void test1(){
        Produto p = new Produto(1, "Café", 10);
        Produto p1 = new Produto(2, "Leite", 5);
        Produto p2 = new Produto(3, "Nescau", 2);
        Produto p3 = new Produto(4, "Feijão", 4);
        List<Produto> produtos = new ArrayList<>();
        produtos.add(p);
        produtos.add(p1);
        produtos.add(p2);
        produtos.add(p3);
        
        EasyMock.expect(iPrecoProdutoService.getPrecoProduto(p)).andReturn(3.00);
        EasyMock.expect(iPrecoProdutoService.getPrecoProduto(p1)).andReturn(5.00);
        EasyMock.expect(iPrecoProdutoService.getPrecoProduto(p2)).andReturn(2.00);
        EasyMock.expect(iPrecoProdutoService.getPrecoProduto(p3)).andReturn(3.00);
        EasyMock.replay(iPrecoProdutoService);
        
        PortifolioProduto port = new PortifolioProduto(iPrecoProdutoService, 
                produtos);
        
        assertEquals(71.00, port.getValorPortfolio(), 0);
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
