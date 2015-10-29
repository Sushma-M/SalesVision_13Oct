/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the source code license agreement you entered into with wavemaker-com*/

package com.salesdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wavemaker.runtime.data.dao.*;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.salesdb.*;


/**
 * ServiceImpl object for domain model class States.
 * @see com.salesdb.States
 */
@Service("salesdb.StatesService")
public class StatesServiceImpl implements StatesService {


    private static final Logger LOGGER = LoggerFactory.getLogger(StatesServiceImpl.class);

    @Autowired
    @Qualifier("salesdb.StatesDao")
    private WMGenericDao<States, Integer> wmGenericDao;
    public void setWMGenericDao(WMGenericDao<States, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "salesdbTransactionManager")
     public Page<States> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "salesdbTransactionManager")
    @Override
    public States create(States states) {
        LOGGER.debug("Creating a new states with information: {}" , states);
        return this.wmGenericDao.create(states);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "salesdbTransactionManager")
    @Override
    public States delete(Integer statesId) throws EntityNotFoundException {
        LOGGER.debug("Deleting states with id: {}" , statesId);
        States deleted = this.wmGenericDao.findById(statesId);
        if (deleted == null) {
            LOGGER.debug("No states found with id: {}" , statesId);
            throw new EntityNotFoundException(String.valueOf(statesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Page<States> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all statess");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Page<States> findAll(Pageable pageable) {
        LOGGER.debug("Finding all statess");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public States findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding states by id: {}" , id);
        States states=this.wmGenericDao.findById(id);
        if(states==null){
            LOGGER.debug("No states found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return states;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "salesdbTransactionManager")
    @Override
    public States update(States updated) throws EntityNotFoundException {
        LOGGER.debug("Updating states with information: {}" , updated);
        this.wmGenericDao.update(updated);
        return this.wmGenericDao.findById((Integer)updated.getId());
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

