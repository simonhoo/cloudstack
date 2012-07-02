// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package com.cloud.network.dao;

import java.util.List;

import junit.framework.TestCase;

import com.cloud.network.ElasticLbVmMapVO;
import com.cloud.network.LoadBalancerVO;
import com.cloud.network.lb.dao.ElasticLbVmMapDaoImpl;
import com.cloud.utils.component.ComponentLocator;
import com.cloud.vm.DomainRouterVO;

public class ElbVmMapDaoTest extends TestCase {
    public void testFindByIp() {
        ElasticLbVmMapDaoImpl dao = ComponentLocator.inject(ElasticLbVmMapDaoImpl.class);
        
        ElasticLbVmMapVO map = dao.findOneByIp(3);
        if (map == null) {
           System.out.println("Not Found");   
        } else {
            System.out.println("Found");
        }
    }
    public void testFindUnused() {
        ElasticLbVmMapDaoImpl dao = ComponentLocator.inject(ElasticLbVmMapDaoImpl.class);
        
        List<DomainRouterVO> map = dao.listUnusedElbVms();
        if (map == null) {
           System.out.println("Not Found");   
        } else {
            System.out.println("Found");
        }
    }
    
    public void testFindLB() {
        ElasticLbVmMapDaoImpl dao = ComponentLocator.inject(ElasticLbVmMapDaoImpl.class);
        
        List<LoadBalancerVO> lbs = dao.listLbsForElbVm(12);
        if (lbs == null) {
           System.out.println("Not Found");   
        } else {
            System.out.println("Found " + lbs.size() + " lbs");
        }
    }
}
