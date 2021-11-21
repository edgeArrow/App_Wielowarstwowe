package com.vistula.tsyhaniuknazar.multi_tier_web_app.vistula_wielowarstwowe.controller;

import com.vistula.tsyhaniuknazar.multi_tier_web_app.vistula_wielowarstwowe.dto.MessageDto;
import com.vistula.tsyhaniuknazar.multi_tier_web_app.vistula_wielowarstwowe.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String showAllMessages(Model model) {
        MessageDto messageDto = new MessageDto();

        model.addAttribute("messageDto", messageDto);
        model.addAttribute("allMessages", messageService.getAllMessages());

        return "main";
    }

    @PostMapping("/createMessage")
    public String createMessage(@ModelAttribute("messageDto") @Valid MessageDto messageDto) {
        messageService.createMessage(messageDto);

        return "redirect:/";
    }

    @GetMapping("/updateMessage/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("message", messageService.getMessage(id));

        return "update-message";
    }

    @PostMapping("/saveMessage")
    public String saveMessage(@ModelAttribute("message") MessageDto messageDto) {
        messageService.saveMessages(messageDto);

        return "redirect:/";
    }

    @GetMapping("/deleteMessage/{id}")
    public String deleteMessage(@PathVariable("id") long id) {
        messageService.deleteMessage(id);

        return "redirect:/";
    }


}

