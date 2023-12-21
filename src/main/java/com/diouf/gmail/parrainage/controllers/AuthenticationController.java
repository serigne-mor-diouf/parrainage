package com.diouf.gmail.parrainage.controllers;
import java.io.IOException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.diouf.gmail.parrainage.dto.AuthenticationDTO;
import com.diouf.gmail.parrainage.dto.AuthenticationResponse;
import com.diouf.gmail.parrainage.entites.Token;
import com.diouf.gmail.parrainage.entites.Utilisateur;
import com.diouf.gmail.parrainage.jwt.UserDetailsServiceImpl;
import com.diouf.gmail.parrainage.services.TokenService;
import com.diouf.gmail.parrainage.services.UtilisateurService;
import com.diouf.gmail.parrainage.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private  UtilisateurService  utilisateurService ; 

    @Autowired
    private TokenService tokenService ;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationDTO authenticationDTO) throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDTO.getEmail(), authenticationDTO.getPassword()));
            System.out.println("Connexion réussie");
        } catch (BadCredentialsException e) {
            System.out.println("Connexion échouée - Nom d'utilisateur ou mot de passe incorrect");
            throw new BadCredentialsException("Nom d'utilisateur ou mot de passe incorrect !");
        }

        // Récupérez le compte de l'utilisateur
        Utilisateur user = utilisateurService.findByEmail(authenticationDTO.getEmail());
        if (user == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé", null);
        }

        // Générez le token en utilisant le profil
        String token = tokenService.generateToken(user).getValeur();
        System.out.println("token = " + token);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    @GetMapping("/logout/{tokenValue}")
    public ResponseEntity<Object> logOut( @PathVariable String tokenValue){
        if (tokenService.isTokenUtilisateurValide(tokenValue)) {
            Token token =  tokenService.findToken(tokenValue);
            token.setRevoquer(true);
            token.setDeconnection(new Date());
            tokenService.updateToken(token);
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
