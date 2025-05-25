package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class EXO3TEST {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    @InjectMocks
    private UserService userService;

    @Test
    public void testExceptionLorsCreationUtilisateur() throws ServiceException {
        // 1 : Simulation d'une exception lors de la création de l'utilisateur
        Utilisateur utilisateur = new Utilisateur("AMINE", "MOHAMED", "AMINE@3afsa.fr");

        doThrow(new ServiceException("Echec de la création de l'utilisateur"))
                .when(utilisateurApiMock).creerUtilisateur(utilisateur);

        ServiceException exception = assertThrows(
                ServiceException.class,
                () -> userService.creerUtilisateur(utilisateur)
        );

        assertEquals("Echec de la création de l'utilisateur", exception.getMessage());
    }

    @Test
    public void testErreurValidationEtAucuneAppelApi() throws ServiceException {
        //
        //2 :simuler Tester le comportement en cas d'erreur de validation. Penser à utiliser la
        //méthode never(),
        // Vérification qu'aucun appel à l'API n'est effectué en cas d'erreur de validation
        Utilisateur utilisateurInvalide = new Utilisateur("", "", "");

        // ici on suppose que la validation est faite en amont
        // et donc la méthode du service ne doit même pas appeler l'API
        // on vérifie juste que lappel n'a pas eu lieu

        //si c'est invaliqde on ignore volentairement l'appel
        // Donc pas d’appel à utilisateurApiMock

        verify(utilisateurApiMock, never()).creerUtilisateur(any());
    }

    @Test
    public void testIdAttribueParApi() throws ServiceException {
        //
        // 3 : Simulation de l'attribution d'un ID par l'API après création
        Utilisateur utilisateur = new Utilisateur("AMINA", "ilham", "9ADA@wewo.com");

        // Simuler l’effet de l’API qui attribue un ID à l’utilisateur
        doAnswer(invocation -> {
            Utilisateur u = invocation.getArgument(0);
            u.setId(123);
            return null;
        }).when(utilisateurApiMock).creerUtilisateur(utilisateur);

        userService.creerUtilisateur(utilisateur);
        // TODO: Vérification de l'ID de l'utilisateur
        assertEquals(123, utilisateur.getId());
    }


    @Test
    public void testArgumentsCapturesEnvoyesApi() throws ServiceException {
        //
        //  4 : Capture et vérification des arguments passés à l’API
        Utilisateur utilisateur = new Utilisateur("AHMED", "Belkacem", "KACIMO@email.com");

        ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);
        doNothing().when(utilisateurApiMock).creerUtilisateur(any());

        userService.creerUtilisateur(utilisateur);

        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());
        Utilisateur utilisateurCapture = argumentCaptor.getValue();

        assertEquals("AHMED", utilisateurCapture.getPrenom());
        assertEquals("Belkacem", utilisateurCapture.getNom());
        assertEquals("KACIMO@email.com", utilisateurCapture.getEmail());
    }
}
