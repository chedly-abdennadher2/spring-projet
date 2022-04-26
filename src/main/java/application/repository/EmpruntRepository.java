package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Emprunt;
import application.model.EmpruntPK;

public interface EmpruntRepository  extends JpaRepository <Emprunt,EmpruntPK>{

}
