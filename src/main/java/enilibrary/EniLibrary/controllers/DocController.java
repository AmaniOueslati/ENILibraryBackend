package enilibrary.EniLibrary.controllers;

import enilibrary.EniLibrary.Enum.DocumentCategory;
import enilibrary.EniLibrary.entities.Doc;
import enilibrary.EniLibrary.services.DocStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Controller
@CrossOrigin("*")
public class DocController {

    @Autowired
    private DocStorageService docStorageService;

    @GetMapping("/")
    public String get(Model model) {
        List<Doc> docs = docStorageService.getFiles();
        model.addAttribute("docs", docs);
        return "doc";
    }

    @PostMapping("/uploadFiles")
    public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files,
                                      @RequestParam("documentCategory") DocumentCategory documentCategory) { // Ajout du paramètre documentCategory
        for (MultipartFile file : files) {
            docStorageService.saveFile(file, documentCategory); // Passer documentCategory au service
        }
        return "redirect:/";
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId) {
        Doc doc = docStorageService.getFile(fileId).orElseThrow(() -> new RuntimeException("Document not found"));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(doc.getDocType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + doc.getDocName() + "\"")

                .body(new ByteArrayResource(doc.getData()));
    }

    @PostMapping("/updateCategory/{fileId}")
    public String updateDocumentCategory(@PathVariable Integer fileId, @RequestParam DocumentCategory newCategory) {
        Doc updatedDoc = docStorageService.updateDocumentCategory(fileId, newCategory);
        if (updatedDoc != null) {
            ResponseEntity.ok().body("Category updated successfully");
            return"redirect:http://localhost:8081/";

        } else {
            return null;
        }
    }

    @PostMapping("/updateName/{fileId}")
    public String updateDocumentName(@PathVariable Integer fileId, @RequestParam String newName) {
        Doc updatedDoc = docStorageService.updateDocumentName(fileId, newName);
        if (updatedDoc != null) {
            ResponseEntity.ok().body("Name updated successfully");
            return "redirect:http://localhost:8081/";
        } else {
            return null;
        }
    }

    @PostMapping("/deleteDoc/{fileId}")
    public String deleteDocument(@PathVariable Integer fileId) {
        docStorageService.deleteDocument(fileId);
        ResponseEntity.ok().body("Document deleted successfully");
        return "redirect:http://localhost:8081/";
    }

/*    @GetMapping("/docs/TD")
    public List<Doc> getDoc(@RequestBody DocumentCategory documentCategory){
        return docStorageService.getTDFiles(documentCategory);
    }*/


    //http://localhost:8081/docs/search/findAllByDocumentCategory?documentCategory=EXAM
    @GetMapping("/docs/CATEGORY")
    public List<Doc> getDocTD(){
        return docStorageService.getCATEGORYFiles();
    }


}
