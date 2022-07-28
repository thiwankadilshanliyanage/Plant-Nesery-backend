/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.app;

import Model.DataAccessobj;
import Model.storage;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.valueextraction.ValueExtractor;

/**
 *
 * @author Thiwanka
 */
@WebServlet(name = "ReceiveData", urlPatterns = {"/receive"})
public class ReceiveData extends HttpServlet {
    
    @Resource(lookup = "Abcf")
    private QueueConnectionFactory factory;
    
    @Resource(lookup = "myjdr")
    private Queue queue;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Gson g = new Gson();
        try {
            QueueConnection connection = factory.createQueueConnection();
            connection.start();
            QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            
            QueueReceiver receiver = session.createReceiver(queue);
//            QueueReceiver receiver = session.createReceiver(queue);

            receiver.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        DataAccessobj.putData(g.fromJson(message.getBody(String.class), storage.class));
                        System.out.println("Data:"+message.getBody(String.class)); 
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                
            });

//            receiver.setMessageListener(e -> {
//                try {
//                    out.write(e.getBody(String.class));
//                    System.out.println("rec"+e.getBody(String.class));
//                } catch (JMSException exception) {
//                    exception.printStackTrace();
//                }
//            });
        } catch (Exception e) {
            System.out.println("servlet error");
            e.printStackTrace();
        }
       
    }
    
}
