package com.project.ecommerce.service;

import com.project.ecommerce.model.Likes;
import com.project.ecommerce.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikesService {

    @Autowired
    private LikesRepository likesRepository;

    // Add like
    public Likes addLike(Likes like) {
        if (!likesRepository.existsByUseridAndProductid(like.getUserid(), like.getProductid())) {
            return likesRepository.save(like);
        }
        return like; // Prevent duplicate likes
    }

    // Remove like
    public void removeLike(int userid, int productid) {
        likesRepository.deleteByUseridAndProductid(userid, productid);
    }

    // Get all likes by user
    public List<Likes> getLikesByUser(int userid) {
        return likesRepository.findByUserid(userid);
    }

    // Get all likes for a product
    public List<Likes> getLikesByProduct(int productid) {
        return likesRepository.findByProductid(productid);
    }
}
