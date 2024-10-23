package CabanasSyC.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import CabanasSyC.domain.Contact;

public interface ContactDao extends JpaRepository<Contact, Long> {}
