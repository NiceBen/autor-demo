//package com.ofben.autordemo.optimize;
//
//import javax.jms.*;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.activemq.jms.pool.PooledConnectionFactory;
//
///**
// * ActiveMQPool 对象池
// *
// * @date 2021-08-27
// * @since 1.0.0
// */
//public class ActiveMQPools {
//
//    /**
//     * 队列名称，从 Spring 配置注入
//     */
//    private String queueName = "";
//
//    /**
//     * ActiveMQ 的连接池工厂，从 Spring 注入
//     */
//    private PooledConnectionFactory pooledConnectionFactory = null;
//
//    /**
//     * 指定创建几个连接对象，默认是1，可以从 Spring 注入
//     */
//    private int connectionMaxCounts = 0;
//
//    /**
//     * 指定为每个连接对象缓存几个 Session 对象，可以从 Spring 注入
//     */
//    private int sessionPerConnectionMaxCounts = 0;
//
//    /**
//     * 指定了每个Session提交消息的阈值，也是每个 Session 对象缓存的消息的最大值
//     */
//    private int messageCountPerSession2Send = 100;
//
//    /**
//     * 指定 Session 每隔多长时间就要提交一次，单位毫秒
//     * 主要为了防止消息数量过少，达不到上述参数指定的阈值
//     */
//    private int sessionCommitInterval = 1000;
//
//    /**
//     * 指定每个 Session 对象缓存几个 Producer 对象，默认为 1
//     * 基本上 1 就够了，只是用来发送消息而已
//     */
//    private int producerPerSession = 1;
//
//    /**
//     * 缓存到目的地的连接对象
//     * key-第几个，也就是连接对象的编号
//     * value-对应的连接对象
//     */
//    private Map<Integer, Connection> mapConnection = new HashMap<>();
//
//    /**
//     * 表示当前取到第几个 Connection 对象，默认轮询方式
//     */
//    private int mapConnectionCount = 0;
//
//    /**
//     * 缓存操作的 Session 对象，一个连接对象可以有多个 Session
//     */
//    private Map<Connection, Map<Integer, Session>> mapSession = new HashMap<>();
//
//    /**
//     * 表示当前取到第几个 Session 对象，默认轮询方式
//     */
//    private int mapSessionCount = 0;
//
//    /**
//     * 缓存操作的 Producer 对象，一个 Session 可以有多个 Producer
//     * 目前只用 1 个
//     */
//    private Map<Session, Map<String, MessageProducer>> mapProducer = new HashMap<>();
//
//    /**
//     * 表示当前取到第几个 Producer 对象，默认轮训方式
//     */
//    private int mapProducerCount = 0;
//
//    /**
//     * 缓存每个 Session 对象创建的新的 ObjectMessage 对象
//     *
//     * {存在疑问，每隔 Session 中应该对应多个 message，
//     * 这里使用 Map<Session, ObjectMessage> 存放为 1-1
//     * 个人感觉应该使用 Map<Session, List<ObjectMessage>> 存放为 1-n}
//     */
//    private Map<Session, ObjectMessage> mapSessionObjectMessage = new HashMap<>();
//
//    /**
//     * 缓存每个 Session 里面等待发送的消息数量
//     */
//    private Map<Session, Integer> mapSessionMessage2Send = new HashMap<>();
//
//    /**
//     * 缓存每个 Session 对象上次提交发送消息的时间
//     */
//    private Map<Session, Long> mapSessionLastCommitTime = new HashMap<>();
//
//    /**
//     * 创建按照时间去提交消息的线程对象
//     */
//    private SessionCommitThread sct = new SessionCommitThread();
//
//    /**
//     * 表示 scr 线程是否已经启动运行中
//     */
//    private boolean sctIsRun = false;
//
//
//    /*----------- 需要 Spring 注入 -----------*/
//    public void setQueueName(String queueName) {
//        this.queueName = queueName;
//    }
//
//    public void setPooledConnectionFactory(PooledConnectionFactory pooledConnectionFactory) {
//        this.pooledConnectionFactory = pooledConnectionFactory;
//    }
//
//    public void setConnectionMaxCounts(int connectionMaxCounts) {
//        this.connectionMaxCounts = connectionMaxCounts;
//    }
//
//    public void setSessionPerConnectionMaxCounts(int sessionPerConnectionMaxCounts) {
//        this.sessionPerConnectionMaxCounts = sessionPerConnectionMaxCounts;
//    }
//
//    public void setMessageCountPerSession2Send(int messageCountPerSession2Send) {
//        this.messageCountPerSession2Send = messageCountPerSession2Send;
//    }
//
//    public void setSessionCommitInterval(int sessionCommitInterval) {
//        this.sessionCommitInterval = sessionCommitInterval;
//    }
//
//    /*----------- 初始化 -----------*/
//    /**
//     * 初始化连接池、创建需要缓存的对象
//     */
//    public void init() {
//        // 检查注入进来的连接池工厂的配置，如果比本实例需要的连接数和Session数少的话
//        // 需要动态调整连接池工厂的配置
//        if (pooledConnectionFactory.getMaxConnections() < this.connectionMaxCounts) {
//            pooledConnectionFactory.setMaxConnections(this.connectionMaxCounts + 1);
//        }
//        if (pooledConnectionFactory.getMaximumActiveSessionPerConnection() < this.sessionPerConnectionMaxCounts) {
//            pooledConnectionFactory.setMaximumActiveSessionPerConnection(this.sessionPerConnectionMaxCounts + 1);
//        }
//        // 防止流量控制
//        ((ActiveMQConnectionFactory) pooledConnectionFactory.getConnectionFactory()).setProducerWindowSize(Integer.MAX_VALUE);
//
//        // 初始化所有需要缓存的对象
//        try {
//            initCache();
//        } catch (JMSException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void initCache() throws JMSException {
//        for (int i = 0; i < this.connectionMaxCounts; i++) {
//            // 1级：Connection
//            Connection connection = pooledConnectionFactory.createConnection();
//            // 一定要 start，否则无法发送和接收消息
//            connection.start();
//            this.mapConnection.put(i + 1, connection);
//
//            // 2级：Session
//            Map<Integer, Session> tempMapSession = new HashMap<>();
//            for (int j = 0; j < this.sessionPerConnectionMaxCounts; j++) {
//                Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
//                tempMapSession.put(j + 1, session);
//
//                // 3级：ObjectMessage
//                ObjectMessage txtMsg = session.createObjectMessage();
//                this.mapSessionObjectMessage.put(session, txtMsg);
//
//                // 3级：Producer
//                Map<String, MessageProducer> tempMapProducer = new HashMap<>();
//                for (int k = 0; k < this.producerPerSession; k++) {
//                    Destination destination = session.createQueue(queueName);
//                    MessageProducer producer;
//                    producer = session.createProducer(destination);
//
//                    tempMapProducer.put(this.queueName + (k + 1), producer);
//                }
//                this.mapProducer.put(session, tempMapProducer);
//            }
//
//            // 把 Session 和 Connection 关联起来
//            mapSession.put(connection, tempMapSession);
//        }
//    }
//
//    /*----------- 提供一些方法给发送客户端使用 -----------*/
//
//    /**
//     * 获取连接对象，目前采用轮询的方式来获取缓存的对象
//     * @return
//     */
//    public synchronized Connection getConnection() {
//        ++this.mapConnectionCount;
//        Connection connection = this.mapConnection.get(mapConnectionCount);
//
//        if (this.mapConnectionCount % this.connectionMaxCounts == 0) {
//            this.mapConnectionCount = 0;
//        }
//        return connection;
//    }
//
//    /**
//     * 获取某个连接对象下的一个缓存的 Session 对象
//     * @param conn
//     * @return
//     */
//    public synchronized Session getSession(Connection conn) {
//        ++this.mapSessionCount;
//        Session session = this.mapSession.get(conn).get(this.mapSessionCount);
//
//        if (this.mapSessionCount % this.sessionPerConnectionMaxCounts == 0) {
//            this.mapSessionCount = 0;
//        }
//        return session;
//    }
//
//    /**
//     * 根据 Session 和 队列名称 来获取缓存的 producer
//     * @param session
//     * @return
//     */
//    public synchronized MessageProducer getQueueProducer(Session session) {
//        ++this.mapProducerCount;
//        MessageProducer producer = this.mapProducer.get(session).get(queueName + this.mapProducerCount);
//
//        if (this.mapProducerCount % 1 == 0) {
//            this.mapProducerCount = 0;
//        }
//        return producer;
//    }
//
//    /**
//     * 根据 Session 获取缓存的 ObjectMessage
//     * @param session
//     * @return
//     */
//    public synchronized ObjectMessage getSessionObjectMessage(Session session) {
//        return this.mapSessionObjectMessage.get(session);
//    }
//
//    /**
//     * 提交 Session，如果 Session 中需要发送的消息数量达到了要提交的阈值，就提交。
//     * 如果没有达到阈值，就把对应的需要发送的消息计数加 1
//     * @param session
//     */
//    public synchronized void sessionCommit(Session session) {
//        synchronized (this) {
//            Object obj = this.mapSessionMessage2Send.get(session);
//            if (obj == null) {
//                this.mapSessionMessage2Send.put(session, 1);
//            } else {
//                int count = (int) obj;
//                if (count > 0 && count % this.messageCountPerSession2Send == 0) {
//                    // 应该发送
//                    this.mapSessionLastCommitTime.put(session, System.currentTimeMillis());
//                    try {
//                        session.commit();
//                    } catch (JMSException e) {
//                        e.printStackTrace();
//                    }
//                    // 清空要发送的消息记录
//                    this.mapSessionMessage2Send.put(session, 0);
//                } else {
//                    this.mapSessionMessage2Send.put(session, ++count);
//                }
//            }
//        }
//        // 设置 sct 的运行标识
//        if (!this.sctIsRun) {
//            this.sctIsRun = true;
//            if (sct.getState() == Thread.State.NEW) {
//                sct.start();
//            }
//        }
//    }
//
//    /**
//     * 按照时间去检查，并提交 Session 中的消息的线程
//     * 在第一次调用 session.commit() 方法的时候启动
//     * 在检测所有的 session 都没有需要提交的消息后，自动终止
//     * 然后再次有人调用 session.commit() 方法的时候启动
//     */
//    private class SessionCommitThread extends Thread {
//        @Override
//        public void run() {
//            boolean flag = true;
//            while (flag) {
//                Set<Session> set = mapSessionObjectMessage.keySet();
//                for (Session s : set) {
//                    // 根据时间来判断，是否需要提交 Session 中的消息
//                    if (mapSessionLastCommitTime == null ||
//                            System.currentTimeMillis() - mapSessionLastCommitTime.get(s)
//                            >= sessionCommitInterval) {
//                        // 应该提交
//                        try {
//                            mapSessionLastCommitTime.put(s, System.currentTimeMillis());
//                            s.commit();
//                        } catch (JMSException e) {
//                            e.printStackTrace();
//                        }
//                        // 把 Session 需要提交的消息数量清空
//                        mapSessionMessage2Send.put(s, 0);
//                    }
//                }
//
//                // 判断是否所有的 Session 中的消息都已经提交了
//                Set<Session> sendSet = mapSessionMessage2Send.keySet();
//                boolean f = true;
//                for (Session s : sendSet) {
//                    if (mapSessionMessage2Send.get(s) > 0) {
//                        f = false;
//                        break;
//                    }
//                }
//
//                if (f) {
//                    // 如果所有的 Session 中的消息都已经提交了，那么本线程就可以结束了
//                    flag = false;
//                    sctIsRun = false;
//                    sct = new SessionCommitThread();
//                } else {
//                    // 如果不是所有的 Session 中的消息都已经提交，那么休息一下，等下次在检查
//                    try {
//                        Thread.sleep(sessionCommitInterval);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }
//}
