package CabanasSyC.service;

import java.util.List;
import CabanasSyC.domain.Contact;

public interface ContactService {
    public List<Contact> getAllContacts();

    public Contact getContactById(Long id);

    public void saveOrUpdate(Contact contact);
    
    public void deleteContact(Long id);
}
