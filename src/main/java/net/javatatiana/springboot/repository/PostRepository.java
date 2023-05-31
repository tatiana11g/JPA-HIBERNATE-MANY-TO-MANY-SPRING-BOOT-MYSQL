package net.javatatiana.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.javatatiana.springboot.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
}
