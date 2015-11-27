package net.dreamlu.controller.web;

import java.util.HashMap;
import java.util.Map;

import net.dreamlu.config.Consts;
import net.dreamlu.kit.MailKit;
import net.dreamlu.model.Blog;
import net.dreamlu.model.Options;
import net.dreamlu.utils.StringUtil;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import com.jfinal.plugin.activerecord.Page;

/**
 * 测试专用
 * @author l.cm
 * @site:www.dreamlu.net
 * 2014年3月23日 上午10:51:54
 */

@ControllerBind(controllerKey = "/test", viewPath="web")
public class TController extends Controller {
	
	public void index () {
		Map<String, Object> model = new HashMap<String, Object>();
//    	Options options = Options.dao.findByCache();
    	
//        model.put("options", options);
        
        
        model.put("user", "dreamlu");
        String pwd = StringUtil.randomPwd(8);
        model.put("pwd", pwd);
        setAttr("postsby", false);
       
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Blog.BLOG_TYPE, null);
        Page<Blog> page = Blog.dao.page(getParaToInt(0, 1), Consts.BLOG_PAGE_SIZE, result);
        setAttr("blogPage", page);
        
        //setAttr("actionUrl", "");//转发请求路径
        
     //   renderNull();
        render("test.vm");
	}
}
