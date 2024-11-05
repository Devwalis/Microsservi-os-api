package com.ecommerce.pedidos.api.pedidos_api.filter;

import java.io.IOException;
import java.util.Objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ecommerce.pedidos.api.pedidos_api.context.UsuarioContext;
import com.ecommerce.web.client.web_client.exception.AutenticacaoException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.java.com.ecommerce.web.client.web_client.usuario.UsuarioDTO;

@Component
public class SecurityFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException{
            String authorization = request.getHeader("Authorization");

            try{
                if(Objects.nonNull(authorization)){
                    String token = authorization.replace("Bearer ", "");

                    if (Objects.isNull(token) || token.isEmpty()) {
                        throw new AutenticacaoException("JWT ausente.");

                    }

                    RestTemplate template = new RestTemplate();
                    String url = String.format("%s/auth/validar?token=%s", usuarioWsURL, token);

                    ResponseEntity<UsuarioDTO> usuarioResponse = template.getForEntity(url, UsuarioDTO.class);

                    if(usuarioResponse.getStatusCode() == HttpStatus.OK && Objects.nonNull(usuarioResponse.getBody())){
                        usuarioContext.setUsuarioDTO(usuarioResponse.getBody());

                    }else{
                        throw new AutenticacaoException("Falha ao validar o token.");
                    }  
                    }else{
                        throw new AutenticacaoException("Cabeçalho Authorization ausente.");
                    }

                    filterChain.doFilter(request, response);

                } catch(AutenticacaoException e){
                    //Envia um erro 403 com a mensagem da exceção
                    response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
                } catch(HttpClientErrorException | HttpServerErrorException e) {
                    // Envia um erro 403 com a mensagem da exceção de cliente ou servidor
                    response.sendError(HttpServletResponse.SC_FORBIDDEN, "Erro ao validar o token: " + e.getStatusCode());
                   
                }catch (ResourceAccessException e){
                    // Falha na comunicação o seviço de autenticação
                    response.sendError(HttpServletResponse.SC_FORBIDDEN, "Falha na comunicação com o serviço de autenticação.");

                } catch (Exception e){
                    // Qualquer outra exceção inesperada
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro desconhecido.");
                }
                }
                @Value(value = "${usuario.ws.url}")
                private String usuarioWsURL;

                @Autowired
                private UsuarioContext usuarioContext;

                }
       
    

