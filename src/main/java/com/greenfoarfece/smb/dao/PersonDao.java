package com.greenfoarfece.smb.dao;

import com.greenfoarfece.smb.domain.Person;

/**
 * Interface contains basic and custom CRUD for {@link Person} entity.
 *
 * @since 13 Apr 2017
 * @version 1.0-SNAPSHOT
 * @author Sayid Sidqi
 */
public interface PersonDao extends CommonDao<Person, Long> {
	
	public Person findByOccupation(String occupation);

}
