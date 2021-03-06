/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the source code license agreement you entered into with wavemaker-com*/

package com.salesdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;





/**
 * Quotes generated by hbm2java
 */
@Entity
@Table(name="QUOTES"
    ,schema="PUBLIC"
    ,catalog="PUBLIC"
)
public class Quotes  implements java.io.Serializable {


     private Integer id;
     private Reps reps;
     private Leads leads;
     private Date entryDate;
     private Integer estimatedSale;
     private Set<Sales> saleses = new HashSet<Sales>(0);
     private Set<FollowUps> followUpses = new HashSet<FollowUps>(0);

    public Quotes() {
    }

    public Quotes(Reps reps, Leads leads, Date entryDate, Integer estimatedSale, Set<Sales> saleses, Set<FollowUps> followUpses) {
       this.reps = reps;
       this.leads = leads;
       this.entryDate = entryDate;
       this.estimatedSale = estimatedSale;
       this.saleses = saleses;
       this.followUpses = followUpses;
    }

     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="REP_ID")
    public Reps getReps() {
        return this.reps;
    }
    
    public void setReps(Reps reps) {
        this.reps = reps;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="LEAD_ID")
    public Leads getLeads() {
        return this.leads;
    }
    
    public void setLeads(Leads leads) {
        this.leads = leads;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ENTRY_DATE", length=10)
    public Date getEntryDate() {
        return this.entryDate;
    }
    
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    
    @Column(name="ESTIMATED_SALE")
    public Integer getEstimatedSale() {
        return this.estimatedSale;
    }
    
    public void setEstimatedSale(Integer estimatedSale) {
        this.estimatedSale = estimatedSale;
    }

@OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="quotes")
    public Set<Sales> getSaleses() {
        return this.saleses;
    }
    
    public void setSaleses(Set<Sales> saleses) {
        this.saleses = saleses;
    }

@OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="quotes")
    public Set<FollowUps> getFollowUpses() {
        return this.followUpses;
    }
    
    public void setFollowUpses(Set<FollowUps> followUpses) {
        this.followUpses = followUpses;
    }



public boolean equals(Object o) {
         if (this == o)
         return true;
		 if ( (o == null ) )
		 return false;
		 if ( !(o instanceof Quotes) )
		 return false;

		 Quotes that = ( Quotes ) o;

		 return ( (this.getId()==that.getId()) || ( this.getId()!=null && that.getId()!=null && this.getId().equals(that.getId()) ) );

   }

   public int hashCode() {
         int result = 17;

         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );

         return result;
     }


}

