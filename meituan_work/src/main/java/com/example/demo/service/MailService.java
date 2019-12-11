package com.example.demo.service;

/**
 * @Author Mcorleon
 * @Date 2019/11/26 18:32
 */
public interface MailService {
    boolean sendMail(String to,String subject,String content);
}
