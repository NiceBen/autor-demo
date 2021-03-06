//package com.ofben.autordemo.optimize;
//
//import javax.jms.Connection;
//import javax.jms.MessageProducer;
//import javax.jms.ObjectMessage;
//import javax.jms.Session;
//import java.io.Serializable;
//
///**
// * 封装提供给具体业务对象使用的消息发送对象
// * 使用方法：
// * 1.在具体的业务模块里面，写一个类来继承这个对象
// * 2.需要注入一个具体的 ActiveMQPools 的实现，这个也可以在 Spring 里面配置
// *
// * @date 2021-08-27
// * @since 1.0.0
// */
//public abstract class QueueSender<M extends Serializable> {
//
//    private ActiveMQPools activeMQPools;
//
//    public void setActiveMQPools(ActiveMQPools activeMQPools) {
//        this.activeMQPools = activeMQPools;
//    }
//
//    /**
//     * 具体发送的消息
//     * @param m
//     * @param msgType 用来描述具体是什么义务类型
//     */
//    public void sendMsg(M m, String msgType) {
//        Connection conn = null;
//        Session session = null;
//        ObjectMessage msg = null;
//
//        try {
//            conn = this.activeMQPools.getConnection();
//            session = this.activeMQPools.getSession(conn);
//            MessageProducer producer = this.activeMQPools.getQueueProducer(session);
//            msg = this.activeMQPools.getSessionObjectMessage(session);
//
//            msg.setObject(m);
//            msg.setStringProperty("MSG_TYPE", msgType);
//
//            producer.send(msg);
//
//            this.activeMQPools.sessionCommit(session);
//        } catch (Exception err) {
//            err.printStackTrace();
//        }
//    }
//}
