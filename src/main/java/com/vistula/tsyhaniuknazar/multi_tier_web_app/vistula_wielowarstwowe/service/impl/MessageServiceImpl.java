package com.vistula.tsyhaniuknazar.multi_tier_web_app.vistula_wielowarstwowe.service.impl;

import com.vistula.tsyhaniuknazar.multi_tier_web_app.vistula_wielowarstwowe.dto.MessageDto;
import com.vistula.tsyhaniuknazar.multi_tier_web_app.vistula_wielowarstwowe.entity.Message;
import com.vistula.tsyhaniuknazar.multi_tier_web_app.vistula_wielowarstwowe.repository.MessageRepository;
import com.vistula.tsyhaniuknazar.multi_tier_web_app.vistula_wielowarstwowe.service.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, ModelMapper modelMapper) {
        this.messageRepository = messageRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public void createMessage(MessageDto messageDto) {
        Message message = modelMapper.map(messageDto, Message.class);

        message.setDateOfCreation(getCurrentDate());
        message.setDateOfUpdate(getCurrentDate());

        messageRepository.save(message);
    }

    @Override
    public void saveMessages(MessageDto messageDto) {
        Message message = modelMapper.map(messageDto, Message.class);
        message.setDateOfCreation(messageRepository.findById(message.getId()).get().getDateOfCreation());
        message.setDateOfUpdate(getCurrentDate());

        messageRepository.save(message);
    }

    @Override
    public Message getMessage(long id) throws RuntimeException {

        Optional<Message> optional = messageRepository.findById(id);
        Message message = null;
        if (optional.isPresent()) {
            message = optional.get();
        }
        return message;
    }

    @Override
    public void deleteMessage(long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public List<Message> getMessagesByName(String name) {
        List<Message> list = messageRepository.findAllByNameOfUser(name);

        if (list.isEmpty()) {
            return new ArrayList<>();
        }

        return messageRepository.findAllByNameOfUser(name);
    }

    private String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        return dtf.format(now);
    }
}
