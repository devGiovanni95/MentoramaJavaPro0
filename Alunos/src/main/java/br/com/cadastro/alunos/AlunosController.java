package br.com.cadastro.alunos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunosController  {

    private final List<Alunos> alunos;

    public AlunosController(List<Alunos> alunos) {

        this.alunos = new ArrayList<>();


        Alunos aluno1 = new Alunos(1,"Eloisa",15);
        Alunos aluno2 = new Alunos(1,"Rian",13);
        Alunos aluno3 = new Alunos(1,"Marcos",14);
        Alunos aluno4 = new Alunos(1,"Diego",16);

        alunos.add(aluno1);
        alunos.add(aluno2);
        alunos.add(aluno3);
        alunos.add(aluno4);
    }

    // @GetMapping
    // public List<Alunos> findAll(@RequestParam(required = false) Integer id,
    // String nome, Integer idade){
    // if (alunos != null){
    // return alunos.stream().collect(Collectors.toList());
    // }
    // return alunos;
    //
    // }

//    @GetMapping
//    public List<Alunos> findAll(@RequestParam(required = false) Integer id, String nome, Integer idade) {
//        if (alunos != null) {
//            List<Alunos> collect = alunos.stream()
//                    .filter(nomeAluno -> nomeAluno.getNome().contains((CharSequence) alunos))
//                    .collect(Collectors.toList());
//
//            return collect;
//        }
//        return alunos;
//
//    }
//
//    @GetMapping
//    public List<Alunos> findAll(@RequestParam(required = false) String nome) {
//        if (alunos != null) {
//            return alunos.stream()
//                    .filter(nomeAluno -> nomeAluno.getNome().contains(nome))
//                    .collect(Collectors.toList());
//
//        }
//        return alunos;
//
//    }

    @GetMapping
    public  List<Alunos> findAll(@RequestParam(required = false) String nome,@RequestParam(required = false) Integer idade){
        if (nome != null){
            return alunos.stream().filter(msg -> msg.getNome().contains(nome)).collect(Collectors.toList());
        }
        if (idade != null){
//            return alunos.stream().filter(msg -> msg.getIdade().equals(idade)).collect(Collectors.toList());
            return (List<Alunos>) alunos.stream().filter(msg -> msg.getIdade().equals(idade)).findFirst().orElse(null);
        }
        return this.alunos;
    }

    @GetMapping("/{id}")
    public Alunos findById(@PathVariable("id") Integer id) {
        return this.alunos.stream().filter(alunoId -> alunoId.getId().equals(id)).findFirst().orElse(null);
    }

    //
    // @PostMapping
    // public ResponseEntity<Integer> add(RequestBody Integer id, String nome,
    // Integer idade ){
    // if (findById().getId() == null){
    // Alunos.
    // }
    // }
//

//    @PostMapping
//    public ResponseEntity<Alunos> add(@RequestBody Alunos aluno) {
//        if (aluno.getId() == null && aluno.getIdade() == null && aluno.getNome() == null) {
//            aluno.setId(alunos.size() + 1);
//            aluno.setIdade();
//            aluno.setNome();
//        }
//        alunos.add(aluno);
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }


    @PostMapping
    public ResponseEntity<Alunos> add(@RequestBody Alunos registroEscolar, @RequestBody Alunos aluno,@RequestBody Alunos old) {
        if (registroEscolar.getId() == null && aluno.getIdade() == null && old.getIdade() == null) {
//            aluno.setId(alunos.size() + 1);
//            aluno.setIdade();
//            aluno.setNome();
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else if (registroEscolar.getId() != null && aluno.getNome() != null && old.getIdade() != null){
            registroEscolar.setId(registroEscolar.getId());
            aluno.setNome(aluno.getNome());
            old.setIdade(old.getIdade());
        }
        alunos.add(registroEscolar);
        alunos.add(aluno);
        alunos.add(old);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody final Alunos aluno) {
        alunos.stream().filter(nomeAluno -> nomeAluno.getId().equals(aluno.getId()))
                .forEach(nomeAluno -> nomeAluno.setNome(aluno.getNome()));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        alunos.removeIf(aluno -> aluno.getId().equals(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
