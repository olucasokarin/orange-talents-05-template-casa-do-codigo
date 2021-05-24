package br.com.zupedu.olucas.casadocodigo.locality.repository;

import br.com.zupedu.olucas.casadocodigo.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
