package com.yrf.service;

import com.yrf.domain.mysql.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UsersService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean addUsers(Users myUser){
        String sql = "insert into Users(uname,upwd)values(?,?)";
        String pwd = getMD5(myUser.getUpwd());
        int flag = jdbcTemplate.update(sql,myUser.getUname(),pwd);
        if(flag > 0){
            return true;
        }
        return false;
    }

    public Users findByUName(String parUName){
        String sql = "select * from Users where uname = ?";
        List<Map<String,Object>> data = jdbcTemplate.queryForList(sql,parUName);
        if(!data.isEmpty()){
            Map<String,Object> row = data.get(0);
            Users myUser = new Users();
            myUser.setUid(Integer.parseInt(row.get("uid").toString()));
            myUser.setUname(row.get("uname").toString());
            myUser.setUpwd(row.get("upwd").toString());
            myUser.setAuthority(Integer.parseInt(row.get("authority").toString()));
            return myUser;
        }
        return null;
    }

    public List<Users> findByAll(int authority){
        String sql = "select * from Users where authority = ?";
        List<Users> data;
        data = (List<Users>) jdbcTemplate.query(sql, new ResultSetExtractor() {
                    @Override
                    public List<Users> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                        List<Users> usersList = new ArrayList<>();
                        while (resultSet.next()){
                            Users users = new Users();
                            users.setUid(resultSet.getInt("uid"));
                            users.setUname(resultSet.getString("uname"));
                            users.setAuthority(resultSet.getInt("authority"));
                            usersList.add(users);
                        }
                        return usersList;
                    }
                }, authority);


        return data;
    }


    public boolean updateUsers(String name,int select){
        String sql = "update Users set authority = "+select+" where uname = "+"\'"+name+"\'";
        //System.out.println(sql);
        int flag = jdbcTemplate.update(sql);
        if(flag > 0){
            return true;
        }
        return false;
    }

















    /**
     * 生成md5
     * @param message
     * @return
     */
    public  String getMD5(String message) {
        String md5str = "";
        try {
            //1 创建一个提供信息摘要算法的对象，初始化为md5算法对象
            MessageDigest md = MessageDigest.getInstance("MD5");

            //2 将消息变成byte数组
            byte[] input = message.getBytes();

            //3 计算后获得字节数组,这就是那128位了
            byte[] buff = md.digest(input);

            //4 把数组每一字节（一个字节占八位）换成16进制连成md5字符串
            md5str = bytesToHex(buff);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5str;
    }

    /**
     * 二进制转十六进制
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer md5str = new StringBuffer();
        //把数组每一字节换成16进制连成md5字符串
        int digital;
        for (int i = 0; i < bytes.length; i++) {
            digital = bytes[i];

            if(digital < 0) {
                digital += 256;
            }
            if(digital < 16){
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toUpperCase();
    }


}
