package CabanasSyC.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import CabanasSyC.dao.RolDao;
import CabanasSyC.domain.Rol;
import CabanasSyC.service.RolService;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    private RolDao rolDao;

    @Override
    @Transactional
    public Rol getRolById(Long id){
        return rolDao.findById(id).get();
    }
}
