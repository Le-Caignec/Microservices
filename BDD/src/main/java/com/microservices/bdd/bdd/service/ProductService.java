package service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.microservices.bdd.bdd.entity.Latex;
import com.microservices.bdd.bdd.entity.Markdown;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class ProductService {
    private static final String COLLECTION_NAME="latex";
    private static final String DOCUMENT_MARKDOWN="markdown";
    private static final String DOCUMENT_LATEX="latex";

    public String saveMarkdown(Markdown markdown) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture=dbFirestore.collection(COLLECTION_NAME).document(DOCUMENT_MARKDOWN).set(markdown, SetOptions.merge());
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public String saveLatex(Latex latex) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture=dbFirestore.collection(COLLECTION_NAME).document(DOCUMENT_LATEX).set(latex, SetOptions.merge());
        return collectionApiFuture.get().getUpdateTime().toString();
    }
}
