package com.demo.springit.repository;

import com.demo.springit.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<Link,Long> {
  Link findByTitle(String title);
}
