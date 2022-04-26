package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Achat;
import application.model.AchatPK;

public interface AchatRepository extends JpaRepository<Achat,AchatPK>{

}
