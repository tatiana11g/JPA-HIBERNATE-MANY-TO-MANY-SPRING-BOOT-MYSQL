package net.javatatiana.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javatatiana.springboot.entity.Post;
import net.javatatiana.springboot.entity.Tag;
import net.javatatiana.springboot.repository.PostRepository;
import net.javatatiana.springboot.repository.TagRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringbootHibernateManyManyMappingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateManyManyMappingApplication.class, args);
	}
	
	@Autowired
	private PostRepository postRepository;
	

	@Autowired
	private TagRepository tagRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		Post post = new Post("Hibernate Many to Many Mapping", 
				"Hibernate Many to Many Mapping Example with Spring Boot", 
				"Hibernate Many to Many Mapping Example with Spring Boot");
		
		Post post1 = new Post("Hibernate One to Many Mapping Example with Spring Boot", 
				"Hibernate One to Many Mapping Example with Spring Boot", 
				"Hibernate One to Many Mapping Example with Spring Boot");
		
		Tag springBoot = new Tag("Spring Boot");
		Tag hibernate = new Tag("Hibernate");
		
		// add tag references post
		post.getTags().add(springBoot);
		post.getTags().add(hibernate);
		
		// add post references tag
		
		springBoot.getPosts().add(post);
		hibernate.getPosts().add(post);
		
		springBoot.getPosts().add(post1);
		post1.getTags().add(springBoot);
		
		
		this.postRepository.save(post);
		this.postRepository.save(post1);	


}
}
