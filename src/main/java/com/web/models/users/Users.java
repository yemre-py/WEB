package com.web.models.users;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

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
public class Users {


    @Id // NOTE: Bu annotasyon, bu alanın veritabanı tablosundaki birincil anahtar (primary key) olduğunu belirtir.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // NOTE: Bu, veritabanında otomatik artan bir değerle (IDENTITY stratejisiyle) id alanının değerlerinin oluşturulmasını sağlar.
    private int id;
    @NotBlank(message = "bu alan boş bırakılamaz")
    private String username;
    @NotBlank(message = "bu alan boş bırakılamaz")
    private String password;
    @NotBlank(message = "bu alan boş bırakılamaz")
    private String email;
    @CreatedDate
    private LocalDateTime createdAt;
}
