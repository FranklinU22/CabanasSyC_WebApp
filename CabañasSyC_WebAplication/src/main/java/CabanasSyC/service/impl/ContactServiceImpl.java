package CabanasSyC.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import CabanasSyC.dao.ContactDao;
import CabanasSyC.domain.Contact;
import CabanasSyC.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactDao contactDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Contact> getAllContacts() {
        return contactDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Contact getContactById(Long id) {
        return contactDao.findById(id).get();
    }

    @Override
    @Transactional
    public void saveOrUpdate(Contact contact) {
        contactDao.save(contact);
    }

    @Override
    @Transactional
    public void deleteContact(Long id) {
        contactDao.deleteById(id);
    }
    
}
