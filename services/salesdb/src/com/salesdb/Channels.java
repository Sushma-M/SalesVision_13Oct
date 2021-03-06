/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the source code license agreement you entered into with wavemaker-com*/

package com.salesdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;





/**
 * Channels generated by hbm2java
 */
@Entity
@Table(name="CHANNELS"
    ,schema="PUBLIC"
    ,catalog="PUBLIC"
)
public class Channels  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Set<Reps> repses = new HashSet<Reps>(0);

    public Channels() {
    }

	
    public Channels(String name) {
        this.name = name;
    }
    public Channels(String name, Set<Reps> repses) {
       this.name = name;
       this.repses = repses;
    }

     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="NAME", nullable=false, length=40)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="channels")
    public Set<Reps> getRepses() {
        return this.repses;
    }
    
    public void setRepses(Set<Reps> repses) {
        this.repses = repses;
    }



public boolean equals(Object o) {
         if (this == o)
         return true;
		 if ( (o == null ) )
		 return false;
		 if ( !(o instanceof Channels) )
		 return false;

		 Channels that = ( Channels ) o;

		 return ( (this.getId()==that.getId()) || ( this.getId()!=null && that.getId()!=null && this.getId().equals(that.getId()) ) );

   }

   public int hashCode() {
         int result = 17;

         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );

         return result;
     }


}

