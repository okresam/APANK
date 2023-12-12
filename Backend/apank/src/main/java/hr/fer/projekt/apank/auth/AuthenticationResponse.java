package hr.fer.projekt.apank.auth;

import hr.fer.projekt.apank.model.Korisnik;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private String token;
    private String ime;
    private String prezime;
    private String email;
    private Long idKorisnika;
}
