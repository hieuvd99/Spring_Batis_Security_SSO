package com.greenfoarfece.smb.dao;

import java.util.ArrayList;
import java.util.List;

import com.greenfoarfece.smb.domain.User;

/**
 * Interface contains basic CRUD operation for all entity.
 *
 * @since 14 Mar 2017
 * @version 1.0-SNAPSHOT
 * @author Sayid Sidqi
 */
public interface CommonDao<T, PK> {

	/**
	 * Method to persist new entity to database.
	 *
	 * @param entity {@link T} object to be persisted
	 * @return {@link int} the number of rows affected by the insert or null if entity was failed to be persisted
	 */
	public Long insert(T entity);

	/**
	 * Method to select id based on its identifier.
	 *
	 * @param id {@link PK} the key/identifier
	 * @return {@link T} the persistent object based on given key or null if there's no such entity found
	 */
	public T find(PK id);

	/**
	 * Method to select all record of entity class.
	 *
	 * @return {@link ArrayList}&lt;{@link T}&gt; the populated objects or null if the record is empty
	 */
	public List<T> findAll();

	/**
	 * Method to update existing data on database.
	 *
	 * @param entity {@link T} object to be updated
	 * @return {@link int} the number of rows affected by the update or null if update process was not successfully executed
	 */
	public Long update(T entity);

	/**
	 * Method to remove data from database based on its identifier.
	 *
	 * @param id {@link PK} the key/identifier
	 * @return {@link int} the number of rows affected by the delete or null if error occurs when removing data
	 */
	public Long delete(PK id);


}
