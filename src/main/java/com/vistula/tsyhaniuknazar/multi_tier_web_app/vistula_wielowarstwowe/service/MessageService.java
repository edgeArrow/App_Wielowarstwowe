package com.vistula.tsyhaniuknazar.multi_tier_web_app.vistula_wielowarstwowe.service;

import com.vistula.tsyhaniuknazar.multi_tier_web_app.vistula_wielowarstwowe.dto.MessageDto;
import com.vistula.tsyhaniuknazar.multi_tier_web_app.vistula_wielowarstwowe.entity.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {

    public List<Message> getAllMessages();

    public void createMessage(MessageDto messageDto);

    public void saveMessages(MessageDto messageDto);

    public Message getMessage(long id);

    public void deleteMessage(long id);

    public List<Message> getMessagesByName(String name);
}
