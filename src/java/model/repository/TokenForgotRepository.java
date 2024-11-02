package model.repository;

import model.Entity.TokenForgetPassword;

import java.time.LocalDateTime;

public interface TokenForgotRepository {
    boolean insertTokenForgot(TokenForgetPassword tokenForgetPassword);
    String getFormatDate(LocalDateTime date);
}
