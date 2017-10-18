package com.sucaiji.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by sucaiji on 2017/10/9.
 */
public class TestRealm implements Realm {
    @Override
    public String getName() {
        return "TestRealm";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        //直接返回true
        return true;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String count=(String)authenticationToken.getPrincipal();
        String password=new String((char[]) authenticationToken.getCredentials());
        if (!count.equals("spz")){
            throw new UnknownAccountException();
        }
        if(!password.equals("123")){
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(count,password,this.getName());
    }
}
