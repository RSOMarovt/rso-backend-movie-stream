package com.rso.stream.interceptors;

import com.kumuluz.ee.common.runtime.EeRuntime;
import com.kumuluz.ee.configuration.utils.ConfigurationUtil;
import com.kumuluz.ee.logs.cdi.Log;
import org.apache.logging.log4j.CloseableThreadContext;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.security.auth.login.Configuration;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by urbanmarovt on 28/12/2017.
 */
@Log
@Interceptor
@Priority(Interceptor.Priority.PLATFORM_BEFORE)
public class LogInterceptor {

    @AroundInvoke
    public Object logMethodEntryAndExit(InvocationContext context) throws Exception {

        ConfigurationUtil configurationUtil = ConfigurationUtil.getInstance();

        HashMap settings = new HashMap();

        settings.put("environmentType", configurationUtil.get("kumuluzee.env.name").orElse(null));
        settings.put("applicationName", configurationUtil.get("kumuluzee.name").orElse(null));
        settings.put("applicationVersion", configurationUtil.get("kumuluzee.version").orElse(null));
        settings.put("uniqueInstanceId", EeRuntime.getInstance().getInstanceId());

        settings.put("uniqueRequestId", UUID.randomUUID().toString());

        try {
            final CloseableThreadContext.Instance ctc = CloseableThreadContext.putAll(settings);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            Object result = context.proceed();
            return result;
        }

    }
}
