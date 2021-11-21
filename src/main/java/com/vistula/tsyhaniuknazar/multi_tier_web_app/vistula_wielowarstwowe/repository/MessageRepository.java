package com.vistula.tsyhaniuknazar.multi_tier_web_app.vistula_wielowarstwowe.repository;

import com.vistula.tsyhaniuknazar.multi_tier_web_app.vistula_wielowarstwowe.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    public List<Message> findAllByNameOfUser(String name);
}
