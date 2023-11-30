package com.si.tpIntegration.entite;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employes")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String matricule;
    //@Column(name = "nom_employe") pour changer le nom de la colonne
    private String nom;
    private String prenom;
    private String sexe;
    private LocalDate date_naissance;
}
