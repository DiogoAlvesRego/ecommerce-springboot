package com.ecommerce.ecommerce.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.ecommerce.ecommerce.dto.ProdutoRequestDTO;
import com.ecommerce.ecommerce.dto.ProdutoResponseDTO;
import com.ecommerce.ecommerce.entity.Produto;
import com.ecommerce.ecommerce.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/v1/produtos")
@RequiredArgsConstructor
@Tag(
        name = "Produtos",
        description = "Operações relacionadas aos produtos"
)
public class ProdutoController {

    private final ProdutoService service;

    @Operation(summary = "Listar todos os produtos")
    @GetMapping
    public ResponseEntity<Iterable<ProdutoResponseDTO>> listar() {

        var produtos = service.listarTodos();

        var resposta = StreamSupport.stream(produtos.spliterator(), false)
                .map(ProdutoResponseDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(resposta);
    }

    @Operation(summary = "Buscar produto por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscar(
            @PathVariable Long id) {

        Produto produto = service.buscarPorId(id);

        return ResponseEntity.ok(
                ProdutoResponseDTO.fromEntity(produto));
    }

    @Operation(summary = "Cadastrar novo produto")
    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criar(
            @Valid @RequestBody ProdutoRequestDTO dto) {

        Produto produto = new Produto();

        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produto.setDescricao(dto.descricao());

        Produto salvo = service.salvar(produto);

        return ResponseEntity.status(201)
                .body(ProdutoResponseDTO.fromEntity(salvo));
    }

    @Operation(summary = "Atualizar produto")
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ProdutoRequestDTO dto) {

        Produto produto = new Produto();

        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produto.setDescricao(dto.descricao());

        Produto atualizado = service.atualizar(id, produto);

        return ResponseEntity.ok(
                ProdutoResponseDTO.fromEntity(atualizado));
    }

    @Operation(summary = "Remover produto")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }

}