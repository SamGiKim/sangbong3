package com.softagape.mustacheajax.category;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/ct")
public class CategoryController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
//    private CategoryServiceImpl categoryService;
    private CategoryServiceImpl categoryService;

    @PostMapping
    public ResponseEntity<ICategory> insert(@RequestBody CategoryDto dto) {
        try {
            if ( dto == null ) {
                return ResponseEntity.badRequest().build();
            }
            ICategory result = this.categoryService.insert(dto);
            if ( result == null ) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(result);
        } catch ( Exception ex ) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ICategory>> getAll() {
        try {
            List<ICategory> result = this.categoryService.getAllList();
            return ResponseEntity.ok(result);
        } catch ( Exception ex ) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        try {
            if ( id == null ) {
                return ResponseEntity.badRequest().build();
            }
            Boolean result = this.categoryService.delete(id);
            return ResponseEntity.ok(result);
        } catch ( Exception ex ) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ICategory> update(@PathVariable Long id, @RequestBody CategoryDto dto) {
        try {
            if ( id == null || dto == null ) {
                return ResponseEntity.badRequest().build();
            }
            ICategory result = this.categoryService.update(id, dto);
            if ( result == null ) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch ( Exception ex ) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ICategory> findById(@PathVariable Long id) {
        try {
            if ( id == null || id <= 0 ) {
                return ResponseEntity.badRequest().build();
            }
            ICategory result = this.categoryService.findById(id);
            if ( result == null ) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch ( Exception ex ) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/nm/{name}")
    public ResponseEntity<List<ICategory>> findAllByNameContains(@PathVariable String searchName) {
        try {
            if ( searchName == null || searchName.isEmpty() ) {
                return ResponseEntity.badRequest().build();
            }
            SearchCategoryDto searchCategoryDto = SearchCategoryDto.builder()
                    .searchName(searchName).page(1).build();
            List<ICategory> result = this.categoryService.findAllByNameContains(searchCategoryDto);
            if ( result == null || result.size() <= 0 ) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch ( Exception ex ) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/searchName")
    public ResponseEntity<List<ICategory>> findAllByNameContains(@RequestBody SearchCategoryDto searchCategoryDto) {
        try {
            if ( searchCategoryDto == null ) {
                return ResponseEntity.badRequest().build();
            }
            List<ICategory> result = this.categoryService.findAllByNameContains(searchCategoryDto);
            if ( result == null ) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch ( Exception ex ) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }
}
