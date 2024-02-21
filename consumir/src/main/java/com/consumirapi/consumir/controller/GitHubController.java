package com.consumirapi.consumir.controller;

import com.consumirapi.consumir.client.GithubCliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class GitHubController {

    private GithubCliente githubCliente;

    public GitHubController(GithubCliente githubCliente) {
        this.githubCliente = githubCliente;
    }

    @GetMapping("/repos")
    public ResponseEntity<List<RepositoryResponse>> listRespons(@RequestHeader("Authorization") String token) {
        // Chama o método do cliente Github passando os parâmetros necessários
        List<RepositoryResponse> repos = githubCliente.listaRespos(
                "Baerer"+ token, // token de autorização
                "2022-11-28", // versão da API
                "public" // visibilidade
        );

        // Retorna a lista de repositórios na resposta
        return ResponseEntity.ok(repos);
    }
}