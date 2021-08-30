package com.ofben.autordemo.config.shiro;

import net.rubyeye.xmemcached.MemcachedClient;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 公共 Session， 从 redis 或者 MemCached
 *
 * @date 2021-08-16
 * @since 1.0.0
 */
public class SessionDAO extends AbstractSessionDAO {

    private static final int EXPIRE_TIME = 1 * 60;

    @Autowired
    private MemcachedClient mcc;

    @Override
    public void update(Session session) throws UnknownSessionException {
        try {
            mcc.set(session.getId().toString(),  EXPIRE_TIME, session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Session session) {
        try {
            mcc.delete(session.getId().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Session> getActiveSessions() {
        // TODO --
        return new ArrayList<>();
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sid = this.generateSessionId(session);
        assignSessionId(session, sid);
        try {
            mcc.add(sid.toString(), EXPIRE_TIME, session);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sid;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        Session session = null;
        try {
            session = mcc.get(sessionId.toString());
            // 计算过期时间，是从最后一次的使用开始
            mcc.set(sessionId.toString(), EXPIRE_TIME, session);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }
}
