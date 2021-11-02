package com.microservices.bdd.bdd.controller;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.microservices.bdd.bdd.entity.Latex;
import com.microservices.bdd.bdd.entity.Markdown;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/bdd")
public class ProductController {

    public static final String COLLECTION_MARKDOWN="markdown";
    public static final String COLLECTION_LATEX="latex";

    @PostMapping("/markdown")
    public ArrayList<Markdown> saveMarkdown(@RequestBody String string) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference addedDocRef = dbFirestore.collection(COLLECTION_MARKDOWN).document();
        Markdown markdown = new Markdown(addedDocRef.getId(),string);
        addedDocRef.set(markdown);
        return getAllMarkdownHistoric();
    }

    @PostMapping("/latex")
    public ArrayList<Latex> saveLatex(@RequestBody String string) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference addedDocRef = dbFirestore.collection(COLLECTION_LATEX).document();
        Latex latex = new Latex(addedDocRef.getId(),string);
        addedDocRef.set(latex);
        return getAllLatexHistoric();
    }

    public ArrayList<Markdown> getAllMarkdownHistoric() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ArrayList<Markdown> arrayListMarkdown= new ArrayList<>();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COLLECTION_MARKDOWN).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            Markdown markdown = null;
            if (document.exists()) {
                markdown = document.toObject(Markdown.class);
                arrayListMarkdown.add(markdown);
            }
        }
        return arrayListMarkdown;
    }

    public ArrayList<Latex> getAllLatexHistoric() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ArrayList<Latex> arrayListLatex= new ArrayList<>();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COLLECTION_LATEX).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            Latex latex = null;
            if (document.exists()) {
                latex = document.toObject(Latex.class);
                arrayListLatex.add(latex);
            }
        }
        return arrayListLatex;
    }

    @GetMapping("/markdown/{id}")
    public Markdown getOneMarkdownHistoric(@PathVariable String id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_MARKDOWN).document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Markdown markdown;
        if (document.exists()) {
            markdown = document.toObject(Markdown.class);
            return markdown;
        }
        return null;
    }

    @GetMapping("latex/{id}")
    public Latex getOneLatexHistoric(@PathVariable String id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_LATEX).document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Latex latex;
        if (document.exists()) {
            latex = document.toObject(Latex.class);
            return latex;
        }
        return null;
    }
}
