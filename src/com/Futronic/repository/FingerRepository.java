package Futronic.repository;

import Futronic.model.Fingerprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FingerRepository extends JpaRepository<Fingerprint,Integer> {

}
