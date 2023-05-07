package com.greenfoarfece.smb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenfoarfece.smb.dao.PersonDao;
import com.greenfoarfece.smb.domain.Person;
import com.greenfoarfece.smb.service.PersonService;

/**
 * Implementation class of {@link PersonService}.
 *
 * @since 13 Apr 2017
 * @version 1.0-SNAPSHOT
 * @author Sayid Sidqi
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonDao personDao;

	@Override
	public Person getPerson() {
		return personDao.findByOccupation("Software Engineer"); 
	}

}
