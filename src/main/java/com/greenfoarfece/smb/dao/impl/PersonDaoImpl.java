package com.greenfoarfece.smb.dao.impl;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.greenfoarfece.smb.dao.PersonDao;
import com.greenfoarfece.smb.domain.Person;
import com.greenfoarfece.smb.domain.User;

/**
 * Implementation class of {@link PersonDao}.
 *
 * @since 13 Apr 2017
 * @version 1.0-SNAPSHOT
 * @author Sayid Sidqi
 */
@Repository("personDao")
public class PersonDaoImpl extends CommonDaoImpl<Person, Long> implements PersonDao {

	private static final Logger LOG = LoggerFactory.getLogger(PersonDaoImpl.class);

	@Override
	public Person findByOccupation(String occupation) {
		SqlSession session = getSqlSessionFactory().openSession();
		Person entity = null;
		try {
			String className = getType().getSimpleName();
			String query = className + SUFFIX_MAPPER + "." + PREFIX_SELECT_QUERY + className + "ByOccupation";
			entity = session.selectOne(query, occupation);
		} catch (PersistenceException pe) {
			LOG.error("Error occurs while finding the entity", pe);
		} finally {
			session.close();
		}
		return entity;
	}


}
