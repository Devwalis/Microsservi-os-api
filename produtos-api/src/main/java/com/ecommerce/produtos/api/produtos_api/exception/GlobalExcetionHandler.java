package com.ecommerce.produtos.api.produtos_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExcetionHandler {
        @ExceptionHandler(AutenticacaoException.class)
        public ResponseEntity<String> tratarAutenticacaoException(AutenticacaoException ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
        }

       /* @ExceptionHandler(JRException.class)
        public ResponseEntity<String> tratarJasperException(JRException ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }*/

    
}
