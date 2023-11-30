package com.wuyibo.spring_boot1.service;

import com.microsoft.graph.models.Message;
import com.microsoft.graph.models.OutlookUser;
import com.microsoft.graph.requests.GraphServiceClient;
import com.microsoft.graph.requests.MessageCollectionPage;
import com.wuyibo.spring_boot1.utils.OutlookUtil;
import okhttp3.Request;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@EnableScheduling
public class OutlookService {

    @Scheduled(fixedDelay = 60)
    public static void getEmail() {
        GraphServiceClient<Request> client = OutlookUtil.getClient();
        MessageCollectionPage messageCollectionPage = client.users("495042441@qq.com")
                .messages()
                .buildRequest()
                .get();
        assert messageCollectionPage != null;
        for (Message message : messageCollectionPage.getCurrentPage()) {
            System.out.println("--------------------");
            System.out.println("Subject" + message.subject);
            System.out.println("Body" + message.body);
            System.out.println("--------------------");

        }
    }

//    @Scheduled(fixedDelay = 100)
    public static void getEmail2() throws IOException {
        OutlookUtil.getEmail();
    }
}
