package com.project.ecommerce.controller;

import com.project.ecommerce.model.Likes;
import com.project.ecommerce.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
@CrossOrigin(origins = "*")
public class LikesController {

    @Autowired
    private LikesService likesService;

    // Add a like
    @PostMapping
    public Likes addLike(@RequestBody Likes like) {
        return likesService.addLike(like);
    }

    // Remove a like
    @DeleteMapping("/{userid}/{productid}")
    public void removeLike(@PathVariable int userid, @PathVariable int productid) {
        likesService.removeLike(userid, productid);
    }

    // Get all likes by user
    @GetMapping("/user/{userid}")
    public List<Likes> getLikesByUser(@PathVariable int userid) {
        return likesService.getLikesByUser(userid);
    }

    // Get all likes for a product
    @GetMapping("/product/{productid}")
    public List<Likes> getLikesByProduct(@PathVariable int productid) {
        return likesService.getLikesByProduct(productid);
    }
}
