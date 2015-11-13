package net.dreamlu.interceptor;

import net.dreamlu.config.Consts;
import net.dreamlu.model.Options;
import net.dreamlu.model.User;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;
import com.jfinal.core.JFinal;
import com.jfinal.kit.StrKit;

/**
 * 安装拦截
 * @author L.cm
 * @date Nov 2, 2013 2:05:00 PM
 */
public class InstallInterceptor implements Interceptor {

    @Override
    public void intercept(ActionInvocation ai) {
        Controller controller = ai.getController();
        if (!Consts.IS_INSTALL) {
            // 1.用户跳转到安装页
            long userCount = User.dao.findCounts();
            if (userCount < 1) {
                String ctxPath = JFinal.me().getContextPath();
                Options options = Options.dao.findByCache();
                if (StrKit.notBlank(ctxPath) && StrKit.isBlank(options.getStr(Options.CDN_PATH))) {
                    options.set(Options.CDN_PATH, ctxPath);
                    options.update();
                }
                ai.getController().setAttr("options", options);
                controller.render("/admin/install.vm");
                return;
            } else {
                Consts.IS_INSTALL = true;
            }
        }
        ai.invoke();
    }

}
