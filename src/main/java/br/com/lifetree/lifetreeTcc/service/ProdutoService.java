package br.com.lifetree.lifetreeTcc.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.lifetree.lifetreeTcc.model.entity.Produto;
import br.com.lifetree.lifetreeTcc.model.entity.TpProduto;
import br.com.lifetree.lifetreeTcc.repository.McProdutoRepository;
import br.com.lifetree.lifetreeTcc.repository.ProdutoRepository;
import br.com.lifetree.lifetreeTcc.repository.TpProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

	//objeto repository
	private  ProdutoRepository produtoRepository; 
	private TpProdutoRepository tpprodutoRepository;
	private McProdutoRepository mcprodutoRepository;
	private ImagensService imagensService;

	//Injeção de dependência
	public ProdutoService(ProdutoRepository produtoRepository , TpProdutoRepository tpprodutoRepository , McProdutoRepository mcProdutoRepository, ImagensService imagensService) {
		super();
		this.produtoRepository = produtoRepository;
		this.tpprodutoRepository = tpprodutoRepository;
		this.mcprodutoRepository = mcProdutoRepository;
		this.imagensService = imagensService;
	}

	public Produto findById(long id) {
		return produtoRepository.findById(id).get();
	}
	public List<Produto>ListarTodos(){
		return produtoRepository.findAll();
	}

	public List<Produto> listarTodosFiltro(String nome){
		return produtoRepository.findByNomeContaining(nome);
	}

	//	public List<Produto> listarStatus() {
	//		return produtoRepository.listarProdutosAtivos("Ativo");
	//		
	//	}


	@Transactional
	public void inativarProd(Produto produto) {

		Produto _produto = produto;

		_produto.setPreco(0.0);
		_produto.setQuantidade(0);
		_produto.setDestaque("NÃO");
		_produto.setImagem(null);
		_produto.setStatusProd("INATIVO");
		produtoRepository.save(_produto);
	}
	
	@Transactional
	public void reativarProd(Produto produto) {

		Produto _produto = produto;

		_produto.setDestaque("NÃO");
		_produto.setImagem(null);
		_produto.setStatusProd("ATIVO");
		produtoRepository.save(_produto);
	}



	@Transactional
	public Produto gravarNovoProd(MultipartFile file, Produto produto) {

		if (file != null && file.getSize() > 0) {
			try {
				produto.setImagem(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			produto.setImagem(null);
		}

		if (produto.getDestaque() == null) {
			produto.setDestaque("NÃO");
		}
		produto.setStatusProd("ATIVO");

		return produtoRepository.save(produto);
	}
	@Transactional
	public void atualizarProd(MultipartFile file, Produto _produto, byte[] foto) {
//
//		Produto _produto = produto;
//
//		TpProduto tpproduto = tpprodutoRepository.findByTpProduto(produto.getTpProduto().getTpProduto());
		
		System.out.println("fi"+file.getSize());
		System.out.println("fo"+foto.length);

		if (file.getSize() == 0 && foto.length == 0) {
			_produto.setImagem(null);
		} 

		if (file.getSize() == 0 && foto.length > 0) {
			_produto.setImagem(foto);
		} 

		if (file != null && file.getSize() > 0 ) {
			try {
				_produto.setImagem(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		

		if (_produto.getDestaque() == null) {
			_produto.setDestaque("NÃO");
		}

		//_produto.setTpProduto(tpproduto);
		_produto.setStatusProd("ATIVO");
		produtoRepository.save(_produto);
	}

	//METODO INSERT INTO PRODUTO 
	@Transactional
	public Produto save(Produto _produto) {
		return produtoRepository.save(_produto);
	}
	//METODO SELECT * FROM PRODUTO
	public List<Produto> ListarTodosProd(){
		List<Produto> lista = produtoRepository.findAll();
		return lista;
	}

	public List<Produto> listarProdutosAtivos(){
		return produtoRepository.findByStatusProd("ATIVO");
	}

	public List<Produto> listarProdutosFiltro(String nomeProd){
		return produtoRepository.listarProdutosFiltro(nomeProd);
	}
}
