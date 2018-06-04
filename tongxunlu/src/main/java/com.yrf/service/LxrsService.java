package com.yrf.service;


import com.yrf.domain.mongo.LxrDetail;
import com.yrf.domain.mongo.Lxrs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class LxrsService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public boolean addLxr(Lxrs lxr){
        /**
         * 1.判断是否有lxrs集合
         * 2.如果有，不说了，操作
         * 3.如果没有，创建
         */
        if(!mongoTemplate.collectionExists("lxrs")){
            mongoTemplate.createCollection(Lxrs.class);
        }

        /**
         * 1.判断该用户是否有联系人
         * 2.如果没有，insert操作
         * 3.如果有，update操作
         */

        Query query = new Query();
        query.addCriteria(where("uname").is(lxr.getUname()));
        List<Lxrs> data = mongoTemplate.find(query,Lxrs.class);
        //System.out.println(data.get(0).getUname());
        if(data.isEmpty()){
            mongoTemplate.save(lxr);
        }else{
            mongoTemplate.updateFirst(
                    query,
                    new Update().push("lxrdetails",lxr.getLxrDetails().get(0)).inc("num",1),
                    Lxrs.class
            );
        }

        return true;
    }

    public List<LxrDetail> findByAll(String name){
        Query query = new Query();
        query.addCriteria(where("uname").is(name));
        List<Lxrs> data = mongoTemplate.find(query,Lxrs.class);
        if(data.isEmpty()){
            return null;
        }else{
            List<LxrDetail> list;
            list = data.get(0).getLxrDetails();
          //  System.out.println(list.get(0).getLxrname());
            return list;
        }

    }


    public boolean updateLxrs(String text,String select,String modify,String uname){
        Query query = Query.query(Criteria.where("uname").is(uname)
                .and("lxrdetails."+select).is(text));
        mongoTemplate.updateFirst(
                query,
                new Update().set("lxrdetails.$."+select, modify),
                Lxrs.class
                );
        return true;
    }


    public boolean delLxrs(String text,String select,String uname){
        Query query = Query.query(Criteria.where("uname").is(uname)
                .and("lxrdetails."+select).is(text));
       /* Update update = new Update();
        update.unset("lxrdetails.$");
        mongoTemplate.updateFirst(query, update, Lxrs.class);*/
        mongoTemplate.remove(query,LxrDetail.class);
        return true;
    }


}
