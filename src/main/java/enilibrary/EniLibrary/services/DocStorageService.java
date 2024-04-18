package enilibrary.EniLibrary.services;


import enilibrary.EniLibrary.Enum.DocumentCategory;
import enilibrary.EniLibrary.entities.Doc;
import enilibrary.EniLibrary.repositories.DocRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class DocStorageService {
    @Autowired
    private DocRepository docRepository;

    public Doc saveFile(MultipartFile file, DocumentCategory category) {
        String docName = file.getOriginalFilename();
        try {
            Doc doc = new Doc(docName, file.getContentType(), category, file.getBytes());
            return docRepository.save(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Optional<Doc> getFile(Integer fileId) {
        return docRepository.findById(fileId);
    }

    public List<Doc> getFiles() {
        return docRepository.findAll();
    }

    public Doc updateDocumentCategory(Integer fileId, DocumentCategory newCategory) {
        Optional<Doc> optionalDoc = docRepository.findById(fileId);
        if (optionalDoc.isPresent()) {
            Doc doc = optionalDoc.get();
            doc.setDocumentCategory(newCategory);
            return docRepository.save(doc);
        }
        return null;
    }

    public Doc updateDocumentName(Integer fileId, String newName) {
        Optional<Doc> optionalDoc = docRepository.findById(fileId);
        if (optionalDoc.isPresent()) {
            Doc doc = optionalDoc.get();
            doc.setDocName(newName);
            return docRepository.save(doc);
        }
        return null;
    }

    public void deleteDocument(Integer fileId) {
        docRepository.deleteById(fileId);
    }

 public List<Doc> getCATEGORYFiles() {
        return docRepository.findAllByDocumentCategory(DocumentCategory.TD); }

}



