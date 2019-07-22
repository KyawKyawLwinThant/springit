package com.demo.springit.contorller;


import com.demo.springit.model.Link;
import com.demo.springit.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/links")
public class LinkController {
  @Autowired
  private LinkRepository linkRepository;


  @GetMapping("/")
  public List<Link> list(){
    return linkRepository.findAll();
  }

  @PostMapping("/create")
  public Link create(@ModelAttribute Link link){
    return linkRepository.save(link);
  }

  @GetMapping("/{id}")
  public Optional<Link> read(@PathVariable("id") Long id){
    return linkRepository.findById(id);
  }
  @PutMapping("/{id}")
  public Link update(@PathVariable("id")Long id,@ModelAttribute Link link){
    return linkRepository.save(link);
  }
  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id")Long id){
    linkRepository.deleteById(id);
  }
}
