package com.soft1851.springboot.task.scheduling.task;

import com.soft1851.springboot.task.scheduling.model.User;
import com.soft1851.springboot.task.scheduling.repository.UserRepository;
import com.soft1851.springboot.task.scheduling.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/15
 */
//@Component
@Slf4j
public class TimeMailTask {
    @Resource
    private UserRepository userRepository;
    @Resource
    private MailService mailService;

    private int count = 1;

    @Scheduled(cron = "0 33 20 * * ?")
    private void process() throws Exception {
        List<User> userList = userRepository.findUsersByBirthday();
        for (User user : userList) {
            String to = user.getMail();
            String subject = user.getUsername() + "生日快乐";
            String content = "<h2>Happy Birthday~~" + user.getUsername() + "</h2>" +
                    "<br/> <img src=\"cid:img01\" />";
            String imgPath = "D:\\resources\\birthday.jpg";
            Map<String, String> birthday = new HashMap<>();
            birthday.put("img01", imgPath);
            mailService.sendImgMail(to, subject, content, birthday);
            log.info(user.getUsername() + "的祝福邮件发送成功" + count++ + "次");
        }
    }
}
