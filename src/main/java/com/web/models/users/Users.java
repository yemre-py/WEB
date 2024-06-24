package com.web.models.users;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
// NOTE: Lombok tarafından sağlanan bir annotasyon. Bu, sınıf için toString, equals, hashCode,getter/setter gibi
//  standart metotları otomatik olarak oluşturur.
@AllArgsConstructor
@NoArgsConstructor
// NOTE: Bu annotasyonlar, sınıf için parametreli ve parametresiz constructor'ları otomatik olarak ekler.
@Builder
// NOTE: Lombok tarafından sağlanan bir başka annotasyon. Bu, builder desenini kullanarak nesne oluşturmayı kolaylaştırır.
@Entity
// NOTE: Bu annotasyon, sınıfın bir JPA (Java Persistence API) varlığı olduğunu belirtir. Veritabanında bir tabloya karşılık gelir.
@EntityListeners(AuditingEntityListener.class)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "username"), @UniqueConstraint(columnNames = "email")})
public class Users {

 // TODO:
    // EXPLAIN: sd
    @Id // NOTE: Bu annotasyon, bu alanın veritabanı tablosundaki birincil anahtar (primary key) olduğunu belirtir.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // NOTE: Bu, veritabanında otomatik artan bir değerle (IDENTITY stratejisiyle) id alanının değerlerinin oluşturulmasını sağlar.
    private Long id;

    @NotBlank(message = "bu alan boş bırakılamaz")
    @Column(unique = true)
    private String username;


    @NotBlank(message = "bu alan boş bırakılamaz")
    @Pattern(message = "Harf, rakam ve özel karakterlerin bulunduğu bir parola", regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
    private String password;

    @Column(unique = true)
    @NotBlank(message = "bu alan boş bırakılamaz")
    private String email;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
