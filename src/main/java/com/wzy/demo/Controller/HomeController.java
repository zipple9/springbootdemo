package com.wzy.demo.Controller;



//import com.wzy.demo.Dao.Dao;
import com.wzy.demo.Dao.MyDao;
import com.wzy.demo.Log.LogAction;
import com.wzy.demo.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HomeController {
    @Autowired
    private MyDao md;
    @Autowired
    private UserService us;


    private Logger logger = LoggerFactory.getLogger(this.getClass());





    @RequestMapping("/{username}")
    public String query(@PathVariable("username") String username){
        return md.getPassword(username);
    }
//    @RequestMapping("/listRoles/{username}")
//    public Set<String> listRoles(@PathVariable("username") String username){
//        Set<String> roleslist=um.listRoles(username);
//        return roleslist;
//    }
//
//    @RequestMapping("/listPermissions/{username}")
//    public Set<String> listPermissions(@PathVariable("username") String username){
//        Set<String> permissionslist=um.listPermissions(username);
//        return permissionslist;
//    }
//
    @RequestMapping("/test")
    public String restTest(){
        System.out.println("/" + Thread.currentThread().getStackTrace()[1].getMethodName());

        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        Object principal=auth.getPrincipal();


//        BCryptPasswordEncoder bCPE=new BCryptPasswordEncoder();
//        if(bCPE.matches("123456",md.getPassword("zhang3"))) {
//        logger.info("encoded password   equal");
//        }else{
//            logger.info("not equal");
//        }


        System.out.println(auth.isAuthenticated());
        if(principal instanceof UserDetails){
            return ((UserDetails) principal).getUsername()+"\n"+"Is authenticated"+auth.isAuthenticated();
        }
        else {
            return "no user"+"\n"+principal.toString();
        }


//        System.out.println(md.getPassword("zhang3"));
//        System.out.println(md.getRolesByUsername("zhang3").iterator().next().getName());
//
//        return um.getRolesByUsername("zhang3").iterator().next().getName();
//        System.out.println(md.getUserByUsername("zhang3").getUsername());
//        return md.getUserByUsername("zhang3").getRoles().getClass().toString();
    }






}