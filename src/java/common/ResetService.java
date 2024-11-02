package common;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.time.LocalDateTime;
import java.util.Properties;
import java.util.UUID;

public class ResetService {
    private final int LIMIT_MINUS = 10;
    private final String from = "tranduykhang159@gmail.com";
    private final String password = "kiwf xuan iuqu atnl"; // Sử dụng mật khẩu ứng dụng nếu có thể

    public String generateToken() {
        return UUID.randomUUID().toString();
    }

    public LocalDateTime expireDateTime() {
        return LocalDateTime.now().plusMinutes(LIMIT_MINUS);
    }

    public boolean isExpiredTime(LocalDateTime localDateTime) {
        return LocalDateTime.now().isAfter(localDateTime);
    }

    public boolean SendMail(String toEmail, String link, String name) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Authenticator authenticator = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };

        // Sử dụng Authenticator trong Session
        Session session = Session.getInstance(properties, authenticator);

        MimeMessage message = new MimeMessage(session);

        try {
            message.addHeader("Content-Type", "text/html; charset=UTF-8"); // Sửa lỗi chính tả
            message.setFrom(new InternetAddress(from, "My Website")); // Cung cấp tên hiển thị
            message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(toEmail, false));
            message.setSubject("Reset Password", "UTF-8");

            // Nội dung email
            String content = "<h1>Hello " + name + "</h1>" +
                    "<p>Your password has been changed to a temporary password. Please log in to reset your password." +
                    " <a href='" + link + "'>LOGIN</a></p>";
            message.setContent(content, "text/html; charset=utf-8");

            // Gửi email
            Transport.send(message);
            System.out.println("Email sent successfully");
            return true;
        } catch (Exception e) {
            System.out.println("Send Error: " + e.getMessage());
            return false;
        }
    }
}
