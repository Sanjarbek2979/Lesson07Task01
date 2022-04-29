package com.example.task01.aop;

import com.example.task01.entity.User;
import com.example.task01.exceptions.ForbiddenException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Sanjarbek Allayev, вс 16:14. 24.04.2022
 */
@Component
@Aspect
public class CheckPermissionExecutor {
   @Before(value = "@annotation(checkPermission)")
    public void checkUserPermissionMyMethod(CheckPermission checkPermission){
//       String value = checkPermission.value();
       User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//       if (user.getAuthorities().stream().filter())
       boolean exist=false;
       for (GrantedAuthority authority : user.getAuthorities()) {
           if (authority.getAuthority().equals(checkPermission.value())){
               exist=true;
               break;
           }
       }
       if (!exist)
           throw new ForbiddenException(checkPermission.value(),"Ruxsat yo`q");
   }
}
