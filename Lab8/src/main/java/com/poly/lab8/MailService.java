package Lab8.service;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public interface MailService {
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Mail {
	    @Builder.Default
	    private String from = "WebShop <web-shop@gmail.com>";
	    private String to, cc, bcc, subject, body, filenames;
	}
    void send(Mail mail);

    // push mail vào hàng đợi
    void push(Mail mail);

    default void send(String to, String subject, String body) {
        Mail mail = Mail.builder()
                .to(to)
                .subject(subject)
                .body(body)
                .build();
        this.send(mail);
    }

    default void push(String to, String subject, String body) {
        Mail mail = Mail.builder()
                .to(to)
                .subject(subject)
                .body(body)
                .build();
        this.push(mail);
    }
}
