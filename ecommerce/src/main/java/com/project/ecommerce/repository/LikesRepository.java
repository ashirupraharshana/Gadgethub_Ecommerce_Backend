package com.project.ecommerce.repository;

import com.project.ecommerce.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {
    List<Likes> findByUserid(int userid);
    List<Likes> findByProductid(int productid);
    boolean existsByUseridAndProductid(int userid, int productid);
    void deleteByUseridAndProductid(int userid, int productid);
}
