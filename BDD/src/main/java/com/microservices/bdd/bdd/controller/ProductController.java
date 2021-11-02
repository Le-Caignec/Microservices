package controller;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import entity.Latex;
import entity.Markdown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/bdd")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/markdown")
    public String saveMarkdown(@RequestBody Markdown markdown) throws ExecutionException, InterruptedException {
        return productService.saveMarkdown(markdown);
    }

    @PostMapping("/latex")
    public String saveLatex(@RequestBody Latex latex) throws ExecutionException, InterruptedException {
        return productService.saveLatex(latex);

    }

    @PostMapping("/hello")
    public String hello() {
        return "alooooo";
    }
}
