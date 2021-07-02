package com.mentorama.desafioMaven;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ola")
public class MessageController {

    private final List<MessageHelloWord> messageHelloWords;

    public MessageController() {
        this.messageHelloWords = new ArrayList<>();
    }



    @GetMapping
    public List<MessageHelloWord> ola(@RequestParam(required = false) String helloWords){
        if (helloWords != null){
            return this.messageHelloWords.stream()
                    .filter(msg -> msg.getHelloWord().contains(helloWords))
                    .collect(Collectors.toList());
        }
        return messageHelloWords;
    }

    @PostMapping
    public ResponseEntity <String> add(@RequestBody final MessageHelloWord helloWords){
     try {
         messageHelloWords.add(helloWords);
         return new ResponseEntity<>(HttpStatus.CREATED);
     }catch (RuntimeException e){
         return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
     }
//        messageHelloWords.add(helloWords);
//        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
