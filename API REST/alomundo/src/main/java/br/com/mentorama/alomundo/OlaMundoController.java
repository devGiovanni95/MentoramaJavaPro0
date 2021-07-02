package br.com.mentorama.alomundo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/olamundo")
public class OlaMundoController {

//    private final String mensage = "Olá Mundo";
    private final List<Message> messages;

    public OlaMundoController() {
        this.messages = new ArrayList<>();
//        Message message1 = new Message(1,"Olá Mundo" );
//        Message message2 = new Message(2,"Hello Word" );
//        Message message3 = new Message(3,"Hello mundo" );
//        this.messages.add(message1);
//        this.messages.add(message2);
//        this.messages.add(message3);
//        message.setMessage("Olá mundo");
//        message.setId(1);

    }

//    @GetMapping
//    public String olaMundo(){
//        return mensage;
//    }
//
//    @GetMapping
//    public List<Message> olaMundo(){
//        return messages;
//    }
//
//    @GetMapping
//    public List<Message> findAll(@RequestParam(required = false) String message){
//        return messages.stream()
//                .filter(msg -> msg.getMessage().contains(message))
//                .collect(Collectors.toList());
//    }

    @GetMapping
    public List<Message> findAll(@RequestParam(required = false) String message) {
        if (message != null) {
            return messages.stream()
                    .filter(msg -> msg.getMessage().contains(message))
                    .collect(Collectors.toList());
        }
        return messages;
    }

    @GetMapping("/{id}")
    public Message findById(@PathVariable("id") Integer id ){
        return this.messages.stream()
                .filter(msg -> msg.getId().equals(id))
                .findFirst().orElse(null);
    }

    //1 criado sem mudar o codigo de status padrao
//    @PostMapping
//    public Integer add(@RequestBody final Message message){
//        if (message.getId() == null){
//            message.setId(messages.size() + 1);
//        }
//        messages.add(message);
//        return message.getId();
//    }

    @PostMapping
    public ResponseEntity <Integer> add(@RequestBody final Message message){
        if (message.getId() == null){
            message.setId(messages.size() + 1);
        }
        messages.add(message);
        return new ResponseEntity<>(message.getId(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody final  Message message){
        messages.stream().filter(msg -> msg.getId().equals(message.getId()))
                .forEach(msg -> msg.setMessage(message.getMessage()));
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable ("id") Integer id){
        messages.removeIf(msg -> msg.getId().equals(id));
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    //conferir documentação
    //http://localhost:8080/v3/api-docs
    //conferir documentacao com interface grafica
    //http://localhost:8080/swagger-ui.html

}
