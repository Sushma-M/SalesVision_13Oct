/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the source code license agreement you entered into with wavemaker-com*/

package com.salesdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.salesdb.*;

/**
 * Service object for domain model class Leads.
 * @see com.salesdb.Leads
 */

public interface LeadsService {
   /**
	 * Creates a new leads.
	 * 
	 * @param created
	 *            The information of the created leads.
	 * @return The created leads.
	 */
	public Leads create(Leads created);

	/**
	 * Deletes a leads.
	 * 
	 * @param leadsId
	 *            The id of the deleted leads.
	 * @return The deleted leads.
	 * @throws EntityNotFoundException
	 *             if no leads is found with the given id.
	 */
	public Leads delete(Integer leadsId) throws EntityNotFoundException;

	/**
	 * Finds all leadss.
	 * 
	 * @return A list of leadss.
	 */
	public Page<Leads> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Leads> findAll(Pageable pageable);
	
	/**
	 * Finds leads by id.
	 * 
	 * @param id
	 *            The id of the wanted leads.
	 * @return The found leads. If no leads is found, this method returns
	 *         null.
	 */
	public Leads findById(Integer id) throws EntityNotFoundException;
	/**
	 * Updates the information of a leads.
	 * 
	 * @param updated
	 *            The information of the updated leads.
	 * @return The updated leads.
	 * @throws EntityNotFoundException
	 *             if no leads is found with given id.
	 */
	public Leads update(Leads updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the leadss in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the leads.
	 */

	public long countAll();


    public Page<Leads> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

